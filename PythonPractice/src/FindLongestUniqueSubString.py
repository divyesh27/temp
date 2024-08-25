def count_substring(s: str) -> int:
    if s is None:
        return -1
    if len(s) <= 1:
        return len(s)

    n = len(s)
    max_len = 0
    i, j = 0, 0
    char_set = set()

    while i < n and j < n:
        if s[j] not in char_set:
            char_set.add(s[j])
            j += 1
            max_len = max(max_len, j - i)
        else:
            char_set.remove(s[i])
            i += 1

    return max_len

if __name__ == "__main__":
    # Test cases
    print(count_substring("abcdedfaafadfagafaeerw"))  # Output should be the length of the longest unique substring
    print(count_substring("abcabcbb"))               # Output should be 3 (i.e., "abc")
    print(count_substring("bbbbb"))                  # Output should be 1 (i.e., "b")
    print(count_substring("pwwkew"))                 # Output should be 3 (i.e., "wke")
