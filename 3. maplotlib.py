#!/usr/bin/env python
# coding: utf-8

# In[2]:



import matplotlib.pyplot as plt


# In[7]:


# matplotlib.pyplot 불러오기
import matplotlib.pyplot as plt


# In[10]:


# line plot
x = [1, 2, 3]
y = [2, 4, 6]

x1 = [1, 2, 3]
y1= [2, 4, 6]

x2 = [1, 2, 3]
y2 = [2, 3, 4]

# plot = 그래프 그리기
plt.plot(x1, y1)
plt.plot(x2, y2)

# show = 출력
# show = 원하는 곳에서 출력하기위해, 이 코드 위에까지 그린 그래프를 출력하기
plt.show()


# In[11]:


# line style
plt.plot(x1, x2, ls='--')
plt.show()


# In[12]:


# marker
plt.plot(x, y, marker = 'o')
plt.show()


# In[13]:


# line width
plt.plot(x, y, lw = 50)
plt.show()


# In[14]:


# markersize
plt.plot(x, y, ms = 10, marker ='o')
plt.show()


# In[15]:


# line color
plt.plot(x, y, color = 'yellow')
plt.show()


# In[16]:


# 한글 인식하게
from matplotlib import font_manager, rc
font_name = font_manager.FontProperties(fname ='c:/Windows/Fonts/malgun.ttf').get_name()
rc('font', family = font_name)


# In[17]:


# 그래프 범위 지정
plt.plot(x1, y2, label = 'blue')
plt.plot(x2, y2, label = 'orange')

plt.xlim(-2, 10) # x축 범위 지정
plt.ylim(-5, 12) # y축 범위 지정

plt.xticks([0, 5, 6, 8]) # x축 값 지정
plt.yticks([0, 3, 6]) # y축 값 지정

plt.grid() # 틱 위치 보기

plt.legend() # plot에 있는 label 출력(반드시 적어줘야만 출력 됨)

plt.xlabel("X축") # x축 이름 달기
plt.ylabel("Y축", rotation = 0) # y축 이름 달기

plt.title('그래프 제목') # 그래프 제목 달기

plt.show()


# # 실습

# In[24]:


import pandas as pd
data = pd.read_csv('./data/Traffic_Accident_2017.csv', encoding = 'euc-kr')
data


# In[26]:


y1 = data[data['주야'] == '야간'].loc[:, '위도']
y1


# In[22]:


# scatter : 산점도
x = data['경도']
y = data['위도']


plt.scatter(x, y, alpha = 0.1) # alpha : 투명도
plt.xlim(123, 133) # 왼쪽으로 치우치는 현상 해결
plt.show()


# In[4]:


# bar 차트
# 요일별로 사고 수를 시각화
# x에는 요일, y에는 요일별 사고수

temp = data['요일'].value_counts()

y = temp[ ['월','화','수','목','금','토','일'] ]
x = ['월','화','수','목','금','토','일']
x = y.index


plt.bar(x, y)
plt.show()


# ![image.png](attachment:image.png)

# In[5]:


# bar 차트
# 요일별로 사고 수를 시각화
# x에는 요일, y에는 요일별 사고수

temp = data['요일'].value_counts()
x = ['월','화','수','목','금','토','일']
x = y.index
y = temp[ ['월','화','수','목','금','토','일'] ]

plt.title('')

plt.bar(x, y)

plt.ylim(500, 620)

plt.xlabel('요일')
plt.ylabel('사고 건수', rotation = 0, position=(1, 0.55)) #포지션 : (x, y 축에 대한 위치)

plt.show()


# In[6]:


import matplotlib
matplotlib.__version__


# In[7]:


# 차 VS 차 사고의 사상자수를 도시별로 시각화
data.columns


# In[8]:


data['발생지시도'].unique()


# In[9]:


data['사고유형_대분류'].unique()


# In[16]:


# 사고유형 대분류에 차대차 값들 중 
# 사상자수와 발생지시도 컬럼을 사용

# 사고유형 대분류에 차대차 값을 가지고 있는 인덱스 : 불리언 인덱싱
# 사상자수와 발생지시도 컬럼 : 리스트 사용 인덱싱

result = data.loc[data['사고유형_대분류']=='차대차', ['사상자수', '발생지시도']].groupby('발생지시도').sum()
result


# In[64]:


x = result.index
y = result.values

plt.figure(figsize = (15, 8)) #그래프 크기 조정

plt.plot(x, y)

plt.xlabel('지역')
plt.ylabel('사상자수', rotation = 0)
plt.title('차 vs 차 교통사고의 사상자수')

plt.show()


# In[77]:


plt.figure(figsize = (15, 8)) #그래프 크기 조정

plt.bar(x, y_bar)

plt.xlabel('지역')
plt.ylabel('사상자수', rotation = 0)
plt.title('차 vs 차 교통사고의 사상자수')

plt.show()


# In[67]:


# y 데이터 1차원으로 만들기
# 1번째 방법
y_bar = []
for i in range(len(y)):
    y_bar.append(y[i,0])
y_bar


# In[68]:


y_bar2 = y.reshape(17)
y_bar2


# In[72]:


y_bar3 = y.reshape(-1)
y_bar3


# In[76]:


y_bar4 = y[:,0]
y_bar4


# In[80]:


# 교통사고가 가장 많이 발생하는 시간대를 알아보자
time = data['발생년월일시'] % 100
time


# In[89]:


# 0~2, 3~5 ,,,
범위 = [-1, 2, 5, 8, 11, 14, 17, 20, 23]
라벨 = ['0~2','3~5','6~8','9~11','12~14','15~17','18~20','21~23']

result = pd.cut(time, bins = 범위, labels = 라벨).value_counts().sort_index()
result


# In[91]:


plt.pie(result, labels = 라벨, autopct='%1.1f%%') # 정규표현식: '%1.1f%%'
plt.show()


# In[ ]:




