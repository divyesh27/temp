def main():
    sum = 0
    number = [0] * 10
    number[0] = 1
    number[1] = 1

    for i in range(2, len(number)):
        number[i] = number[i - 1] + number[i - 2]

    for num in number:
        print(num, end=" ")

    print("\n")

    for i in range(1, 10):
        print(recursive_fibo(i), end=" ")

    print("\n")

    print(even_fibo_number(400))
    print()
    print(dynamic_program_fibonacci(19))
    print()
    print(fibonacci_iterative(19))

def recursive_fibo(i):
    if i == 0:
        return 0
    elif i == 1:
        return 1
    else:
        return recursive_fibo(i - 1) + recursive_fibo(i - 2)

def even_fibo_number(val):
    if val < 2:
        return 0

    even1 = 0
    even2 = 2
    sum = even1 + even2

    while even2 <= val:
        even3 = 4 * even2 + even1
        if even3 > val:
            break

        even1 = even2
        even2 = even3
        sum += even2

    return sum

def dynamic_program_fibonacci(n):
    lookup = [0] * (n + 2)
    lookup[0] = 0
    lookup[1] = 1

    for i in range(2, n + 1):
        lookup[i] = lookup[i - 1] + lookup[i - 2]

    return lookup[n]

def fibonacci_iterative(n):
    if n <= 1:
        return n

    f = [0] * (n + 1)
    f[0] = 0
    f[1] = 1

    for i in range(2, n + 1):
        f[i] = f[i - 1] + f[i - 2]

    return f[n]

if __name__ == "__main__":
    main()
