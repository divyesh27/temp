import re

def main():
    s1 = "I am Jinal Jinal Jinal I am Jinal"
    find = "Jinal"
    replace = "Kinal"

    # print("Output is =", find_replace(s1, find, replace))
    print("Output is =", find_replace_regex(s1, find, replace))

def find_replace(s1: str, find: str, replace: str) -> str:
    if len(s1) == 0 or len(find) == 0 or len(replace) == 0:
        return s1

    last_index = 0
    index = s1.find(find)
    buffer = []

    while index != -1:
        buffer.append(s1[last_index:index])
        buffer.append(replace)
        last_index = index + len(find)
        index = s1.find(find, last_index)

    buffer.append(s1[last_index:])
    return ''.join(buffer)

def find_replace_regex(s1: str, find: str, replace: str) -> str:
    if len(s1) == 0 or len(find) == 0 or len(replace) == 0:
        return s1

    pattern = re.compile(find)
    return pattern.sub(replace, s1)

if __name__ == "__main__":
    main()
