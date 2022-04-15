import pyautogui

class MYC:
    def __init__(self):
        pass

    def moveTo(self,x,y,dura):
        try:
            pyautogui.moveTo(int(x),int(y),duration=int(dura))
        except Exception as e:
            print(e)

    def move(self,x,y,dura):
        try:
            pyautogui.move(int(x),int(y),duration=int(dura))
        except Exception as e:
            print(e)
    
    def click(self,x,y,dura):
        try:
            pyautogui.click(int(x),int(y),duration=int(dura))
        except Exception as e:
            print(e)