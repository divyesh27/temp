import re
from typing import Optional

def extract_digits_to_sum(s: str) -> None:
    if not isinstance(s, str):
        raise TypeError("Input must be a string")

    pattern = re.compile(r'-?\d+')
    matches = pattern.findall(s)

    sum_digits = 0
    for match in matches:
        try:
            sum_digits += int(match)
        except ValueError:
            # If there's an issue with converting to int, skip this match
            continue

    print(sum_digits)

def add_summation(input_string: Optional[str]) -> int:
    if not isinstance(input_string, str):
        raise TypeError("Input must be a string")
    if len(input_string) < 2:
        raise ValueError("Input string is too short")

    sum_digits = 0
    result = ''
    flag = False

    for char in input_string:
        if char.isdigit():
            result += char
            flag = True
        else:
            if flag:
                try:
                    sum_digits += int(result)
                except ValueError:
                    # If there's an issue with converting to int, reset result
                    result = ''
                result = ''
                flag = False

    if result:
        try:
            sum_digits += int(result)
        except ValueError:
            # If there's an issue with converting to int, ignore
            pass

    return sum_digits

# Example usage
print("*** Extract Digits Method ***")
extract_digits_to_sum("23adf5dsf4")
extract_digits_to_sum("235a4")
extract_digits_to_sum("2354a")
extract_digits_to_sum("a2354")
extract_digits_to_sum("a2a3a5a4a")
extract_digits_to_sum("123a-bc-22")

print("\n*** ******** ***\n")
print("*** Add Summation Method ***")
print(add_summation("123abc45def6gh78"))
print(add_summation("23adf5dsf4"))
print(add_summation("235a4"))
print(add_summation("2354a"))
print(add_summation("a2a3a5a4a"))
print(add_summation("232345"))
print(add_summation("abcde"))
print(add_summation("1abcde1"))
