import pyautogui

fw = pyautogui.getActiveWindow()
print(fw)
print(fw.title)
print(fw.left,fw.top,fw.right,fw.bottom)

# pyautogui.click(fw.left+25,fw.top+20)
# pyautogui.click(fw.left+25,fw.top+20)


for i in pyautogui.getAllWindows():
    print(i)

try:
    fw = pyautogui.getWindowsWithTitle('제목 없음')[0]
    if fw.isActive == False :
        fw.activate()

    if fw.isMaximized == False:
        fw.maximize()

    pyautogui.sleep(1)

    fw.restore()
    fw.close()
except Exception as e:
    print(e)
