from sklearn.neighbors import KNeighborsRegressor
from sklearn.model_selection import train_test_split
import numpy as np
import matplotlib.pyplot as plt

perch_length = np.array(
    [8.4, 13.7, 15.0, 16.2, 17.4, 18.0, 18.7, 19.0, 19.6, 20.0, 
     21.0, 21.0, 21.0, 21.3, 22.0, 22.0, 22.0, 22.0, 22.0, 22.5, 
     22.5, 22.7, 23.0, 23.5, 24.0, 24.0, 24.6, 25.0, 25.6, 26.5, 
     27.3, 27.5, 27.5, 27.5, 28.0, 28.7, 30.0, 32.8, 34.5, 35.0, 
     36.5, 36.0, 37.0, 37.0, 39.0, 39.0, 39.0, 40.0, 40.0, 40.0, 
     40.0, 42.0, 43.0, 43.0, 43.5, 44.0]
     )
perch_weight = np.array(
    [5.9, 32.0, 40.0, 51.5, 70.0, 100.0, 78.0, 80.0, 85.0, 85.0, 
     110.0, 115.0, 125.0, 130.0, 120.0, 120.0, 130.0, 135.0, 110.0, 
     130.0, 150.0, 145.0, 150.0, 170.0, 225.0, 145.0, 188.0, 180.0, 
     197.0, 218.0, 300.0, 260.0, 265.0, 250.0, 250.0, 300.0, 320.0, 
     514.0, 556.0, 840.0, 685.0, 700.0, 700.0, 690.0, 900.0, 650.0, 
     820.0, 850.0, 900.0, 1015.0, 820.0, 1100.0, 1000.0, 1100.0, 
     1000.0, 1000.0]
     )

train_input, test_input, train_target, test_target =\
    train_test_split(perch_length,perch_weight,random_state=42)

print(train_input[:5])
print(test_input[:5])

train_input = train_input.reshape(-1,1)    
test_input = train_input.reshape(-1,1)    

print(train_input[:5])
print(test_input[:5])
    
knr = KNeighborsRegressor(n_neighbors=3)
knr.fit(train_input,train_target)

value = knr.predict([[50]])
print(value)
# plt.scatter(50,value,marker='D')

value = knr.predict([[100]])
print(value)
# plt.scatter(100,value,marker='^')

dis,index = knr.kneighbors([[50]])
# plt.scatter(train_input,train_target)
# plt.scatter(train_input[index],train_target[index],c="#ff0000")

# plt.show()


from sklearn.linear_model import LinearRegression

lr = LinearRegression()
lr.fit(train_input,train_target)

value = lr.predict([[50]])
print(value)

value = lr.predict([[1]])
print(value)

value = lr.predict([[100]])
print(value)

print('가중치',lr.coef_)
print('절편',lr.intercept_)

plt.scatter(train_input,train_target)
plt.plot( [1,100],[ 1*lr.coef_+lr.intercept_, 100*lr.coef_+lr.intercept_])

# plt.show()
# 3*x + 4
# 7*3 + 4 = 25
'''
mytrain = np.array([1,2,3,4,5])
mytrain = mytrain.reshape(-1,1)
mytrain = np.column_stack( (mytrain**2,mytrain) )
print('mytrain\n',mytrain)

mytarget = np.array([7,10,13,16,19])

mylr = LinearRegression()
mylr.fit(mytrain,mytarget)

value = mylr.predict([[7,49]])
print(value)

print(mylr.coef_)
print(mylr.intercept_)
'''


