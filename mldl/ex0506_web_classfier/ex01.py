import pandas as pd
import numpy as np
from sklearn.model_selection import train_test_split
from sklearn.preprocessing import PolynomialFeatures
from sklearn.preprocessing import StandardScaler

from sklearn.linear_model import LinearRegression
from sklearn.linear_model import Ridge
from sklearn.linear_model import Lasso

df = pd.read_csv('https://bit.ly/perch_csv_data')
perch_full = df.to_numpy()
# print(perch_full)

perch_weight = np.array(
    [5.9, 32.0, 40.0, 51.5, 70.0, 100.0, 78.0, 80.0, 85.0, 85.0, 
     110.0, 115.0, 125.0, 130.0, 120.0, 120.0, 130.0, 135.0, 110.0, 
     130.0, 150.0, 145.0, 150.0, 170.0, 225.0, 145.0, 188.0, 180.0, 
     197.0, 218.0, 300.0, 260.0, 265.0, 250.0, 250.0, 300.0, 320.0, 
     514.0, 556.0, 840.0, 685.0, 700.0, 700.0, 690.0, 900.0, 650.0, 
     820.0, 850.0, 900.0, 1015.0, 820.0, 1100.0, 1000.0, 1100.0, 
     1000.0, 1000.0]
     )

train_input,test_input,train_target,test_target = train_test_split(
    perch_full,perch_weight,random_state=42
)
poly = PolynomialFeatures(degree=5,include_bias=False)
poly.fit(train_input,train_target)

train_poly = poly.transform(train_input)
test_poly = poly.transform(test_input)

print(train_poly.shape)
print(test_poly.shape)

lr = LinearRegression()
lr.fit(train_poly,train_target)

train_score = lr.score(train_poly,train_target)
test_score = lr.score(test_poly,test_target)
print(train_score)
print(test_score)

ss = StandardScaler()
ss.fit(train_poly,train_target)

train_scaled = ss.transform(train_poly)
test_scaled = ss.transform(test_poly)

lr = Ridge()
lr.fit(train_scaled,train_target)

train_score = lr.score(train_scaled,train_target)
test_score = lr.score(test_scaled,test_target)
print(train_score)
print(test_score)

lr = Lasso()
lr.fit(train_scaled,train_target)

train_score = lr.score(train_scaled,train_target)
test_score = lr.score(test_scaled,test_target)
print(train_score)
print(test_score)