import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
from sklearn.model_selection import train_test_split
from sklearn.preprocessing import StandardScaler
from sklearn.neighbors import KNeighborsClassifier

fish = pd.read_csv('https://bit.ly/fish_csv_data')
print(fish[50:55])

print(pd.unique(fish['Species']))

fish_input =\
    fish[['Weight','Length',
          'Diagonal','Height','Width']].to_numpy()

fish_target = fish['Species'].to_numpy()

print(fish_input.shape)
print(fish_target.shape)

train_input,test_input,train_target,test_target =\
    train_test_split(fish_input,fish_target,random_state=42)
    
ss = StandardScaler()    
ss.fit(train_input,train_target)

train_scaled = ss.transform(train_input)
test_scaled = ss.transform(test_input)

knclf = KNeighborsClassifier(n_neighbors=3)
knclf.fit(train_scaled,train_target)

value = knclf.score(train_scaled,train_target)
print('학습 데이터 점수',value)
value = knclf.score(test_scaled,test_target)
print('테스트 데이터 점수',value)

# bream Roach
mydata = [[250.0,26,30.0,12,4.3],
          [200,23,26,7,4]]
mydata = ss.transform(mydata)
value = knclf.predict(mydata)
print('예측한 값',value)

proba = knclf.predict_proba(mydata)
print(np.round(proba,decimals=4))

x = np.arange(-5,5,0.1)
y = 1/ (1+np.exp(-x))

plt.plot(x,y)
plt.xlabel('x')
plt.ylabel('y')
plt.show()