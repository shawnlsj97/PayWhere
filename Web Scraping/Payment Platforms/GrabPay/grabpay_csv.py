# The following program is used to scrape names and addresses of food and beverage outlets that accept the GrabPay mobile payment method from https://www.grab.com/sg/pay/where-to-use/
# Language used: Python
# Package used: Selenium

from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.common.exceptions import TimeoutException
from selenium.common.exceptions import NoSuchElementException
import time
import csv

# initialise csv file
with open('grabpay_merchants.csv', 'w') as f:
    f.write("Store Name;Address\n")

# create new instance of chrome web browser by specifying path where chromedriver.exe is installed
path = 'C:\\Users\Shawn Lee\AppData\Local\Programs\Python\Python37\chromedriver.exe'
browser = webdriver.Chrome(path)

# visit website of interest
website = "https://www.grab.com/sg/pay/where-to-use/"
browser.get(website)

# wait up to 10 seconds for all elements on page to load (observe which element loads last and use it to determine if entire page is loaded)
timeout = 10;
try:
    WebDriverWait(browser, timeout).until(EC.visibility_of_element_located((By.XPATH, '//*[@id="map"]')))
except TimeoutException:
    print("Timed out waiting for page to load")
    browser.quit()

# website opened successfully, begin scraping of data
# find details of elements by right clicking then inspecting them

# there are currently 243 pages of merchants so we need a for loop to retrieve a list of all food and drink merchants on each page
for i in range(243):
    time.sleep(2)
    all_food_merchants = browser.find_elements_by_class_name('cardwrapper')
    
    # iterate through each merchant to extract store name and address
    for merchant in all_food_merchants:
        merchant_name = merchant.find_element_by_class_name('card-title').get_attribute('innerText')
        merchant_address = merchant.find_element_by_class_name('card-text').get_attribute('innerText')
        print(merchant_name + ", " + merchant_address)
        with open('grabpay_merchants.csv', 'a') as f:
            f.write(merchant_name + ", " + merchant_address + '\n')
    
    # navigate to next page once done with all merchants on current page
    time.sleep(2)
    if(i == 0):
        next_page_click = browser.find_element_by_xpath('//*[@id="pagination"]/a[2]').click()
    elif(i < 242):
        next_page_click = browser.find_element_by_xpath('//*[@id="pagination"]/a[4]').click()

# clean up (close browser once task completed)
browser.quit()