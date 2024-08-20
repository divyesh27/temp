def rev_string(s: str) -> str:
    if s is None or len(s) <= 1:
        return s

    s_list = list(s)
    start = 0
    end = len(s_list) - 1

    while start <= end:
        s_list[start], s_list[end] = s_list[end], s_list[start]
        start += 1
        end -= 1

    return ''.join(s_list)


def rev_string_without_extra_mem(s: str) -> str:
    for i in range(len(s)):
        s = s[1:len(s) - i] + s[0] + s[len(s) - i:]
    return s


def rev_string_without_extra_mem_1(s: str) -> str:
    length = len(s)
    for i in range(length - 1, -1, -1):
        s += s[i]
    s = s[length:]
    return s


def reverse_string_alphabets_only_ignore_others(s: str) -> str:
    if s is None or len(s) == 0:
        return s

    s_list = list(s)
    start = 0
    end = len(s_list) - 1

    while start < end:
        if s_list[start].isalpha() and s_list[end].isalpha():
            s_list[start], s_list[end] = s_list[end], s_list[start]
            start += 1
            end -= 1
        elif s_list[start].isalpha() and not s_list[end].isalpha():
            end -= 1
        elif not s_list[start].isalpha() and s_list[end].isalpha():
            start += 1
        else:
            start += 1
            end -= 1

    return ''.join(s_list)


def main():
    print(rev_string("Divyesh"))  # Output: "hseyviD"
    print(rev_string_without_extra_mem("Divyesh Shah"))  # Output: "ShahDivyesh "
    print(rev_string_without_extra_mem_1("Divyesh Shah"))  # Output: "hahS hseyiD"
    print(reverse_string_alphabets_only_ignore_others("a3b5%dfy%67df^cs"))  # Output: "s3c5%fdd%67yf^ba"


if __name__ == "__main__":
    main()
