def count_substring(main_str: str, sub_str: str) -> int:
    if main_str is None or sub_str is None or len(main_str) < len(sub_str):
        return -1

    count = 0
    sub_count = 0
    for i in range(len(main_str)):
        if sub_count != len(sub_str) and main_str[i] == sub_str[sub_count]:
            sub_count += 1
        elif sub_count > 0:
            sub_count = 0

        if sub_count == len(sub_str):
            count += 1
            sub_count = 0

    return count

if __name__ == "__main__":
    count = count_substring("aabcdedfaafadfagafaeerwaa", "aa")
    print(count)
