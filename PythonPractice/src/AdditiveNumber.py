from typing import Optional

def is_additive_number(num: str) -> bool:
    if not isinstance(num, str) or len(num) < 3:
        raise ValueError("Input must be a string with at least 3 characters")

    def is_valid(num: str, start: int, x1: int, x2: int) -> bool:
        if start == len(num):
            return True
        x3 = x1 + x2
        x3_str = str(x3)
        return num.startswith(x3_str, start) and is_valid(num, start + len(x3_str), x2, x3)

    for i in range(1, len(num) // 2 + 1):
        if num[0] == '0' and i > 1:
            break

        try:
            x1 = int(num[:i])
        except ValueError:
            return False

        for j in range(i + 1, len(num)):
            if num[i] == '0' and j > i + 1:
                break

            try:
                x2 = int(num[i:j])
            except ValueError:
                return False

            if is_valid(num, j, x1, x2):
                return True

    return False

def is_additive_number1(num: str) -> bool:
    if not isinstance(num, str) or len(num) < 3:
        raise ValueError("Input must be a string with at least 3 characters")

    def is_valid1(x1: int, x2: int, start: int, num: str) -> bool:
        if start == len(num):
            return True
        x3 = x1 + x2
        x1 = x2
        x2 = x3
        x3_str = str(x3)
        return num.startswith(x3_str, start) and is_valid1(x1, x2, start + len(x3_str), num)

    for i in range(1, len(num) // 2 + 1):
        if num[0] == '0' and i > 1:
            break

        try:
            first = int(num[:i])
        except ValueError:
            return False

        for j in range(i + 1, len(num)):
            if num[i] == '0' and j > i + 1:
                break

            try:
                second = int(num[i:i + j])
            except ValueError:
                return False

            if is_valid1(first, second, i + j, num):
                return True

    return False

# Example usage
if __name__ == "__main__":
    print(is_additive_number("112358"))    # True
    print(is_additive_number("199100199")) # True
    print(is_additive_number("1234a5"))    # False

    print(is_additive_number1("112358"))    # True
    print(is_additive_number1("199100199")) # True
    print(is_additive_number1("1234a5"))    # False
