def power_of_two(n):
    if not isinstance(n, int) or n <= 0:
        return False
    while n != 1:
        if n % 2 != 0:
            return False
        n //= 2
    return True

def power(n, m):
    if not isinstance(n, int) or not isinstance(m, int):
        raise ValueError("Both n and m must be integers")
    if m == 0:
        return 1
    pow_half = power(n, m // 2)
    if m % 2 == 0:
        return pow_half * pow_half
    else:
        return n * pow_half * pow_half

if __name__ == "__main__":
    n = 24
    print(power_of_two(n))  # Output: False
    print(power(n, 7))      # Output: 4745832
