def find_min_element_rotate_sorted_array(input_array):
    if not input_array or len(input_array) < 1:
        return "Input array should not be null or empty."

    start = 0
    end = len(input_array) - 1

    while start < end:
        # If the array is already sorted, return the first element
        if input_array[start] < input_array[end]:
            return input_array[start]

        mid = (start + end) // 2

        # Determine the side where the minimum element resides
        if input_array[mid] >= input_array[start]:
            start = mid + 1
        else:
            end = mid

    return input_array[start]


if __name__ == "__main__":
    # Test cases
    input_data1 = [4, 5, 6, 7, 0, 1, 2]
    input_data2 = [3, 4, 5, 1, 2]

    print(find_min_element_rotate_sorted_array(input_data1))  # Output should be 0
    print(find_min_element_rotate_sorted_array(input_data2))  # Output should be 1
