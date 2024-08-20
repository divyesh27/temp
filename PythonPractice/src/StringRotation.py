def is_rotated(s1, s2):
    s1len = len(s1)
    s2len = len(s2)

    if s1len != s2len or s1len == 0:
        return False

    s1s1 = s1 + s1
    return is_substring(s1s1, s2)

def is_substring(big, small):
    return small in big

def main():
    s1 = "apple"
    s2 = "pleap"
    print("Output is -", is_rotated(s1, s2))  # Output: True

if __name__ == "__main__":
    main()
