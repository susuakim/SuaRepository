#!/usr/bin/env python
# coding: utf-8

# ### 네이버 영화 평점 수집
# - 현재 날짜 기준으로 수집
# - 기간을 정의해서 수집

# ##### 영화명과 평점을 수집해서 데이터 프래임 만들기

# In[6]:


import requests as req
import pandas as pd
import time
from bs4 import BeautifulSoup as bs


# In[7]:


# 아래 3개는 필수로 있어야 한다.
url = 'https://movie.naver.com/movie/sdb/rank/rmovie.naver?sel=cur&date=20220627'
header = {
    'user-agent':
    'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/102.0.0.0 Safari/537.36'
}
res = req.get(url, headers=header).text
html = bs(res, 'lxml')


# In[8]:


# 영화명과 평점을 수집해서 데이터 프래임 만들기

movieName = html.select('div.tit5 > a')
movieScore = html.select('td.point')
print(len(movieName), len(movieScore))


# In[9]:


namelist = []
scorelist = []

for i in range(len(movieName)):
    namelist.append(movieName[i].text)
    scorelist.append(movieScore[i].text)

print(len(movieName), len(movieScore))


# In[10]:


movie_dic = {
    '영화명' : namelist,
    '평점' : scorelist
}


# In[11]:


movie_df = pd.DataFrame(movie_dic)
movie_df.head()


# ### 날짜별 영화 평점 수집

# In[12]:


# pandas에서 날짜 데이터 생성해 주는 함수가 있음
# 첫번째 방법
# pd.date_range('2022-06-01', '2022-06-27')

# 두번째 방법
dates = pd.date_range('2022-06-01', periods = 27)

datefmlist = []

for date in dates:
    datefmlist.append(str(date)[:10].replace('-', ''))


# In[13]:


datefmlist


# In[14]:


# datelist = ['20220601', '20220602', '20220603']

for date in datefmlist:
    url = 'https://movie.naver.com/movie/sdb/rank/rmovie.naver?sel=cur'
    header = {
        'user-agent':
        'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/102.0.0.0 Safari/537.36'
    }
    res = req.get(url, headers=header, params={'date' : date }).text
    html = bs(res, 'lxml')
    
    movieName = html.select('div.tit5 > a')
    movieScore = html.select('td.point')
    
    print('-'*20, date, '-'*20)
    
    for i in range(len(movieName)):
        print('순위:', (i+1), '영화명:', movieName[i].text, '평점:', movieScore[i].text)
    
    time.sleep(1)


# ### 영화 리뷰 수집하기

# ### 10건의 리뷰데이터 수집 후 출력해보기
# - iframe요소: 현재 페이지에서 다른 페이지를 포함시킬 때 사용하는 요소
# - iframe 안에 있는 내용을 가져올 때는 src 속성의 값으로 페이지를 다시 접속해서 해당 주소로 요청

# In[15]:


import requests as req
import pandas as pd
import time
from bs4 import BeautifulSoup as bs


# In[16]:


url ='https://movie.naver.com/movie/bi/mi/pointWriteFormList.naver?code=81888&type=after&i[%E2%80%A6]geSubscriptionAlready=false&isMileageSubscriptionReject=false'

# 서버에게 브라우저로 접속했다라는 것을 인지시키기 위한 헤더
header = {
    'user-agent':
    'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/102.0.0.0 Safari/537.36'
}

res = req.get(url, headers=header).text
html = bs(res, 'lxml')


# In[17]:


html.select('div.score_reple > p > span')


# In[18]:


# 관람객이라는 단어 빼기
reviews = html.select('div.score_reple > p > span')

for review in reviews:
    #'관람객'을 제외한 리뷰 출력
    if review.text != '관람객':
        print(review.text.strip())


# ### 1~5 페이지의 리뷰 데이터 수집 후 출력해보기

# In[19]:


for pageNum in range(5):
    url = 'https://movie.naver.com/movie/bi/mi/pointWriteFormList.naver?code=81888&type=after&i[%E2%80%A6]geSubscriptionAlready=false&isMileageSubscriptionReject=false'
    header = {
        'user-agent':
        'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/102.0.0.0 Safari/537.36'
    }
    res = req.get(url, headers=header, params={'page' : pageNum}).text
    html = bs(res, 'lxml')
    
    reviews = html.select('div.score_reple > p > span')
    
    for review in reviews:
        #'관람객'을 제외한 리뷰 출력
        if review.text != '관람객':
            print(review.text.strip())
            
    print('-'*30, (pageNum+1), '페이지', '-'*30)
    
    time.sleep(1)


# ### 모든 리뷰데이터 수집
# - 총 페이지 수 구하기
# - 페이지 수를 반복 횟수로 활용해서 모든 리뷰 수집
# - 텍스트 파일로 저장(이름 : reviews.txt)

# In[42]:


import requests as req
import pandas as pd
import time
from bs4 import BeautifulSoup as bs

# 로직이 실행되는 진행률을 프로그래스바로 출력해주는 라이브러리
from tqdm.notebook import tqdm


# In[20]:


url ='https://movie.naver.com/movie/bi/mi/pointWriteFormList.naver?code=81888&type=after&i[%E2%80%A6]geSubscriptionAlready=false&isMileageSubscriptionReject=false'

# 서버에게 브라우저로 접속했다라는 것을 인지시키기 위한 헤더
header = {
    'user-agent':
    'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/102.0.0.0 Safari/537.36'
}

res = req.get(url, headers=header).text
html = bs(res, 'lxml')


# In[22]:


strPageNum = html.select_one('strong > em').text
print(strPageNum)


# In[40]:


# 13,195 > 1320 으로 변환하기
# 1. strPageNum 값에서 ','를 '' 으로 변환(13,195 -> 13195)
strPageNum = strPageNum.replace(',', '')

# 2. strPageNum을 정수로 변환(int()활용)
intPageNum = int(strPageNum)

# 3. 정수데이터의 몫 구하기 -> 페이지 수 (// 활용)
totalPage = intPageNum//10

# 4. 정수데이터의 나머지를 구하기(% 활용)
# 5. 나머지가 0 이상일 경우 페이지 수에 + 1
if intPageNum%10 > 0:
    totalPage += 1

print('총 페이지 수: ', totalPage)


# In[45]:


for i in tqdm(range(100)):
    print(i, end=' ')


# In[48]:


# 파일 저장 및 읽는 함수
f = open('reviews.txt', 'w') # 파일이 없는 경우 자동으로 파일 생성, 파일이 있는 경우 존재하는 파일 열기
f.write('Hello World!') # 그 파일을 기록을 하고
f.close() # 파일을 저장한다


# In[49]:


# 파일 객체 생성
f = open('reviews.txt', 'w')

for pageNum in tqdm(range(1, totalPage+1)):
    url = 'https://movie.naver.com/movie/bi/mi/pointWriteFormList.naver?code=81888&type=after&i[%E2%80%A6]geSubscriptionAlready=false&isMileageSubscriptionReject=false'
    header = {
        'user-agent':
        'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/102.0.0.0 Safari/537.36'
    }
    res = req.get(url, headers=header, params={'page' : pageNum}).text
    html = bs(res, 'lxml')
    
    reviews = html.select('div.score_reple > p > span')
    
#   영화 리뷰 페이지별로 구분하여 출력
    for review in reviews:
        #'관람객'을 제외한 리뷰 출력
        if review.text != '관람객':
            f.write(review.text.strip())

#   1초 뒤에 실행       
    time.sleep(1)

# 파일 객체 종료
f.close()


# In[50]:


# 파일 객체 생성
f = open('reviews.txt', 'r')
text = f.readline()
f.close()


# In[51]:


text


# ### 워드클라우드 그리기
# - wordcloud 라이브러리 설치

# In[52]:


# !pip install 설치할 라이브러리 이름
get_ipython().system('pip install wordcloud')


# In[78]:


# 워드클라우드를 그릴 때 사용하는 라이브러리
from wordcloud import WordCloud
from collections import Counter
import random
import matplotlib.pyplot as plt


# In[75]:


# 원하는 색상을 RGB 값으로 저장
colors = [[255, 99, 72],[46, 213, 115],[83, 82, 237],[214, 48, 49],[232, 67, 147],[255, 118, 117]]

# 색상 리스트에서 랜덤으로 색상을 뽑는 함수
def color_func(**kwargs):
    return tuple(colors[random.randint(0,5)])


# In[76]:


# 워드클라우드를 스타일(폰트, 배경, 마스크이미지, 불용어 등등)을 정의
wc = WordCloud(
    font_path ='C:/Windows/Fonts/Malgunbd.ttf',
    background_color = 'white'
)

# 위에서 정의한 스타일을 텍스트에 반영 및 단어 추출
wc = wc.generate(text)


# In[79]:


wc.recolor(color_func = color_func)


# In[80]:


# 단어 빈도수를 0~1 사이로 출력
wc.words_


# In[81]:


# interplo
plt.imshow(wc, interpolation = 'bilinear')
plt.axis('off')


# In[ ]:




