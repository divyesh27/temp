import re
from typing import Optional

def find_valid_url(input_string: Optional[str]) -> bool:
    if input_string is None or not input_string.strip():
        return False

    regex1 = r"^(https://|http://|www\.)[-a-zA-Z0-9+/%?_|:.]*[-a-zA-Z0-9](\.[a-z]{2,3})$"
    try:
        pattern = re.compile(regex1)
        if pattern.match(input_string):
            return True
    except re.error as e:
        print(f"Regex error: {e}")

    return False

def main():
    test_cases = [
        "https://www.helix.com",
        "1234",
        "htt://ee.ee.com",
        "http://abc.cde.fed.in",
        "http://www.abc.cde.fed.in",
        "http://www.abc/cde/fed.in",
        "https://www.helix.in",
        "https://helix.ca",
        "https://www.helix.abcd",
        "http://www.helix.abcd",
        "http://www.helix.com",
        "http://abc",
        "www.helix.com",
        "https://",
        "http://",
    ]

    for test in test_cases:
        print(find_valid_url(test))

if __name__ == "__main__":
    main()
