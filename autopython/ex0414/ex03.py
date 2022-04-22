import pyautogui

file_menu = pyautogui.locateOnScreen('./ex0414/bogi.png',confidence=0.9)
print(file_menu)

pyautogui.click(file_menu,duration=2)