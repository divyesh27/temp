import re
from typing import Optional

def find_valid_phone_number_regex(input_string: Optional[str]) -> bool:
    if input_string is None or not input_string.strip():
        return False

    regex1 = r"[0-9]{10}|([0-9]{3}[-.\s][0-9]{3}[-.\s][0-9]{4})"
    try:
        pattern = re.compile(regex1)
        if pattern.fullmatch(input_string):
            return True
    except re.error as e:
        print(f"Regex error: {e}")

    return False

def main():
    test_cases = [
        "413-344-5454",
        "413.344.5454",
        "4133445454",
        "413345454",
        "413.3445454",
        "413-344.5454",
        "413_344_5454",
        "413 344 5454",
    ]

    for test in test_cases:
        print(find_valid_phone_number_regex(test))

if __name__ == "__main__":
    main()
