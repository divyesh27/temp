from selenium.webdriver.common.by import By
from base_page_ui import BasePage

class TablePage(BasePage):
    # Locator for the table rows
    TABLE_ROWS = (By.CSS_SELECTOR, "#table1 tbody tr")
    TABLE_HEADERS = (By.CSS_SELECTOR, "#table1 thead th")

    def __init__(self, driver):
        super().__init__(driver)
        self.driver = driver

    def open_table_page(self):
        self.open("/tables")

    def get_column_index(self, column_name):
        """Get the index of the column by name."""
        headers = self.driver.find_elements(*self.TABLE_HEADERS)
        for index, header in enumerate(headers):
            if header.text.strip() == column_name:
                return index
        return -1

    def get_cell_value(self, row_index, column_name):
        """Get the cell value by row index and column name."""
        column_index = self.get_column_index(column_name)
        if column_index == -1:
            raise Exception(f"Column '{column_name}' not found")

        rows = self.driver.find_elements(*self.TABLE_ROWS)
        if row_index < 0 or row_index >= len(rows):
            raise Exception(f"Row index '{row_index}' out of range")

        # Get all cells in the specific row
        cells = rows[row_index].find_elements(By.TAG_NAME, "td")
        return cells[column_index].text.strip() if column_index < len(cells) else None

    def get_row_count(self):
        """Get the total number of rows in the table."""
        return len(self.driver.find_elements(*self.TABLE_ROWS))
