#!/usr/bin/env python
# coding: utf-8

# ### 유튜브 데이터 수집
# - 영상 제목, 조회수, 링크
# - 특정 영상 페이지의 댓글

# In[77]:


from selenium import webdriver as wb
from selenium.webdriver.common.by import By

# 키보드의 값을 보관하고 있는 라이브러리
from selenium.webdriver.common.keys import Keys

from bs4 import BeautifulSoup as bs

# 이미지 URL을 이용해서 파일로 저장시켜주는 라이브러리
from urllib.request import urlretrieve

# 파일 시스템을 활용하기 위한 라이브러리
# 파일&폴더 생성, 삭제, 존재여부 확인
import os

import time
import pandas as pd


# In[40]:


# f-string
keyword = '강아지'
yt_url = f'https://www.youtube.com/results?search_query={keyword}'

driver = wb.Chrome()
driver.get(yt_url)


# In[59]:


# selenium을 이용해서 HTML 문서를 변환한 후에는 반드시 브라우저를 종료해야 한다.
html = bs(driver.page_source, 'lxml')
driver.close()


# In[27]:


yt_content = html.select_one('a#video-title')
title = yt_content.get('title')
content_url = 'https://www.youtube.com' + yt_content.get('href')


# In[18]:


start_pos = yt_content.get('aria-label').find('조회수') + 4

# rfind() : 문자열 마지막에서부터 문자의 위치를 찾는 함수
end_pos = yt_content.get('aria-label').rfind('회')

# 5,663을 출력해보기(슬라이싱 활용)
reviews = yt_content.get('aria-label')[start_pos : end_pos]


# In[60]:


len(html.select('a#video-title'))


# ### html.select()를 이용해서 영상 제목, 조회수, 링크를 출력해보기

# In[37]:


titleList = []
contentUrlList = []
reviewsList = []

for content in html.select('a#video-title'):
    title = content.get('title')
    content_url = 'https://www.youtube.com'+content.get('href')
    
    start_pos = content.get('aria-label').find('조회수')+4
    end_pos = content.get('aria-label').rfind('회')
    
    reviews = content.get('aria-label')[start_pos:end_pos]
    
    titleList.append(title)
    contentUrlList.append(content_url)
    reviewsList.append(reviews)


# ### 페이지 스크롤

# In[61]:


body = driver.find_element(By.TAG_NAME, value='body')

# 스크롤 key 값 활용: PageDown, PageUp, 방향키(위/아래), Space
# body.send_keys(Keys.PAGE_DOWN)

for i in range(5):
    body.send_keys(Keys.ARROW_DOWN)
    time.sleep(1.5)


# ### 코드 통합

# In[67]:


# f-string
keyword = '강아지'
yt_url = f'https://www.youtube.com/results?search_query={keyword}'
driver = wb.Chrome()
driver.get(yt_url)

# 브라우저 로드가 완료되기 위한 시간
time.sleep(2)

body = driver.find_element(By.TAG_NAME, value='body')

# 스크롤 key값 활용: PageDown, PageUp, 방향기(위/아래)
for i in range(5):
    body.send_keys(Keys.END)
    time.sleep(1.5)
    
# selenium을 이용해서 HTML문서를 변환한 후에는 반드시 브라우저를 종료해야 한다!
html = bs(driver.page_source, 'lxml')
driver.close()

titleList = []
contentUrlList = []
reviewsList = []

for content in html.select('a#video-title'):
    title = content.get('title')
    content_url = 'https://www.youtube.com'+content.get('href')
    
    start_pos = content.get('aria-label').find('조회수')+4
    end_pos = content.get('aria-label').rfind('회')
    
    reviews = content.get('aria-label')[start_pos:end_pos]
    
    titleList.append(title)
    contentUrlList.append(content_url)
    reviewsList.append(reviews)
    
#     print('영상제목:', title)
#     print('영상주소:', content_url)
#     print('조회수:', reviews)
#     print('-'*30)


# In[69]:


# 유튜브 내용을 저장할 딕셔너리 생성
yt_dic = {
    '영상제목' : titleList,
    '영상주소' : contentUrlList,
    '조회수' : reviewsList
}

# 데이터 프레임 생성
yt_df = pd.DataFrame(yt_dic)
yt_df


# ### 특정 유튜브 페이지의 댓글 수집
# 1. 특정 유튜브 페이지를 driver 객체로 실행
# 2. 페이지 스크롤 (횟수 : 5~10 회)
# 3. 현재 HTML 문서 내용을 파이썬 객체로 변환( bs 활용)
# 4. 댓글 내용을 가진 HTML 요소 객체를 select()로 수집
# 5. 요소가 가진 데이터를 print()로 출력

# In[74]:


# 1. 특정 유튜브 페이지를 driver 객체로 실행
driver = wb.Chrome()
driver.get('https://www.youtube.com/watch?v=d1IEHdKpMvI')

# 2. 페이지 스크롤(횟수 5~10 회/ 딜레이 1~2초)
body = driver.find_element(By.TAG_NAME, value='body')
for i in range(5):
    body.send_keys(Keys.END)
    
    # 정해진 횟수만큼 반복되어 스크롤이 내려가지 않을 수 있기 때문에 반드시 sleep() 설정
    time.sleep(1.5)
    
# 3. 현재 HTML 문서 내용을 파이썬 객체로 변환(bs 활용)
content_html = html = bs(driver.page_source, 'lxml')
driver.close()

# 4. 댓글 내용을 가진 HTML 요소 객체를 select()로 수집
comments = content_html.select('div#content > yt-formatted-string')

for comment in comments:
    print(comment.text)


# ### 이미지 수집

# In[82]:


# 폴더 존재 여부 확인하는 함수
def createDirectory(name):
    # True : 폴더 있음 / False : 폴더 없음
    # 폴더를 확인하고 생성하는 함수
    if not os.path.isdir(name):
        # 폴더생성
        os.mkdir(name)


# In[83]:


dir_name = '최우식'

# 폴더 생성
createDirectory(dir_name)

imgUrl = 'https://blog.kakaocdn.net/dn/eegLhJ/btrlFnnyiDN/2KVyMuawSEoKuVAItmufnK/img.jpg'

# urlretrieve(이미지경로, 폴더경로 or 파일명, 확장자)
urlretrieve(imgUrl, f'./{dir_name}/최우식.jpg')


# ### 네이버 이미지 수집
# 1. 검색결과 이미지 페이지를 driver 객체로 생성
# 2. 페이지 스크롤
# 1. 검색결과 이미지 페이지를 driver 객체로 생성
# 2. 페이지 스크롤
# 3. 현재 HTML 문서를 파이썬 객체로 변환하고, driver 객체 종료
# 4. img 요소들을 select()로 수집
# 5. 각 요소별로 get(속성이름)를 이용해 이미지 주소 수집
# 6. 수집한 이미지 주소를 폴더에 저장(폴더명 : 검색어)

# In[86]:


from selenium import webdriver as wb
from selenium.webdriver.common.by import By

# 키보드의 값을 보관하고 있는 라이브러리
from selenium.webdriver.common.keys import Keys

from bs4 import BeautifulSoup as bs
from urllib.request import urlretrieve

# 이미지 URL을 이용해서 파일로 저장시켜주는 라이브러리
from urllib.request import urlretrieve

# 파일 시스템을 활용하기 위한 라이브러리
# 파일&폴더 생성, 삭제, 존재여부 확인
import os

import time
import pandas as pd


# In[102]:


# 폴더 존재 여부 확인하는 함수
def createDirectory(name):
    if not os.path.isdir(name):
        # 폴더생성
        os.mkdir(name)
        print(f'{name}폴더가 생성되었습니다.')
    else:
        print(f'{name}폴더는 이미 생성된 폴더입니다.')


# In[103]:


# 1. 검색 결과 이미지 페이지를 driver 객체로 생성
keyword = "최우식"
url = f'https://search.naver.com/search.naver?where=image&sm=tab_jum&query={keyword}'

driver = wb.Chrome()
driver.get(url)


# In[104]:


# 2. 페이지 스크롤
body = driver.find_element(By.TAG_NAME, value='body')
for i in range(5):
    body.send_keys(Keys.END)
    time.sleep(1.5)


# In[105]:


# 3. 현재 HTML 문서를 파이썬 객체로 변환하고, driver 객체 종료
html = bs(driver.page_source, 'lxml')
driver.close()


# In[106]:


# 4. img 요소들을 select()로 수집
imgs = html.select('img._image._listImage')

for img in imgs:
    print(img.get('src'))


# In[107]:


# 4. img 요소들을 select()로 수집
imgs = html.select('img._image._listImage')

# 5. 각 요소별로 get(속성이름)를 이용해 이미지 주소 수집
imgList = []

for img in imgs:
    # 이미지 주소에 'data:'이 포함되어 있지 않다면
    if 'data:' not in img.get('src'):
        imgList.append(img.get('src'))


# In[108]:


# 6. 수집한 이미지 주소를 폴더에 저장(폴더명 : 검색어)
createDirectory(keyword)


# In[110]:


save_path = f'./{keyword}/{keyword}.jpg'

for imgUrl in range(len(imgList)):
    urlretrieve(imgList[i], f'{save_path}{keyword}{i+1}.jpg')


# ### 코드 통합

# In[111]:


# 1. 검색 결과 이미지 페이지를 driver 객체로 생성
keyword = "최우식"
url = f'https://search.naver.com/search.naver?where=image&sm=tab_jum&query={keyword}'

driver = wb.Chrome()
driver.get(url)

time.sleep(2)

# 2. 페이지 스크롤
body = driver.find_element(By.TAG_NAME, value='body')

for i in range(5):
    body.send_keys(Keys.END)
    time.sleep(1.5)
    
# 3. 현재 HTML 문서를 파이썬 객체로 변환하고, driver 객체 종료
html = bs(driver.page_source, 'lxml')
driver.close()

# 4. img 요소들을 select()로 수집
imgs = html.select('img._image._listImage')

# 5. 각 요소별로 get(속성이름)를 이용해 이미지 주소 수집
imgList = []

for img in imgs:
    # 이미지 주소에 'data:'이 포함되어 있지 않다면
    if 'data:' not in img.get('src'):
        imgList.append(img.get('src'))
        
# 6. 수집한 이미지 주소를 폴더에 저장(폴더명 : 검색어)
createDirectory(keyword)

save_path = f'./{keyword}/'

for imgUrl in range(len(imgList)):
    urlretrieve(imgList[i], f'{save_path}{keyword}{i+1}.jpg')


# ### 코드 통합(함수형)

# In[113]:


# 폴더를 생성하는 함수
def createDirectory(name):
    if not os.path.isdir(name):
        # 폴더생성
        os.mkdir(name)
        print(f'{name}폴더가 생성되었습니다.')
    else:
        print(f'{name}폴더는 이미 생성된 폴더입니다.')


# 이미지 주소를 수집하는 함수
def imgCrawling(keyword):
    # 1. 검색 결과 이미지 페이지를 driver 객체로 생성
    url = f'https://search.naver.com/search.naver?where=image&sm=tab_jum&query={keyword}'

    driver = wb.Chrome()
    driver.get(url)

    time.sleep(2)

    # 2. 페이지 스크롤
    body = driver.find_element(By.TAG_NAME, value='body')

    for i in range(5):
        body.send_keys(Keys.END)
        time.sleep(1.5)

    # 3. 현재 HTML 문서를 파이썬 객체로 변환하고, driver 객체 종료
    html = bs(driver.page_source, 'lxml')
    driver.close()

    # 4. img 요소들을 select()로 수집
    imgs = html.select('img._image._listImage')

    # 5. 각 요소별로 get(속성이름)를 이용해 이미지 주소 수집
    imgList = []

    for img in imgs:
        # 이미지 주소에 'data:'이 포함되어 있지 않다면
        if 'data:' not in img.get('src'):
            imgList.append(img.get('src'))
    
    # 수집된 이미지 주소 리스트 반환
    return imgList



# 이미지를 저장하는 함수
def saveImg(keyword, imgList):
    # 6. 수집한 이미지 주소를 폴더에 저장(폴더명 : 검색어)
    createDirectory(keyword)

    save_path = f'./{keyword}/'

    for imgUrl in range(len(imgList)):
        urlretrieve(imgList[i], f'{save_path}{keyword}{i+1}.jpg')
    


# In[114]:


keyword = '고양이'
imgList = imgCrawling(keyword)
saveImg(keyword, imgList)


# In[ ]:




