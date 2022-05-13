import decimal
import imp
import pandas as pd
import numpy as np
from sklearn.model_selection import train_test_split
from sklearn.preprocessing import StandardScaler
from sklearn.linear_model import LogisticRegression
from scipy.special import expit


fish = pd.read_csv('https://bit.ly/fish_csv_data')

print(fish.head())

fish_input = fish[['Weight','Length','Diagonal','Height','Width']].to_numpy()
fish_target = fish['Species'].to_numpy()

# print(fish_input[:5])
# print(fish_target[:5])

train_input,test_input,train_target,test_target =\
    train_test_split(fish_input,fish_target,random_state=42)

ss = StandardScaler()    
ss.fit(train_input,train_target)
    
train_scaled = ss.transform(train_input)
test_scaled = ss.transform(test_input)
    
bream_smelt_indexes = (train_target=='Bream') | (train_target=='Smelt')
train_bream_smelt = train_scaled[bream_smelt_indexes]
target_bream_smelt = train_target[bream_smelt_indexes]

lr = LogisticRegression()
lr.fit(train_bream_smelt,target_bream_smelt)

pro = lr.predict_proba(train_scaled[:5])
print(pro)

z = lr.decision_function(train_scaled[:5])
print(z)

prob = expit(z)
print(prob)

lr = LogisticRegression(C=20,max_iter=1000)
lr.fit(train_scaled,train_target)

score = lr.score(train_scaled,train_target)
print(score)
score = lr.score(test_scaled,test_target)
print(score)

value = lr.predict(test_scaled[:5])
print(value)

proba = lr.predict_proba(test_scaled[:5])
print(np.round(proba,decimals=3))
print(lr.classes_)

print(lr.coef_.shape,lr.intercept_.shape)

zz = lr.decision_function(test_scaled[:5])
print(np.round(zz,decimals=3))

from scipy.special import softmax

proba = softmax(zz,axis=1)
print(np.round(proba,decimals=3))

print(np.argmax(proba,axis=1))