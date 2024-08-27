def add_numbers(num: int) -> int:
    # Validate input
    if not isinstance(num, int):
        raise TypeError("Input must be an integer")

    if num == 0:
        return num

    if num % 9 == 0:
        return 9
    else:
        return num % 9

def add_number(num: int) -> int:
    # Validate input
    if not isinstance(num, int):
        raise TypeError("Input must be an integer")

    return (num - 1) % 9 + 1

def add_num(num: int) -> int:
    # Validate input
    if not isinstance(num, int):
        raise TypeError("Input must be an integer")

    return 9 if num != 0 and num % 9 == 0 else num % 9

def main():
    # Testing add_numbers
    for i in range(1, 31):
        print(f"add_numbers({i}) = {add_numbers(i)}")

    print("*****************")

    # Testing add_number
    for i in range(21, 31):
        print(f"add_number({i}) = {add_number(i)}")

    print("*****************")

    # Testing add_num
    for i in range(31, 41):
        print(f"add_num({i}) = {add_num(i)}")

if __name__ == "__main__":
    main()
