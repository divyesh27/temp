def pad_spaces(input_string: str, pad_space: int) -> str:
    """
    Pad the input string with spaces to ensure the total length is equal to `pad_space`.
    """
    if not isinstance(input_string, str) or not isinstance(pad_space, int):
        raise ValueError("Input must be a string and pad_space must be an integer.")
    if input_string is None or pad_space < len(input_string):
        return input_string

    words = input_string.split()
    if not words:
        return input_string

    result = []
    i = 0
    while i < len(words):
        total_length = len(words[i])
        j = i + 1
        sb = [words[i]]

        while j < len(words) and total_length + len(words[j]) + 1 <= pad_space:
            total_length += len(words[j]) + 1
            j += 1

        remaining = pad_space - total_length

        if j != len(words):
            num_spaces = j - i - 1
            if num_spaces > 0:
                quo = remaining // num_spaces
                rem = remaining % num_spaces

                for k in range(i + 1, j):
                    sb.append(' ' * (quo + 1) if rem > 0 else ' ' * quo)
                    rem -= 1
                    sb.append(words[k])
            else:
                sb.append(' ' * remaining)
        else:
            for m in range(i + 1, j):
                sb.append(' ')
                sb.append(words[m])

        result.append(''.join(sb))
        i = j

    return ''.join(result)


def text_justify(input_string: str, pad_space: int) -> str:
    """
    Justify the input string to ensure the total length is equal to `pad_space`.
    """
    if not isinstance(input_string, str) or not isinstance(pad_space, int):
        raise ValueError("Input must be a string and pad_space must be an integer.")
    if input_string is None or pad_space < len(input_string):
        return input_string

    words = input_string.split()
    if not words:
        return input_string

    num_of_words = len(words)
    total_length = len(input_string)
    space = pad_space - total_length + num_of_words - 1

    quo = space // num_of_words
    rem = space % num_of_words

    sb = []
    for i in range(num_of_words):
        sb.append(words[i])
        if i < num_of_words - 1:
            sb.append(' ' * (quo + 1))
            if rem > 0:
                sb.append(' ')
                rem -= 1

    return ''.join(sb)


# Example usage
if __name__ == "__main__":
    print(pad_spaces("Hello world, it is a good day today.", 50))
    print(text_justify("Hello world, it is a good day today.", 50))
