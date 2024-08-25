from collections import defaultdict

def find_non_repeated_char_from_string(s: str) -> str:
    if s is None:
        return '\0'  # Returning a null character equivalent

    if len(s) <= 1:
        return s[0] if s else '\0'

    char_count = defaultdict(int)

    for char in s:
        char_count[char] += 1

    for char in s:
        if char_count[char] == 1:
            return char

    return '\0'  # Return a null character if no non-repeated character is found

if __name__ == "__main__":
    result = find_non_repeated_char_from_string("a Salesforce guys in salesforce")
    print(result)
