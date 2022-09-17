#!/usr/bin/env python
# coding: utf-8

# # <<연산자>>

# ### 연산자의 종류
# ![image.png](attachment:image.png)

# ### 산술연산자
# ![image-2.png](attachment:image-2.png)

# In[22]:


#숫자 나누기
num1 = 10
num2 = 7

print(num1/num2)
print(num1%num2)
print(num1//num2)


# In[23]:


#문자열 더하기
str1 = '안녕'
str2 = '하세요'
print(str1 + str2)

str2 = '10'
str3 = '7'
print(str2 + str3)


# In[24]:


#숫자와 문자열 더하기
num1 = 10
str5 = '7'
# print(num1 + str5) => 에러발생

print(str(num1) + str5)
print(num1 + int(str5))


# In[25]:


#문자포맷팅
num1 = 10
str5 = '7'
print(num1 + str5)


# In[26]:


#예제
num1 = 23
num2 = 3
result1 = "더하기 결과:  {}".format(num1+num2)
result2 = "빼기 결과:  {}".format(num1-num2)
result3 = "곱하기 결과:  {}".format(num1*num2)
result4 = "나누기 결과:  {}".format(num1/num2)

print(result1)
print(result2)
print(result3)
print(result4)


# In[27]:


#입력받기
num1 = input('정수를 입력하세요>>  ') 
# input은 뭐든 문자열로 인식한다
print(num1)


num2 = input('정수를 입력하세요>>  ')
print(int(num2)+1)

num3 = int(input('정수를 입력하세요>>  '))
print(num3+1)


# In[28]:


#데이터 타입 확인
num4 = input('정수를 입력하세요>>  ')
print(type(num4))


# In[32]:


#예제
num1 = int(input('정수를 입력하세요>> '))
num2 = int(input('정수를 입력하세요>> '))

print("더하기 결과:  {}".format(num1+num2))
print("빼기 결과:  {}".format(num1-num2))
print("곱하기 결과:  {}".format(num1*num2))
print("나누기 결과:  {}".format(num1/num2))


# In[42]:


#예제
time = int(input("시간 입력>>  "))
hour = time // 3600
minute = (time - hour*3600) // 60
second = time - ((hour*3600) + (minute * 60))
print("{}시간 {}분 {}초".format(hour, minute, second))


# #### 예제 다른 방법
# ![image.png](attachment:image.png)

# In[43]:


#문자열은 무조건 더하기만 가능
s = 'X'
print(s * s)


# In[44]:


#문자열과 숫자 연산 => 곱하기 연산만 가능
s = 'X'
print(s*5)


# In[48]:


#지수연산자(**)
num = int(input('정수 입력>>  '))
power = int(input('지수 입력>> '))
print('{}의 {}승은 {}입니다.'.format(num, power, num**power))


# ### 대입연산자
# ![image.png](attachment:image.png)

# In[49]:


num = 27
num += 3
print(num)


# In[53]:


#치환하기
num1 = 15
num2 = 3
print(num1, num2)

temp = num1
num1 = num2
num2 = temp
print(num1, num2)

num1, num2 = num2, num1
print(num1, num2)


# ### 비교연산자
# ![image.png](attachment:image.png)

# In[55]:


#비교연산자
a = 3
b = 7
print(a < b)
print(a >= b)
print(a == b)
print(a != b)


# ### 논리연산자
# ![image.png](attachment:image.png)

# In[58]:


a = 3
b = 7
print(not a < b)
print(not a == b)


# ![image.png](attachment:image.png)

# In[61]:


print(3>5 and 10==12)
print(3>5 and 10<12)
print(3<5 and 10<12)


# ![image.png](attachment:image.png)

# In[63]:


print(3>5 or 10==20)
print(3>5 or 10<20)
print(3<5 or 10<20)


# ### 삼항연산자
# ![image.png](attachment:image.png)

# In[65]:


score = 80
"합격" if score >= 60 else "불합격"


# In[70]:


score = int(input('정수입력>>  '))
result = "합격" if score > 50 else "불합격"
print("결과>> {}".format(result))


# In[72]:


#예제
num1 = int(input('첫번째 정수 입력>>  '))
num2 = int(input('두번째 정수 입력>>  '))
result = num1-num2 if num1>num2 else num2-num1
print("두 수의 차>>  {}".format(result))


# In[75]:


#예제
num1 = int(input('정수입력>> '))
result = '짝수' if num1%2==0 else '홀수'
print("{}는(은) {}입니다.".format(num1, result))


# In[ ]:





# In[ ]:





# In[ ]:





# In[ ]:





# In[ ]:




