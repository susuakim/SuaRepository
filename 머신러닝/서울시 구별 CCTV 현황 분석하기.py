#!/usr/bin/env python
# coding: utf-8

# ### 실습목표

# #### 서울시 구별 CCTV 현황 분석
# - pandas, matplotlib 사용하기
# - 서울시 각 구별 CCTV 현황 살펴보기, 인구대비 CCTV 비율이 높은/낮은 지역 알아보기

# In[6]:


import numpy as np
import pandas as pd
import matplotlib.pyplot as plt


# #### 서울시 구별 cctv 현황 데이터 불러오기 파일

# In[10]:


cctv_seoul= pd.read_csv('CCTV_in_Seoul.csv')
cctv_seoul


# In[11]:


cctv_seoul.head()


# In[12]:


cctv_seoul.tail(3)


# In[21]:


# 컬럼명 바꾸기(기관명 > 구)
cctv_seoul.rename(columns={'기관명' : '구'}, inplace= True) 


# In[24]:


# 파일 형시때문에 컬럼에 해당하는 부분을 데이터로 인식함
pop_seoul =pd.read_excel('population_in_Seoul.xls', header=2, usecols='B,D,G,J,N')

# header : 읽고 싶은 row index
# usecols : 읽고 싶은 column 선택


# In[25]:


pop_seoul.head(2)


# In[29]:


# 컬럼명 수정
pop_seoul.columns = ['구', '인구수', '한국인수', '외국인수', '65세이상고령자']


# In[30]:


pop_seoul.head(2)


# ### 결측치 확인

# In[32]:


cctv_seoul.info()
# 결측치 없다


# In[34]:


pop_seoul.info()


# In[38]:


# 결측치 확인
# 불리언(T/F) 인덱싱 : True에 해당하는 데이터만 가져오기
pop_seoul[pop_seoul['인구수'].isnull()]


# In[39]:


pop_seoul['인구수'].isnull()


# In[44]:


# 결측치 삭제
pop_seoul.drop(26, inplace=True)


# In[45]:


pop_seoul


# ### cctv가 많거나 적은 지역 파악해보자(각각 5구씩)
# - 많은 지역 5개

# In[49]:


# ascending = True > 기본값
cctv_seoul.sort_values(by='소계', ascending=False)


# - 적은 지역 5개

# In[50]:


cctv_seoul.sort_values(by='소계', ascending=False).tail()


# In[51]:


cctv_seoul.sort_values(by='소계').head()


# In[53]:


data_result = pd.merge(cctv_seoul, pop_seoul, on='구')


# In[54]:


data_result.head(1)


# ### 인구수대비 CCTV 비율이 높은/낮은 지역 알아보기
# - 특성공학

# In[57]:


data_result['인구대비 CCTV비율'] = (data_result['소계']/data_result['인구수'])*100


# In[59]:


data_result.head(2)


# In[61]:


# 인구수 대비 CCTV가 많은 지역
data_result.sort_values(by='인구대비 CCTV비율')[['구', '인구대비 CCTV비율']]


# In[65]:


# 한글 지원 폰트로 바꿔주기
from matplotlib import rc
rc('font', family='Malgun Gothic')


# In[69]:


plt.figure(figsize=(10,7)) #(가로, 세로)
plt.barh(data_result.sort_values(by='인구대비 CCTV비율')['구'], 
        data_result.sort_values(by='인구대비 CCTV비율')['인구대비 CCTV비율'])
plt.xlabel('인구대비 CCTV 비율')
plt.ylabel('구별')
plt.grid()
plt.show()


# In[70]:


# 구 컬럼을 인덱스로 설정
data_result.set_index('구', inplace=True)
data_result.head(1)


# In[71]:


# 상관계수
data_result.corr()
# cctv 숫자와 관련된 컬럼이 뭘까?


# In[72]:


data_result.corr()['소계']


# In[ ]:




