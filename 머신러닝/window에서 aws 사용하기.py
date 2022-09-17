#!/usr/bin/env python
# coding: utf-8

# In[2]:


get_ipython().system('pip3 install boto3')


# In[4]:


#Copyright 2018 Amazon.com, Inc. or its affiliates. All Rights Reserved.
#PDX-License-Identifier: MIT-0 (For details, see https://github.com/awsdocs/amazon-rekognition-developer-guide/blob/master/LICENSE-SAMPLECODE.)
import boto3
def detect_labels_local_file(photo):
    client=boto3.client('rekognition')
    with open(photo, 'rb') as image:
        response = client.detect_labels(Image={'Bytes': image.read()})
        print(response)
    print('Detected labels in ' + photo)
    for label in response['Labels']:
        print (label['Name'] + ' : ' + str(label['Confidence']))
    return len(response['Labels'])
def main():
    photo='common.jfif'
    label_count=detect_labels_local_file(photo)
    print("Labels detected: " + str(label_count))
if __name__ == "__main__":
    main()


# In[22]:


#Copyright 2018 Amazon.com, Inc. or its affiliates. All Rights Reserved.
#PDX-License-Identifier: MIT-0 (For details, see https://github.com/awsdocs/amazon-rekognition-developer-guide/blob/master/LICENSE-SAMPLECODE.)
import boto3

def detect_labels_local_file(photo):
    
    client=boto3.client('rekognition')
    
    with open(photo, 'rb') as image:
        
        response = client.detect_labels(Image={'Bytes': image.read()})
        
    print('Detected labels in ' + photo)
    
    for label in response['Labels']:
        #print (label['Name'] + ' : ' + str(label['Confidence']))
        if label['Name'] == "Canine":
            print("Canine일 확률은 {:.2f}% 입니다.".format(label['Confidence']))
    return len(response['Labels'])

def main():
    
    photo='common.jfif'
    
    label_count=detect_labels_local_file(photo)
    
    print("Labels detected: " + str(label_count))
    
if __name__ == "__main__":
    
    main()


# In[24]:


#Copyright 2018 Amazon.com, Inc. or its affiliates. All Rights Reserved.
#PDX-License-Identifier: MIT-0 (For details, see https://github.com/awsdocs/amazon-rekognition-developer-guide/blob/master/LICENSE-SAMPLECODE.)
import boto3

def detect_labels_local_file(photo):
    
    client=boto3.client('rekognition')
    
    with open(photo, 'rb') as image:
        
        response = client.detect_labels(Image={'Bytes': image.read()})
        
    print('Detected labels in ' + photo)
    
    check = True
    for label in response['Labels']:
        #print (label['Name'] + ' : ' + str(label['Confidence']))
        if label['Name'] == "Canine":
            print("Canine일 확률은 {:.2f}% 입니다.".format(label['Confidence']))
            check = False
        
    if check == True:
        print('Kitten이 아닙니다')
            
    return len(response['Labels'])

def main():
    
    photo='cat.jfif'
    
    label_count=detect_labels_local_file(photo)
    
    print("Labels detected: " + str(label_count))
    
if __name__ == "__main__":
    
    main()


# In[ ]:




