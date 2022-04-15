import pyautogui
from notepad import opennote,copyandpaste,exit,printnotepad,openmspaint,clickfont

# notefw = pyautogui.getWindowsWithTitle('제목 없음')[0]
# notefw.activate()

# 메모장 열기
def start():
    opennote()
    result = pyautogui.prompt("파일명을 무엇으로 하시겠습니까?", "입력")
    copyandpaste(result)
    pyautogui.sleep(3)
    exit()
    print('ex02py',__name__)
    printnotepad()
    pyautogui.countdown(3)
    pyautogui.alert("종료됩니다.", "경고")

def psstart():
    openmspaint()
    clickfont()
    

if __name__ =='__main__':
    # start()
    psstart()