def smallest_distance(array):
    if array is None:
        raise ValueError("Pass valid input")

    size = len(array)
    if size < 2:
        return -1

    smallest = abs(array[0] - array[1])
    index = 0

    for i in range(1, size - 1):
        value = abs(array[i] - array[i + 1])
        if value < smallest:
            smallest = value
            index = i

    return index


if __name__ == "__main__":
    # Test cases
    arr1 = [4, 8, 6, 1, 2, 9, 4]
    arr2 = [1, 1, 1, 1]
    arr3 = [1, 3, 3]

    print(smallest_distance(arr1))  # Output should be the index of the smallest distance
    print(smallest_distance(arr2))  # Output should be the index of the smallest distance
    print(smallest_distance(arr3))  # Output should be the index of the smallest distance
