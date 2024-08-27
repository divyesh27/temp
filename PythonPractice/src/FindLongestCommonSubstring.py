def find_longest_common_substring(str1, str2):
    # Type checks and handling for null or non-string inputs
    if not isinstance(str1, str) or not isinstance(str2, str) or str1 is None or str2 is None:
        return -1

    len_str1 = len(str1)
    len_str2 = len(str2)

    if len_str1 == 0 or len_str2 == 0:
        return -1

    max_length = 0
    pos_i = 0

    # Initialize a 2D array for dynamic programming
    matrix = [[0] * (len_str2 + 1) for _ in range(len_str1 + 1)]

    for i in range(1, len_str1 + 1):
        for j in range(1, len_str2 + 1):
            if str1[i - 1] == str2[j - 1]:
                matrix[i][j] = matrix[i - 1][j - 1] + 1

                if max_length < matrix[i][j]:
                    max_length = matrix[i][j]
                    pos_i = i

    # If no common substring is found
    if pos_i == 0:
        return -1

    # Return the longest common substring and its length
    if pos_i > 0:
        common_substring = str1[pos_i - max_length:pos_i]
        print(common_substring)

    return max_length

# Test cases
print(find_longest_common_substring("abcdperedfgwerasgdfsh", "adgqtfbghfgaafrwelgdfglaewrdsaf"))
print(find_longest_common_substring("abcdperedfgwerasgdfsh", "adgqtfbghfga"))
print(find_longest_common_substring("tesla", "slate"))
print(find_longest_common_substring("xxxx", "slate"))
print(find_longest_common_substring("xxxxx", "slate"))
