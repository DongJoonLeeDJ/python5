from selenium import webdriver
from selenium.webdriver.common.by import By
import time

web = webdriver.Chrome()

web.get('https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_input_type_radio')

# iframe 안으로 들어가기...
web.switch_to.frame('iframeResult')

web.find_element(by=By.ID,value='html').click()

time.sleep(5)

web.close()
web.quit()