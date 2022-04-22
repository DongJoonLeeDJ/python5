import pyautogui
import pyperclip

def openmspaint():
    pyautogui.hotkey('win','r')
    pyautogui.write('mspaint')
    pyautogui.hotkey('enter')

def clickfont():
    # pyautogui.sleep(2)  # 딜레이시간 안주면 못찾음
    img = None
    while img is None:
        img = pyautogui.locateOnScreen('font.png',confidence=0.9)
    print(img)
    pyautogui.click(img)
    pyautogui.move(0,300)
    pyautogui.click()
    pyautogui.sleep(3)
    copyandpaste('참잘햇어요')
    pyautogui.sleep(3)
    fw = pyautogui.getWindowsWithTitle('제목 없음')[0]
    fw.close()
    pyautogui.write('n')

def opennote():
    pyautogui.hotkey('win','r')
    pyautogui.write('notepad')
    pyautogui.hotkey('enter')
    pyautogui.sleep(1)
    # 메모장에 글작성
    pyautogui.write('12345')
    pyautogui.hotkey('enter')
    pyautogui.write('aaaaa')
    pyautogui.hotkey('enter')

def copyandpaste(str):
    pyperclip.copy(str)
    pyautogui.hotkey('ctrl','v')

def exit():
    fw = pyautogui.getActiveWindow()
    fw.close()
    pyautogui.write('n')

def printnotepad():
    print('notepad',__name__)