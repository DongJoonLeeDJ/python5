from selenium import webdriver
from selenium.webdriver.common.by import By
import time

web = webdriver.Chrome()
web.get('http://www.naver.com')

# ele = web.find_element(by=webdriver.common.by.By.LINK_TEXT,value='카페')
ele = web.find_element(by=By.LINK_TEXT,value='카페')
# print('ele',ele.tag_name)
# qweqwe
ele.click()
time.sleep(2)
ele = None

# while ele is None or ele.tag_name != 'a':
#     try:
#         ele = web.find_element(by=By.CSS_SELECTOR, value='a.lnb_link')
#         time.sleep(1)
#         print('=======================')
#     except Exception as e:
#         print(e)

# ele.click()

web.back()
time.sleep(1)
web.forward()
time.sleep(1)
web.refresh()
time.sleep(1)
web.back()

ele = web.find_element(by=By.ID, value='query')
ele.send_keys('python 검색')
ele = web.find_element(by=By.ID, value='search_btn').click()

web.save_screenshot('scr.png')

# ele = web.find_element(by=By.XPATH,value='/html/body/div/div/div[2]/div[2]/div/ul/li[3]/a')
# ele.click()


# 3초뒤에...
time.sleep(3)

# 창닫고..
web.close()
# 크롬 종료..
web.quit()