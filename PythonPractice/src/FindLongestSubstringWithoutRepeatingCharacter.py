def longest_substring_without_repeating_character(s: str) -> int:
    if s is None:
        return -1
    if len(s) == 0:
        return 0

    char_set = set()
    start = 0
    max_size = 0

    for i in range(len(s)):
        if s[i] not in char_set:
            char_set.add(s[i])
            max_size = max(max_size, len(char_set))
        else:
            while s[start] != s[i]:
                char_set.remove(s[start])
                start += 1
            start += 1

    return max_size

if __name__ == "__main__":
    # Test cases
    print(longest_substring_without_repeating_character("slatevotea"))  # Output should be 6 (i.e., "slatev")
    print(longest_substring_without_repeating_character("ABCDECAMNCZB"))  # Output should be 6 (i.e., "ABCDEC")
    print(longest_substring_without_repeating_character(""))  # Output should be 0
    print(longest_substring_without_repeating_character(None))  # Output should be -1
