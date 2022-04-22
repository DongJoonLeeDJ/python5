from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
import time

web = webdriver.Chrome()

web.get('http://www.danawa.com')

time.sleep(2)

ele = web.find_element(by=By.ID,value='AKCSearch')
ele.send_keys('3060ti')
ele.send_keys(Keys.ENTER)

ele = web.find_element(by=By.XPATH,value='/html/body/div[2]/div[3]/div[3]/div[2]/div[8]/div[2]/div[2]/div[3]/ul/li[1]/div/div[2]/p/a')
ele.click()

time.sleep(2)

web.switch_to.window(web.window_handles[-1])
ele = web.find_element(by=By.XPATH, value='/html/body/div[2]/div[3]/div[2]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div/a[1]')
ele.click()

time.sleep(3)

web.close()
time.sleep(3)
web.quit()