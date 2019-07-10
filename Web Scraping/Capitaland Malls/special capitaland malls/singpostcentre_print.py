# The following program is used to scrape names and addresses of food and beverage outlets in Singpost Centre from http://www.singpostcentre.com/stores/
# Language used: Python
# Package used: Selenium

from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.common.exceptions import TimeoutException
from selenium.common.exceptions import NoSuchElementException
import csv
import time 

# create new instance of chrome web browser by specifying path where chromedriver.exe is installed
path = 'C:\\Users\Shawn Lee\AppData\Local\Programs\Python\Python37\chromedriver.exe'
browser = webdriver.Chrome(path)

# visit website of interest
website = "http://www.singpostcentre.com/stores/"
browser.get(website)

# wait up to 10 seconds for all elements on page to load (observe which element loads last and use it to determine if entire page is loaded)
timeout = 10;
try:
    WebDriverWait(browser, timeout).until(EC.visibility_of_element_located((By.XPATH, '//*[@class="listing-container"]')))
except TimeoutException:
    print("Timed out waiting for page to load")
    browser.quit()

# click on spinner drop down to select F&B
browser.find_element_by_id('selectdo').click()
browser.find_element_by_xpath('//*[@id="selectdo"]/option[4]').click()

# click on see more button 3 times to display all F&B merchants
for i in range(2):
    time.sleep(5)
    load_more = browser.find_element_by_class_name('load-more-btn')
    browser.execute_script("arguments[0].click();", load_more)

time.sleep(5)

# website opened successfully, begin scraping of data
# find details of elements by right clicking then inspecting them
# in our case, we are interested in food and drink merchants so we retrieve a list of URLS of food and drink merchants
all_food_merchants = browser.find_elements_by_class_name('store-items')
urls = []

for merchant in all_food_merchants:
    urls.append(merchant.find_element_by_xpath('article/a').get_attribute('href'))

# iterate through each merchant to extract store name and address
count = 0

for merchant in all_food_merchants:
    browser.get(urls[count])
    store_name = browser.find_element_by_class_name("cm-details-section-head").get_attribute('innerText')
    store_unitnum = browser.find_element_by_xpath('//*[@id="content"]/div/div/div[3]/section/dl/dd[1]/a').get_attribute('innerText')
    print(store_name + ", " + store_unitnum)
    browser.back()
    count += 1

# now move on to other section (food kiosks and takeaway)
browser.find_element_by_id('selectdo').click()
browser.find_element_by_xpath('//*[@id="selectdo"]/option[10]').click()
time.sleep(5)

more_merchants = browser.find_elements_by_class_name('store-items')
links = []

for store in more_merchants:
    links.append(store.find_element_by_xpath('article/a').get_attribute('href'))

count = 0

for store in more_merchants:
    browser.get(links[count])
    store_name = browser.find_element_by_class_name("cm-details-section-head").get_attribute('innerText')
    store_unitnum = browser.find_element_by_xpath('//*[@id="content"]/div/div/div[3]/section/dl/dd[1]/a').get_attribute('innerText')
    print(store_name + ", " + store_unitnum)
    browser.back()
    count += 1

# clean up (close browser once task completed)
browser.quit()