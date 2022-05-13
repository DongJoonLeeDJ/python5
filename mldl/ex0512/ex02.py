import pandas as pd
import numpy as np
from sklearn.linear_model import SGDClassifier
from sklearn.preprocessing import StandardScaler
from sklearn.model_selection import train_test_split

fish = pd.read_csv('https://bit.ly/fish_csv_data')

fish_input =\
    fish[['Weight','Length','Diagonal','Height','Width']].to_numpy()

fish_target = fish['Species'].to_numpy()

print(fish_input[:5])
print(fish_target[:5])

train_input,test_input,train_target,test_target =\
    train_test_split(fish_input,fish_target,random_state=42)

ss = StandardScaler()    
ss.fit(train_input,train_target)
    
train_scaled = ss.transform(train_input)
test_scaled = ss.transform(test_input)

sgdclf = SGDClassifier(loss='log',max_iter=1000,random_state=42)
sgdclf.fit(train_scaled,train_target)

# print(sgdclf.score(train_scaled,train_target))
# print(sgdclf.score(test_scaled,test_target))

sgdclf.partial_fit(train_scaled,train_target)
# print(sgdclf.score(train_scaled,train_target))
# print(sgdclf.score(test_scaled,test_target))

