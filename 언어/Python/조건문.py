#!/usr/bin/env python
# coding: utf-8

# # <<조건문>>

# In[5]:


# 조건문을 이용해서 변수 money가 10000원 이상이면 "택시를 탄다" 출력
money = 10000
if money >= 10000 :
    print("택시를 탄다.")
    print("버스 안타도 된다")
print("프로그램 종료")


# ![image.png](attachment:image.png)

# In[6]:


# 조건문을 이용해서 변수 money가 10000원 이상이면 "택시를 탄다", 10000원 이하면 "버스를 탄다" 출력
money = int(input("금액 입력>>  "))
if money >= 10000:
    print("택시를 탄다")
else:
    print("버스를 탄다")


# ### elif문
# ![image.png](attachment:image.png)

# In[8]:


# 두개의 정수를 입력받아 두 수의 크기를 비교
num1 = int(input("첫번째 정수 입력>>  "))
num2 = int(input("두번째 정수 입력>>  "))
if num1 > num2:
    print("첫번째 정수가 더 큽니다")
elif num1 < num2:
    print("두번째 정수가 더 큽니다")
else:
    print("두 수가 같습니다.")


# In[10]:


#예제
score = int(input("점수 입력>>  "))

if score >= 90 :
    print("{}점은 A학점 입니다.".format(score))
elif score >= 80 :
    print("{}점은 B학점 입니다.".format(score))
elif score >= 70 :
    print("{}점은 C학점 입니다.".format(score))
elif score >= 60 :
    print("{}점은 D학점 입니다.".format(score))
else:
    print("{}점은 F학점 입니다.".format(score))


# In[ ]:





# In[ ]:





# In[ ]:





# In[ ]:





# In[ ]:




