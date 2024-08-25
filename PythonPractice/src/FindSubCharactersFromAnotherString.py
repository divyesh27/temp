def find_sub_char(input1: str, input2: str) -> set:
    if input1 is None or input2 is None:
        raise ValueError("Pass valid input")

    if not input1 or not input2:
        return set()

    unique = set(input1)
    result = {c for c in input2 if c in unique}

    return result

if __name__ == "__main__":
    print(find_sub_char("apple", "pear"))
    print(find_sub_char("lock", "door"))
    print(find_sub_char("foo", "barf"))
    print(find_sub_char("foo", ""))
