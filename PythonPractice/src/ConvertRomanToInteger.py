def convert_roman_values_to_integer(input_roman: str) -> int:
    if not isinstance(input_roman, str):
        raise TypeError("Input must be a string")

    if input_roman is None or len(input_roman) < 1:
        raise ValueError("Pass valid input")

    roman_map = get_roman_map()

    result = 0
    prev_value = 0

    for char in reversed(input_roman):
        if char not in roman_map:
            raise ValueError(f"Invalid Roman numeral character: {char}")

        value = roman_map[char]

        if value < prev_value:
            result -= value
        else:
            result += value

        prev_value = value

    return result

def get_roman_map() -> dict:
    return {
        'I': 1,
        'V': 5,
        'X': 10,
        'L': 50,
        'C': 100,
        'D': 500,
        'M': 1000
    }

# Test cases
if __name__ == "__main__":
    try:
        print(convert_roman_values_to_integer("V"))           # Output: 5
        print(convert_roman_values_to_integer("XI"))          # Output: 11
        print(convert_roman_values_to_integer("XICM"))        # Output: 0 (Invalid Roman numeral)
        print(convert_roman_values_to_integer("MC"))          # Output: 1100
        print(convert_roman_values_to_integer("MCMLXXI"))     # Output: 1971
        print(convert_roman_values_to_integer("MCMXCIV"))     # Output: 1994
    except ValueError as e:
        print(f"ValueError: {e}")
    except TypeError as e:
        print(f"TypeError: {e}")
