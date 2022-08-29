#!/usr/bin/env python
# coding: utf-8

# In[324]:


import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import seaborn as sns

from sklearn.neighbors import KNeighborsClassifier
from sklearn.tree import DecisionTreeClassifier
from sklearn.model_selection import train_test_split
from sklearn.model_selection import cross_val_score
from sklearn.preprocessing import StandardScaler


# ### 1. 문제 정의
# - 어떤 사람이 일년에 개인 수입이 $50k 달러 초과인지 예측해보자
# - "결혼을 했고( Married-civ-spouse), 남자고( Male), 동양인인( White) 사람이 수입이 많다"라고 정의하고 데이터 분석을 해보자

# ### 2. 데이터 수집

# In[325]:


train = pd.read_csv('train.csv')
test = pd.read_csv('test.csv')


# In[326]:


train.head(2)


# In[327]:


test.head(2)


# In[328]:


train


# In[329]:


train.shape, test.shape


# In[330]:


test.info()


# ### 3. 데이터 전처리

# ### 컬럼 workclass의 결측치를 제일 작은 수치인 ' Never-worked'로 채워주기

# In[331]:


train['workclass'].value_counts()


# In[332]:


train['age'][train['age'] == 21]


# In[333]:


train['workclass'][train['workclass'] == " Private"]


# In[334]:


# 결측치를 제일 작은 수치인 ' Never-worked'로 채워주기
train.replace({'workclass': {' ?' : ' Never-worked'}}, inplace=True)
test.replace({'workclass': {' ?' : ' Never-worked'}}, inplace=True)


# In[335]:


train['workclass'].value_counts()


# In[336]:


test['workclass'].value_counts()


# In[337]:


test.shape, train.shape


# ### 컬럼 occupation의 결측치를 제일 작은 수치인 ' Armed-Forces'로 채워주기

# In[338]:


train['occupation'].value_counts()


# In[339]:


# 결측치를 제일 작은 수치인 ' Armed-Forces'로 채워주기
train.replace({'occupation': {' ?' : ' Armed-Forces'}}, inplace=True)
test.replace({'occupation': {' ?' : ' Armed-Forces'}}, inplace=True)


# In[340]:


train['workclass'].value_counts()


# In[341]:


test['workclass'].value_counts()


# ### 컬럼 native-country의 결측치를 제일 작은 수치인 ' Holand-Netherlands'로 채워주기

# In[342]:


train['native-country'].value_counts()


# In[343]:


train.replace({'occupation': {' ?' : ' Holand-Netherlands'}}, inplace=True)
test.replace({'occupation': {' ?' : ' Holand-Netherlands'}}, inplace=True)


# In[344]:


train['workclass'].value_counts()


# In[345]:


test['workclass'].value_counts()


# ### 필요없는 컬럼 삭제
# - relationship : marital-status, sex를 보고 충분히 알 수 있다고 생각해서 컬럼 삭제
# - native-country : race를 보고 예상가능 하다고 생각해서 컬럼 삭제

# In[346]:


# 2가지 컬럼 삭제
train.drop(['relationship', 'native-country'], axis=1, inplace=True)
test.drop(['relationship', 'native-country'], axis=1, inplace=True)


# In[347]:


train.info()


# In[348]:


test.info()


# ### 4. 탐색적 데이터 분석

# In[349]:


# 남자일 때 수입을 확인
sns.countplot(data=train, x='sex', hue='income')


# In[350]:


# 결혼했을 때 수입을 확인
sns.countplot(data=train, x='marital-status', hue='income')


# In[351]:


# 동양인일 때 수입 확인
sns.countplot(data=train, x='race', hue='income')


# ## --------------

# In[352]:


train.head(1)


# In[353]:


train.info(0)


# In[354]:


categorical_features = ['workclass', 'education', 'marital-status', 'occupation', 'race', 'sex']


# In[355]:


for feature_name in categorical_features:
    one_hot = pd.get_dummies(train[feature_name], prefix=feature_name) # 원-핫
    train.drop(feature_name, axis=1, inplace=True) # 글자 컬럼 삭제
    train = pd.concat([train, one_hot], axis=1) # 원본 데이터 + 원핫 데이텀


# In[356]:


for feature_name in categorical_features:
    one_hot = pd.get_dummies(test[feature_name], prefix=feature_name) # 원-핫
    test.drop(feature_name, axis=1, inplace=True) # 글자 컬럼 삭제
    test = pd.concat([test, one_hot], axis=1) # 원본 데이터 + 원핫 데이텀


# In[357]:


train.info()


# In[358]:


test.info()


# ### 5. 모델 평가

# ### 문제와 정답 나누기

# In[359]:


X_train = train.drop('income', axis=1) # 문제 데이터
y_train = train['income'] # 정답 데이터


# In[360]:


test.info()


# In[361]:


X_test = test.iloc[:]
X_test.head(1)


# In[362]:


X_train.head(1)


# In[363]:


X_train.info()


# In[ ]:





# ### 모델 선택

# In[364]:


knn_model = KNeighborsClassifier()
tree_model = DecisionTreeClassifier()


# In[365]:


X_train, X_val, y_train, y_val = train_test_split(X_train, y_train)


# In[366]:


X_train.shape, y_train.shape


# In[367]:


from sklearn.model_selection import cross_val_score


# In[368]:


X_train


# In[369]:


y_train


# In[370]:


knn_result = cross_val_score(knn_model, X_train, y_train, cv=5)
knn_result


# In[371]:


knn_result.mean()


# ### 교차 검증(== 성능 평가)

# In[372]:


knn_result = cross_val_score(knn_model, X_train, y_train, cv=5)
knn_result


# In[373]:


knn_result.mean()


# ### 하이퍼파라미터튜닝

# In[374]:


score_list = []

for k in range(1, 150) : # 이웃이 작으면 복잡(과대적합), 크면 단순(과소적합)
    knn_model = KNeighborsClassifier(n_neighbors=k) # 이웃의 수에 따른 모델 생성
    knn_result = cross_val_score(knn_model, X_train, y_train, cv=5) # 교차검증값
    score_list.append(knn_result.mean())


# In[375]:


plt.figure(figsize=(45, 5))
plt.plot(range(1, 150), score_list)
plt.xticks(range(1, 150))
plt.grid()
plt.xlabel('n_neighbors')
plt.ylabel('score')
plt.show()


# In[376]:


tree_result = cross_val_score(tree_model, X_train, y_train, cv=5)
tree_result


# In[377]:


# tree 모델로 하이퍼파라미터 튜닝
for tree in range(1, 150) : # 깊이가 깊으면 복잡, 얕으면 단순
    tree_model = DecisionTreeClassifier(max_depth=tree) # 깊이에 따른 모델 생성
    tree_result = cross_val_score(tree_model, X_train, y_train, cv=5) # 교차검증값
    score_list.append(tree_result.mean())


# ### 모델 학습 및 평가

# In[378]:


cross_val_score(final_knn, X_train, y_train, cv=5).mean()


# In[387]:


final_knn = KNeighborsClassifier(n_neighbors=8)
final_knn.fit(X_train, y_train)

final_tree = DecisionTreeClassifier(max_depth=5)
final_tree.fit(X_train, y_train)


# In[380]:


X_test.shape


# In[381]:


X_train.shape, y_train.shape


# In[388]:


final_knn.predict(X_test)


# In[389]:


final_tree.predict(X_test)


# ### knn Scaler 적용

# In[383]:


scaler = StandardScaler()


# In[384]:


scaler.fit(X_train)


# In[385]:


trainsform_X_train = scaler.transform(X_train)
trainsform_X_train # train의 범위를 맞추는 것


# In[386]:


trainsform_X_test = scaler.transform(X_test)
trainsform_X_test


# ### Scalilng 된 데이터 성능 확인

# In[390]:


scaling_result = cross_val_score(knn_model, trainsform_X_train, y_train, cv=5)


# In[391]:


scaling_result.mean()


# ### 예측 결과 저장하기

# In[392]:


tree_pre = final_tree.predict(X_test)
tree_pre


# In[394]:


submission = pd.read_csv('sample_submission.csv')
submission.head(1)


# In[395]:


submission['income'] = tree_pre


# In[396]:


submission.to_csv('tree_submission01.csv', index=False) 


# In[ ]:




