from typing import Optional, Dict, List

def find_match_string(s1: Optional[str], s2: Optional[str]) -> bool:
    if s1 is None or s2 is None:
        raise ValueError("Pass valid input")

    if len(s1) != len(s2):
        return False

    s1_count = {}
    s1_values = []
    s2_count = {}
    s2_values = []

    for c in s1:
        s1_count[c] = s1_count.get(c, 0) + 1

    for count in s1_count.values():
        s1_values.append(count)

    for c in s2:
        s2_count[c] = s2_count.get(c, 0) + 1

    for count in s2_count.values():
        s2_values.append(count)

    for count in s1_count.values():
        if count not in s2_values:
            return False

    for count in s2_count.values():
        if count not in s1_values:
            return False

    return True

def find_match_string1(str1: Optional[str], str2: Optional[str]) -> bool:
    if str1 is None or str2 is None:
        raise ValueError("Pass valid input")

    m = len(str1)
    n = len(str2)

    if m != n:
        return False

    size = 256
    marked = [False] * size
    map = [-1] * size

    for i in range(n):
        str1_char = ord(str1[i])
        str2_char = ord(str2[i])

        if map[str1_char] == -1:
            if marked[str2_char]:
                return False
            marked[str2_char] = True
            map[str1_char] = str2_char
        elif map[str1_char] != str2_char:
            return False

    return True

# Example usage
if __name__ == "__main__":
    print(find_match_string("batat", "catat"))  # Output: True
    print(find_match_string("aab", "xyz"))      # Output: False
    print(find_match_string("egg", "add"))      # Output: True
    print(find_match_string("foo", "bar"))      # Output: False
    print(find_match_string("paper", "title"))  # Output: True
    print(find_match_string("bar", "foo"))      # Output: False

    print("******************************")
    print(find_match_string1("batat", "catat"))  # Output: True
    print(find_match_string1("aab", "xyz"))      # Output: False
    print(find_match_string1("egg", "add"))      # Output: True
    print(find_match_string1("foo", "bar"))      # Output: False
    print(find_match_string1("paper", "title"))  # Output: True
    print(find_match_string1("bar", "foo"))      # Output: False
