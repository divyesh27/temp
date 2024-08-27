from collections import Counter

def check_anagram(str1, str2):
    # Validate input types
    if not isinstance(str1, str) or not isinstance(str2, str):
        raise TypeError("Both inputs must be strings.")

    # Check for null or empty strings
    if str1 is None or str2 is None or len(str1) == 0 or len(str2) == 0:
        return False

    # Normalize the strings by converting to lowercase and removing spaces
    str1 = str1.replace(" ", "").lower()
    str2 = str2.replace(" ", "").lower()

    # Compare character counts using Counter
    return Counter(str1) == Counter(str2)

# Test cases
print(check_anagram("A Rope Ends It", "Desperation"))  # Output: True
print(check_anagram("Desperation", "A Rope Ends It"))  # Output: True
print(check_anagram("Hello", "World"))  # Output: False
