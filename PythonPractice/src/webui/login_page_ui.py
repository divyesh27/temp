from selenium.webdriver.common.by import By
from base_page_ui import BasePage

class LoginPage(BasePage):
    # Locators
    USERNAME_INPUT = (By.ID, "username")
    PASSWORD_INPUT = (By.ID, "password")
    LOGIN_BUTTON = (By.CSS_SELECTOR, "button[type='submit']")
    FLASH_MESSAGE = (By.ID, "flash")

    def __init__(self, driver):
        super().__init__(driver)
        self.driver = driver

    def open_login_page(self):
        self.open("/login")

    def enter_username(self, username):
        self.find_element(*self.USERNAME_INPUT).send_keys(username)

    def enter_password(self, password):
        self.find_element(*self.PASSWORD_INPUT).send_keys(password)

    def click_login(self):
        self.find_element(*self.LOGIN_BUTTON).click()

    def get_flash_message(self):
        return self.wait_for_element(self.FLASH_MESSAGE).text
