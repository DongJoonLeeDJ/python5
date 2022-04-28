# 분류
from sklearn.neighbors import KNeighborsClassifier
import matplotlib.pyplot as plt
import numpy as np
# 회귀
from sklearn.neighbors import KNeighborsRegressor

x = [[10,20],[20,30],[30,40],[40,50],[50,60]]
x = np.array(x)
y = [20,30,40,50,60]

knre = KNeighborsRegressor(n_neighbors=2)
knre.fit(x,y)

value = knre.predict([[15,20],[45,50]])
print(value)

plt.scatter(x[:,0],y)
plt.scatter((15,45),(value[0],value[1]))
plt.show()




'''
x = [[100,100],[200,200],[150,150],[50,50],[30,30],[20,20]]
y = [ 1, 1, 1, 0, 0, 0]

x = np.array(x)
y = np.array(y)

knclf = KNeighborsClassifier(n_neighbors=2)
knclf.fit(x,y)

value = knclf.predict([[120,120]])
print(value)

value = knclf.predict([[40,40]])
print(value)

plt.scatter(x[:,0],x[:,1])
plt.scatter(120,120,marker='^')
plt.scatter(40,40,marker='D')
plt.show()

'''