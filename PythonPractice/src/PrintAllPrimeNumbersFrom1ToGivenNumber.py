def prime_numbers(n):
    if not isinstance(n, int) or n < 2:
        raise ValueError("Input should be an integer greater than or equal to 2")

    prime_numbers = []
    for i in range(2, n + 1):
        if is_prime(i):
            prime_numbers.append(i)

    return prime_numbers

def is_prime(number):
    if number < 2:
        return False
    for i in range(2, number):
        if number % i == 0:
            return False
    return True

if __name__ == "__main__":
    print(prime_numbers(100))
