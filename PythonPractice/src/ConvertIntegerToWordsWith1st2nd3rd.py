def convert_int_to_words(input_number):
    # Check for valid input
    if not isinstance(input_number, int) or input_number < 0 or input_number > 200:
        raise ValueError("Input must be an integer between 0 and 200")

    if input_number % 10 == 1 and (input_number % 100 != 11):
        suffix = "st"
    elif input_number % 10 == 2 and (input_number % 100 != 12):
        suffix = "nd"
    elif input_number % 10 == 3 and (input_number % 100 != 13):
        suffix = "rd"
    else:
        suffix = "th"

    print(f"{input_number}{suffix}")

# Test cases
convert_int_to_words(191)
convert_int_to_words(1)
convert_int_to_words(2)
convert_int_to_words(3)
convert_int_to_words(111)
convert_int_to_words(112)
convert_int_to_words(113)
convert_int_to_words(121)
convert_int_to_words(122)
convert_int_to_words(141)
convert_int_to_words(142)
