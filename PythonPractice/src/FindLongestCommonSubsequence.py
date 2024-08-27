def find_longest_common_subsequence(str1, str2):
    # Type checks and handling for null or non-string inputs
    if not isinstance(str1, str) or not isinstance(str2, str) or str1 is None or str2 is None:
        return str1

    len_str1 = len(str1)
    len_str2 = len(str2)

    # Initialize a 2D array for dynamic programming
    matrix = [[0] * (len_str2 + 1) for _ in range(len_str1 + 1)]
    max_length = 0
    sb = []

    for i in range(1, len_str1 + 1):
        for j in range(1, len_str2 + 1):
            if str1[i - 1] == str2[j - 1]:
                matrix[i][j] = matrix[i - 1][j - 1] + 1
            else:
                matrix[i][j] = max(matrix[i][j - 1], matrix[i - 1][j])

            if matrix[i][j] > max_length:
                max_length = matrix[i][j]

    # Reconstruct the LCS by backtracking through the matrix
    x, y = len_str1, len_str2
    while x != 0 and y != 0:
        if matrix[x][y] == matrix[x - 1][y]:
            x -= 1
        elif matrix[x][y] == matrix[x][y - 1]:
            y -= 1
        else:
            assert str1[x - 1] == str2[y - 1]
            sb.append(str1[x - 1])
            x -= 1
            y -= 1

    # Return the reversed LCS string as it was built backwards
    lcs = ''.join(reversed(sb))
    print(f"Longest common subsequence: {lcs}")
    return lcs

def longest_common_subsequence(text1, text2):
    m = len(text1)
    n = len(text2)

    # Initialize the dp array with 0s
    dp = [[0] * (n + 1) for _ in range(m + 1)]

    # Fill the dp array using dynamic programming
    for i in range(1, m + 1):
        for j in range(1, n + 1):
            if text1[i - 1] == text2[j - 1]:
                # If the characters match, add 1 to the LCS of the substrings
                dp[i][j] = dp[i - 1][j - 1] + 1
            else:
                # If the characters don't match, take the maximum LCS of the substrings
                dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])

    # Return the length of the LCS of the two strings
    return dp[m][n]

# Test cases
find_longest_common_subsequence("abcdaf", "acbcf")
find_longest_common_subsequence("ABCDGH", "AEDFHR")
find_longest_common_subsequence("AGGTAB", "GXTXAYB")
find_longest_common_subsequence("longestcommonsubsequence", "dynamicprogramming")
find_longest_common_subsequence("alphabetagamma", "applemangopineapple")
find_longest_common_subsequence("xxxxxx", "yyyy")
print("Longest common subsequence length:", longest_common_subsequence("abcetd", "cssftdsgsrhd"))
