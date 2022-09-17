#!/usr/bin/env python
# coding: utf-8

# ### 리스트
# ![image.png](attachment:image.png)

# In[7]:


#리스트 생성
# 리스트명 = [요소1, 요소2, 요소3, 요소4, .....]

list1 = [] #어떤리스트가 들어가있는지 모를때 비어있는 대괄호 사용
print(type(list1))
print(len(list1))
print(list1)

list2 = [1, 2, 3]
print(list2)

list3 = ['a', 'b', 'c']
print(list3)

list4 = [1, 2, 3, 'a', 'b']
print(list4)

list5 = [1, 2, ['a', 'b', 3]]
print(list5)


# ![image.png](attachment:image.png)

# In[13]:


#인덱싱: 리스트[인덱스] : 인덱스에 위치한 값 반환
list2 = [2, 5, 7, 9, 10]
print(list2[0])
print(list2[3])
print(list2[2] + list2[-1])


# In[19]:


list3 = [1, 2, 3, ['a', 'b', 'c']]
print(len(list3))

#변수 temp에 ['a', 'b', 'c']를 저장하여 출력하시오
temp = list3[3]
print(temp)

#list3에서 문자 'b'를 가지고와서 출력하시오
print(list3[3][1])
print(temp[1])


# In[25]:


#슬라이싱: 리스트[start인덱스:end인덱스+1]
#start 인덱스부터 end 인덱스 바로 전까지 값을 반환(start <= x < end)
list4 = [0, 1, 2, 3, 4]
print(list4[1:3])
print(list4[:2])
print(list4[3:])

#두개의 차이점 알기
print(list4[3:4])
print(type(list4[3:4]))

print(list4[3])
print(type(list4[3]))


# In[28]:


#리스트 연산하기
list5 = [1, 2, 3]
list6 = [3, 4, 5, 6]
print(list5 + list6)
print(list6 + list5)
print(list5 * 2)

#연산 안되는 것들
print(list5 - list6)
print(list5 * list6)
print(list5 / list6)
print(list5 + 2)


# In[31]:


# 값 추가하기: 리스트명.append(값)
list7 = [0, 1, 2, 3, 4]
print(list7)

list7.append(5)
print(list7)

list7.append(6)
print(list7)


# In[34]:


# 원하는 곳에 값 추가하기: 리스트.insert(인덱스위치, 값)
list8 = [0, 1, 2, 3, 4]
print(list8)

list8.insert(1 , 5)
print(list8)

list8.insert(2 , 'a')
print(list8)

list8.insert(4 , ['b', 'c', 8])
print(list8)


# ### 예제
# ![image.png](attachment:image.png)

# In[35]:


music_list = [['Butter', '방탄'], ['헤픈 우연', '헤이즈'],['라일락', '아이유']]

loc = int(input("인덱스 위치 입력>>  "))
song = input("노래 제목 입력>>  ")
singer = input("가수 입력>>  ")

music_list.insert(loc, [song, singer])
print('music_list>>  ', music_list)


# In[39]:


#리스트 값 수정: 리스트명[인덱스] = 값
list9 = [0, 1, 2, 3, 4]
list9[1] = 8
print(list9)

list9[2:4] = [7]
print(list9)

#에러발생
list9[2:4] = 7
print(list9)


# In[43]:


5.


# In[48]:


# 값 삭제
# 1번째: 인덱스를 이용해서 삭제: del 리스트[인덱스]
# 2번째: 값을 이용해서 삭제: 리스트.remove(값)

list10 = ['a', 'b', 'c', 'd', 'e']
print(list10)

del list10[2]
print(list10)

list10.remove('d')
print(list10)


# In[50]:


# 리스트 정렬: 리스트.sorf() => 오름차순 정렬
list11 = [9, 77, 13, 51, 100, 3]
list11.sort()
print(list11)


# In[51]:


# 리스트 순서 거꾸로 뒤집기: 리스트.reverse()
list11 = [9, 77, 13, 51, 100, 3]
list11.reverse()
print(list11)


# In[53]:


# 리스트 정렬: 리스트.sort() => 내림차순정렬
list11 = [9, 77, 13, 51, 100, 3]
list11.sort()
list11.reverse()
print(list11)

list11 = [9, 77, 13, 51, 100, 3]
list11.sort(reverse = True)
print(list11)


# In[54]:


# 리스트 값 위치 반환: 리스트.index(값)
list12 = ['a', 'b', 'c', 'd', 'e']
print(list12.index('e'))


# ### 튜플
# ![image.png](attachment:image.png)

# In[59]:


#튜플 생성: 튜플명 = (요소1, 요소2, 요소3,,,,,)
tu1 = (1, 2, 3)
tu2 = 1, 2, 3
tu3 = 'a', 'b', 'c'
tu4 = (1, 2, 'a', 'b', 'c')
tu5 = (1, 2, ('a', 'b', 3))
tu6 = (4) #이건 튜플이 아니라 int이다
tu7 = (4,)


print(len(tu1))
print(tu1)
print(tu2)
print(tu3)
print(tu4)
print(tu5)
print(tu6) #이건 튜플이 아니라 int이다
print(tu7)


# ![image.png](attachment:image.png)

# ### member 연산자
# ![image.png](attachment:image.png)

# In[64]:


# 문자열 
str1 = '파이썬 최고'
print('파이썬' in str1)
print('파이썬' not in str1)

# 리스트
list1 = [77, 38, 10]
print(33 in list1)
print(33 not in list1)

# 사용예시
if 38 in list1 :
    print('포함되어있습니다.')
else:
    print('포함되어있지 않습니다.')


# ![image.png](attachment:image.png)

# In[81]:


#예제
lst = ['딸기', '바나나', '수박', '체리', '포도']
search = input('검색할 문자를 입력하세요>>  ')
if search in lst:
    print('{}은(는) 리스트 {}번째 인덱스에 들어있습니다'.format(search, lst.index(search)))
else:
    print('{}은(는) 리스트에 들어있지 않습니다.'.format(search))


# ![image.png](attachment:image.png)

# In[80]:


s = "Hi, My neme is Mihee"

search = input("검색할 문자를 입력하세요>>  ")
if search in s:
    print("'{}'는 {}번 들어있습니다.".format(search, s.count(search)))
else:
    print("'{}'는 문자열에 들어있지 않습니다.".format(search))


# In[ ]:




