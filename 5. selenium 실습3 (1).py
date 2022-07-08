#!/usr/bin/env python
# coding: utf-8

# In[1]:


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


# ### G마켓 상품데이터 수집

# In[7]:


# driver 객체 옵션 설정(GPU 사용X, 화면사이즈, 브라우저 숨김)
options = wb.ChromeOptions()
options.add_argument('disable-gpu')
options.add_argument('window-size=1920x1080')
options.add_argument('headless')


# In[52]:


url = 'http://corners.gmarket.co.kr/Bestsellers'
driver = wb.Chrome()
driver.get(url)


# #### 상품명, 가격 수집

# In[8]:


html = bs(driver.page_source, 'lxml')


# In[26]:


pd_names = html.select('a.itemname')
pd_prices = html.select('div.s-price > strong > span > span')

print(len(pd_names), len(pd_prices))

for i in range(len(pd_names)):
    print(pd_names[i].text)
    print(pd_prices[i].text)


# #### 수집된 정보를 DataFrame로 출력해보기
# 1. 수집한 정보를 리스트로 저장
# 2. 각 리스트를 하나의 딕셔너리로 생성
# 3. 딕셔너리를 pd.DataFrame()에 매개변수로 전달

# In[35]:


# 1. 수집한 정보를 리스트로 저장
pd_name_list = []
pd_price_list = []

for i in range(len(pd_names)):
    pd_name_list.append(pd_names[i].text)
    pd_price_list.append(pd_prices[i].text)


# In[36]:


# 2. 각 릿트를 하나의 딕셔너리로 생성
product_dic = {
    '상품명' : pd_name_list,
    '가격' : pd_price_list
}


# In[37]:


# 3. 딕셔너리를 pd.DataFrame()에 매개변수로 전달
df = pd.DataFrame(product_dic)
df


# ### 카테고리 클릭해보기

# In[53]:


# driver.find_elements() : 요소객체를 리스트로 반환
category = driver.find_elements(By.CSS_SELECTOR, value='ul#categoryTabG > :not(li:first-child) > a')

# 페이지 주소가 변경이 되면 이전 페이지의 내용을 가지고 있는
# driver 객체의 요소들을 사용할 수 없기 때문에
# 카테고리 주소를 추출해서 페이지 변환하는 방식으로 처리

href_list = [] # 카테고리 버튼의 주소를 저장하는 리스트

for cate in category:
    href = cate.get_attribute('href') # 속성값 접근하는 함수
    href_list.append(href)


# In[54]:


# 저장된 리스트 내 주소로 페이지 실행
for url in href_list:
    driver.get(url)
    time.sleep(1.5)


# ### 카테고리별 상품정보 수집

# In[60]:


# 저장된 리스트 내 주소로 페이지 실행
for url in href_list:
    driver.get(url)
    
    # 파이썬 객체 변환
    html = bs(driver.page_source, 'lxml')
    
    # 상품정보 수집하는 로직
    pd_names = html.select('a.itemname', limit=10)
    pd_prices = html.select('div.s-price > strong > span > span', limit=10)
    
    for i in range(len(pd_names)):
        print('상품명: ', pd_names[i].text)
        print('가격: ', pd_prices[i].text)
        
    print('='*90)
    time.sleep(1.5)


# In[ ]:




