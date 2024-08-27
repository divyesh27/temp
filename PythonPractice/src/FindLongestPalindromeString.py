def longest_palindrome(s):
    if not isinstance(s, str) or s is None or len(s) <= 1:
        return s

    def is_palindrome(substring, left, right):
        if substring is None or len(substring) == 0:
            return ""
        if left > right:
            return ""

        while left >= 0 and right < len(substring) and substring[left] == substring[right]:
            left -= 1
            right += 1

        return substring[left + 1:right]

    max_palindrome = s[0:1]

    for i in range(len(s) - 1):
        # Check for odd-length palindromes
        palin = is_palindrome(s, i, i)
        if len(palin) > len(max_palindrome):
            max_palindrome = palin

        # Check for even-length palindromes
        palin = is_palindrome(s, i, i + 1)
        if len(palin) > len(max_palindrome):
            max_palindrome = palin

    return max_palindrome

# Test cases
print(longest_palindrome("HYTBCABADEFGHABCDEDCBAGHTFYW12345678987654321ZWETYGDE"))
print(longest_palindrome("1234"))
print(longest_palindrome("12321"))
print(longest_palindrome("9912321456"))
print(longest_palindrome("9912333321456"))
print(longest_palindrome("12145445499"))
print(longest_palindrome("1223213"))
print(longest_palindrome("abb"))
print(longest_palindrome("Hello how are you madam hope you are fine"))
print(longest_palindrome("abba madam you are malayalamabcbaabcba"))
print(longest_palindrome("abba madam you are malayalam"))
