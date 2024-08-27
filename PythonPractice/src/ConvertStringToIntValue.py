def convert_string_to_integer_values(input_string: str) -> int:
    if not isinstance(input_string, str):
        raise ValueError("Input must be a string")

    if not input_string.strip():
        raise ValueError("Input string cannot be empty or whitespace only")

    input_string = input_string.strip()

    # Handle possible signs
    if input_string[0] in ('-', '+'):
        sign = -1 if input_string[0] == '-' else 1
        index = 1
    else:
        sign = 1
        index = 0

    result = 0

    for i in range(index, len(input_string)):
        char = input_string[i]

        if char.isdigit():
            val = int(char)
            result = result * 10 + val
        else:
            break

    result *= sign

    # Handle overflow cases
    if result > 2**31 - 1:
        return 2**31 - 1
    elif result < -2**31:
        return -2**31
    else:
        return result

if __name__ == "__main__":
    try:
        # Test cases
        print(convert_string_to_integer_values("1242"))            # 1242
        print(convert_string_to_integer_values("    acdd 234324234"))  # 0
        print(convert_string_to_integer_values(" acdd 234324234"))     # 0
        print(convert_string_to_integer_values("     21332 ad"))     # 21332
        print(convert_string_to_integer_values("     21332"))        # 21332
        print(convert_string_to_integer_values("     -21332"))       # -21332
        print(convert_string_to_integer_values("-1242"))            # -1242
        print(convert_string_to_integer_values("-9343232242"))      # -2147483648 (overflow)
        print(convert_string_to_integer_values("9343232242"))       # 2147483647 (overflow)
    except ValueError as e:
        print(f"Error: {e}")
