#!/usr/bin/env python
# coding: utf-8

# In[2]:


get_ipython().system('pip3 install flask')


# In[ ]:


from flask import Flask, render_template, request, redirect
from werkzeug.utils import secure_filename

app = Flask(__name__)

@app.route('/')
def hello():
    return render_template('home.html')

@app.route('/add', methods=['GET', 'POST']) #메서드는 get, post 방식이 있다
def add_number():
    if request.method=="GET":
        num1 = request.args['num1'] #num1, num2 데이터 타입 문자열
        num2 = request.args['num2']
        result = int(num1) + int(num2)
    else:
        num1 = request.form['num1'] #num1, num2 데이터 타입 문자열
        num2 = request.form['num2']
        result = int(num1) + int(num2)
        
    return "두 수의 합은 {}입니다.".format(result)

@app.route('/move', methods=['GET', 'POST'] )
def move():
    if request.method == "GET":
        url ="https://" + request.args['url']
        return redirect(url)
    
    return "주소없음"

# /detect 경로설정 return값으로는 얼굴분석페이지
@app.route('/detect', methods=['GET', 'POST'])
def detect():
    if request.method == 'POST':
        f = request.files['file']
        f.save(secure_filename(f.filename)) #filename은 내가 분석하고 싶은 사진 1.저장, 2.분석
        photo = f.filename
        face_count = detect_faces(photo)
        print('얼굴감지됨:{}'.format(face_count))
    
    return '얼굴분석페이지'

if __name__ == "__main__":
    app.run(host='61.80.80.187', port='5020')


# In[31]:


#Copyright 2018 Amazon.com, Inc. or its affiliates. All Rights Reserved.
#PDX-License-Identifier: MIT-0 (For details, see https://github.com/awsdocs/amazon-rekognition-developer-guide/blob/master/LICENSE-SAMPLECODE.)
import boto3
import json
def detect_faces(photo):
    client=boto3.client('rekognition')
    with open(photo, 'rb') as image:
        response = client.detect_faces(Image={'Bytes': image.read()},Attributes=['ALL'])
    #response = client.detect_faces(Image={'S3Object':{'Bucket':bucket,'Name':photo}},Attributes=['ALL'])
    #print(response)
    print('Detected faces for ' + photo)
    for faceDetail in response['FaceDetails']:
        age = faceDetail['AgeRange']['Low'] + faceDetail['AgeRange']['High']
        print("나이는 %d세입니다."%(age/2))
        print(str(faceDetail['Gender']['Value']))
        if faceDetail['Gender']['Value'] == "Female":
            print('성별은 여자입니다.')
        elif faceDetail['Gender']['Value'] == "Male":
            print('성별은 남자입니다.')
        print('대표감정은 {}입니다.'.format(faceDetail['Emotions'][0]['Type']))
#          print('The detected face is between ' + str(faceDetail['AgeRange']['Low'])
#                + ' and ' + str(faceDetail['AgeRange']['High']) + ' years old')
#         print('Here are the other attributes:')
#         print(json.dumps(faceDetail, indent=4, sort_keys=True))
		# Access predictions for individual face details and print them
#         print("Gender: " + str(faceDetail['Gender']))
#         print("Smile: " + str(faceDetail['Smile']))
#         print("Eyeglasses: " + str(faceDetail['Eyeglasses']))
#         print("Emotions: " + str(faceDetail['Emotions'][0]))
    return len(response['FaceDetails'])
def main():
    photo='img.jfif'
    face_count=detect_faces(photo)
    print("Faces detected: " + str(face_count))
if __name__ == "__main__":
    main()


# In[ ]:




