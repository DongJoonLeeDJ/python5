fish_length = [25.4, 26.3, 26.5, 29.0, 29.0, 29.7, 29.7, 30.0, 30.0, 30.7, 31.0, 31.0, 
                31.5, 32.0, 32.0, 32.0, 33.0, 33.0, 33.5, 33.5, 34.0, 34.0, 34.5, 35.0, 
                35.0, 35.0, 35.0, 36.0, 36.0, 37.0, 38.5, 38.5, 39.5, 41.0, 41.0, 9.8, 
                10.5, 10.6, 11.0, 11.2, 11.3, 11.8, 11.8, 12.0, 12.2, 12.4, 13.0, 14.3, 15.0]
fish_weight = [242.0, 290.0, 340.0, 363.0, 430.0, 450.0, 500.0, 390.0, 450.0, 500.0, 475.0, 500.0, 
                500.0, 340.0, 600.0, 600.0, 700.0, 700.0, 610.0, 650.0, 575.0, 685.0, 620.0, 680.0, 
                700.0, 725.0, 720.0, 714.0, 850.0, 1000.0, 920.0, 955.0, 925.0, 975.0, 950.0, 6.7, 
                7.5, 7.0, 9.7, 9.8, 8.7, 10.0, 9.9, 9.8, 12.2, 13.4, 12.2, 19.7, 19.9]

fish_data = [[l,w] for l,w in zip(fish_length,fish_weight)]
fish_target = [1]*35 + [0]*14

# print(fish_data)
# print(fish_target)

from sklearn.neighbors import KNeighborsClassifier

kn = KNeighborsClassifier()

train_input = fish_data[:35]
train_target = fish_target[:35]

test_input = fish_data[35:]
test_target = fish_target[35:]

kn.fit(train_input,train_target)

print(kn.score(test_input,test_target))

# print(test_input)
# print(test_target)

import numpy as np

input_arr = np.array(fish_data)
target_arr = np.array(fish_target)

# print(input_arr.shape)
# print(fish_data.shape)

np.random.seed(42)
# myrandomint = np.random.rand(30)
# print(myrandomint)

# np_arr = np.arange(10,50)
# print(np_arr.shape)

index = np.arange(49)
np.random.shuffle(index)

print(index)

train_input = input_arr[index[:35]]
train_target = target_arr[index[:35]]

test_input = input_arr[index[35:]]
test_target = target_arr[index[35:]]

print(train_input[:5])
print(test_input[:5])

import matplotlib.pyplot as plt

plt.scatter(train_input[:,0],train_input[:,1],c="#ff0000")
plt.scatter(test_input[:,0],test_input[:,1],c="#00ff00")
plt.savefig('b.png')

kn = KNeighborsClassifier()
kn.fit(train_input,train_target)

print( kn.score(test_input,test_target) )
print( kn.predict(test_input) )
print( test_target )


import cv2

rec = cv2.imread('rec.png')
circle = cv2.imread('circle.png')
triangle = cv2.imread('triangle.png')

myrec = cv2.imread('myrec.png')
myrec2 = cv2.imread('myrec2.png')

rec = rec.reshape(-1)
circle = circle.reshape(-1)
triangle = triangle.reshape(-1)

myrec = myrec.reshape(-1)
myrec2 = myrec2.reshape(-1)

print(rec.shape)
print(circle.shape)
print(triangle.shape)

train_input = np.array([[rec],[circle],[triangle]])
train_input = train_input.reshape(3,236442)
print(train_input.shape)
kn = KNeighborsClassifier(n_neighbors=1)
kn.fit(train_input,['rec','circle','tri'])

rec = kn.predict([rec])
print('rec',rec)

circle = kn.predict([circle])
print('circle',circle)

triangle = kn.predict([triangle])
print('triangle',triangle)

myrec = kn.predict([myrec])
print('myrec',myrec)

myrec2 = kn.predict([myrec2])
print('myrec2',myrec2)



# index = np.arange(5)
# np.random.shuffle(index)

# print(index)

# a = np.array([1,2,3,4,5])   # [1,2,3,4,5]
# print(a[index])


'''
a = [[10,10],[20,20],[30,30],[40,40],[50,50],[60,60]]

변수 = a[3]
변수2 = a[0:3]
변수3 = a[:3]
print(변수)
print(변수2)
print(변수3)    # 0 ~ 2까지...
print(a[3:])    # 끝까지...
'''