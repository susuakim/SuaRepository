#!/usr/bin/env python
# coding: utf-8

# ### 1. 목표
# - 버섯의 특징을 활용해 독/식용 버섯을 분류
# - Decision tree 시각화 & 과대적합 속성 제어
# - 특성 중요도 확인하기

# In[1]:


import pandas as pd
import matplotlib.pyplot as plt


# In[3]:


data = pd.read_csv('mushroom.csv')


# In[4]:


data.head(3)


# In[6]:


data.info() # 결측치 없음


# In[ ]:


data.describe()

