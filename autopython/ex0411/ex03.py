def doA(a):
    print("a: ",a)
    print("a[0]",a[0])
    print("a[1]",a[1])
    print("=======================")
# tuple, list(list), dict(map)
doA( (10,20) )

def doAA(a,b):
    print("a: ",a)
    print("a[0]",a[0])
    print("a[1]",a[1])
    print("b: ",b)
    print("=======================")

doAA(b=440,a=(20,30))
doAA((20,30), 330)