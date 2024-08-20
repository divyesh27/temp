from collections import Counter
from typing import Optional

def can_construct(ransom_note: Optional[str], magazine: Optional[str]) -> bool:
    # Check for null or invalid inputs
    if ransom_note is None or magazine is None or len(magazine) < len(ransom_note):
        return False

    # Create a frequency counter for the magazine
    magazine_counter = Counter(magazine)

    # Check if ransom note can be constructed from magazine
    for char in ransom_note:
        if magazine_counter[char] <= 0:
            return False
        magazine_counter[char] -= 1

    return True

# Example usage
if __name__ == "__main__":
    print(can_construct("a", "b"))   # Output: False
    print(can_construct("aa", "ab")) # Output: False
    print(can_construct("aa", "aab"))# Output: True
