import pyautogui
def doA():
    return 10,20
#절대좌표
pyautogui.moveTo(100,200,1)
pyautogui.moveTo(200,100,duration=2)

#상대좌표
pyautogui.move(100,100,duration=1)
p = pyautogui.position()
print(p)
print(p[0],p[1])

a = doA()
c,d = doA()
print("a",a)
print("c",c)
print("d",d)