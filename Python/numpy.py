#!/usr/bin/env python
# coding: utf-8

# In[4]:


# numpy 라이브러리 불러오기
# numpy를 np라고 부르기
import numpy as np


# In[19]:


# 1차원 array 생성하고
list1 = [1, 2, 3, 4, 5]
arr1 = np.array(list1)
arr1

arr2 = np.array([1, 2, 3])
arr2


# In[20]:


arr1.sum(0)


# In[13]:


# 2차원 array 생성하기
list2 = [[1,2,3], [4,5,6]]
arr2 = np.array(list2)
arr2


# In[23]:


# 배열의 크기 확인
# shape
list2 = [[1,2,3], [4,5,6]]
arr2 = np.array(list2)
arr2
arr2.shape

# 배열의 전체 요소 개수 확인하기
# size
arr2.size


# In[24]:


# 배열의 차원 확인하기
# ndim
print(arr2.ndim)
print(arr1.ndim)


# In[25]:


# 배열의 타입 확인하기
# dtype
arr2.dtype


# ![image.png](attachment:image.png)

# ![image.png](attachment:image.png)

# In[29]:


arr3 = np.array([[[1, 2], [3, 4]], [[5, 6], [7, 8]]])
print(arr3)
print(arr3.shape)
print(arr3.ndim)
print(arr3.size)


# In[39]:


# 특정한 값으로 배열 생성
# 0으로 만들기 : zeros(배열크기)
# 3행 4열
np.zeros((3,4))
size = (3, 4)


# In[40]:


# 특정한 값으로 배열 생성
# 1으로 만들기 : ones(배열크기)
np.ones((3,4))

# dtype = 타입 지정해서 생성하기
np.ones(size, dtype = int)


# In[41]:


# 0과 1을 제외하고 다른 숫자를 배열 생성하기
# full(배열의 크기, 생성할 숫자)
np.full(size, 5)


# In[46]:


# 1부터 50까지 숫자로 배열 생성하기

# 방법1
list_50 = []
for i in range(1, 51):
    list_50.append(i)
    
arr_50 = np.array(list_50)
print(arr_50)

# 방법2
# arange(시작 = 0, 끝, 간격=1)
np.arange(50)


# In[47]:


# 1부터 51까지 10의 간격으로 배열 생성
np.arange(1, 52, 10)


# In[50]:


# linspace(시작, 끝, 값의 갯수)
# 시작부터 끝까지 값의 갯수만큼으로 분할하기
np.linspace(1, 50, 50)


# In[62]:


# 랜덤 값 배열 생성
# np.random.rand(배열의 크기)
arr = np.random.rand(2, 4)
arr


# In[65]:


# 랜덤한 정수(랜덤값의 범위 지정)로 배열 생성
# np.random.randint(처음 숫자(이상), 끝 숫자(미만), 배열의 크기)
arr = np.random.randint(2, 10, (2,4))


# In[67]:


# 타입 변경하기
# astype(변경할 타입)
arr4 = arr.astype(float)


# In[68]:


arr4


# ### 배열 연산

# In[77]:


# 배열 연산
# 같은 위치에 있는 값들끼리 연산
# shape가 같아야 함 => arr끼리 연산할때
# array와 숫자를 연산하며 모든 자리에 연산이 진행
list1 = [1, 2, 3]
list2 = [1, 2, 3]
list1 * list2


# In[86]:


# array 인덱싱
# 1 ~ 6 까지가 들어있는 2차원 배열 생성
# 생성된 배열의 차원을 바꾸는 방법
# reshape(변경하고 싶은 배열의 크기)
arr5 = np.arange(1, 7).reshape(2,3)
arr5


# In[87]:


# array 인덱싱
# [행, 열]
# [고차원 > 저차원]
arr5[0,2]


# In[89]:


# array 슬라이싱
arr5[3:8]
arr5


# In[92]:


# 0~49 까지 담긴 5, 10의 배열 생성
arr6 = np.arange(0, 50).reshape(5,10)
arr6


# In[94]:


arr6[0:2]


# In[111]:


#arr[행시작값:행 마지막 범위(인덱스 범위+1) , 열]


# In[113]:


arr6[0:6, 0:1]


# In[115]:


arr6[0:4, 0:5]


# In[5]:


# txt 파일 불러오기
# loadtxt(경로)
# delimiter : 구분기호가 어떤것이냐
data = np.loadtxt("height_weight.txt", delimiter = "," )
data


# In[22]:


kg = data[1]
height = data[0] / 100
hh = h*h

bmi = kg / hh
bmi


# ![image.png](attachment:image.png)

# In[24]:


height = data[0] / 100
weigth = data[1]

weigth / height**2


# ### 불리언 인덱싱

# In[25]:


# True, False 값으로 인덱싱을 진행
# True는 출력하고, Falses는 미출력
# 조건을 통해 값을 가져올때 사용
arr1 = np.array([1,4,2,3,5])
arr1


# In[26]:


# 2보다 큰 값들을 출력
bol = arr1 > 2
bol


# In[27]:


arr1[bol]


# In[41]:


# 2보다 크고, 4보자 작은 값들 출력
# numpy는 비트연산자를 사용하기 (&(and), |(or))
bol = (2 < arr1) & (arr1 < 4)
bol
arr1[bol]


# In[49]:


# numpy 배열 생성
# (2.5)의 크기를 갖는 배열 생성
#1~9까지의 랜덤한 값을 갖는 배열

arr2 = np.random.randint(1,10,size = (2,5))
arr2


# In[60]:


# 함수 사용하기
# sum(axis =  ), "axis" 축 의미 (mean()함수와 사용방식이 같음) => 2개 이상의 값이 필요
# axis = none: 기본값, 전체를 한번에 계산
# axis = 0: 1차원끼리 계산, 세로 방향으로 계산
# axis = 1: 2차원끼리 계산, 가로 방향으로 계산
print(np.sum(arr2, axis=0))
print(np.sum(arr2, axis=1))

# abs() : 절대값 구하기, sqrt(4)=2 : 절반값 구하기 => 1개 값만 필요함
print(np.sqrt(arr2))


# In[54]:


arr2[1]


# ![image.png](attachment:image.png)
# user id :: 영화번호 :: 평점 :: ? 

# In[67]:


data = np.loadtxt('ratings.txt', delimiter = "::", dtype='int')
data


# In[83]:


# 1. 데이터의 차원, 크기, 요소갯수 출력
print(data.shape) 
print(type(data)) 
print(data.size)
print(data.ndim)


# In[84]:


# 2. 전체 데이터의 평점 평균 구하기
print(data[:, 2].mean())


# In[107]:


# 3. 1번 사용자의 평점 평균 구하기
# 첫번째 방법
user_id = np.unique(data[:, 0]) # unique는 중복값을 제거

for i in user_id : 
    result = data[data[:, 0] == 1, 2].mean()
result
    
# 두번째 방법
np.mean(data[data[:,0] == 1 ] [:,2])


# In[ ]:


# 4. 모든 사용자의 평점 평균 구하기
# 첫번째 방법
list = []

for i in user_id : 
    result = data[data[:, 0] == i, 2].mean()
    list.append([i, result])
list

# 두번째 방법
for i in user_id:
    result = np.mean(data[data[:, 0] == i][:, 2])
    list.append(i.result)
list


# In[109]:


# 평점 평균이 4점 이상인 사용자 구하기
user4 = []

for i in user_id : 
    result = data[data[:, 0] == i, 2].mean()
    if result >= 4:
        user4.append(i)
print(user4)

# 두번째 방법
mean = np.array(list)
mean[mean[:,1]>=4][:,0].astype(int)


# In[111]:


# csv 파일로 출력하기
# 경로 : 내pc > C드라이브 > 사용자 > smhrd
np.savetxt('user_id_mean.csv', mean,delimiter=',', fmt='%.3f')


# In[ ]:




