#!/usr/bin/env python
# coding: utf-8

# In[1]:


# 두개의 숫자를 매개변수로 받아 합을 반환하는 함수 정의
def number_sum(num1, num2):
    result = num1 + num2
    return result


# In[2]:


number_sum(2, 3)


# In[4]:


num1 = int(input("1입력>> "))
num2 = int(input("2입력>> "))

def m(num1, num2):
    result = num1-num2
    return result

re = m(num1, num2)
print(re)


# In[16]:


def cal(num1, num2, op):
    """덧셈과 뺄셈을 계산하는 함수"""
    if op=='+':
        return num1+num2
    elif op=='-':
        return num1-num2
    
num1 = int(input('첫번째 정수 입력>> '))
num2 = int(input('두번째 정수 입력>> '))
op = input('연산자 입력(+ or -)>> ')
result = cal(num1, num2, op)
print(result)


# In[15]:


# 함수의 소괄호안에 shith + tab 누르면 함수 주석달린 내용 확인 가능
print(cal(2, 3, '*'))


# In[19]:


# 오버로딩
# 3게의 숫자를 매개변수로 받아서 합을 구하는 함수 정의
def sum_number2(num1, num2, num3):
    return num2+num2+num3
print(sum_number(1,2,7))

# 4게의 숫자를 매개변수로 받아서 합을 구하는 함수 정의 
# snum_number2 새롭게 정의 했더니 에러나온다
# 즉 파이썬에서는 오버로딩이 불가능
def sum_number2(num1, num2, num3, num4):
    return num2+num2+num3+num4
print(sum_number(1,2,7,10))


# In[23]:


# 오버로딩이 안되니까 가변매개변수 이용
def num(*args):
    print(args)

#튜플형태로 출력
num(1,2,3)
num(1,2,3,4,5,)


# In[29]:


# 모든 숫자를 더해서 결과를 반환하는 함수
# 1번째 방법
def add(*args):
    sum_args = 0
    for i in args:
        sum_args += i
    return sum_args
    
add(1,2,4,5,7)

# 1번째 방법
def add(*args):
    sum_args = 0
    for i in range(0, len(args), 1):
        sum_args += args[i]
    return sum_args


# In[33]:


# 함수의 return 키워드는 한번만 사용 가능
# return 키워드가 호출되는 순간 함수는 종료되고, 일부러 종료시키기 위해 사용하기도 함
# 불가능 함수
def add_sub1(num1, num2):
    return num1+num2
    return num1-num2

# 실행할때 에러는 안나오지만, 튜플타입으로 출력됨 
# 즉 return (num1+num2, num1-num2) 와 같다
def add_sub2(num1, num2):
    return num1+num2, num1-num2

add, sub = (add_sub2(10,7))
print(add, sub)


# ### 기본값 설정
# def power_of_N(num, power=2):
#     return num**power

# In[37]:


def power_of_N(num, power=2): 
    return num**power

# power를 설정해주지 않으면 기본값인 power=2로 계산한다.
print(power_of_N(2))

print(power_of_N(2,3))

print(power_of_N(3, power=5))


# In[ ]:




