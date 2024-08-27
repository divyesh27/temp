def num_to_words(number: int) -> str:
    if not isinstance(number, int):
        raise TypeError("Input must be an integer")

    if number < 0 or number > 999999999999999:
        raise ValueError("Number out of range. Supported range is from 0 to 999,999,999,999,999")

    if number == 0:
        return "Zero"

    thousands = ["", "thousand", "million", "billion", "trillion", "quadrillion", "quintillion"]
    digits_20 = ["", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
                 "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
                 "eighteen", "nineteen"]
    tens = ["", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"]

    def num_to_string(number: int) -> str:
        if number == 0:
            return ""
        elif number < 20:
            return digits_20[number] + " "
        elif number < 100:
            return tens[number // 10] + " " + num_to_string(number % 10)
        else:
            return digits_20[number // 100] + " hundred " + num_to_string(number % 100)

    count = 0
    result = ""

    while number > 0:
        if number % 1000 != 0:
            result = num_to_string(number % 1000) + thousands[count] + " " + result
        number //= 1000
        count += 1

    return result.strip()

# Test cases
if __name__ == "__main__":
    try:
        print(num_to_words(123134))            # Output: "one hundred twenty-three thousand one hundred thirty-four"
        print(num_to_words(1000000004))        # Output: "one billion four"
        print(num_to_words(4))                 # Output: "four"
        print(num_to_words(0))                 # Output: "Zero"
        print(num_to_words(999999999999999))  # Output: "nine hundred ninety-nine trillion nine hundred ninety-nine billion nine hundred ninety-nine million nine hundred ninety-nine thousand nine hundred ninety-nine"
    except ValueError as e:
        print(f"ValueError: {e}")
    except TypeError as e:
        print(f"TypeError: {e}")
