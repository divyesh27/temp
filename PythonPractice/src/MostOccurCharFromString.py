from collections import defaultdict
from typing import Optional

def find_most_occurring_char(s: Optional[str]) -> Optional[str]:
    """
    Find the character that occurs the most in the string.

    Args:
    s (Optional[str]): The input string.

    Returns:
    Optional[str]: The character that occurs the most. Returns None if input is None or empty.
    """
    if s is None or len(s) == 0:
        return None

    if not isinstance(s, str):
        raise ValueError("Input must be a string.")

    count_map = defaultdict(int)

    # Populate the count_map with the frequency of each character
    for char in s:
        count_map[char] += 1

    # Find the character with the maximum frequency
    most_occurring = max(count_map.items(), key=lambda item: item[1])[0]

    return most_occurring

# Example usage
if __name__ == "__main__":
    print(find_most_occurring_char("aaabbbbcbsbdddcbbbc"))
    print(find_most_occurring_char("aaaaaaaaaa"))
    print(find_most_occurring_char("abc"))
    print(find_most_occurring_char(" "))
    print(find_most_occurring_char("c"))
    print(find_most_occurring_char("abc#a"))
    print(find_most_occurring_char("SSSS"))
    print(find_most_occurring_char("SS"))
    print(find_most_occurring_char("SS     SS"))
    print(find_most_occurring_char("SS ######SS"))
    print(find_most_occurring_char("11111SSSS"))
    print(find_most_occurring_char("0000"))
    print(find_most_occurring_char("1111 23456SSSS"))
