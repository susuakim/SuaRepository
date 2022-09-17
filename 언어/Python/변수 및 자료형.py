#!/usr/bin/env python
# coding: utf-8

# ## 단축키
# ![image.png](attachment:image.png)
# 
# ## 공통단축키
# ![image-2.png](attachment:image-2.png)

# In[37]:


num = 3


# In[38]:


print(num)


# In[39]:


num


# In[40]:


num1 = 3.5


# In[41]:


print(num1)


# In[42]:


s1 = 'Hello World'
s2 = "Hi"
print(s1)
print(s2)


# In[43]:


ba = True
bb = False
print(ba)
print(bb)


# In[44]:


a = 10
b = 15
print(a)
print(b)


# In[45]:


temp = a
a = b
b = temp
print(a)
print(b)


# In[46]:


c, d = 11, 12, 15
print(c, d)


# In[47]:


num1


# ![image.png](attachment:image.png)

# In[48]:


s1 = 'she\' s gone'
print(s1)


# In[49]:


s2 = "he said that \"she is gone\""
print(s2)


# In[53]:


s3 = "he said that 'she is gone'"


# In[54]:


print(s3)


# In[55]:


s5 = "자세히보아야 이쁘다. \n오래보아야."
print(s5)


# In[58]:


s6 = ""자세히보아야 이쁘다.
오래보아야 사랑스업다
너도그렇다""
print(s6)


# ### 인덱싱: 무엇인가를 가리킨다.
# ### 슬라이싱: 무엇인가를 잘라낸다.

# In[59]:


s7 = 'My name is MH'
print(s7[8])


# In[61]:


print(s7[3:7])


# In[62]:


print(s7[8:10])


# In[64]:


s8 = "2020년 3월 3일의 날씨는 맑음입니다."
print('날짜   ' + s8[:11])


# 1번째 방법

# In[65]:


month = 6
day = 8
s8 = "오늘은 %d월 %d일 입니다."%(month, day)
print(s8)


# 2번째 방법

# In[66]:


month = 6
day = 8
s9 = "오늘은 {}월 {}일 입니다".format(month, day)


# 3번째 방법

# In[69]:


month = 6
day = 8
s = '오늘은 {month}월 {day}일 입니다'
print(s)


# In[ ]:





# In[70]:


x = 100
y = 200
sum2 = x + y
a = "{}와 {}의 합은 {}입니다.".format(x, y, sum2)
print(a)


# In[72]:


s11 = 'hi, gmgm '
print(s11.count('m'))
print(s11.find('i'))


# In[ ]:





# In[ ]:





# In[ ]:





# In[ ]:





# In[ ]:





# In[ ]:





# In[ ]:





# In[ ]:




