def find_median_sorted_arrays(input_array1, input_array2):
    if input_array1 is None or input_array2 is None or len(input_array1) < 1 or len(input_array2) < 1:
        raise ValueError("Pass valid input")

    if len(input_array1) > len(input_array2):
        return find_median_sorted_arrays(input_array2, input_array1)

    x, y = len(input_array1), len(input_array2)
    low, high = 0, x

    while low <= high:
        partition_x = (low + high) // 2
        partition_y = ((x + y + 1) // 2) - partition_x

        max_left_x = float('-inf') if partition_x == 0 else input_array1[partition_x - 1]
        min_right_x = float('inf') if partition_x == x else input_array1[partition_x]

        max_left_y = float('-inf') if partition_y == 0 else input_array2[partition_y - 1]
        min_right_y = float('inf') if partition_y == y else input_array2[partition_y]

        if max_left_x <= min_right_y and max_left_y <= min_right_x:
            if (x + y) % 2 == 0:
                return (max(max_left_x, max_left_y) + min(min_right_x, min_right_y)) / 2
            else:
                return max(max_left_x, max_left_y)
        elif max_left_x > min_right_y:
            high = partition_x - 1
        else:
            low = partition_x + 1

    raise ValueError("Pass valid input")


def find_median_sort_arrays_diff_size(input1, input2):
    if input1 is None or input2 is None or len(input1) < 1 or len(input2) < 1:
        raise ValueError("Pass valid input")

    combined_array = []
    len1, len2 = len(input1), len(input2)
    i, j = 0, 0

    while i < len1 and j < len2:
        if input1[i] < input2[j]:
            combined_array.append(input1[i])
            i += 1
        else:
            combined_array.append(input2[j])
            j += 1

    while i < len1:
        combined_array.append(input1[i])
        i += 1

    while j < len2:
        combined_array.append(input2[j])
        j += 1

    total_len = len1 + len2
    if total_len % 2 == 0:
        return (combined_array[total_len // 2 - 1] + combined_array[total_len // 2]) / 2
    else:
        return combined_array[total_len // 2]


if __name__ == "__main__":
    # Test cases
    input1 = [1, 3, 8, 9, 15]
    input2 = [7, 11, 18, 19, 21, 25]

    print(find_median_sorted_arrays(input1, input2))  # Output should be 11.0
    print(find_median_sort_arrays_diff_size(input1, input2))  # Output should be 11.0
