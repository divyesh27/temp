def find_missing_number_ap(input_list):
    if not input_list or len(input_list) < 3:
        return "Input array should have at least 3 elements."

    low = 0
    high = len(input_list) - 1
    common_difference = (input_list[high] - input_list[low]) // len(input_list)

    while low <= high:
        middle = (low + high) // 2
        expected_value = input_list[0] + middle * common_difference

        if input_list[middle] == expected_value:
            low = middle + 1
        elif input_list[middle] > expected_value and input_list[middle - 1] == input_list[0] + (middle - 1) * common_difference:
            return expected_value
        else:
            high = middle - 1

    return -1


def find_missing_number_1_to_n(input_list):
    if not input_list or len(input_list) < 2:
        return "Input array should have at least 2 elements."

    low_num = input_list[0]
    low = 0
    high = len(input_list) - 1

    while low <= high:
        middle = (low + high) // 2

        if input_list[middle] == (middle + 1 + low_num) and middle - 1 >= 0 and input_list[middle - 1] == (middle + low_num - 1):
            return middle + low_num
        elif (middle + low_num) == input_list[middle]:
            low = middle + 1
        else:
            high = middle - 1

    return -1


if __name__ == "__main__":
    input_data1 = [1, 3, 7, 9, 11, 13]
    input_data2 = [3, 4, 5, 6, 7, 8, 9, 10, 11, 12]
    input_data3 = [-5, -4, -3, -1, 0, 1, 2, 3]

    print(find_missing_number_ap(input_data1))   # Output should be 5
    print(find_missing_number_1_to_n(input_data2))  # Output should be 2
    print(find_missing_number_1_to_n(input_data3))  # Output should be -2
