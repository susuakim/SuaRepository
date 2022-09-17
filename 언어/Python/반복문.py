#!/usr/bin/env python
# coding: utf-8

# ### 반복문
# ![image.png](attachment:image.png)

# In[6]:


# 숫자를 입력받아 10보다 큰 수가 나오면 반복문을 종료하는 프로그램 작성
# 1번째 방법
num = 0
while num <= 10 :
    num = int(input('정수 입력>>  '))
print('프로그램 종료')

# 2번째 방법
num = 0
while True :
    num = int(input('정수 입력>>  '))
    if num > 10:
        break;
print('프로그램 종료')


# ![image.png](attachment:image.png)

# In[9]:


while True :
    num1 = int(input('첫번째 정수 입력>>  '))
    num2 = int(input('첫번째 정수 입력>>  '))
    if num1==0 and num2==0:
          break;
    print('두 정수의 합:  ', num1+num2)
print('프로그램이 종료되었습니다.')


# ![image.png](attachment:image.png)

# In[28]:


cnt = 1
weigth = int(input('현재 몸무게'))
goal = int(input('목표 몸무게'))

while weigth > goal:
    hh = int(input(f'{cnt}주차 감량 몸무게: '))    
    weigth = weigth - hh
    cnt+=1
print('{}kg 달성!! 축하합니다.'.format(weigth))     


# In[32]:


cnt = 1
weigth = int(input('현재 몸무게'))
goal = int(input('목표 몸무게'))

while True:
    hh = int(input(f'{cnt}주차 감량 몸무게: '))    
    weigth = weigth - hh
    cnt+=1
    if weigth < goal:
        print('{}kg 달성!! 축하합니다.'.format(weigth))  
        break;


# ### random 숫자 입력받는 방법

# In[34]:


import random as rd


# In[ ]:


#랜덤수 추출하기
rd.randint(1,10)


# ![image.png](attachment:image.png)

# In[40]:


import random as rd
ran = rd.randint(1, 10)

while True:
    num = int(input('숫자를 입력하세요>>  '))
    if num > ran:
        print('{}보다 작은 수 입니다.'.format(num))
    elif num < ran:
        print('{}보다 큰 수 입니다.'.format(num))
    else:
        print('정답을 맞추셨습니다.')
        break


# ### for문
# - 명확하게 반복 횟수가 정해져 있을때 사용하는 반복문
# - for 변수 in (문자열 or 리스트 or 튜플 or range()):
#     실행문장
# ![image.png](attachment:image.png)

# In[42]:


s1 = '안녕하세요'
for i in s1:
    print(i)


# In[49]:


s2 = '안녕하세요'
for i in s2 :
    print(i, end='')


# ![image.png](attachment:image.png)

# In[54]:


score_list = [90, 45, 70, 60, 55]
cnt = 0;

for i in score_list:
    cnt += 1
    if i >= 60:
        print(f'{cnt}번 학생은 합격입니다.')
    else:
        print(f'{cnt}번 학생은 불합격입니다.')


# In[56]:


score_list = [90, 45, 70, 90, 55]
cnt = 0;

for i in score_list:
    cnt += 1
    if i >= 60:
        print(f'{score_list.index(i)+1}번 학생은 합격입니다.')
    else:
        print(f'{score_list.index(i)+1}번 학생은 불합격입니다.')


# ### range() 함수
# range(시작할 숫자, 종료할 숫자, 증감량)
# 
# ex) 
# range(1, 10, 1) : 1부터 9까지 1씩 증가
# range(1, 100, 3) : 1부터 99까지 3씩 증가
# 
# ![image.png](attachment:image.png)

# In[57]:


for i in range(1, 11, 1):
    print(i, end=' ')


# In[59]:


# range() 매개변수가 2일때 (시작값, 끝값)
for i in range(3, 10):
    print(i, end=' ')


# In[60]:


# range() 매개변수가 1일때 (끝값)
for i in range(10):
    print(i, end=' ')


# In[62]:


for i in range(97, 76, -1):
    print(i, end=' ')


# ![image.png](attachment:image.png)

# In[64]:


sum = 0

for i in range(1, 101):
    if i%3==0:
        sum += i
        
print(sum)


# ![image.png](attachment:image.png)

# In[65]:


for i in range(1, 10):
    print('2 * {} = {}'.format(i, 2*i))


# In[ ]:




