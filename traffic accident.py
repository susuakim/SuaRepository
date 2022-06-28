#!/usr/bin/env python
# coding: utf-8

# # Question2

# In[2]:


import matplotlib.pyplot as plt
import pandas as pd


# In[11]:


from matplotlib import font_manager, rc
font_name = font_manager.FontProperties(fname ='c:/Windows/Fonts/malgun.ttf').get_name()
rc('font', family = font_name)


# In[42]:


x = [2,3,4,5,6,7,8]
y1 = [5,7,3,9,1,8,6]
y2 = [9,5,7,2,3,7,1]

plt.plot(x, y1, color = 'red', label = 'Y1')
plt.plot(x, y2, color = 'blue', label = 'Y2')

plt.grid()

plt.legend()

fontdict={
     'fontsize': 13,
      'fontweight': 'bold'}

plt.title('<실행결과>', **fontdict)

plt.xlabel("X")
plt.ylabel("Y")

plt.show()


# # Question3

# In[19]:


import pandas as pd
data = pd.read_csv('./data/Traffic_Accident_2017.csv', encoding = 'euc-kr')


# In[31]:


x1 = data[data['주야'] == '야간'].loc[:, '경도']
y1 = data[data['주야'] == '야간'].loc[:, '위도']

x2 = data[data['주야'] == '주간'].loc[:, '경도']
y2 = data[data['주야'] == '주간'].loc[:, '위도']

plt.scatter(x1, y1, color = 'blue', alpha = 0.1, label = 'Night') 
plt.scatter(x2, y2, color = 'red', alpha = 0.1, label = 'Day')

plt.legend()

plt.xlim(123, 133)

plt.xlabel("LON")
plt.ylabel("LAT")

plt.show()


# In[ ]:




