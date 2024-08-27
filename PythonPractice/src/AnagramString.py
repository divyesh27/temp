from typing import List, Dict
from collections import defaultdict

def check_anagram(str1: str, str2: str) -> bool:
    if str1 is None or str2 is None:
        return False

    if len(str1) != len(str2):
        return False

    # Create frequency maps
    freq_map = defaultdict(int)

    for char in str1:
        freq_map[char] += 1

    for char in str2:
        freq_map[char] -= 1

    # Check if all counts are zero
    return all(count == 0 for count in freq_map.values())

def group_anagrams(input_strings: List[str]) -> List[List[str]]:
    if input_strings is None or len(input_strings) < 2:
        return []

    anagram_map: Dict[str, List[str]] = defaultdict(list)

    for s in input_strings:
        if s is None:
            continue
        # Sort the string to create a key
        sorted_str = ''.join(sorted(s))
        anagram_map[sorted_str].append(s)

    return list(anagram_map.values())

def main():
    print(check_anagram("divyesh", "jinal"))  # False
    print(check_anagram("ljani", "jinal"))    # False
    print(group_anagrams(["are", "bat", "ear", "code", "tab", "era"]))

if __name__ == "__main__":
    main()
