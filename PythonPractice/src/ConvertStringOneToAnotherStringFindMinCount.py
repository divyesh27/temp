def steps_to_convert_one_string_to_another_string(str1: str, str2: str) -> int:
    if not isinstance(str1, str) or not isinstance(str2, str):
        raise TypeError("Both inputs must be strings")

    if str1 is None or str2 is None:
        raise ValueError("Input strings cannot be None")

    if len(str1) != len(str2):
        return -1

    # Create frequency maps for both strings
    frequency_map = {}

    for c in str1:
        frequency_map[c] = frequency_map.get(c, 0) + 1

    for c in str2:
        if c in frequency_map:
            frequency_map[c] -= 1
        else:
            return -1

    # Check if all frequencies are zero
    if any(count != 0 for count in frequency_map.values()):
        return -1

    # Calculate minimum steps to convert str1 to str2
    result = 0
    s1len = len(str1) - 1
    s2len = len(str2) - 1

    while s1len >= 0:
        if str1[s1len] != str2[s2len]:
            result += 1
        else:
            s2len -= 1
        s1len -= 1

    return result

# Test cases
if __name__ == "__main__":
    try:
        print(steps_to_convert_one_string_to_another_string("ABD", "BAD"))   # Output: 1
        print(steps_to_convert_one_string_to_another_string("EACBD", "EABCD"))  # Output: 2
    except ValueError as e:
        print(f"Error: {e}")
    except TypeError as e:
        print(f"Error: {e}")
