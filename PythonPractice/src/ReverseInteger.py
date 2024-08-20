def reverse_integer(input):
    if input == 0:
        return 0

    neg = -1
    flag = False
    if input < 0:
        flag = True
        input = -input  # Make input positive for easier processing

    reverse = 0
    while input != 0:
        reverse = reverse * 10 + input % 10
        input = input // 10  # Use integer division

    if flag:
        return -reverse
    return reverse

def main():
    print(reverse_integer(123))
    print(reverse_integer(8765))
    print(reverse_integer(4421))
    print(reverse_integer(222))
    print(reverse_integer(-1002))

if __name__ == "__main__":
    main()
