#!/usr/bin/env python
# coding: utf-8

# ### 머신러닝 전체 과정
# 1. 문제 정의(목표 설정)
# 2. 데이터 수집
# 3. 데이터 전처리
# 4. EDA 탐색적 데이터 분석 == 시각화
# 5. 모델 선택
# 6. 모델 학습
# 7. 모델 평가

# ### 1. 문제 정의
# - 탑승객의 정보를 바탕으로 생존자/사망자 예측
# - Kaggle 대회에서 높은 순위를 차지
# - 머신러닝 과정 전체를 체험해보는 예제

# ![image.png](attachment:image.png)

# ### 2. 데이터 수집
# - kaggle 사이트로부터 train, test 다운로드

# In[320]:


import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import seaborn as sns # 시각화 라이브러리


# In[321]:


train = pd.read_csv('train.csv')
test = pd.read_csv('test.csv')


# In[322]:


train.head(2)


# In[323]:


test.head(2)


# ### 3. 데이터 전처리
# - 수집된 데이터 중에서 나의 분석에 필요하지 않은 불필요한 컬럼 삭제
# - 결측치 채우기(데이터 삭제, 기술통계, 상관계를 통한 대체값)
# - 특성공학
# - 새로운 컬럼 만들기
# - 범주형 데이터로 바꾸기
# - 모든 컬럼 수치화

# In[324]:


# 생각하기에 필요없는 데이터 삭제(주관적인거라서 정답이 없음)
train.drop('PassengerId', axis=1, inplace=True)


# In[325]:


train.head(1)


# In[326]:


# *****중요!!! train, test 모두 같은 전처리를 해주어야 한다.
test.drop('PassengerId', axis=1, inplace=True)


# In[327]:


test.head(1)


# In[328]:


# 데이터와 컬럼의 갯수 확인 가능
train.shape, test.shape


# In[329]:


# 데이터의 전반적인 정보 확인 -> 결측치 확인도 가능
train.info()


# In[330]:


test.info()


# ### Embarked 결측치 채우기

# In[331]:


# 문자들로 구성되어있는 Embarked
# .value_counts() : 값들이 각각 몇개가 들어있는지 확인
train['Embarked'].value_counts()


# In[332]:


# 결측치 갯수? 2개
# S가 가장 빈도수가 많아서 null값에 S를 채워준다
train['Embarked'].fillna('S', inplace=True)


# In[333]:


train.info()


# ### Fare 결측치 채우기

# In[334]:


test['Fare']


# In[335]:


# 다른 컬럼과의 상관관계를 이용하여 결측치를 채울 예정
train.corr()


# - Pclass가 Fare와 가장 높은 상관관계를 갖는다
# - 생존에 관련이 많을 것 같은 성별을 함께 활용해보자

# In[336]:


# 몇 개의 컬럼만 뽑아 통계치 확인하고 싶을 때
pt1= train.pivot_table(values='Fare', index=['Pclass', 'Sex'], aggfunc='mean')
pt1


# In[337]:


# 누가 Fare의 결측갑을 가질까?
test['Fare'].isnull()


# In[338]:


test[test['Fare'].isnull()]


# In[339]:


# 결측치 채우기
test['Fare'].fillna(12.6616, inplace=True)


# In[340]:


test.info()


# In[341]:


train.info()


# ### Age 컬럼 결측치 채우기

# In[342]:


# 상관관계 
train.corr()


# In[343]:


pt2 = train.pivot_table(values='Age', index=['Pclass', 'Sex'], aggfunc='mean')
pt2


# In[344]:


pt2.loc[1, 'female']


# In[345]:


pt2.loc[3, 'male']


# In[346]:


# 함수 만들기
def fill_age(row):
    # 만약에 나이가 결측치라면 pt2에서 값을 가져오기
    if np.isnan(row['Age']):
        return pt2.loc[row['Pclass'], row['Sex']]
    # 만약 나이가 결측치가 아니라면 원래 값 그대로 사용
    else:
        return row['Age']


# In[347]:


train['Age'].tail()


# In[348]:


train['Age'] = train.apply(fill_age, axis=1).astype('int64')


# In[349]:


train.info()


# In[350]:


test['Age'] = test.apply(fill_age, axis=1).astype('int64')


# In[351]:


test.info()


# ### Cabin 결측치 채우기

# In[352]:


# 중복없이 고유한 값들을 볼 수 있는 unique()
train['Cabin'].unique()


# - 결측치를 하나의 데이터로 활용
# - Cabin의 종류가 너무 많다 -> 종류를 줄여보자(모델이 복잡해지는 것을 방지(과대적합))

# In[353]:


# 데이터는 문자형식으로 되어있다.
train['Cabin'].str


# In[354]:


train['Cabin'].str[0]


# In[355]:


train['Cabin'] = train['Cabin'].str[0]
train['Cabin']


# In[356]:


train['Cabin'].unique()


# In[357]:


# 기존에 겹치지않는 값인 M을 넣는다
train['Cabin'].fillna('M', inplace=True)
train['Cabin']


# In[358]:


test['Cabin'] = test['Cabin'].str[0]
test['Cabin'].fillna('M', inplace=True)
test['Cabin']


# In[359]:


train.info()


# In[360]:


test.info()


# ### 4. 탐색적 데이터 분석(EDA)
# - train 데이터를 이용해 탐색한다
# - 그래프 그려보기

# ### 범주형 데이터 시각화
# - 빈도 기반의 bar chart를 많이 활용

# ### Cabin 시각화

# In[361]:


# 학습의 목적인 Survivied 컬럼과의 관계 확인
sns.countplot(data=train, x='Cabin', hue='Survived')


# - M에서 상대적으로 많은 사람이 사망했다. 모델에게 학습을 시도해봐도 괜찮겠다(주관적인 생각)

# ### Pclass 시각화

# In[362]:


sns.countplot(data=train, y='Pclass', hue='Survived')


# - 1등급에 탑승하면 생존 확률이 조금 더 있다
# - 3등급에 탑승하면 사망 확률이 꽤 높다
# - Pclass 모델 학습에 이용해도 괜찮을 것 같다

# ### Pclass, Cabin 시각화

# In[363]:


sns.countplot(data=train, x='Cabin', hue='Pclass')


# - A, B, C는 1등급 사람들이 탑승했다
# - G, F는 1등급 사람들이 없다
# - M은 3등급 사람들이 많이 탑승했다 -> 3등급 사람들이 많이 사망해서 정보가 손실되었을까,,,,?

# ### Embarked, sex 시각화

# In[364]:


sns.countplot(data=train, x='Embarked', hue='Survived')


# In[365]:


sns.countplot(data=train, x='Embarked', hue='Pclass')
# Embarked 컬럼이 학습에 도움이 될까,,,? 딱히 도움은 안되어 보임


# In[366]:


sns.countplot(data=train, x='Sex', hue='Survived')


# ### 수치형 데이터
# - 히스토그램 - 구간에 따라 그래프가 달라질 수 있음
# - 커널밀도추정 그래프

# In[367]:


plt.hist(train['Age'], bins=3)
plt.show()


# ### Age 시각화

# - violinplot : KDE(커널밀도추정) + 박스플롯
# - 가운데 하얀 점 : 중앙값
# - 가운데 검정 사각형 모양 : 하얀점 아래가 25%(1사분위수), 하얀점 윗쪽 75%(3사분위수)

# In[368]:


plt.figure(figsize=(15,5))
sns.violinplot(data=train, y='Age', x='Sex', hue='Survived', split=True)


# - 남자는 20대가 좀 더 사망했다
# - 어린아이 중에서는 남자아이가 여자아이에 비해 많이 생존했다

# ### Fare 시각화

# In[369]:


plt.figure(figsize=(10,5))
sns.violinplot(data=train, y='Fare', x='Sex', hue='Survived', split=True)


# - 대부분의 사람들은 0~40달러 사이의 요금을 지불했다
# - 적은 요금을 지불한 사람들은 사망자가 많다 

# ### 특성공학
# - SibSp와 Parch를 합쳐서 '가족'이라는 새로운 컬럼 생성

# In[370]:


train['Family_Size'] = train['SibSp'] + train['Parch'] + 1
test['Family_Size'] = test['SibSp'] + test['Parch'] + 1


# In[371]:


sns.countplot(data=train, x='Family_Size', hue='Survived')


# - 1명일 때는 사망 비율이 높다
# - 2~4명일 때는 생존 배율이 높다
# - 5명 이상일 경우 사망 비율이 높다
# - Family_Size라는 수치 데이터를 그대로 사용해도 좋지만, 범주형 데이터로 바꿔보자
# - Binning(수치형 -> 범주형) : 모델의 단순화 유도

# ### 특성공학
# - Family_Size가 (1) 1명이라면 Alone, (2) 2~4명이라면 Small, (3) 5명 이상이라면 Large 범주로 변경
# - cut함수 활용

# In[372]:


bins = [0, 1, 4, 20]
labels = ['Alone', 'Small', 'Large']
train['Family_Group'] = pd.cut(x=train['Family_Size'], bins=bins, labels=labels)


# In[373]:


test['Family_Group'] = pd.cut(x=test['Family_Size'], bins=bins, labels=labels)


# In[374]:


train.head(1)


# In[375]:


sns.countplot(data=train, x='Family_Group', hue='Survived')


# ### 특성공학
# - text 데이터 다루기(비정형 데이터)
# - Name 컬럼 : 중간에 호칭 정보 -> 호칭만 뽑아서 정형화 시키자

# In[376]:


train['Name']


# In[377]:


# 반환값이 리스트 : 호칭이 들어있는 문자열을 인덱싱
# 'Mr' 단어 찾기
# 1.
'Braund, Mr. Owen Harris'.split(',')


# In[378]:


# 2.
'Braund, Mr. Owen Harris'.split(',')[1]


# In[379]:


# 3.
' Mr. Owen Harris'.split('.')


# In[380]:


# 4.
' Mr. Owen Harris'.split('.')[0]


# In[381]:


# 5. 즉
'Braund, Mr. Owen Harris'.split(',')[1].split('.')[0] # 하지만 'Mr' 앞에 공백이 있어서 제거하자


# In[382]:


# 6. 공백제거하기
'Braund, Mr. Owen Harris'.split(',')[1].split('.')[0].strip()


# In[383]:


# 모든 이름에서 문자 가져오기
def split_title(row):
    return row.split(',')[1].split('.')[0].strip()


# In[384]:


# 새 컬럼 생성
train['Title'] = train['Name'].apply(split_title)
test['Title'] = test['Name'].apply(split_title)


# In[385]:


train.head(1)


# In[386]:


test.head(1)


# In[387]:


# 정형화된 Title 종류 확인하기
train['Title'].unique()


# In[388]:


plt.figure(figsize=(20,5))
sns.countplot(data=train, x='Title', hue='Survived')


# In[389]:


plt.figure(figsize=(20,5))
sns.countplot(data=train, x='Title', hue='Survived')
plt.ylim(0, 20)


# - Mr, Mrs, Miss : 성별과 관련된 호칭 : 학습에 적용시켜 볼 수 있을 것 같다
# - 나머지 호칭들은 인원수가 적고, 종류가 많기 때문에 범주를 통합시켜보자

# In[390]:


# map 함수 사용하기
title_dic = {
    'Mr' : 'Mr',
    'Mrs' : 'Mrs',
    'Miss' : 'Miss',
    'Master' : 'Master',
    'Don' : 'Other',
    'Rev' : 'Other',
    'Dr' : 'Other',
    'Mme' : 'Miss',
    'Ms' : 'Miss',
    'Major': 'Other',
    'Lady' : 'Miss',
    'Sir' : 'Other',
    'Mlle' : 'Other',
    'Col' : 'Other',
    'Capt': 'Other',
    'the Countess' : 'Other',
    'Jonkheer' : 'Other',
    'Dona' : 'Other'
}


# In[391]:


train['Title2'] = train['Title'].map(title_dic)


# In[392]:


# NaN 데이터 등장 : train에 없는 호칭이지만, test에만 등장하는 호칭이 있아
# titlet._dic : 추가해 주자('Donna')
test['Title2'] = test['Title'].map(title_dic)


# In[393]:


test['Title'].unique()


# In[394]:


test.info


# In[395]:


train.head()


# ### 티켓 정보는 사용하지 않겠다

# ### 사용하지 않을 컬럼 정리

# In[396]:


train.columns


# In[397]:


# 3가지 컬럼 삭제
train.drop(['Name', 'Ticket', 'Title'], axis=1, inplace=True)


# In[398]:


test.drop(['Name', 'Ticket', 'Title'], axis=1, inplace=True)


# In[399]:


train.columns


# In[400]:


test.columns


# ### 5. 모델링
# - 인코딩(문자형태의 데이터를 숫자 형태의 데이터로 변환)
#     1. label encoding
#     2. one-hot-encoding
# - 모델 선택 및 하이퍼파라미터 조정
# 
# ### 6. 모델 학습
# ### 7. 모델 평가

# In[401]:


test.columns


# In[402]:


pd.get_dummies(train['Title2'], prefix='컬럼이름')


# In[403]:


categorical_features = ['Sex', 'Cabin', 'Embarked', 'Family_Group', 'Title2']


# In[404]:


for feature_name in categorical_features:
    one_hot = pd.get_dummies(train[feature_name], prefix=feature_name) # 원-핫
    train.drop(feature_name, axis=1, inplace=True) # 글자 컬럼 삭제
    train = pd.concat([train, one_hot], axis=1) # 원본 데이터 + 원핫 데이텀


# In[405]:


train.head(1)


# In[406]:


for feature_name in categorical_features:
    one_hot = pd.get_dummies(test[feature_name], prefix=feature_name) # 원-핫
    test.drop(feature_name, axis=1, inplace=True) # 글자 컬럼 삭제
    test = pd.concat([test, one_hot], axis=1) # 원본 데이터 + 원핫 데이텀


# In[408]:


test.head(1)


# In[409]:


train.columns


# In[410]:


test.columns


# In[414]:


# 차집합 연산
set(train.columns) - set(test.columns)
# train의 Cabin에는 T라는 데이터가 있어서, 원핫인코딩때 컬럼 생성
# test에는 없어서 안 만들어짐
# -> 0으로 채워주자(왜냐면 없는 데이터니까)


# In[415]:


test['Cabin_T']=0


# In[416]:


train.columns


# In[417]:


test.columns


# In[418]:


train[train.columns]


# ### 문제와 정답으로 나누기

# In[436]:


X_train = train.drop('Survived', axis=1) # 문제 데이터
y_train = train['Survived'] # 정답 데이터


# In[437]:


X_train.head(1)


# In[438]:


X_test = test[X_train.columns]
# y_test는 kaggle 사이트에 있다


# ### 모델 선택

# In[439]:


from sklearn.neighbors import KNeighborsClassifier
from sklearn.tree import DecisionTreeClassifier


# In[440]:


# 모델 생성
knn_model = KNeighborsClassifier()
tree_model = DecisionTreeClassifier()


# ### train, validation 분리

# In[441]:


from sklearn.model_selection import train_test_split


# In[442]:


X_train, X_val, y_train, y_val = train_test_split(X_train, y_train)


# In[443]:


X_train.shape, y_train.shape


# ### 교차 검증

# In[444]:


from sklearn.model_selection import cross_val_score


# In[446]:


knn_result = cross_val_score(knn_model, X_train, y_train, cv=5)


# In[448]:


knn_result.mean()


# In[ ]:




