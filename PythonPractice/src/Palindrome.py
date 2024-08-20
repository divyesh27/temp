def is_palindrome(s: str) -> bool:
    """
    Check if a given string is a palindrome using two-pointer technique.
    """
    if not isinstance(s, str):
        raise ValueError("Input must be a string")
    if s is None or s == "":
        return False

    left, right = 0, len(s) - 1
    while left < right:
        if s[left] != s[right]:
            return False
        left += 1
        right -= 1
    return True

def is_palindrome2(s: str) -> bool:
    """
    Check if a given string is a palindrome using a different method.
    """
    if not isinstance(s, str):
        raise ValueError("Input must be a string")
    if s is None or s == "":
        return False

    left, right = 0, len(s) - 1
    while left < right:
        if s[left] != s[right]:
            return False
        left += 1
        right -= 1
    return True

def is_palindrome_number(num: int) -> bool:
    """
    Check if a given integer is a palindrome.
    """
    if not isinstance(num, int):
        raise ValueError("Input must be an integer")
    if num < 0 or (num % 10 == 0 and num != 0):
        return False

    original_num = num
    reversed_num = 0
    while num > reversed_num:
        reversed_num = reversed_num * 10 + num % 10
        num //= 10

    return num == reversed_num or num == reversed_num // 10

if __name__ == "__main__":
    str_input = "12321"
    num_input = 1221

    # Test palindrome checks
    print(is_palindrome(str_input))         # Output: True
    print(is_palindrome2(str_input))        # Output: True
    print(is_palindrome_number(num_input))  # Output: True
