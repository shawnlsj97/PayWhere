# The following program is used to scrape names and addresses of food and beverage outlets that accept the Singtel Dash mobile payment method from https://www.dash.com.sg/where-to-dash/
# Language used: Python
# Package used: Selenium

from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.common.exceptions import TimeoutException
from selenium.common.exceptions import NoSuchElementException

# create new instance of chrome web browser by specifying path where chromedriver.exe is installed
path = 'C:\\Users\Shawn Lee\AppData\Local\Programs\Python\Python37\chromedriver.exe'
browser = webdriver.Chrome(path)

# visit website of interest
website = "https://www.dash.com.sg/where-to-dash/"
browser.get(website)

# wait up to 10 seconds for all elements on page to load (observe which element loads last and use it to determine if entire page is loaded)
timeout = 10;
try:
    WebDriverWait(browser, timeout).until(EC.visibility_of_element_located((By.XPATH, '//*[@id="dash-google-map"]')))
except TimeoutException:
    print("Timed out waiting for page to load")
    browser.quit()

# website opened successfully, begin scraping of data
# find details of elements by right clicking then inspecting them
# in our case, we are interested in food and drink merchants so we retrieve a list of elements of food and drink merchants
all_food_merchants = browser.find_elements_by_class_name('food-drink')

# iterate through each merchant to extract store name and address
for merchant in all_food_merchants:
    # retrieve number of outlets, if >1, we have to retrieve multiple sets of names and data (e.g. there are 7 outlets of Itacho Sushi accepting Singtel Dash)
    num_outlets = (int)((merchant.find_element_by_class_name('store-count').text.split(' '))[0])
    store_name = merchant.find_element_by_class_name('store-name').text

    # if only only one outlet, no need to loop through multiple outlets to retrieve name and address
    if (num_outlets == 1):
        street_address = merchant.find_element_by_xpath('div/div/div/div/p/span[@class="store-address-1"]').get_attribute('innerText')
        
        # all stores will always have a store name and street address
        default_info = store_name + ", " + street_address
        
        # not all stores have unit number hence retrieval of it might throw NoSuchElementException, so we handle the exception in this try block and print accordingly
        try:
            unit_number = merchant.find_element_by_xpath('div/div/div/div/p/span[@class="store-address-2"]').get_attribute('innerText')
            print(default_info + " " + unit_number)
        except NoSuchElementException:
            print(default_info)
    
    # num_outlets > 1, have to retrieve multiple outlet names and addresses by looping through multiple outlets
    else:
        # retrieve list of all outlets of store
        outlets = merchant.find_elements_by_class_name('medium-6')
        
        # for loop controlled by number of outlets, iterate through each outlet to retrieve outlet name and address
        for i in range(0, num_outlets):
            outlet = outlets[i]
            outlet_name = outlet.find_element_by_class_name('small-12').get_attribute('innerText').strip()
            street_address = outlet.find_element_by_xpath('div/p/span[@class="store-address-1"]').get_attribute('innerText')
            
            # all outlets will always have store name, outlet name and street address
            default_info = store_name + ", " + outlet_name + ", " + street_address

            # same as above, not all outlets have unit number hence might throw NoSuchElementException so we handle retrieval of unit number in this try block
            try:
                unit_number = outlet.find_element_by_xpath('div/p/span[@class="store-address-2"]').get_attribute('innerText')
                print(default_info + " " + unit_number)
            except NoSuchElementException:
                print(default_info)

# clean up (close browser once task completed)
browser.quit()