import pyautogui
import time
import sys

office_file_image = None
while office_file_image is None:
    office_file_image = pyautogui.locateOnScreen('./ex0414/office.png',confidence=0.9)
    print(office_file_image)

pyautogui.click(office_file_image)