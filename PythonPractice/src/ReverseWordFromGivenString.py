def reverse_words_string(s: str) -> str:
    if s is None or len(s) == 0:
        return s

    words = s.split()
    return ' '.join(reversed(words))


def reverse_each_word_of_given_string(s: str) -> str:
    if s is None or len(s) < 2:
        raise ValueError("Pass valid input")

    words = s.split()
    reversed_words = [reverse_string(word) for word in words]
    return ' '.join(reversed_words)


def reverse_string(s: str) -> str:
    return s[::-1]


def main():
    print(reverse_words_string("Hi my name is Divyesh"))  # Output: "Divyesh is name my Hi"
    print(reverse_each_word_of_given_string("Hi my name is Divyesh"))  # Output: "iH ym eman si hseyviD"


if __name__ == "__main__":
    main()
