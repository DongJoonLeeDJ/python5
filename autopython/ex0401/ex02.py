# 4칙연산프로그램 
# 두 수의 값을 입력 받아 +,-,*,/ 해봅시다..
'''
    프로그램 돌아가는 속도
    c < java < python
    생산성은 
    python < java < c
'''
from myfunction import doprint, doadd, dosub, domul, dodiv

a = input('a 값입력 : ')
print("a = ",a)
b = input("b 값입력 : ")
print("b = ",b)

doprint(a,b)

doadd(a,b)
dosub(a,b)
domul(a,b)
dodiv(a,b)