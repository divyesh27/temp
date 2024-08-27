from typing import List

def is_find(arr: List[int], k: int) -> bool:
    if not isinstance(arr, list) or not all(isinstance(x, int) for x in arr):
        raise TypeError("The first argument must be a list of integers")
    if not isinstance(k, int):
        raise TypeError("The second argument must be an integer")

    # Sorting the array
    arr.sort()

    low = 0
    high = len(arr) - 1

    while low <= high:
        mid = (low + high) // 2
        if arr[mid] == k:
            return True
        elif arr[mid] < k:
            low = mid + 1
        else:
            high = mid - 1

    return False

if __name__ == "__main__":
    # Example input
    a = [1, 8, 4, 5, 6, 7, 16, 10, 11, 13, 15]
    k = 11

    # Check if the element is in the list
    result = is_find(a, k)
    print(f"Output is {result}")
