from collections import defaultdict
from collections import Counter

## This solution is done using dictionary and its counter.
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

#This functionality is implemented using Counter from collections to capture frequency
def find_non_repeat_char_from_string(s: str) -> str:
    if not s:  # Check if the string is empty or None
        return '\0'

    # Use Counter to count character frequencies
    char_count = Counter(s)

    # Return the first character with a count of 1
    for char in s:
        if char_count[char] == 1:
            return char

    return '\0'  # Return a null character if no non-repeated character is found


if __name__ == "__main__":
    result = find_non_repeated_char_from_string("a Salesforce guys in salesforce")
    print(result)
    results = find_non_repeat_char_from_string("a Salesforce guys in salesforce")
    print(results)

