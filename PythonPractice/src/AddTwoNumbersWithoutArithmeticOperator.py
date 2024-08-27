def add_numbers(a: int, b: int) -> int:
    # Validate inputs
    if not isinstance(a, int) or not isinstance(b, int):
        raise TypeError("Both a and b must be integers")

    # Add numbers using bitwise operations
    while b != 0:
        carry = a & b
        a = a ^ b
        b = carry << 1

    return a

def add_binary_numbers_from_two_given_strings(x: str, y: str) -> str:
    # Validate inputs
    if not isinstance(x, str) or not isinstance(y, str):
        raise TypeError("Both x and y must be strings")

    if not x or not y:
        raise ValueError("Both input strings must be non-empty")

    result = []
    i = len(x) - 1
    j = len(y) - 1
    carry = 0

    while i >= 0 or j >= 0 or carry:
        sum = carry

        if i >= 0:
            sum += int(x[i])
            i -= 1

        if j >= 0:
            sum += int(y[j])
            j -= 1

        result.append(str(sum % 2))
        carry = sum // 2

    return ''.join(reversed(result))

def main():
    print(add_numbers(5, 9))  # Output: 14
    print(add_binary_numbers_from_two_given_strings("111", "111"))  # Output: "1110"

if __name__ == "__main__":
    main()
