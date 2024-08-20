def remove_space(s1):
    if s1 is None or len(s1) == 0:
        return s1

    count = s1.count(' ')
    if count <= 1:
        return s1

    index = s1.find(' ')
    next_index = s1.find(' ', index + 1)
    if next_index == -1:
        next_index = len(s1)

    return s1[:index] + ' ' + s1[next_index:]

def remove_extra_spaces_efficient(s):
    if s is None:
        return s

    char_array = list(s)
    prev = char_array[0]
    i = 0

    for cur in char_array:
        if cur == ' ' and prev == ' ':
            continue
        else:
            char_array[i] = cur
            i += 1
        prev = cur

    return ''.join(char_array[:i])

def remove_multiple_space(input_string):
    if input_string is None or len(input_string) < 2:
        return input_string

    input_char = list(input_string)
    len_input = len(input_char)

    i = 0
    j = 0
    flag = False

    while j < len_input:
        if not input_char[j].isspace():
            if (input_char[j] in '.?,' and i - 1 >= 0 and input_char[i - 1] == ' '):
                input_char[i - 1] = input_char[j]
            else:
                input_char[i] = input_char[j]
                i += 1
            flag = False
        elif input_char[j].isspace():
            if not flag:
                flag = True
                input_char[i] = ' '
                i += 1
        j += 1

    return ''.join(input_char[:i])

def main():
    s1 = "Jinal    Shah"
    print("output -", remove_space(s1))

    s = "   my    name is    mr    space  "
    print("output -", remove_multiple_space(s))

    text = "This  is   a    test"
    index = 0
    while index >= 0:
        index = text.find("  ")
        if index != -1:
            text = text.replace("  ", " ")
    print("output text -", text)

if __name__ == "__main__":
    main()
