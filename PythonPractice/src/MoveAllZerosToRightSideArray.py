def move_zeros_to_end(arr):
    """
    Move all zeros in the array to the end, preserving the order of non-zero elements.
    """
    if not isinstance(arr, list) or not all(isinstance(x, int) for x in arr):
        raise ValueError("Input must be a list of integers.")

    if arr is None:
        return

    n = len(arr)
    count = 0
    for i in range(n):
        if arr[i] != 0:
            arr[count] = arr[i]
            count += 1
    while count < n:
        arr[count] = 0
        count += 1


def move_zeros_to_start_and_ones_to_end(arr):
    """
    Move all zeros to the start and ones to the end, preserving the order of other elements.
    """
    if not isinstance(arr, list) or not all(isinstance(x, int) for x in arr):
        raise ValueError("Input must be a list of integers.")

    if arr is None:
        return

    n = len(arr)
    count = n - 1
    for i in range(n - 1, -1, -1):
        if arr[i] != 0:
            arr[count] = arr[i]
            count -= 1
    while count >= 0:
        arr[count] = 0
        count -= 1


def print_array(arr):
    """
    Print the array elements.
    """
    if arr is None:
        print("Array is None")
        return

    if not isinstance(arr, list):
        raise ValueError("Input must be a list.")

    print("Array after pushing zeros to the back/front: ")
    print(" ".join(map(str, arr)))


# Example usage
if __name__ == "__main__":
    arr = [1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0, 9]
    n = len(arr)

    move_zeros_to_end(arr)
    print_array(arr)

    move_zeros_to_start_and_ones_to_end(arr)
    print_array(arr)
