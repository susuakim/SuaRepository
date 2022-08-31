#!/usr/bin/env python
# coding: utf-8

# ### 보스턴 주택 값 예측하기(회귀)

# In[80]:


import numpy as np
import pandas as pd
import matplotlib.pyplot as plt
from sklearn.datasets import load_boston  # 보스턴 주택 값 데이터


# In[81]:


boston = load_boston() # 데이터 가져오기


# In[82]:


boston.keys()


# In[83]:


boston.data


# In[84]:


boston.target # 집 값들이 다양한 숫자로 나타나고 있음


# In[85]:


boston.feature_names


# In[86]:


# DataFrame으로 만들기
boston_df = pd.DataFrame(boston.data, columns=boston.feature_names)


# In[87]:


boston_df


# In[88]:


boston_df.shape


# In[89]:


# X데이터
boston_df.head(1)


# In[90]:


# y데이터
house_price = boston.target # 보스턴 주택 값


# In[91]:


boston_df.info()


# ### train, test로 분리

# In[92]:


from sklearn.model_selection import train_test_split


# In[93]:


X_train, X_test, y_train, y_test = train_test_split(boston_df, house_price, test_size=0.3)


# In[94]:


X_train.shape, y_train.shape


# In[95]:


X_test.shape, y_test.shape


# In[96]:


boston_copy = X_train.copy()
boston_copy


# In[97]:


# 정답 컬럼 추가하기
boston_copy['PRICE'] = y_train
boston_copy.head(1)


# In[98]:


import seaborn as sns


# In[99]:


# boston_df.corr() == 상관계수
plt.figure(figsize=(12, 12))
sns.heatmap(boston_copy.corr(), annot=True) # 열 분포 그래프


# ### LinearRegrssion

# In[100]:


from sklearn.linear_model import LinearRegression
from sklearn.model_selection import cross_val_score


# In[101]:


# 모델 생성하기
linear_model = LinearRegression()


# In[102]:


# 학습하기
linear_model.fit(X_train, y_train)


# In[103]:


linear_model.score(X_train, y_train) # R2score : sklearn에서 R2score라는 값을 제공한다


# In[104]:


linear_model.score(X_test, y_test)


# In[105]:


result = cross_val_score(linear_model, X_train, y_train, cv=5)
result


# ### 특성확장
# - (선형모델을 더 잘 다루기 위해서)

# In[106]:


extended_X_train = X_train.copy()


# In[107]:


for col1 in X_train.columns:
    for col2 in X_train.columns:
        extended_X_train[col1 + 'x' + col2] = X_train[col1] * X_train[col2]


# In[108]:


extended_X_train.shape


# In[109]:


# 데이터 학습
linear_model2 = LinearRegression()
linear_model2.fit(extended_X_train, y_train)


# In[110]:


result2 = cross_val_score(linear_model2, extended_X_train, y_train, cv=5)
result2


# In[111]:


result2.mean()


# In[112]:


extended_X_test = X_test.copy()


# In[113]:


for col1 in X_test.columns:
    for col2 in X_test.columns:
        extended_X_test[col1 + 'x' + col2] = X_test[col1] * X_test[col2]


# In[114]:


extended_X_test.shape


# In[115]:


linear_model2.predict(extended_X_test)


# In[116]:


linear_model2.score(extended_X_test, y_test)


# ### Ridge

# In[117]:


from sklearn.linear_model import Ridge


# In[118]:


ridge_model = Ridge()


# In[121]:


ridge_model.fit(extended_X_train, y_train)


# In[122]:


ridge_model.score(extended_X_train, y_train)


# In[123]:


ridge_model.score(extended_X_test, y_test)


# ### Lasso

# In[124]:


from sklearn.linear_model import Lasso


# In[125]:


lasso_model = Lasso()


# In[126]:


lasso_model.fit(extended_X_train, y_train)


# In[127]:


lasso_model.score(extended_X_train, y_train)


# In[128]:


lasso_model.score(extended_X_test, y_test)


# ### Ridge vs Lasso
# - 제약조건에 따른 두 모델의 가중치 확인
# - Lasso : L1 규제 사용, 특정 계수가 0이 될 수 있다 => 특성 선택이 이루어짐
# - Ridge : L2 규제 사용, 규제가 골고루 적용 => 0에 가까워짐(0은 아님!!)

# In[129]:


alpha_list = [0.001, 0.01, 0.1, 10, 100, 1000] 
# 0을 작성안하는 이유 => 0을 준다는 거는 정규화항을 사용안하는 거랑 같다 

ridge_coef_list = []
lasso_coef_list = []

for a in alpha_list:
    r_model = Ridge(alpha = a)  # 제약조건에 따른 모델 생성
    l_model = Lasso(alpha = a)
    
    r_model.fit(X_train, y_train)
    l_model.fit(X_train, y_train)
    
    ridge_coef_list.append(r_model.coef_)
    lasso_coef_list.append(l_model.coef_)


# In[132]:


r_df = pd.DataFrame(np.array(ridge_coef_list).T,
            columns=alpha_list)
r_df


# In[133]:


l_df = pd.DataFrame(np.array(lasso_coef_list).T,
            columns=alpha_list)
l_df
# 1000일때는 0.0이다 => 제약조건이 너무 걸려있어서 0이 나왔음


# In[134]:


# 어느정도 제약조건을 주어야 좋을까?
alpha_list = [0.001, 0.01, 0.1, 10, 100, 1000] 
scoce_list = []

for a in alpha_list:
    ridge_model = Ridge(alpha = a)
    ridge_result = cross_val_score(ridge_model, extended_X_train, y_train, cv=5)
    scoce_list.append(ridge_result.mean())


# In[137]:


plt.figure(figsize=(45,5))
plt.plot(alpha_list, scoce_list)
plt.xticks(alpha_list)
plt.grid()
plt.xlabel('alpha')
plt.ylabel('score')
plt.show()


# ### 결정 트리 회귀 모형

# In[138]:


from sklearn.tree import DecisionTreeRegressor # 회귀


# In[139]:


tree_reg = DecisionTreeRegressor(max_depth=5, random_state=11)


# In[140]:


tree_reg.fit(X_train, y_train)


# In[141]:


from sklearn.model_selection import GridSearchCV


# In[142]:


tree_reg2 = DecisionTreeRegressor()


# In[143]:


params = {'max_depth' : [3,5,7],
         'max_leaf_nodes' : [4,6,8],
         'min_samples_split' : [4,6,8],
         'min_samples_leaf' : [3,5,7]}

grid = GridSearchCV(tree_reg2, params, cv=5)

grid.fit(X_train, y_train)


# In[145]:


grid.best_params_ # 가장 좋은 성능의 조합을 보여준다


# In[146]:


print(grid.best_params_)
print(grid.best_score_)


# In[147]:


# gridSearch를 통해 가장 좋은 성능을 보이는 모델 제공
best_model = grid.best_estimator_


# In[149]:


pred_test = best_model.predict(X_test) # 예측한 값


# In[150]:


pred_train = best_model.predict(X_train)


# In[151]:


from sklearn.metrics import mean_squared_error


# In[153]:


# 성능 평가하기
print("학습 데이터에 대한 평가 결과", mean_squared_error(pred_train, y_train))
print("학습 데이터에 대한 평가 결과", mean_squared_error(pred_test, y_test))


# ### 랜덤 포레스트 회귀 모형

# In[154]:


from sklearn.ensemble import RandomForestRegressor


# In[155]:


rf_reg = RandomForestRegressor()


# In[156]:


rf_reg.fit(X_train, y_train)


# In[ ]:




