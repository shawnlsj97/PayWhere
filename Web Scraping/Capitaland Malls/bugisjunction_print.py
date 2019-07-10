# The following program is used to scrape names and addresses of food and beverage outlets in Bugis Junction from https://www.capitaland.com/sg/malls/bugisjunction/en/stores.html?category=foodandbeverage
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
website = "https://www.capitaland.com/sg/malls/bugisjunction/en/stores.html?category=foodandbeverage"
browser.get(website)

# wait up to 10 seconds for all elements on page to load (observe which element loads last and use it to determine if entire page is loaded)
timeout = 10;
try:
    WebDriverWait(browser, timeout).until(EC.visibility_of_element_located((By.XPATH, '//*[@class="listing-container"]')))
except TimeoutException:
    print("Timed out waiting for page to load")
    browser.quit()

# click on see more button 5 times to display all F&B merchants
time.sleep(5)
see_more = browser.find_element_by_class_name('cta-see-more')
browser.execute_script("arguments[0].click();", see_more)
time.sleep(5)
see_more = browser.find_element_by_class_name('cta-see-more')
browser.execute_script("arguments[0].click();", see_more)
time.sleep(5)
see_more = browser.find_element_by_class_name('cta-see-more')
browser.execute_script("arguments[0].click();", see_more)
time.sleep(5)
see_more = browser.find_element_by_class_name('cta-see-more')
browser.execute_script("arguments[0].click();", see_more)
time.sleep(5)
see_more = browser.find_element_by_class_name('cta-see-more')
browser.execute_script("arguments[0].click();", see_more)
time.sleep(5)

# website opened successfully, begin scraping of data
# find details of elements by right clicking then inspecting them
# in our case, we are interested in food and drink merchants so we retrieve a list of URLS of food and drink merchants
all_food_merchants = browser.find_elements_by_class_name('listing-tenants')
urls = []

for merchant in all_food_merchants:
    urls.append(merchant.find_element_by_xpath('a').get_attribute('href'))

# iterate through each merchant to extract store name and address
count = 0

for merchant in all_food_merchants:
    browser.get(urls[count])
    store_name = browser.find_element_by_class_name("cm-details-section-head").get_attribute('innerText')
    store_unitnum = browser.find_element_by_xpath('//*[@id="main"]/div[1]/div[1]/div/div[3]/section/dl/dd[1]/a').get_attribute('innerText')
    print(store_name + ", " + store_unitnum)
    browser.back()
    count += 1

# clean up (close browser once task completed)
browser.quit()