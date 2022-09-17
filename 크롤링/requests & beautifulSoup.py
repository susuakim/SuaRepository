#!/usr/bin/env python
# coding: utf-8

# ### requests 라이브러리
# - 웹 페이지의 정보를 요청/응답 할 때 사용하는 라이브러리

# In[4]:


import requests as req


# In[5]:


url = 'https://www.google.co.kr'

# 200: 정상적으로 요청/응답이 완료된 상태
# req.get(url)

# text 변수: HTML을 문자열로 반환
req.get(url).text


# In[7]:


keyword = '필라테스'
search_url = 'https://www.google.co.kr/search?q=크로링'.format(keyword)

req.get(search_url).text


# In[71]:


# 첫번째
naver_url = 'https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=1&ie=utf8'
res = req.get(naver_url, params={'query':'맥북'}).text


# ### beautifulSoup
# - HTML 문서를 파이썬 객체로 변환하여 원하는 정보를 가져올 때 사용하는 라이브러리

# In[18]:


from bs4 import BeautifulSoup as bs


# In[20]:


# HTML 문서 -> 파이썬 객체로 변환
# 변환방식 3개 존재 : lxml > html.parser > html5lib
# 두번째
html = bs(res, 'lxml')
print(type(html))
print(type(res))


# In[24]:


# find(tag name): tag name으로 요소객체를 접근
html.find('title').text


# In[25]:


# 슬라이싱
html.find('title').text[:2]


# In[26]:


# 공백 없애기
html.find('title').text.replace(' ', ' ')


# In[29]:


html.find('a', {'class':'tit'}).text


# In[37]:


# div.product_info: a.title
html.find('div', {'class':'product_info'}).find('a').text
html.find('div', {'class':'product_info'}).find('div').find('div').find('strong').text


# In[39]:


# select_one(css 선택자): css 선택자를 이용해서 하나의 요소를 접근
html.select_one('div.product_info > a.title').text
html.select_one('div.product_info > div > div > strong').text 
# == html.select_one('div.price > strong').text


# In[44]:


# select(css 선택자): css 선택자를 이용해서 여러개의 요소를 접근(리스트 반환)
# => findAll()와 같은 기능
titles = html.select('div.product_info > a.title')
prices = html.select('div.price > strong')

print(len(titles), len(prices))


# In[45]:


for i in range(len(titles)):
    print(titles[i].text, prices[i].text)
    


# # 네이버 뉴스 데이터 수집
# - 뉴스의 제목과 내용을 수집하여 출력
# - 주소: https://n.news.naver.com/mnews/article/015/0004716773?sid=105

# In[66]:


url ='https://n.news.naver.com/mnews/article/015/0004716773?sid=105'

# 서버에게 브라우저로 접속했다라는 것을 인지시키기 위한 헤더
header = {
    'user-agent':
    'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/102.0.0.0 Safari/537.36'
}

res = req.get(url, headers=header).text
html = bs(res, 'lxml')


# In[67]:


new_title = html.select_one('h2.media_end_head_headline')
new_content = html.select_one('div#dic_area')
print('제목', new_title.text)
print('내용', new_content.text.strip())


# # 멜론 음원차트 수집
# - 순위(rank), 곡명(songNm), 아티스트(artist), 이미지 주소(imgURL)
# - melon_top100.csv 파일로 저장

# ![image.png](attachment:image.png)

# In[25]:


import requests as req
import pandas as pd
from bs4 import BeautifulSoup as bs


# In[2]:


url ='https://www.melon.com/chart/index.htm'

# 서버에게 브라우저로 접속했다라는 것을 인지시키기 위한 헤더
header = {'user-agent':'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/102.0.0.0 Safari/537.36'}
res = req.get(url, headers=header).text

html = bs(res, 'lxml')


# In[16]:


# 하나만 가져오기 select_one
# select를 이용하면 반환하는 값은 리스트
rank = html.select_one('td span.rank')
albumlmg = html.select_one('a.image_typeAll > img')
songNm = html.select_one('div.ellipsis.rank01 > span')
artist = html.select_one('div.ellipsis.rank02 span')

print(rank.text)

# print(albumlmg.get('alt')), print(albumlmg.get('width'))
print(albumlmg.get('src'))

print(songNm.text)
print(artist.text)


# In[33]:


# select를 이용해서 여러개 값 구하기
ranks = html.select('td span.rank')
albumlmgs = html.select('a.image_typeAll > img')
songNms = html.select('div.ellipsis.rank01 > span > a')
artists = html.select('div.ellipsis.rank02 span')


print(len(ranks), len(albumlmgs), len(songNms), len(artists))


# In[34]:


ranklist = []
albumimglist = []
songNmlist = []
artistlist = []

for i in range(len(ranks)):
    ranklist.append(ranks[i].text)
    albumimglist.append(albumlmgs[i].get('src'))
    songNmlist.append(songNms[i].text)
    artistlist.append(artists[i].text)
    
#     print(ranks[i].text)
#     print(albumlmgs[i].get('src'))
#     print(songNms[i].text)
#     print(artists[i].text)
#     print('-' * 20)    


# In[35]:


print(len(ranklist), len(albumimglist), len(songNmlist), len(artistlist))


# In[36]:


melon_dic = {
    '순위' : ranklist,
    '곡명' : songNmlist,
    '아티스트' : artistlist,
    '이미지URL' : albumimglist
}


# In[37]:


melon_df = pd.DataFrame(melon_dic)
melon_df.head()


# In[39]:


# melon_top100.csv 파일로 저장하기
melon_df.to_csv('melon_top100.csv', encoding = 'euc-kr')


# In[ ]:




