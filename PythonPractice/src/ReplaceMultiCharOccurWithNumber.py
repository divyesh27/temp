def replace_mult_char_occur_with_number(s):
    if s is None or len(s) == 0:
        return s

    c = s[0]
    count = 0
    result = []

    for t in s:
        if t == c:
            count += 1
        else:
            result.append(c)
            if count > 1:
                result.append(str(count))  # Convert count to string for concatenation
            count = 1
            c = t

    # Append the last character and its count
    result.append(c)
    if count > 1:
        result.append(str(count))

    return ''.join(result)

def main():
    print(replace_mult_char_occur_with_number("aaaabbbbcdddee"))
    print(replace_mult_char_occur_with_number("abbbbcddde"))

if __name__ == "__main__":
    main()
