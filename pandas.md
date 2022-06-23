![image.png](attachment:image.png)
![image-2.png](attachment:image-2.png)


```python
# 1차원데이터 Series, 2차원데이터 
# pandas
import pandas as pd
```


```python
#pop() 같은 함수 이름은 변수로 사용 가능
# if, for, while, del 같은 키워드는 변수로 사용 불가능
```

![image.png](attachment:image.png)


```python
# 1차원 데이터 Series 사용
pop = pd.Series([9904312,3448737,2890451,2466052])
pop
```




    0    9904312
    1    3448737
    2    2890451
    3    2466052
    dtype: int64




```python
# 인덱스 지정해서 생성
pop = pd.Series([9904312,3448737,2890451,2466052], index=['서울', '부산', '인천', '대구'])
pop
```




    서울    9904312
    부산    3448737
    인천    2890451
    대구    2466052
    dtype: int64




```python
# 원하는 값 인덱싱으로 가져오기
pop[1], pop['부산']
```




    (3448737, 3448737)




```python
# 여러가지 값을 인덱싱 하기
# 순서, 횟수 관계없이
# 리스트 형식으로 여러가지 값 인덱싱하기
a = pop[ ['인천', '서울', '인천'] ]
b = pop[ [0, 1, 3] ]
print(a)
print(b)
```

    인천    2890451
    서울    9904312
    인천    2890451
    dtype: int64
    서울    9904312
    부산    3448737
    대구    2466052
    dtype: int64
    


```python
# 슬라이싱 
# 인덱스 1이상 3미만
pop[ 1 : 3 ]
```




    서울    9904312
    부산    3448737
    인천    2890451
    대구    2466052
    dtype: int64




```python
# 직접 부여한 인덱스 값을 사용해서 슬라이싱을 할때는
# 인덱스 이상 인덱스 이하
pop[ '부산' : '대구']
```




    부산    3448737
    인천    2890451
    대구    2466052
    dtype: int64




```python
# 예외) 인덱스 번호를 숫자로 직접 부여
# 인덱싱은 부여한 숫자로
# 슬라이싱은 부여받은 숫자로
pop = pd.Series([9904312,3448737,2890451,2466052], index=[10, 11, 12, 13])
a = pop[11]
b = pop[ 1 : 3 ]
print(a)
print(b)
```

    3448737
    11    3448737
    12    2890451
    dtype: int64
    

### Series 확인
![image.png](attachment:image.png)


```python
# 1.값(values), 2.인덱스(index), 3.타입(dtype) 총 3개 확인 가능
pop.values
pop.dtype
pop
```




    서울    9904312
    부산    3448737
    인천    2890451
    대구    2466052
    dtype: int64




```python
# Series에 이름 지정
# columns에 이름 달기
pop.name = '인구'

# index에 이름 달기
pop.index.name = '도시'

pop
```




    도시
    서울    9904312
    부산    3448737
    인천    2890451
    대구    2466052
    Name: 인구, dtype: int64



![image-2.png](attachment:image-2.png)


```python
# dataFrame(Sefies(numpy))
import numpy as np
```


```python
pd.Series(np.arange(1,10))
```




    0    1
    1    2
    2    3
    3    4
    4    5
    5    6
    6    7
    7    8
    8    9
    dtype: int32




```python
# Series 연산
# 인덱스 값이 지정한 값이 되어버리면 Series 연산시 인덱스 값이 동일한 것 끼리 연산
# 딕셔너리로 Series 생성
# 딕셔너리는 ket는 values로, values는 values로
data_dic = {"서울":9631481, "부산":3393191,"인천":2632035,"대전":1490158}
pop2 = pd.Series(data_dic)
pop2
# pop와 pop2는 다르다(대전이 있다.)

temp = pop - pop2
temp
```




    대구         NaN
    대전         NaN
    부산     55546.0
    서울    272831.0
    인천    258416.0
    dtype: float64




```python
pop - pop
```




    도시
    서울    0
    부산    0
    인천    0
    대구    0
    Name: 인구, dtype: int64




```python
pop / 100000
```




    도시
    서울    99.04312
    부산    34.48737
    인천    28.90451
    대구    24.66052
    Name: 인구, dtype: float64




```python
# NaN 값 제외하고 확인하기
# 1. isnull()
# 2. notnull()
temp.isnull()
```




    대구     True
    대전     True
    부산    False
    서울    False
    인천    False
    dtype: bool




```python
temp.notnull()
```




    대구    True
    부산    True
    서울    True
    인천    True
    dtype: bool




```python
# null이 아닌 값들만 출력
temp[temp.notnull()]
```




    부산     55546.0
    서울    272831.0
    인천    258416.0
    dtype: float64




```python
# 차이가 10만보다 큰 도시 출력
temp[temp > 100000]
```




    서울    272831.0
    인천    258416.0
    dtype: float64




```python
# Series 데이터 갱신, 삭제, 추가
# 1. 갱신
temp['대구'] = 5

# 2. 삭제
del temp['인천']

# 3. 추가
temp['광주'] = 10
temp
```




    대구         5.0
    부산     55546.0
    서울    272831.0
    광주        10.0
    dtype: float64



### DataFrame(2차원)


```python
# 딕셔너리 사용해서 데이터 프레임 생성
data = {
    "2015" : [9904312,3448737,2890451,2466052],
    "2010" : [9631482,3393191,2632035,2431774]
}

# 데이터 프레임 생성할때 인덱스 값 지정
# 첫번째 방법
ind = ['서울', '부산', '인천', '대구']
df = pd.DataFrame(data, index = ind)
df
```




<div>
<style scoped>
    .dataframe tbody tr th:only-of-type {
        vertical-align: middle;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }

    .dataframe thead th {
        text-align: right;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>2015</th>
      <th>2010</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>서울</th>
      <td>9904312</td>
      <td>9631482</td>
    </tr>
    <tr>
      <th>부산</th>
      <td>3448737</td>
      <td>3393191</td>
    </tr>
    <tr>
      <th>인천</th>
      <td>2890451</td>
      <td>2632035</td>
    </tr>
    <tr>
      <th>대구</th>
      <td>2466052</td>
      <td>2431774</td>
    </tr>
  </tbody>
</table>
</div>




```python
# 두번째 방법
# 인덱스 값 수정
# 데이터프레임이 만들어진 후에 사용
df.index = ['서울', '부산', '인천', '대구']
df
```




<div>
<style scoped>
    .dataframe tbody tr th:only-of-type {
        vertical-align: middle;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }

    .dataframe thead th {
        text-align: right;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>2015</th>
      <th>2010</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>서울</th>
      <td>9904312</td>
      <td>9631482</td>
    </tr>
    <tr>
      <th>부산</th>
      <td>3448737</td>
      <td>3393191</td>
    </tr>
    <tr>
      <th>인천</th>
      <td>2890451</td>
      <td>2632035</td>
    </tr>
    <tr>
      <th>대구</th>
      <td>2466052</td>
      <td>2431774</td>
    </tr>
  </tbody>
</table>
</div>




```python
# 리스트 사용해서 데이터 프레임 생성
data_list = [
    [9904312,3448737,2890451,2466052],
    [9361482,3393191,2632035,2431774]
]

ind = ['2015', '2010']
col = ['서울', '부산', '인천', '대구']
pd.DataFrame(data_list, index = ind, columns = col)
df
```




<div>
<style scoped>
    .dataframe tbody tr th:only-of-type {
        vertical-align: middle;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }

    .dataframe thead th {
        text-align: right;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>2015</th>
      <th>2010</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>서울</th>
      <td>9904312</td>
      <td>9631482</td>
    </tr>
    <tr>
      <th>부산</th>
      <td>3448737</td>
      <td>3393191</td>
    </tr>
    <tr>
      <th>인천</th>
      <td>2890451</td>
      <td>2632035</td>
    </tr>
    <tr>
      <th>대구</th>
      <td>2466052</td>
      <td>2431774</td>
    </tr>
  </tbody>
</table>
</div>




```python
# 전치 = 컬럼과 인덱스 바꾸기
df.T
```




<div>
<style scoped>
    .dataframe tbody tr th:only-of-type {
        vertical-align: middle;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }

    .dataframe thead th {
        text-align: right;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>서울</th>
      <th>부산</th>
      <th>인천</th>
      <th>대구</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>2015</th>
      <td>9904312</td>
      <td>3448737</td>
      <td>2890451</td>
      <td>2466052</td>
    </tr>
    <tr>
      <th>2010</th>
      <td>9631482</td>
      <td>3393191</td>
      <td>2632035</td>
      <td>2431774</td>
    </tr>
  </tbody>
</table>
</div>




```python
# DataRrame 확인
# 값(values), 인덱스(index), 컬럼(columns)
df.values
df.index
df.columns
```




    Index(['2015', '2010'], dtype='object')




```python
# 열 인덱싱
df['2015']
# 인덱스 슬라이싱
df[0:1]
```




<div>
<style scoped>
    .dataframe tbody tr th:only-of-type {
        vertical-align: middle;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }

    .dataframe thead th {
        text-align: right;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>2015</th>
      <th>2010</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>서울</th>
      <td>9904312</td>
      <td>9631482</td>
    </tr>
  </tbody>
</table>
</div>




```python
# 인덱서
# 행(index)과 열(columns)을 한번에 인덱싱/슬라이싱할 때 사용
# loc[]: 직접 부여한 인덱스, iloc[]:
# 인덱서[행 , 열]

# loc[]: 직접 부여한 인덱스,
# 1. 서울과 부산 인덱스
# 2. 2015 컬럼
df.loc['서울' : '부산', '2015']

# iloc : 자동으로 부여된 인덱스, 컬럼값 사용
df.iloc[0 : 2, 0]
```




    서울    9904312
    부산    3448737
    Name: 2015, dtype: int64




```python
df
```




<div>
<style scoped>
    .dataframe tbody tr th:only-of-type {
        vertical-align: middle;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }

    .dataframe thead th {
        text-align: right;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>2015</th>
      <th>2010</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>서울</th>
      <td>9904312</td>
      <td>9631482</td>
    </tr>
    <tr>
      <th>부산</th>
      <td>3448737</td>
      <td>3393191</td>
    </tr>
    <tr>
      <th>인천</th>
      <td>2890451</td>
      <td>2632035</td>
    </tr>
    <tr>
      <th>대구</th>
      <td>2466052</td>
      <td>2431774</td>
    </tr>
  </tbody>
</table>
</div>




```python
# 서울, 인천 인덱스
# 2010 컬럼
df.loc[['서울', '인천'], '2010']
```




    서울    9631482
    인천    2632035
    Name: 2010, dtype: int64




```python
# 하나의 값을 리스트에 넣어서 출력하면 데이터 프레임으로 출력
df.loc[['서울', '인천'],['2010']]
```




<div>
<style scoped>
    .dataframe tbody tr th:only-of-type {
        vertical-align: middle;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }

    .dataframe thead th {
        text-align: right;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>2010</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>서울</th>
      <td>9631482</td>
    </tr>
    <tr>
      <th>인천</th>
      <td>2632035</td>
    </tr>
  </tbody>
</table>
</div>




```python
# 하나의 값을 그냥 넣어서 출력하면 시리즈로 출력
df.loc[['서울', '인천'],'2010']
```




    서울    9631482
    인천    2632035
    Name: 2010, dtype: int64




```python
# 데이터 추가
# 컬럼을 기준으로 데이터 추가
df['2005'] = [465, 789, 798, 465]
df
```




<div>
<style scoped>
    .dataframe tbody tr th:only-of-type {
        vertical-align: middle;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }

    .dataframe thead th {
        text-align: right;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>2015</th>
      <th>2010</th>
      <th>2005</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>서울</th>
      <td>9904312</td>
      <td>9631482</td>
      <td>465</td>
    </tr>
    <tr>
      <th>부산</th>
      <td>3448737</td>
      <td>3393191</td>
      <td>789</td>
    </tr>
    <tr>
      <th>인천</th>
      <td>2890451</td>
      <td>2632035</td>
      <td>798</td>
    </tr>
    <tr>
      <th>대구</th>
      <td>2466052</td>
      <td>2431774</td>
      <td>465</td>
    </tr>
  </tbody>
</table>
</div>




```python
# 인덱스 기준으로 데이터 추가
# 인덱서에 하나의 값만 적으면 해당 행의 모든 열을 가져옴
df.loc['광주'] = [46543, 6545132, 8798543]
df
```




<div>
<style scoped>
    .dataframe tbody tr th:only-of-type {
        vertical-align: middle;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }

    .dataframe thead th {
        text-align: right;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>2015</th>
      <th>2010</th>
      <th>2005</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>서울</th>
      <td>9904312</td>
      <td>9631482</td>
      <td>465</td>
    </tr>
    <tr>
      <th>부산</th>
      <td>3448737</td>
      <td>3393191</td>
      <td>789</td>
    </tr>
    <tr>
      <th>인천</th>
      <td>2890451</td>
      <td>2632035</td>
      <td>798</td>
    </tr>
    <tr>
      <th>대구</th>
      <td>2466052</td>
      <td>2431774</td>
      <td>465</td>
    </tr>
    <tr>
      <th>광주</th>
      <td>46543</td>
      <td>6545132</td>
      <td>8798543</td>
    </tr>
  </tbody>
</table>
</div>




```python
df.loc['순천'] = [353575, None, None]
df
```




<div>
<style scoped>
    .dataframe tbody tr th:only-of-type {
        vertical-align: middle;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }

    .dataframe thead th {
        text-align: right;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>2015</th>
      <th>2010</th>
      <th>2005</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>서울</th>
      <td>9904312.0</td>
      <td>9631482.0</td>
      <td>465.0</td>
    </tr>
    <tr>
      <th>부산</th>
      <td>3448737.0</td>
      <td>3393191.0</td>
      <td>789.0</td>
    </tr>
    <tr>
      <th>인천</th>
      <td>2890451.0</td>
      <td>2632035.0</td>
      <td>798.0</td>
    </tr>
    <tr>
      <th>대구</th>
      <td>2466052.0</td>
      <td>2431774.0</td>
      <td>465.0</td>
    </tr>
    <tr>
      <th>광주</th>
      <td>46543.0</td>
      <td>6545132.0</td>
      <td>8798543.0</td>
    </tr>
    <tr>
      <th>순천</th>
      <td>353575.0</td>
      <td>NaN</td>
      <td>NaN</td>
    </tr>
  </tbody>
</table>
</div>




```python
# 데이터 삭제
# 1. drop, 2.del
# axis = 0 : 인덱스 기준으로
# axis = 1 : 컬럼 기준으로
# df.drop('2015') #오류나옴
df.drop('2015', axis = 1)

```




<div>
<style scoped>
    .dataframe tbody tr th:only-of-type {
        vertical-align: middle;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }

    .dataframe thead th {
        text-align: right;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>2010</th>
      <th>2005</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>서울</th>
      <td>9631482.0</td>
      <td>465.0</td>
    </tr>
    <tr>
      <th>부산</th>
      <td>3393191.0</td>
      <td>789.0</td>
    </tr>
    <tr>
      <th>인천</th>
      <td>2632035.0</td>
      <td>798.0</td>
    </tr>
    <tr>
      <th>대구</th>
      <td>2431774.0</td>
      <td>465.0</td>
    </tr>
    <tr>
      <th>광주</th>
      <td>6545132.0</td>
      <td>8798543.0</td>
    </tr>
    <tr>
      <th>순천</th>
      <td>NaN</td>
      <td>NaN</td>
    </tr>
  </tbody>
</table>
</div>




```python
df
```




<div>
<style scoped>
    .dataframe tbody tr th:only-of-type {
        vertical-align: middle;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }

    .dataframe thead th {
        text-align: right;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>2015</th>
      <th>2010</th>
      <th>2005</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>서울</th>
      <td>9904312.0</td>
      <td>9631482.0</td>
      <td>465.0</td>
    </tr>
    <tr>
      <th>부산</th>
      <td>3448737.0</td>
      <td>3393191.0</td>
      <td>789.0</td>
    </tr>
    <tr>
      <th>인천</th>
      <td>2890451.0</td>
      <td>2632035.0</td>
      <td>798.0</td>
    </tr>
    <tr>
      <th>대구</th>
      <td>2466052.0</td>
      <td>2431774.0</td>
      <td>465.0</td>
    </tr>
    <tr>
      <th>광주</th>
      <td>46543.0</td>
      <td>6545132.0</td>
      <td>8798543.0</td>
    </tr>
    <tr>
      <th>순천</th>
      <td>353575.0</td>
      <td>NaN</td>
      <td>NaN</td>
    </tr>
  </tbody>
</table>
</div>




```python
df.drop('2015', axis = 1, inplace=True)
df
```


    ---------------------------------------------------------------------------

    NameError                                 Traceback (most recent call last)

    Input In [1], in <cell line: 1>()
    ----> 1 df.drop('2015', axis = 1, inplace=True)
          2 df
    

    NameError: name 'df' is not defined



```python
df
```




<div>
<style scoped>
    .dataframe tbody tr th:only-of-type {
        vertical-align: middle;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }

    .dataframe thead th {
        text-align: right;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>2010</th>
      <th>2005</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>서울</th>
      <td>9631482.0</td>
      <td>465.0</td>
    </tr>
    <tr>
      <th>부산</th>
      <td>3393191.0</td>
      <td>789.0</td>
    </tr>
    <tr>
      <th>인천</th>
      <td>2632035.0</td>
      <td>798.0</td>
    </tr>
    <tr>
      <th>대구</th>
      <td>2431774.0</td>
      <td>465.0</td>
    </tr>
    <tr>
      <th>광주</th>
      <td>6545132.0</td>
      <td>8798543.0</td>
    </tr>
    <tr>
      <th>순천</th>
      <td>NaN</td>
      <td>NaN</td>
    </tr>
  </tbody>
</table>
</div>




```python
del df['2010']
df
```


    ---------------------------------------------------------------------------

    NameError                                 Traceback (most recent call last)

    Input In [2], in <cell line: 1>()
    ----> 1 del df['2010']
          2 df
    

    NameError: name 'df' is not defined


### 6/22


```python
import pandas as pd
# euc-kr, utf-8 : 가장 대중적인 인코딩 방법
# cp949 : 위의 2개가 안되었을때 인코딩
# index_col 속성 = 원하는 컬럼을 인덱스로 사용 가능
data = pd.read_csv('./data/population_number.csv', encoding = 'euc-kr',
                  index_col = '도시')
data
```




<div>
<style scoped>
    .dataframe tbody tr th:only-of-type {
        vertical-align: middle;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }

    .dataframe thead th {
        text-align: right;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>지역</th>
      <th>2015</th>
      <th>2010</th>
      <th>2005</th>
      <th>2000</th>
    </tr>
    <tr>
      <th>도시</th>
      <th></th>
      <th></th>
      <th></th>
      <th></th>
      <th></th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>서울</th>
      <td>수도권</td>
      <td>9904312</td>
      <td>9631482.0</td>
      <td>9762546.0</td>
      <td>9853972</td>
    </tr>
    <tr>
      <th>부산</th>
      <td>경상권</td>
      <td>3448737</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>3655437</td>
    </tr>
    <tr>
      <th>인천</th>
      <td>수도권</td>
      <td>2890451</td>
      <td>2632035.0</td>
      <td>NaN</td>
      <td>2466338</td>
    </tr>
    <tr>
      <th>대구</th>
      <td>경상권</td>
      <td>2466052</td>
      <td>2431774.0</td>
      <td>2456016.0</td>
      <td>2473990</td>
    </tr>
  </tbody>
</table>
</div>




```python
# 정렬
# 1. 인덱스 기준으로 : sort_index()
# 기본값은 오름차순(한글 ㄱㄷㄴ, 영어는 abc, 숫자는 123)
# ascending = False : 내림차순 정렬
data.sort_index(ascending = False) 
```




<div>
<style scoped>
    .dataframe tbody tr th:only-of-type {
        vertical-align: middle;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }

    .dataframe thead th {
        text-align: right;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>지역</th>
      <th>2015</th>
      <th>2010</th>
      <th>2005</th>
      <th>2000</th>
    </tr>
    <tr>
      <th>도시</th>
      <th></th>
      <th></th>
      <th></th>
      <th></th>
      <th></th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>인천</th>
      <td>수도권</td>
      <td>2890451</td>
      <td>2632035.0</td>
      <td>NaN</td>
      <td>2466338</td>
    </tr>
    <tr>
      <th>서울</th>
      <td>수도권</td>
      <td>9904312</td>
      <td>9631482.0</td>
      <td>9762546.0</td>
      <td>9853972</td>
    </tr>
    <tr>
      <th>부산</th>
      <td>경상권</td>
      <td>3448737</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>3655437</td>
    </tr>
    <tr>
      <th>대구</th>
      <td>경상권</td>
      <td>2466052</td>
      <td>2431774.0</td>
      <td>2456016.0</td>
      <td>2473990</td>
    </tr>
  </tbody>
</table>
</div>




```python
# 2. 데이터 기준으로 : sort_values()
data.sort_values(by = ['지역', '2015'], ascending = False)
```




<div>
<style scoped>
    .dataframe tbody tr th:only-of-type {
        vertical-align: middle;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }

    .dataframe thead th {
        text-align: right;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>지역</th>
      <th>2015</th>
      <th>2010</th>
      <th>2005</th>
      <th>2000</th>
    </tr>
    <tr>
      <th>도시</th>
      <th></th>
      <th></th>
      <th></th>
      <th></th>
      <th></th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>서울</th>
      <td>수도권</td>
      <td>9904312</td>
      <td>9631482.0</td>
      <td>9762546.0</td>
      <td>9853972</td>
    </tr>
    <tr>
      <th>인천</th>
      <td>수도권</td>
      <td>2890451</td>
      <td>2632035.0</td>
      <td>NaN</td>
      <td>2466338</td>
    </tr>
    <tr>
      <th>부산</th>
      <td>경상권</td>
      <td>3448737</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>3655437</td>
    </tr>
    <tr>
      <th>대구</th>
      <td>경상권</td>
      <td>2466052</td>
      <td>2431774.0</td>
      <td>2456016.0</td>
      <td>2473990</td>
    </tr>
  </tbody>
</table>
</div>




```python
# 값의 갯수를 세어주는 함수
# value_counts()
data['지역'].value_counts(0)
```




    수도권    2
    경상권    2
    Name: 지역, dtype: int64




```python
# 중복 제거하고 값을 출력
# unique()
data['지역'].unique()
```




    array(['수도권', '경상권'], dtype=object)




```python
# 결측치 채우는 함수
# fillna()
data.fillna(value = 100, inplace = True)
data
```




<div>
<style scoped>
    .dataframe tbody tr th:only-of-type {
        vertical-align: middle;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }

    .dataframe thead th {
        text-align: right;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>지역</th>
      <th>2015</th>
      <th>2010</th>
      <th>2005</th>
      <th>2000</th>
    </tr>
    <tr>
      <th>도시</th>
      <th></th>
      <th></th>
      <th></th>
      <th></th>
      <th></th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>서울</th>
      <td>수도권</td>
      <td>9904312</td>
      <td>9631482.0</td>
      <td>9762546.0</td>
      <td>9853972</td>
    </tr>
    <tr>
      <th>부산</th>
      <td>경상권</td>
      <td>3448737</td>
      <td>100.0</td>
      <td>100.0</td>
      <td>3655437</td>
    </tr>
    <tr>
      <th>인천</th>
      <td>수도권</td>
      <td>2890451</td>
      <td>2632035.0</td>
      <td>100.0</td>
      <td>2466338</td>
    </tr>
    <tr>
      <th>대구</th>
      <td>경상권</td>
      <td>2466052</td>
      <td>2431774.0</td>
      <td>2456016.0</td>
      <td>2473990</td>
    </tr>
  </tbody>
</table>
</div>




```python
score = pd.read_csv('./data/score.csv', encoding = 'euc-kr', index_col = '과목')
score
```




<div>
<style scoped>
    .dataframe tbody tr th:only-of-type {
        vertical-align: middle;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }

    .dataframe thead th {
        text-align: right;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>1반</th>
      <th>2반</th>
      <th>3반</th>
      <th>4반</th>
    </tr>
    <tr>
      <th>과목</th>
      <th></th>
      <th></th>
      <th></th>
      <th></th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>수학</th>
      <td>45</td>
      <td>44</td>
      <td>73</td>
      <td>39</td>
    </tr>
    <tr>
      <th>영어</th>
      <td>76</td>
      <td>92</td>
      <td>45</td>
      <td>69</td>
    </tr>
    <tr>
      <th>국어</th>
      <td>47</td>
      <td>92</td>
      <td>45</td>
      <td>69</td>
    </tr>
    <tr>
      <th>사회</th>
      <td>92</td>
      <td>81</td>
      <td>85</td>
      <td>40</td>
    </tr>
    <tr>
      <th>과학</th>
      <td>11</td>
      <td>79</td>
      <td>47</td>
      <td>26</td>
    </tr>
  </tbody>
</table>
</div>




```python
# sum 함수는 기본적으로 열 단위로 계산
# 학급별 순위
score.sum().sort_values(ascending = False)
```




    2반    388
    3반    295
    1반    271
    4반    243
    dtype: int64




```python
# axis = 1 : 행 단위로 계산
score.sum(axis = 1)
```




    과목
    수학    201
    영어    282
    국어    253
    사회    298
    과학    163
    dtype: int64




```python
# 합계 구하기
score['합계'] = score.iloc[:, 0:4].sum(axis = 1)
score
```




<div>
<style scoped>
    .dataframe tbody tr th:only-of-type {
        vertical-align: middle;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }

    .dataframe thead th {
        text-align: right;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>1반</th>
      <th>2반</th>
      <th>3반</th>
      <th>4반</th>
      <th>합계</th>
    </tr>
    <tr>
      <th>과목</th>
      <th></th>
      <th></th>
      <th></th>
      <th></th>
      <th></th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>수학</th>
      <td>45</td>
      <td>44</td>
      <td>73</td>
      <td>39</td>
      <td>201</td>
    </tr>
    <tr>
      <th>영어</th>
      <td>76</td>
      <td>92</td>
      <td>45</td>
      <td>69</td>
      <td>282</td>
    </tr>
    <tr>
      <th>국어</th>
      <td>47</td>
      <td>92</td>
      <td>45</td>
      <td>69</td>
      <td>253</td>
    </tr>
    <tr>
      <th>사회</th>
      <td>92</td>
      <td>81</td>
      <td>85</td>
      <td>40</td>
      <td>298</td>
    </tr>
    <tr>
      <th>과학</th>
      <td>11</td>
      <td>79</td>
      <td>47</td>
      <td>26</td>
      <td>163</td>
    </tr>
  </tbody>
</table>
</div>




```python
# 평균 구하기
score['평균'] = score.iloc[:, 0:4].mean(axis = 1)
score
```




<div>
<style scoped>
    .dataframe tbody tr th:only-of-type {
        vertical-align: middle;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }

    .dataframe thead th {
        text-align: right;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>1반</th>
      <th>2반</th>
      <th>3반</th>
      <th>4반</th>
      <th>합계</th>
      <th>평균</th>
    </tr>
    <tr>
      <th>과목</th>
      <th></th>
      <th></th>
      <th></th>
      <th></th>
      <th></th>
      <th></th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>수학</th>
      <td>45</td>
      <td>44</td>
      <td>73</td>
      <td>39</td>
      <td>201</td>
      <td>50.25</td>
    </tr>
    <tr>
      <th>영어</th>
      <td>76</td>
      <td>92</td>
      <td>45</td>
      <td>69</td>
      <td>282</td>
      <td>70.50</td>
    </tr>
    <tr>
      <th>국어</th>
      <td>47</td>
      <td>92</td>
      <td>45</td>
      <td>69</td>
      <td>253</td>
      <td>63.25</td>
    </tr>
    <tr>
      <th>사회</th>
      <td>92</td>
      <td>81</td>
      <td>85</td>
      <td>40</td>
      <td>298</td>
      <td>74.50</td>
    </tr>
    <tr>
      <th>과학</th>
      <td>11</td>
      <td>79</td>
      <td>47</td>
      <td>26</td>
      <td>163</td>
      <td>40.75</td>
    </tr>
  </tbody>
</table>
</div>




```python
# 반평균 구하기
score.loc['반평균'] = score.iloc[0:5, 0:6].mean().sort_values(ascending = False)
score
```




<div>
<style scoped>
    .dataframe tbody tr th:only-of-type {
        vertical-align: middle;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }

    .dataframe thead th {
        text-align: right;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>1반</th>
      <th>2반</th>
      <th>3반</th>
      <th>4반</th>
      <th>합계</th>
      <th>평균</th>
    </tr>
    <tr>
      <th>과목</th>
      <th></th>
      <th></th>
      <th></th>
      <th></th>
      <th></th>
      <th></th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>수학</th>
      <td>45.0</td>
      <td>44.0</td>
      <td>73.0</td>
      <td>39.0</td>
      <td>201.0</td>
      <td>50.25</td>
    </tr>
    <tr>
      <th>영어</th>
      <td>76.0</td>
      <td>92.0</td>
      <td>45.0</td>
      <td>69.0</td>
      <td>282.0</td>
      <td>70.50</td>
    </tr>
    <tr>
      <th>국어</th>
      <td>47.0</td>
      <td>92.0</td>
      <td>45.0</td>
      <td>69.0</td>
      <td>253.0</td>
      <td>63.25</td>
    </tr>
    <tr>
      <th>사회</th>
      <td>92.0</td>
      <td>81.0</td>
      <td>85.0</td>
      <td>40.0</td>
      <td>298.0</td>
      <td>74.50</td>
    </tr>
    <tr>
      <th>과학</th>
      <td>11.0</td>
      <td>79.0</td>
      <td>47.0</td>
      <td>26.0</td>
      <td>163.0</td>
      <td>40.75</td>
    </tr>
    <tr>
      <th>반평균</th>
      <td>54.2</td>
      <td>77.6</td>
      <td>59.0</td>
      <td>48.6</td>
      <td>239.4</td>
      <td>59.85</td>
    </tr>
  </tbody>
</table>
</div>




```python
# min() : 최소값
# max() : 최대값
score.min()
score.min(axis = 1)
```




    과목
    수학     39.0
    영어     45.0
    국어     45.0
    사회     40.0
    과학     11.0
    반평균    48.6
    dtype: float64




```python
score.max()
```




    1반     92.0
    2반     92.0
    3반     85.0
    4반     69.0
    합계    298.0
    평균     74.5
    dtype: float64




```python
#  과목별 최대값과 최소값의 차이
sub_min = score.loc[:'과학', :'4반'].min(axis = 1)
sub_min
```




    과목
    수학    39.0
    영어    45.0
    국어    45.0
    사회    40.0
    과학    11.0
    dtype: float64




```python
sub_max = score.loc[:'과학', :'4반'].max(axis = 1)
sub_max
```




    과목
    수학    73.0
    영어    92.0
    국어    92.0
    사회    92.0
    과학    79.0
    dtype: float64




```python
sub_max -sub_min
```




    과목
    수학    34.0
    영어    47.0
    국어    47.0
    사회    52.0
    과학    68.0
    dtype: float64




```python
# apply(복잡한 처리, 행/열)
# 행이나 열 단위로 복잡한 처리(직접 만든 함수)를 할 때 사용
def max_min(x):
    return x.max() - x.min()

# axis = 1 : 행 단위로 계산
score.loc[: '과학', : '4반'].apply(max_min, axis = 1)
```




    과목
    수학    34.0
    영어    47.0
    국어    47.0
    사회    52.0
    과학    68.0
    dtype: float64




```python
# 데이터를 카테고리로 나누기
# pd.cut(카테고리화 시킬 데이터, 카테고리의 범위, 할당시킬 값)
ages = [0, 2, 10, 21, 23, 37, 31, 61, 20, 41, 32, 100]
```


```python
범위 = [0, 15, 25, 35, 60, 99]
할당값 = ['미성년자', '청년', '중년', '장년', '노년']
```


```python
pd.cut(ages, 범위, labels = 할당값)
```




    [NaN, '미성년자', '미성년자', '청년', '청년', ..., '노년', '청년', '장년', '중년', NaN]
    Length: 12
    Categories (5, object): ['미성년자' < '청년' < '중년' < '장년' < '노년']




```python
import pandas as pd
```


```python
df1 = pd.DataFrame({'A': ['A0', 'A1', 'A2', 'A3'],
                   'B': ['B0', 'B1', 'B2', 'B3'],
                   'C': ['C0', 'C1', 'C2', 'C3'],
                   'D': ['D0', 'D1', 'D2', 'D3']},
                  index=[0, 1, 2, 3])
df2 = pd.DataFrame({'A': ['A4', 'A5', 'A6', 'A7'],
                   'B': ['B4', 'B5', 'B6', 'B7'],
                   'C': ['C4', 'C5', 'C6', 'C7'],
                   'D': ['D4', 'D5', 'D6', 'D7']},
                  index=[4, 5, 6, 7])
df3 = pd.DataFrame({'A': ['A8', 'A9', 'A10', 'A11'],
                   'B': ['B8', 'B9', 'B10', 'B11'],
                   'C': ['C8', 'C9', 'C10', 'C11'],
                   'D': ['D8', 'D9', 'D10', 'D11']},
                  index=[8, 9, 10, 11])
```


```python
df3
```




<div>
<style scoped>
    .dataframe tbody tr th:only-of-type {
        vertical-align: middle;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }

    .dataframe thead th {
        text-align: right;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>A</th>
      <th>B</th>
      <th>C</th>
      <th>D</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>8</th>
      <td>A8</td>
      <td>B8</td>
      <td>C8</td>
      <td>D8</td>
    </tr>
    <tr>
      <th>9</th>
      <td>A9</td>
      <td>B9</td>
      <td>C9</td>
      <td>D9</td>
    </tr>
    <tr>
      <th>10</th>
      <td>A10</td>
      <td>B10</td>
      <td>C10</td>
      <td>D10</td>
    </tr>
    <tr>
      <th>11</th>
      <td>A11</td>
      <td>B11</td>
      <td>C11</td>
      <td>D11</td>
    </tr>
  </tbody>
</table>
</div>




```python
# 데이터 프레임 병합
# concat()
pd.concat([df1, df2, df3])
```




<div>
<style scoped>
    .dataframe tbody tr th:only-of-type {
        vertical-align: middle;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }

    .dataframe thead th {
        text-align: right;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>A</th>
      <th>B</th>
      <th>C</th>
      <th>D</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>0</th>
      <td>A0</td>
      <td>B0</td>
      <td>C0</td>
      <td>D0</td>
    </tr>
    <tr>
      <th>1</th>
      <td>A1</td>
      <td>B1</td>
      <td>C1</td>
      <td>D1</td>
    </tr>
    <tr>
      <th>2</th>
      <td>A2</td>
      <td>B2</td>
      <td>C2</td>
      <td>D2</td>
    </tr>
    <tr>
      <th>3</th>
      <td>A3</td>
      <td>B3</td>
      <td>C3</td>
      <td>D3</td>
    </tr>
    <tr>
      <th>4</th>
      <td>A4</td>
      <td>B4</td>
      <td>C4</td>
      <td>D4</td>
    </tr>
    <tr>
      <th>5</th>
      <td>A5</td>
      <td>B5</td>
      <td>C5</td>
      <td>D5</td>
    </tr>
    <tr>
      <th>6</th>
      <td>A6</td>
      <td>B6</td>
      <td>C6</td>
      <td>D6</td>
    </tr>
    <tr>
      <th>7</th>
      <td>A7</td>
      <td>B7</td>
      <td>C7</td>
      <td>D7</td>
    </tr>
    <tr>
      <th>8</th>
      <td>A8</td>
      <td>B8</td>
      <td>C8</td>
      <td>D8</td>
    </tr>
    <tr>
      <th>9</th>
      <td>A9</td>
      <td>B9</td>
      <td>C9</td>
      <td>D9</td>
    </tr>
    <tr>
      <th>10</th>
      <td>A10</td>
      <td>B10</td>
      <td>C10</td>
      <td>D10</td>
    </tr>
    <tr>
      <th>11</th>
      <td>A11</td>
      <td>B11</td>
      <td>C11</td>
      <td>D11</td>
    </tr>
  </tbody>
</table>
</div>




```python
df4 = pd.DataFrame({'B': ['B2', 'B3', 'B6', 'B7'],
                   'D': ['D2', 'D3', 'D6', 'D7'],
                   'F': ['F2', 'F3', 'F6', 'F7']},
                  index=[2, 3, 6, 7])
df4
```




<div>
<style scoped>
    .dataframe tbody tr th:only-of-type {
        vertical-align: middle;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }

    .dataframe thead th {
        text-align: right;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>B</th>
      <th>D</th>
      <th>F</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>2</th>
      <td>B2</td>
      <td>D2</td>
      <td>F2</td>
    </tr>
    <tr>
      <th>3</th>
      <td>B3</td>
      <td>D3</td>
      <td>F3</td>
    </tr>
    <tr>
      <th>6</th>
      <td>B6</td>
      <td>D6</td>
      <td>F6</td>
    </tr>
    <tr>
      <th>7</th>
      <td>B7</td>
      <td>D7</td>
      <td>F7</td>
    </tr>
  </tbody>
</table>
</div>




```python
# join outer : 모든걸 표시
# join inner : 같은 기준을 가지고 있는 것들만 표시
pd.concat([df1, df4], axis = 1, join = 'inner')
```




<div>
<style scoped>
    .dataframe tbody tr th:only-of-type {
        vertical-align: middle;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }

    .dataframe thead th {
        text-align: right;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>A</th>
      <th>B</th>
      <th>C</th>
      <th>D</th>
      <th>B</th>
      <th>D</th>
      <th>F</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>2</th>
      <td>A2</td>
      <td>B2</td>
      <td>C2</td>
      <td>D2</td>
      <td>B2</td>
      <td>D2</td>
      <td>F2</td>
    </tr>
    <tr>
      <th>3</th>
      <td>A3</td>
      <td>B3</td>
      <td>C3</td>
      <td>D3</td>
      <td>B3</td>
      <td>D3</td>
      <td>F3</td>
    </tr>
  </tbody>
</table>
</div>




```python
pd.concat([df1, df4], axis = 1)
```




<div>
<style scoped>
    .dataframe tbody tr th:only-of-type {
        vertical-align: middle;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }

    .dataframe thead th {
        text-align: right;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>A</th>
      <th>B</th>
      <th>C</th>
      <th>D</th>
      <th>B</th>
      <th>D</th>
      <th>F</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>0</th>
      <td>A0</td>
      <td>B0</td>
      <td>C0</td>
      <td>D0</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
    </tr>
    <tr>
      <th>1</th>
      <td>A1</td>
      <td>B1</td>
      <td>C1</td>
      <td>D1</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
    </tr>
    <tr>
      <th>2</th>
      <td>A2</td>
      <td>B2</td>
      <td>C2</td>
      <td>D2</td>
      <td>B2</td>
      <td>D2</td>
      <td>F2</td>
    </tr>
    <tr>
      <th>3</th>
      <td>A3</td>
      <td>B3</td>
      <td>C3</td>
      <td>D3</td>
      <td>B3</td>
      <td>D3</td>
      <td>F3</td>
    </tr>
    <tr>
      <th>6</th>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>B6</td>
      <td>D6</td>
      <td>F6</td>
    </tr>
    <tr>
      <th>7</th>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>B7</td>
      <td>D7</td>
      <td>F7</td>
    </tr>
  </tbody>
</table>
</div>




```python
# ignore_index = True : 데이터를 합치고 인덱스를 초기호하
pd.concat([df1, df4], axis = 1, ignore_index = True)
```




<div>
<style scoped>
    .dataframe tbody tr th:only-of-type {
        vertical-align: middle;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }

    .dataframe thead th {
        text-align: right;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>0</th>
      <th>1</th>
      <th>2</th>
      <th>3</th>
      <th>4</th>
      <th>5</th>
      <th>6</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>0</th>
      <td>A0</td>
      <td>B0</td>
      <td>C0</td>
      <td>D0</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
    </tr>
    <tr>
      <th>1</th>
      <td>A1</td>
      <td>B1</td>
      <td>C1</td>
      <td>D1</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
    </tr>
    <tr>
      <th>2</th>
      <td>A2</td>
      <td>B2</td>
      <td>C2</td>
      <td>D2</td>
      <td>B2</td>
      <td>D2</td>
      <td>F2</td>
    </tr>
    <tr>
      <th>3</th>
      <td>A3</td>
      <td>B3</td>
      <td>C3</td>
      <td>D3</td>
      <td>B3</td>
      <td>D3</td>
      <td>F3</td>
    </tr>
    <tr>
      <th>6</th>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>B6</td>
      <td>D6</td>
      <td>F6</td>
    </tr>
    <tr>
      <th>7</th>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>B7</td>
      <td>D7</td>
      <td>F7</td>
    </tr>
  </tbody>
</table>
</div>




```python
# reindex(새로운 인덱스 값)
pd.concat([df1, df4], axis = 1).reindex(df1.index)
```




<div>
<style scoped>
    .dataframe tbody tr th:only-of-type {
        vertical-align: middle;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }

    .dataframe thead th {
        text-align: right;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>A</th>
      <th>B</th>
      <th>C</th>
      <th>D</th>
      <th>B</th>
      <th>D</th>
      <th>F</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>0</th>
      <td>A0</td>
      <td>B0</td>
      <td>C0</td>
      <td>D0</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
    </tr>
    <tr>
      <th>1</th>
      <td>A1</td>
      <td>B1</td>
      <td>C1</td>
      <td>D1</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
    </tr>
    <tr>
      <th>2</th>
      <td>A2</td>
      <td>B2</td>
      <td>C2</td>
      <td>D2</td>
      <td>B2</td>
      <td>D2</td>
      <td>F2</td>
    </tr>
    <tr>
      <th>3</th>
      <td>A3</td>
      <td>B3</td>
      <td>C3</td>
      <td>D3</td>
      <td>B3</td>
      <td>D3</td>
      <td>F3</td>
    </tr>
  </tbody>
</table>
</div>




```python
df5 = pd.DataFrame({'key': ['K0','K2','K3','K4'],
'A':['A0','A1','A2','A3'],
'B':['B0','B1','B2','B3']})

df6 = pd.DataFrame({'key': ['K0','K1','K2','K3'],
'C':['C0','C1','C2','C3'],
'D':['D0','D1','D2','D3']})

df5
```




<div>
<style scoped>
    .dataframe tbody tr th:only-of-type {
        vertical-align: middle;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }

    .dataframe thead th {
        text-align: right;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>key</th>
      <th>A</th>
      <th>B</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>0</th>
      <td>K0</td>
      <td>A0</td>
      <td>B0</td>
    </tr>
    <tr>
      <th>1</th>
      <td>K2</td>
      <td>A1</td>
      <td>B1</td>
    </tr>
    <tr>
      <th>2</th>
      <td>K3</td>
      <td>A2</td>
      <td>B2</td>
    </tr>
    <tr>
      <th>3</th>
      <td>K4</td>
      <td>A3</td>
      <td>B3</td>
    </tr>
  </tbody>
</table>
</div>




```python
df6
```




<div>
<style scoped>
    .dataframe tbody tr th:only-of-type {
        vertical-align: middle;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }

    .dataframe thead th {
        text-align: right;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>key</th>
      <th>C</th>
      <th>D</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>0</th>
      <td>K0</td>
      <td>C0</td>
      <td>D0</td>
    </tr>
    <tr>
      <th>1</th>
      <td>K1</td>
      <td>C1</td>
      <td>D1</td>
    </tr>
    <tr>
      <th>2</th>
      <td>K2</td>
      <td>C2</td>
      <td>D2</td>
    </tr>
    <tr>
      <th>3</th>
      <td>K3</td>
      <td>C3</td>
      <td>D3</td>
    </tr>
  </tbody>
</table>
</div>




```python
# merge : values를 기준으로 데이터를 합침
# on : 기준이 되는 컬럼
# 1. how = outer : 전체 값 출력
# 2. how = inner : 기준이 같은 데이터만 남김(기존값)
# 3. how = left : 먼저 적은 데이터만 출력
# 4. how = right : 나중에 적은 데이터만 출력
pd.merge(df5, df6, on='key', how='outer')
```




<div>
<style scoped>
    .dataframe tbody tr th:only-of-type {
        vertical-align: middle;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }

    .dataframe thead th {
        text-align: right;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>key</th>
      <th>A</th>
      <th>B</th>
      <th>C</th>
      <th>D</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>0</th>
      <td>K0</td>
      <td>A0</td>
      <td>B0</td>
      <td>C0</td>
      <td>D0</td>
    </tr>
    <tr>
      <th>1</th>
      <td>K2</td>
      <td>A1</td>
      <td>B1</td>
      <td>C2</td>
      <td>D2</td>
    </tr>
    <tr>
      <th>2</th>
      <td>K3</td>
      <td>A2</td>
      <td>B2</td>
      <td>C3</td>
      <td>D3</td>
    </tr>
    <tr>
      <th>3</th>
      <td>K4</td>
      <td>A3</td>
      <td>B3</td>
      <td>NaN</td>
      <td>NaN</td>
    </tr>
    <tr>
      <th>4</th>
      <td>K1</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>C1</td>
      <td>D1</td>
    </tr>
  </tbody>
</table>
</div>



# 실습

![image.png](attachment:image.png)


```python
df2015 = pd.read_csv('./data/2015.csv', encoding = 'euc-kr', index_col = '관서명')
df2016 = pd.read_csv('./data/2016.csv', encoding = 'euc-kr', index_col = '관서명')
df2017 = pd.read_csv('./data/2017.csv', encoding = 'euc-kr', index_col = '관서명')
```


```python
df2016
```




<div>
<style scoped>
    .dataframe tbody tr th:only-of-type {
        vertical-align: middle;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }

    .dataframe thead th {
        text-align: right;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>구분</th>
      <th>살인</th>
      <th>강도</th>
      <th>강간·강제추행</th>
      <th>절도</th>
      <th>폭력</th>
      <th>총계</th>
    </tr>
    <tr>
      <th>관서명</th>
      <th></th>
      <th></th>
      <th></th>
      <th></th>
      <th></th>
      <th></th>
      <th></th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>광주지방경찰청계</th>
      <td>발생건수</td>
      <td>17</td>
      <td>47</td>
      <td>701</td>
      <td>6052</td>
      <td>8599</td>
      <td>15416</td>
    </tr>
    <tr>
      <th>광주지방경찰청계</th>
      <td>검거건수</td>
      <td>18</td>
      <td>47</td>
      <td>713</td>
      <td>4242</td>
      <td>7631</td>
      <td>12651</td>
    </tr>
    <tr>
      <th>광주지방경찰청계</th>
      <td>검거인원</td>
      <td>21</td>
      <td>54</td>
      <td>758</td>
      <td>3455</td>
      <td>10747</td>
      <td>15035</td>
    </tr>
    <tr>
      <th>광주지방경찰청계</th>
      <td>구속</td>
      <td>14</td>
      <td>25</td>
      <td>37</td>
      <td>132</td>
      <td>57</td>
      <td>265</td>
    </tr>
    <tr>
      <th>광주지방경찰청계</th>
      <td>불구속</td>
      <td>3</td>
      <td>25</td>
      <td>491</td>
      <td>2862</td>
      <td>5267</td>
      <td>8648</td>
    </tr>
    <tr>
      <th>광주지방경찰청계</th>
      <td>기타</td>
      <td>4</td>
      <td>4</td>
      <td>230</td>
      <td>461</td>
      <td>5423</td>
      <td>6122</td>
    </tr>
    <tr>
      <th>광주동부경찰서</th>
      <td>발생건수</td>
      <td>3</td>
      <td>8</td>
      <td>83</td>
      <td>832</td>
      <td>1142</td>
      <td>2068</td>
    </tr>
    <tr>
      <th>광주동부경찰서</th>
      <td>검거건수</td>
      <td>3</td>
      <td>7</td>
      <td>70</td>
      <td>679</td>
      <td>1002</td>
      <td>1761</td>
    </tr>
    <tr>
      <th>광주동부경찰서</th>
      <td>검거인원</td>
      <td>4</td>
      <td>10</td>
      <td>71</td>
      <td>543</td>
      <td>1497</td>
      <td>2125</td>
    </tr>
    <tr>
      <th>광주동부경찰서</th>
      <td>구속</td>
      <td>2</td>
      <td>2</td>
      <td>3</td>
      <td>17</td>
      <td>7</td>
      <td>31</td>
    </tr>
    <tr>
      <th>광주동부경찰서</th>
      <td>불구속</td>
      <td>0</td>
      <td>7</td>
      <td>50</td>
      <td>460</td>
      <td>773</td>
      <td>1290</td>
    </tr>
    <tr>
      <th>광주동부경찰서</th>
      <td>기타</td>
      <td>2</td>
      <td>1</td>
      <td>18</td>
      <td>66</td>
      <td>717</td>
      <td>804</td>
    </tr>
    <tr>
      <th>광주서부경찰서</th>
      <td>발생건수</td>
      <td>2</td>
      <td>11</td>
      <td>174</td>
      <td>1417</td>
      <td>2288</td>
      <td>3892</td>
    </tr>
    <tr>
      <th>광주서부경찰서</th>
      <td>검거건수</td>
      <td>3</td>
      <td>11</td>
      <td>158</td>
      <td>963</td>
      <td>1994</td>
      <td>3129</td>
    </tr>
    <tr>
      <th>광주서부경찰서</th>
      <td>검거인원</td>
      <td>3</td>
      <td>13</td>
      <td>169</td>
      <td>894</td>
      <td>2874</td>
      <td>3953</td>
    </tr>
    <tr>
      <th>광주서부경찰서</th>
      <td>구속</td>
      <td>3</td>
      <td>6</td>
      <td>7</td>
      <td>22</td>
      <td>18</td>
      <td>56</td>
    </tr>
    <tr>
      <th>광주서부경찰서</th>
      <td>불구속</td>
      <td>0</td>
      <td>4</td>
      <td>92</td>
      <td>749</td>
      <td>1301</td>
      <td>2146</td>
    </tr>
    <tr>
      <th>광주서부경찰서</th>
      <td>기타</td>
      <td>0</td>
      <td>3</td>
      <td>70</td>
      <td>123</td>
      <td>1555</td>
      <td>1751</td>
    </tr>
    <tr>
      <th>광주남부경찰서</th>
      <td>발생건수</td>
      <td>1</td>
      <td>4</td>
      <td>64</td>
      <td>768</td>
      <td>1028</td>
      <td>1865</td>
    </tr>
    <tr>
      <th>광주남부경찰서</th>
      <td>검거건수</td>
      <td>1</td>
      <td>4</td>
      <td>54</td>
      <td>544</td>
      <td>883</td>
      <td>1486</td>
    </tr>
    <tr>
      <th>광주남부경찰서</th>
      <td>검거인원</td>
      <td>1</td>
      <td>5</td>
      <td>55</td>
      <td>348</td>
      <td>1198</td>
      <td>1607</td>
    </tr>
    <tr>
      <th>광주남부경찰서</th>
      <td>구속</td>
      <td>1</td>
      <td>4</td>
      <td>2</td>
      <td>12</td>
      <td>2</td>
      <td>21</td>
    </tr>
    <tr>
      <th>광주남부경찰서</th>
      <td>불구속</td>
      <td>0</td>
      <td>1</td>
      <td>38</td>
      <td>264</td>
      <td>599</td>
      <td>902</td>
    </tr>
    <tr>
      <th>광주남부경찰서</th>
      <td>기타</td>
      <td>0</td>
      <td>0</td>
      <td>15</td>
      <td>72</td>
      <td>597</td>
      <td>684</td>
    </tr>
    <tr>
      <th>광주북부경찰서</th>
      <td>발생건수</td>
      <td>6</td>
      <td>7</td>
      <td>205</td>
      <td>1788</td>
      <td>2142</td>
      <td>4148</td>
    </tr>
    <tr>
      <th>광주북부경찰서</th>
      <td>검거건수</td>
      <td>5</td>
      <td>8</td>
      <td>158</td>
      <td>1156</td>
      <td>1906</td>
      <td>3233</td>
    </tr>
    <tr>
      <th>광주북부경찰서</th>
      <td>검거인원</td>
      <td>6</td>
      <td>10</td>
      <td>178</td>
      <td>933</td>
      <td>2700</td>
      <td>3827</td>
    </tr>
    <tr>
      <th>광주북부경찰서</th>
      <td>구속</td>
      <td>3</td>
      <td>6</td>
      <td>1</td>
      <td>50</td>
      <td>13</td>
      <td>73</td>
    </tr>
    <tr>
      <th>광주북부경찰서</th>
      <td>불구속</td>
      <td>2</td>
      <td>4</td>
      <td>135</td>
      <td>759</td>
      <td>1402</td>
      <td>2302</td>
    </tr>
    <tr>
      <th>광주북부경찰서</th>
      <td>기타</td>
      <td>1</td>
      <td>0</td>
      <td>42</td>
      <td>124</td>
      <td>1285</td>
      <td>1452</td>
    </tr>
    <tr>
      <th>광주광산경찰서</th>
      <td>발생건수</td>
      <td>5</td>
      <td>17</td>
      <td>175</td>
      <td>1247</td>
      <td>1999</td>
      <td>3443</td>
    </tr>
    <tr>
      <th>광주광산경찰서</th>
      <td>검거건수</td>
      <td>5</td>
      <td>17</td>
      <td>147</td>
      <td>898</td>
      <td>1798</td>
      <td>2865</td>
    </tr>
    <tr>
      <th>광주광산경찰서</th>
      <td>검거인원</td>
      <td>6</td>
      <td>16</td>
      <td>147</td>
      <td>723</td>
      <td>2382</td>
      <td>3274</td>
    </tr>
    <tr>
      <th>광주광산경찰서</th>
      <td>구속</td>
      <td>4</td>
      <td>7</td>
      <td>14</td>
      <td>31</td>
      <td>7</td>
      <td>63</td>
    </tr>
    <tr>
      <th>광주광산경찰서</th>
      <td>불구속</td>
      <td>1</td>
      <td>9</td>
      <td>85</td>
      <td>620</td>
      <td>1125</td>
      <td>1840</td>
    </tr>
    <tr>
      <th>광주광산경찰서</th>
      <td>기타</td>
      <td>1</td>
      <td>0</td>
      <td>48</td>
      <td>72</td>
      <td>1250</td>
      <td>1371</td>
    </tr>
  </tbody>
</table>
</div>




```python
# 2017년도에만 광주지방경찰청이 존재한다.
df2017.index.unique()
```




    Index(['광주지방경찰청계', '광주지방경찰청', '광주동부경찰서', '광주서부경찰서', '광주남부경찰서', '광주북부경찰서',
           '광주광산경찰서'],
          dtype='object', name='관서명')




```python
# 합쳐주기 위해서 2017년 데이터에서 광주지방경찰청 삭제
df2017.drop('광주지방경찰청', inplace = True)
```


```python
# 각 년도별 총계컬럼 만들기
df2015['총계'] = df2015.sum(axis = 1)
df2016['총계'] = df2016.sum(axis = 1)
df2017['총계'] = df2017.sum(axis = 1)
```

    C:\Users\smhrd\AppData\Local\Temp\ipykernel_19276\3676899464.py:2: FutureWarning: Dropping of nuisance columns in DataFrame reductions (with 'numeric_only=None') is deprecated; in a future version this will raise TypeError.  Select only valid columns before calling the reduction.
      df2015['총계'] = df2015.sum(axis = 1)
    C:\Users\smhrd\AppData\Local\Temp\ipykernel_19276\3676899464.py:3: FutureWarning: Dropping of nuisance columns in DataFrame reductions (with 'numeric_only=None') is deprecated; in a future version this will raise TypeError.  Select only valid columns before calling the reduction.
      df2016['총계'] = df2016.sum(axis = 1)
    C:\Users\smhrd\AppData\Local\Temp\ipykernel_19276\3676899464.py:4: FutureWarning: Dropping of nuisance columns in DataFrame reductions (with 'numeric_only=None') is deprecated; in a future version this will raise TypeError.  Select only valid columns before calling the reduction.
      df2017['총계'] = df2017.sum(axis = 1)
    


```python
# 발생건수 데이터 추출
# 1. df2015['구분'] == '발생건수'
# 2. df2015[df2015['구분'] == '발생건수']
s1 = df2015[df2015['구분'] == '발생건수'].loc[:,'총계']
s1.name = '2015총계'

s2 = df2016[df2016['구분'] == '발생건수'].loc[:,'총계']
s2.name = '2016총계'

s3 = df2017[df2017['구분'] == '발생건수'].loc[:,'총계']
s3.name = '2017총계'
```


```python
# 범죄 증감율 구하기
# (금년 - 작년)/작년 * 100
s4 = (s2 - s1)/s1 * 100
s4.name = '2015-2016 증감율'
s4

s5 = (s3 - s2)/s2 * 100
s5.name = '2016-2017 증감율'
s5
```




    관서명
    광주지방경찰청계    -9.516087
    광주동부경찰서    -13.007737
    광주서부경찰서     -6.526208
    광주남부경찰서    -17.050938
    광주북부경찰서     -4.893925
    광주광산경찰서    -12.285797
    Name: 2016-2017 증감율, dtype: float64




```python
total = pd.concat([s1, s4, s2, s5, s3], axis = 1)
total
```




<div>
<style scoped>
    .dataframe tbody tr th:only-of-type {
        vertical-align: middle;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }

    .dataframe thead th {
        text-align: right;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>2015총계</th>
      <th>2015-2016 증감율</th>
      <th>2016총계</th>
      <th>2016-2017 증감율</th>
      <th>2017총계</th>
    </tr>
    <tr>
      <th>관서명</th>
      <th></th>
      <th></th>
      <th></th>
      <th></th>
      <th></th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>광주지방경찰청계</th>
      <td>18830</td>
      <td>-18.130643</td>
      <td>15416</td>
      <td>-9.516087</td>
      <td>13949</td>
    </tr>
    <tr>
      <th>광주동부경찰서</th>
      <td>2355</td>
      <td>-12.186837</td>
      <td>2068</td>
      <td>-13.007737</td>
      <td>1799</td>
    </tr>
    <tr>
      <th>광주서부경찰서</th>
      <td>4720</td>
      <td>-17.542373</td>
      <td>3892</td>
      <td>-6.526208</td>
      <td>3638</td>
    </tr>
    <tr>
      <th>광주남부경찰서</th>
      <td>2117</td>
      <td>-11.903637</td>
      <td>1865</td>
      <td>-17.050938</td>
      <td>1547</td>
    </tr>
    <tr>
      <th>광주북부경찰서</th>
      <td>5466</td>
      <td>-24.112697</td>
      <td>4148</td>
      <td>-4.893925</td>
      <td>3945</td>
    </tr>
    <tr>
      <th>광주광산경찰서</th>
      <td>4172</td>
      <td>-17.473634</td>
      <td>3443</td>
      <td>-12.285797</td>
      <td>3020</td>
    </tr>
  </tbody>
</table>
</div>




```python

```
