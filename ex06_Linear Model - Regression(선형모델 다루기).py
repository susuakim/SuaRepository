#!/usr/bin/env python
# coding: utf-8

# ### 1. 성적 데이터 생성

# In[1]:


import numpy as np
import pandas as pd


# In[28]:


# DataFrame
data = pd.DataFrame([[2, 20],
                     [4, 40],
                     [8, 80],
                     [9, 90]],
                     columns = ['시간', '성적'],
                     index = ['수아', '형주', '혜지', '자람'])
data


# ![image.png](attachment:image.png)

# ### 1. 수학 공식을 이용한 해석적 모델

# In[29]:


from sklearn.linear_model import LinearRegression


# In[30]:


# 선형 모델 생성
linear_model = LinearRegression()


# In[31]:


# 문제 데이터
data['시간']


# In[32]:


# 정답 데이터
data['성적']


# In[33]:


linear_model.fit(data[['시간']],data['성적'] ) # 학습시킬 데이터 X, 정답 데이터 Y


# In[34]:


# 가중치
linear_model.coef_


# In[35]:


# 편향
linear_model.intercept_


# In[36]:


# 예측
linear_model.predict([[7]])


# ### H(x) = w*x + b

# In[37]:


def h(w, x, b):
    return w*x+b


# ### 비용함수
# - 평균제곱오차(MSE)
# ![image.png](attachment:image.png)

# In[41]:


def cost(data, target, weight, intercept): # MSE 구하는 함수
    y_pre = h(weight, data, intercept)  # 예측값
    return ( (y_pre - target) **2 ).mean()  # 평균제곱오차(MSE)


# In[42]:


# MSE가 0! 오차가 없다!
cost( data['시간'], data['성적'], 10, 0 )


# In[43]:


# 가중치 10->20, MSE는 0->4125
cost( data['시간'], data['성적'], 20, 0 )


# In[44]:


# 가중치 10->8, MSE는 0->165
cost( data['시간'], data['성적'], 8, 0 )


# ![image.png](attachment:image.png)

# ### SGDRegressor 사용하기 
# - 경사하강법

# In[46]:


from sklearn.linear_model import SGDRegressor


# In[50]:


sgd_model = SGDRegressor(max_iter=1000,  # 가중치 수정하는 횟수
            eta0 = 0.01,  # 학습률(Learning rate)
            verbose = 1)  # 학습 과정 확인 가능


# In[51]:


sgd_model.fit( data[['시간']], data['성적'] )
# Epoch 1 : 첫번째 학습 ,,, n번째 학습
# loss : 손실값


# In[52]:


sgd_model.predict([[7]])


# In[53]:


sgd_model.coef_  # 계수


# In[54]:


sgd_model.intercept_


# In[ ]:




