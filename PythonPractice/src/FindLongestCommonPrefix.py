from typing import List

def find_long_common_prefix_in_string(str_list: List[str]) -> str:
    if str_list is None or len(str_list) == 0:
        return ""

    prefix = str_list[0]

    for i in range(1, len(str_list)):
        # Type check and conversion to string, if needed
        if not isinstance(str_list[i], str):
            str_list[i] = str(str_list[i])

        while str_list[i].find(prefix) != 0:
            prefix = prefix[:len(prefix) - 1]
            if not prefix:
                return ""

    return prefix

def find_longest_common_prefix(input_string: List[str]) -> str:
    if input_string is None or len(input_string) < 2:
        raise ValueError("Pass a valid input")

    # Convert to string in case of non-string elements
    input_string = [str(s) for s in input_string]

    max_length = len(input_string[0])
    comp = input_string[0]

    for i in range(1, len(input_string)):
        temp = input_string[i]
        j = 0
        k = 0

        while k < len(temp) and k < max_length:
            if temp[j] == comp[j]:
                j += 1
            k += 1

        if j < max_length:
            max_length = j

    return input_string[0][:max_length]

def main():
    input = ["f", "flower", "flower", "flower", "flower", "flowea"]
    input1 = ["dog", "racecar", "car"]
    input2 = ["maggi", "magic", "magical"]

    print(find_long_common_prefix_in_string(input))
    print(find_long_common_prefix_in_string(input1))
    print(find_long_common_prefix_in_string(input2))

    print(find_longest_common_prefix(input))
    print(find_longest_common_prefix(input1))
    print(find_longest_common_prefix(input2))

if __name__ == "__main__":
    main()
