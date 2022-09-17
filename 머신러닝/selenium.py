#!/usr/bin/env python
# coding: utf-8

# ### Selenium 라이브러리
# - 웹 페이지를 자동제어(마우스, 스크롤, 입력창에 데이터 입력 등)하기 위한 라이브러리
# - 동적인 콘텐츠를 가진 페이지의 내용을 수집할 때 사용하는 라이브러리
# - selenium 라이브러리 설치 + webdriver 파일 설치
# - webdriver 파일의 경우 브라우저 버전이 바뀌면 파일을 새로운 버전으로 변경해줘야 함

# In[1]:


get_ipython().system('pip install selenium')


# In[1]:


from selenium import webdriver as wb
from selenium.webdriver.common.by import By
from bs4 import BeautifulSoup as bs


# In[1]:


driver = wb.Chrome()
driver.get('https://www.naver.com')


# In[3]:


# find_element() : 요소 객체를 반환
# send_keys() : 요소에 데이터를 보내는 함수
driver.find_element(by='id', value='query').send_keys('치즈돈까스')


# In[4]:


driver.find_element(by='id', value='query').send_keys('치즈돈까스')

# 버튼 클릭
driver.find_element(by='id', value='search_btn').click()


# ### Google 페이지에 접속한 후 검색어를 입력하여 결과 페이지가 나오도록 구현해 보기

# In[14]:


driver = wb.Chrome()
driver.get('https://www.google.com/')


# In[16]:


# By.요소접근방식
# driver.find_element(By.CLASS_NAME, value='gLFyf')

# 선택자로 쓴다면
driver.find_element(By.CSS_SELECTOR, value='input.gLFyf').send_keys('라면')


# In[17]:


# HTML 문서 -> 문자열로 출력(= req.get(url).text)
driver.page_source


# In[23]:


html = bs(driver.page_source, 'lxml')


# In[24]:


for data in html.select('div.dbgOpd > span.0SrXXb'):
    print(data.text)


# In[ ]:





# In[ ]:




