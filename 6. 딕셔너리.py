#!/usr/bin/env python
# coding: utf-8

# #### 딕셔너리(dictionary)
# - {key : value, key : value, ... } key와 value가 한쌍으로 이루어진 자료구조
# - 순서가 없는 형태
# - key 값은 절대 변할 수 없는 데이터

# In[2]:


# 딕셔너리 생성하기
person = {'이름' : '홍길동', '나이' : '100', '전화번호' : '0101234567' }
person


# In[14]:


# value 값 가져오는 방법 : key를 통하여 가져온다
# 1. key 값 적어서 가져오는 방법
person['이름']

# 2. get 기능 활용해서 가져오기
person.get('이름')


# In[5]:


# value 값 변경하기
# 딕셔너리명['key'] = 변경하고 싶은 데이터 
person['이름'] = '김영희'
person


# In[7]:


# 새로운 데이터 추가하기
# 딕셔너리명['추가하고 싶은 새로운 key'] = 추가하고 싶은 데이터 
person['생일'] = '1212'
person


# In[12]:


# 딕셔너리 안에 있는 값 삭제하기
del dic_test['날짜']
dic_test


# ![image.png](attachment:image.png)

# In[11]:


# 딕셔너리 생성
dic_test = {'노래제목':'아무노래'}

# 딕셔너리에 값 추가하기
dic_test['가수'] = '지코'
dic_test['날짜'] = '2020, 01, 13'
dic_test


# ### 딕셔너리 데이터 가져오기

# In[15]:


# 1. key 값 적어서 가져오는 방법
dic_test['가수']

# 2. get 기능 활용해서 가져오기
dic_test.get('가수')


# In[16]:


# [key] vs get(key)
dic_test['나이']


# In[17]:


print(dic_test.get('나이'))


# In[18]:


# dictionary 안에 있는 key 값만 가져오는 방법
dic_test.keys()


# In[19]:


# dictionary 안에 있는 value 값만 가져오는 방법
dic_test.values()


# In[21]:


# 자료구조 안에 해당하는 데이터가 존재하는지 여부를 알려주는 키워드
# 결과값은 논리자료형으로 출력
'가수' in dic_test


# In[22]:


# 딕셔너리 값 모두 삭제
dic_test.clear()


# ### 딕셔너리를 활용한 최종 실습

# ![image.png](attachment:image.png)

# In[39]:


score_dic = {'홍길동' : {'자바점수' : 100, '파이썬점수' : 90, '웹점수' : 70}, 
             '김영희':{'자바점수' : 90, '파이썬점수' : 87, '웹점수' : 70},
            '철수':{'자바점수' : 20, '파이썬점수' : 50, '웹점수' : 70}}


# In[40]:


score_dic


# In[42]:


dic
python = score_dic['홍길동']['파이썬점수'] + score_dic['김영희']['파이썬점수'] + score_dic['철수']['파이썬점수']
python
dic


# In[43]:


score_dic['홍길동']['자바점수']


# In[ ]:





# ### for문 사용해서 가져오기

# In[44]:


for key in score_dic.keys():
    print(key)


# In[58]:


dic_result = {'자바점수':0, '파이썬점수':0, '웹점수':0}

for value in score_dic.values():
    dic_result['자바점수'] += value.get('자바점수')
    dic_result['파이썬점수'] += value.get('파이썬점수')
    dic_result['웹점수'] += value.get('웹점수')
    
    
dic_result   


# ### 선생님 코드
# ![image.png](attachment:image.png)

# In[62]:



for value in score_dic.values():
    for key in value.keys():
        dic_result[key] += value.get(key)
    
dic_result   


# In[ ]:




