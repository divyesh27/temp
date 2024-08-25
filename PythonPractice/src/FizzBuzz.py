def fizz_buzz(n: int) -> None:
    if not isinstance(n, int) or n <= 0:
        raise ValueError("Input must be a positive integer.")

    for i in range(1, n + 1):
        if i % 3 == 0 and i % 5 == 0:
            print("FizzBuzz")
        elif i % 3 == 0:
            print("Fizz")
        elif i % 5 == 0:
            print("Buzz")
        else:
            print(i)

if __name__ == "__main__":
    n = 100  # set the range of integers to 1 to 100 (inclusive)
    fizz_buzz(n)
