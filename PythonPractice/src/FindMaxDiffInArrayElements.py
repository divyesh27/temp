def max_diff(input_array):
    if input_array is None or len(input_array) < 2:
        return -1

    min_element = input_array[0]
    max_element = float('-inf')

    for i in range(1, len(input_array)):
        if input_array[i] < min_element:
            min_element = input_array[i]
        if input_array[i] > max_element:
            max_element = input_array[i]

    max_diff = max_element - min_element
    return max_diff if max_diff > 0 else -1

if __name__ == "__main__":
    # Test cases
    print(max_diff([2, 3, 10, 6, 4, 8, 1]))  # Output should be 9
    print(max_diff([7, 9, 5, 6, 3, 2]))      # Output should be 7
