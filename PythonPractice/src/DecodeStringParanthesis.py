from collections import deque

def decode_string(input_string: str) -> str:
    if not isinstance(input_string, str) or input_string is None or len(input_string) < 1:
        raise ValueError("Pass a valid input string")

    int_deque = deque()
    str_deque = deque()
    sb = []

    i = 0
    length = len(input_string)

    while i < length:
        char = input_string[i]

        if char.isdigit():
            num = int(char)
            while i + 1 < length and input_string[i + 1].isdigit():
                i += 1
                num = num * 10 + int(input_string[i])
            int_deque.append(num)

        elif char == '[':
            str_deque.append(''.join(sb))
            sb = []  # Reset the string builder

        elif char == ']':
            temp = str_deque.pop()
            repeat = int_deque.pop()
            sb = [temp + ''.join(sb) * repeat]

        else:
            sb.append(char)

        i += 1

    return ''.join(sb)

if __name__ == "__main__":
    try:
        print(decode_string("3[a]21[bc]"))
        print(decode_string("3[a2[c]]"))
        print(decode_string("2[abc]3[cd]ef"))
    except ValueError as e:
        print(f"Error: {e}")
