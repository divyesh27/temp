def remove_char_from_string(s: str, c: str) -> str:
    if s is None:
        return None

    result = []
    for char in s:
        if char != c:
            result.append(char)

    return ''.join(result)

def main():
    print(remove_char_from_string("google", 'g'))

if __name__ == "__main__":
    main()
