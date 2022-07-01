#!/usr/bin/env python
# coding: utf-8

# ![image.png](attachment:image.png)
# ![image-2.png](attachment:image-2.png)

# In[8]:


# 1차원데이터 Series, 2차원데이터 
# pandas
import pandas as pd


# In[4]:


#pop() 같은 함수 이름은 변수로 사용 가능
# if, for, while, del 같은 키워드는 변수로 사용 불가능


# ![image.png](attachment:image.png)

# In[5]:


# 1차원 데이터 Series 사용
pop = pd.Series([9904312,3448737,2890451,2466052])
pop


# In[25]:


# 인덱스 지정해서 생성
pop = pd.Series([9904312,3448737,2890451,2466052], index=['서울', '부산', '인천', '대구'])
pop


# In[10]:


# 원하는 값 인덱싱으로 가져오기
pop[1], pop['부산']


# In[14]:


# 여러가지 값을 인덱싱 하기
# 순서, 횟수 관계없이
# 리스트 형식으로 여러가지 값 인덱싱하기
a = pop[ ['인천', '서울', '인천'] ]
b = pop[ [0, 1, 3] ]
print(a)
print(b)


# In[18]:


# 슬라이싱 
# 인덱스 1이상 3미만
pop[ 1 : 3 ]


# In[19]:


# 직접 부여한 인덱스 값을 사용해서 슬라이싱을 할때는
# 인덱스 이상 인덱스 이하
pop[ '부산' : '대구']


# In[21]:


# 예외) 인덱스 번호를 숫자로 직접 부여
# 인덱싱은 부여한 숫자로
# 슬라이싱은 부여받은 숫자로
pop = pd.Series([9904312,3448737,2890451,2466052], index=[10, 11, 12, 13])
a = pop[11]
b = pop[ 1 : 3 ]
print(a)
print(b)


# ### Series 확인
# ![image.png](attachment:image.png)

# In[26]:


# 1.값(values), 2.인덱스(index), 3.타입(dtype) 총 3개 확인 가능
pop.values
pop.dtype
pop


# In[30]:


# Series에 이름 지정
# columns에 이름 달기
pop.name = '인구'

# index에 이름 달기
pop.index.name = '도시'

pop


# ![image-2.png](attachment:image-2.png)

# In[32]:


# dataFrame(Sefies(numpy))
import numpy as np


# In[33]:


pd.Series(np.arange(1,10))


# In[46]:


# Series 연산
# 인덱스 값이 지정한 값이 되어버리면 Series 연산시 인덱스 값이 동일한 것 끼리 연산
# 딕셔너리로 Series 생성
# 딕셔너리는 ket는 values로, values는 values로
data_dic = {"서울":9631481, "부산":3393191,"인천":2632035,"대전":1490158}
pop2 = pd.Series(data_dic)
pop2
# pop와 pop2는 다르다(대전이 있다.)

temp = pop - pop2
temp


# In[47]:


pop - pop


# In[37]:


pop / 100000


# In[49]:


# NaN 값 제외하고 확인하기
# 1. isnull()
# 2. notnull()
temp.isnull()


# In[61]:


temp.notnull()


# In[53]:


# null이 아닌 값들만 출력
temp[temp.notnull()]


# In[55]:


# 차이가 10만보다 큰 도시 출력
temp[temp > 100000]


# In[62]:


# Series 데이터 갱신, 삭제, 추가
# 1. 갱신
temp['대구'] = 5

# 2. 삭제
del temp['인천']

# 3. 추가
temp['광주'] = 10
temp


# ### DataFrame(2차원)

# In[11]:


# 딕셔너리 사용해서 데이터 프레임 생성
data = {
    "2015" : [9904312,3448737,2890451,2466052],
    "2010" : [9631482,3393191,2632035,2431774]
}

# 데이터 프레임 생성할때 인덱스 값 지정
# 첫번째 방법
ind = ['서울', '부산', '인천', '대구']
df = pd.DataFrame(data, index = ind)
df


# In[12]:


# 두번째 방법
# 인덱스 값 수정
# 데이터프레임이 만들어진 후에 사용
df.index = ['서울', '부산', '인천', '대구']
df


# In[15]:


# 리스트 사용해서 데이터 프레임 생성
data_list = [
    [9904312,3448737,2890451,2466052],
    [9361482,3393191,2632035,2431774]
]

ind = ['2015', '2010']
col = ['서울', '부산', '인천', '대구']
pd.DataFrame(data_list, index = ind, columns = col)
df


# In[14]:


# 전치 = 컬럼과 인덱스 바꾸기
df.T


# In[80]:


# DataRrame 확인
# 값(values), 인덱스(index), 컬럼(columns)
df.values
df.index
df.columns


# In[86]:


# 열 인덱싱
df['2015']
# 인덱스 슬라이싱
df[0:1]


# In[93]:


# 인덱서
# 행(index)과 열(columns)을 한번에 인덱싱/슬라이싱할 때 사용
# loc[]: 직접 부여한 인덱스, iloc[]:
# 인덱서[행 , 열]

# loc[]: 직접 부여한 인덱스,
# 1. 서울과 부산 인덱스
# 2. 2015 컬럼
df.loc['서울' : '부산', '2015']

# iloc : 자동으로 부여된 인덱스, 컬럼값 사용
df.iloc[0 : 2, 0]


# In[94]:


df


# In[100]:


# 서울, 인천 인덱스
# 2010 컬럼
df.loc[['서울', '인천'], '2010']


# In[101]:


# 하나의 값을 리스트에 넣어서 출력하면 데이터 프레임으로 출력
df.loc[['서울', '인천'],['2010']]


# In[103]:


# 하나의 값을 그냥 넣어서 출력하면 시리즈로 출력
df.loc[['서울', '인천'],'2010']


# In[105]:


# 데이터 추가
# 컬럼을 기준으로 데이터 추가
df['2005'] = [465, 789, 798, 465]
df


# In[108]:


# 인덱스 기준으로 데이터 추가
# 인덱서에 하나의 값만 적으면 해당 행의 모든 열을 가져옴
df.loc['광주'] = [46543, 6545132, 8798543]
df


# In[109]:


df.loc['순천'] = [353575, None, None]
df


# In[117]:


# 데이터 삭제
# 1. drop, 2.del
# axis = 0 : 인덱스 기준으로
# axis = 1 : 컬럼 기준으로
# df.drop('2015') #오류나옴
df.drop('2015', axis = 1)


# In[118]:


df


# In[1]:


df.drop('2015', axis = 1, inplace=True)
df


# In[123]:


df


# In[2]:


del df['2010']
df


# ### 6/22

# In[7]:


import pandas as pd
# euc-kr, utf-8 : 가장 대중적인 인코딩 방법
# cp949 : 위의 2개가 안되었을때 인코딩
# index_col 속성 = 원하는 컬럼을 인덱스로 사용 가능
data = pd.read_csv('./data/population_number.csv', encoding = 'euc-kr',
                  index_col = '도시')
data


# In[10]:


# 정렬
# 1. 인덱스 기준으로 : sort_index()
# 기본값은 오름차순(한글 ㄱㄷㄴ, 영어는 abc, 숫자는 123)
# ascending = False : 내림차순 정렬
data.sort_index(ascending = False) 


# In[13]:


# 2. 데이터 기준으로 : sort_values()
data.sort_values(by = ['지역', '2015'], ascending = False)


# In[14]:


# 값의 갯수를 세어주는 함수
# value_counts()
data['지역'].value_counts(0)


# In[15]:


# 중복 제거하고 값을 출력
# unique()
data['지역'].unique()


# In[18]:


# 결측치 채우는 함수
# fillna()
data.fillna(value = 100, inplace = True)
data


# In[23]:


score = pd.read_csv('./data/score.csv', encoding = 'euc-kr', index_col = '과목')
score


# In[26]:


# sum 함수는 기본적으로 열 단위로 계산
# 학급별 순위
score.sum().sort_values(ascending = False)


# In[27]:


# axis = 1 : 행 단위로 계산
score.sum(axis = 1)


# In[36]:


# 합계 구하기
score['합계'] = score.iloc[:, 0:4].sum(axis = 1)
score


# In[40]:


# 평균 구하기
score['평균'] = score.iloc[:, 0:4].mean(axis = 1)
score


# In[47]:


# 반평균 구하기
score.loc['반평균'] = score.iloc[0:5, 0:6].mean().sort_values(ascending = False)
score


# In[56]:


# min() : 최소값
# max() : 최대값
score.min()
score.min(axis = 1)


# In[51]:


score.max()


# In[64]:


#  과목별 최대값과 최소값의 차이
sub_min = score.loc[:'과학', :'4반'].min(axis = 1)
sub_min


# In[66]:


sub_max = score.loc[:'과학', :'4반'].max(axis = 1)
sub_max


# In[67]:


sub_max -sub_min


# In[70]:


# apply(복잡한 처리, 행/열)
# 행이나 열 단위로 복잡한 처리(직접 만든 함수)를 할 때 사용
def max_min(x):
    return x.max() - x.min()

# axis = 1 : 행 단위로 계산
score.loc[: '과학', : '4반'].apply(max_min, axis = 1)


# In[71]:


# 데이터를 카테고리로 나누기
# pd.cut(카테고리화 시킬 데이터, 카테고리의 범위, 할당시킬 값)
ages = [0, 2, 10, 21, 23, 37, 31, 61, 20, 41, 32, 100]


# In[72]:


범위 = [0, 15, 25, 35, 60, 99]
할당값 = ['미성년자', '청년', '중년', '장년', '노년']


# In[75]:


pd.cut(ages, 범위, labels = 할당값)


# In[1]:


import pandas as pd


# In[76]:


df1 = pd.DataFrame({'A': ['A0', 'A1', 'A2', 'A3'],
                   'B': ['B0', 'B1', 'B2', 'B3'],
                   'C': ['C0', 'C1', 'C2', 'C3'],
                   'D': ['D0', 'D1', 'D2', 'D3']},
                  index=[0, 1, 2, 3])
df2 = pd.DataFrame({'A': ['A4', 'A5', 'A6', 'A7'],
                   'B': ['B4', 'B5', 'B6', 'B7'],
                   'C': ['C4', 'C5', 'C6', 'C7'],
                   'D': ['D4', 'D5', 'D6', 'D7']},
                  index=[4, 5, 6, 7])
df3 = pd.DataFrame({'A': ['A8', 'A9', 'A10', 'A11'],
                   'B': ['B8', 'B9', 'B10', 'B11'],
                   'C': ['C8', 'C9', 'C10', 'C11'],
                   'D': ['D8', 'D9', 'D10', 'D11']},
                  index=[8, 9, 10, 11])


# In[90]:


df3


# In[82]:


# 데이터 프레임 병합
# concat()
pd.concat([df1, df2, df3])


# In[84]:


df4 = pd.DataFrame({'B': ['B2', 'B3', 'B6', 'B7'],
                   'D': ['D2', 'D3', 'D6', 'D7'],
                   'F': ['F2', 'F3', 'F6', 'F7']},
                  index=[2, 3, 6, 7])
df4


# In[86]:


# join outer : 모든걸 표시
# join inner : 같은 기준을 가지고 있는 것들만 표시
pd.concat([df1, df4], axis = 1, join = 'inner')


# In[88]:


pd.concat([df1, df4], axis = 1)


# In[92]:


# ignore_index = True : 데이터를 합치고 인덱스를 초기호하
pd.concat([df1, df4], axis = 1, ignore_index = True)


# In[95]:


# reindex(새로운 인덱스 값)
pd.concat([df1, df4], axis = 1).reindex(df1.index)


# In[2]:


df5 = pd.DataFrame({'key': ['K0','K2','K3','K4'],
'A':['A0','A1','A2','A3'],
'B':['B0','B1','B2','B3']})

df6 = pd.DataFrame({'key': ['K0','K1','K2','K3'],
'C':['C0','C1','C2','C3'],
'D':['D0','D1','D2','D3']})

df5


# In[3]:


df6


# In[6]:


# merge : values를 기준으로 데이터를 합침
# on : 기준이 되는 컬럼
# 1. how = outer : 전체 값 출력
# 2. how = inner : 기준이 같은 데이터만 남김(기존값)
# 3. how = left : 먼저 적은 데이터만 출력
# 4. how = right : 나중에 적은 데이터만 출력
pd.merge(df5, df6, on='key', how='outer')


# # 실습

# ![image.png](attachment:image.png)

# In[142]:


df2015 = pd.read_csv('./data/2015.csv', encoding = 'euc-kr', index_col = '관서명')
df2016 = pd.read_csv('./data/2016.csv', encoding = 'euc-kr', index_col = '관서명')
df2017 = pd.read_csv('./data/2017.csv', encoding = 'euc-kr', index_col = '관서명')


# In[153]:


df2016


# In[143]:


# 2017년도에만 광주지방경찰청이 존재한다.
df2017.index.unique()


# In[144]:


# 합쳐주기 위해서 2017년 데이터에서 광주지방경찰청 삭제
df2017.drop('광주지방경찰청', inplace = True)


# In[148]:


# 각 년도별 총계컬럼 만들기
df2015['총계'] = df2015.sum(axis = 1)
df2016['총계'] = df2016.sum(axis = 1)
df2017['총계'] = df2017.sum(axis = 1)


# In[150]:


# 발생건수 데이터 추출
# 1. df2015['구분'] == '발생건수'
# 2. df2015[df2015['구분'] == '발생건수']
s1 = df2015[df2015['구분'] == '발생건수'].loc[:,'총계']
s1.name = '2015총계'

s2 = df2016[df2016['구분'] == '발생건수'].loc[:,'총계']
s2.name = '2016총계'

s3 = df2017[df2017['구분'] == '발생건수'].loc[:,'총계']
s3.name = '2017총계'


# In[151]:


# 범죄 증감율 구하기
# (금년 - 작년)/작년 * 100
s4 = (s2 - s1)/s1 * 100
s4.name = '2015-2016 증감율'
s4

s5 = (s3 - s2)/s2 * 100
s5.name = '2016-2017 증감율'
s5


# In[155]:


total = pd.concat([s1, s4, s2, s5, s3], axis = 1)
total


# In[ ]:




