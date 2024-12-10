import unittest
from selenium import webdriver
from login_page_ui import LoginPage
from table_page_ui import TablePage

class TestWebApp(unittest.TestCase):
    def setUp(self):
        self.driver = webdriver.Chrome()
        self.driver.implicitly_wait(10)
        self.login_page = LoginPage(self.driver)
        self.table_page = TablePage(self.driver)

    def test_valid_login(self):
        self.login_page.open_login_page()
        self.login_page.enter_username("tomsmith")
        self.login_page.enter_password("SuperSecretPassword!")
        self.login_page.click_login()

        flash_message = self.login_page.get_flash_message()
        self.assertIn("You logged into a secure area!", flash_message)

    def test_invalid_login(self):
        self.login_page.open_login_page()
        self.login_page.enter_username("invalid_user")
        self.login_page.enter_password("invalid_password")
        self.login_page.click_login()

        flash_message = self.login_page.get_flash_message()
        self.assertIn("Your username is invalid!", flash_message)

    def test_table_cell_value(self):
        self.table_page.open_table_page()
        cell_value = self.table_page.get_cell_value(row_index=1, column_name="Last Name")
        self.assertEqual(cell_value, "Bach", f"Expected 'Smith' but got '{cell_value}'")

    def test_table_row_count(self):
        self.table_page.open_table_page()
        row_count = self.table_page.get_row_count()
        self.assertEqual(row_count, 4, f"Expected 4 rows but got '{row_count}'")

    def tearDown(self):
        self.driver.quit()

if __name__ == "__main__":
    unittest.main()
