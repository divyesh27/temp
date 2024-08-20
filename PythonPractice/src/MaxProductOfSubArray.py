def product_of_subarray_contiguous(input_array):
    """
    Finds the maximum product of a contiguous subarray.

    Args:
    input_array (List[int]): List of integers.

    Returns:
    int: Maximum product of a contiguous subarray.
    """
    if not input_array:
        raise ValueError("Input array cannot be empty")

    if not all(isinstance(x, int) for x in input_array):
        raise TypeError("Input array must contain only integers")

    max_value = min_value = max_product = input_array[0]

    for i in range(1, len(input_array)):
        if input_array[i] < 0:
            max_value, min_value = min_value, max_value

        max_value = max(input_array[i], max_value * input_array[i])
        min_value = min(input_array[i], min_value * input_array[i])

        max_product = max(max_product, max_value)

    return max_product

if __name__ == "__main__":
    print(product_of_subarray_contiguous([-1, -3, -10, 0, 60]))  # Example 1
    print(product_of_subarray_contiguous([6, -3, -10, 0, 2]))   # Example 2
    print(product_of_subarray_contiguous([-2, -3, 0, -2, -40])) # Example 3
    print(product_of_subarray_contiguous([1, -2, -3, 0, 7, -8, -2])) # Example 4
    print(product_of_subarray_contiguous([0, 7, -8, -2]))       # Example 5
