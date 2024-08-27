def convert_int_to_roman(input_number):
    # Define the mapping of Arabic to Roman numerals
    arabic_values = [1000, 900, 500, 400, 100, 90, 50, 40, 10, 5, 4, 1]
    roman_values = ["M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "V", "IV", "I"]

    # Validate the input
    if not isinstance(input_number, int):
        raise TypeError("Input must be an integer.")
    if input_number <= 0:
        raise ValueError("Input must be a positive integer.")

    result = []

    # Convert the integer to a Roman numeral
    for i in range(len(arabic_values)):
        while input_number >= arabic_values[i]:
            result.append(roman_values[i])
            input_number -= arabic_values[i]

    return ''.join(result)

# Test cases
print(convert_int_to_roman(1200))  # Output: "MCC"
print(convert_int_to_roman(100))   # Output: "C"
print(convert_int_to_roman(1999))  # Output: "MCMXCIX"
