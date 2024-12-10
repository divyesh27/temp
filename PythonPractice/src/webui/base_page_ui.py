from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

class BasePage:
    def __init__(self, driver):
        self.driver = driver
        self.base_url = "https://the-internet.herokuapp.com"

    def open(self, url):
        self.driver.get(self.base_url + url)

    def find_element(self, *locator):
        return self.driver.find_element(*locator)

    def wait_for_element(self, locator, timeout=10):
        return WebDriverWait(self.driver, timeout).until(EC.presence_of_element_located(locator))
