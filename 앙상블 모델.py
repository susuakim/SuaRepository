#!/usr/bin/env python
# coding: utf-8

# ### 앙상블 모델

# In[ ]:


from sklearn.ensemble import RandomForestClassifier


# In[ ]:


# 배깅 
rf_model = RandomForestClassifier(random_state=777,
                      n_estimators=1000, # 생성될 나무 개수
                      max_depth=7,       # 나무의 길이
                      max_features=0.5)  # 사용할 컬럼 갯수 비율


# In[ ]:


rf_model.fit(X_train, y_train)


# In[ ]:


from sklearn.model_selection import cross_val_score


# In[ ]:


rf_result = cross_val_score(rf_model,X_train,y_train, cv=5)
rf_result


# In[ ]:


rf_result.mean()


# ##### 하이퍼파라미터튜닝 - grid search

# In[ ]:


from sklearn.model_selection import GridSearchCV


# In[ ]:


# 내가 궁금한 파라미터  - 딕셔너리 
params = {
    'n_estimators' : [1000, 1500, 2000],
    'max_depth' : [3,5,7,9],
    'max_features' : [0.3,0.5,0.7],
    'min_samples_leaf' : [10,20]
    
}


# In[ ]:


grid=GridSearchCV(rf_model,params, cv=3)


# In[ ]:


grid.fit(X_train, y_train)


# In[ ]:


# 가장 좋은 조합!
grid.best_params_


# In[ ]:


# 가장 좋은 조합의 score
grid.best_score_


# In[ ]:


# 가장 좋은 모델
grid.best_estimator_


# ##### 부스팅 모델

# In[ ]:


from sklearn.ensemble import GradientBoostingClassifier


# In[ ]:


gb_model = GradientBoostingClassifier(n_estimators=1000,
                           max_depth=5,
                           learning_rate=0.01) # 오차를 반영하는 정도


# In[ ]:


gb_model.fit(X_train, y_train)


# ##### xgboost

# In[ ]:


get_ipython().system('pip install xgboost')


# In[ ]:


from xgboost import XGBClassifier


# - booster -> gbtree, gblinear
# - objective 
# > 이진분류 : 'binary:logistic', <br>
# > 다중분류 : 'multi:softmax' <br>
# > 회귀 : 'reg:squarederror'

# In[ ]:


xgb = XGBClassifier(booster='gbtree',
             objective= 'binary:logistic',
             n_estimator=1000,
             max_depth=3,
             learning_rate=0.01)


# In[ ]:




