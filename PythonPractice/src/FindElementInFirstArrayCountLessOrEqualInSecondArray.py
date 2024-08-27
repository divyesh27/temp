from typing import List, Optional

def find_small_or_equal_elements(arr1: Optional[List[int]], arr2: Optional[List[int]]) -> Optional[List[int]]:
    # Check for null inputs
    if arr1 is None or arr2 is None:
        return None

    # Check if both lists contain only integers
    if not all(isinstance(x, int) for x in arr1) or not all(isinstance(x, int) for x in arr2):
        raise ValueError("Both arrays must contain only integers.")

    # Initialize the results list with the same length as arr1
    results = [0] * len(arr1)

    # Sort the second array for binary search
    arr2.sort()

    # Perform binary search for each element in arr1
    for i in range(len(arr1)):
        results[i] = binary_search(arr2, arr1[i])

    return results

def binary_search(arr2: List[int], val: int) -> int:
    start = 0
    end = len(arr2) - 1

    # Implement binary search to find the count of elements less than or equal to val
    while start <= end:
        mid = (start + end) // 2
        if arr2[mid] <= val:
            start = mid + 1
        else:
            end = mid - 1

    # Return the count of elements less than or equal to val
    return end + 1

def main():
    arr1 = [5, 10, 2, 6, 1, 8, 6, 12]
    arr2 = [6, 5, 11, 4, 2, 3, 7]

    try:
        results = find_small_or_equal_elements(arr1, arr2)
        if results is not None:
            for i in results:
                print(i)
        else:
            print("One of the arrays is null.")
    except ValueError as e:
        print(e)

if __name__ == "__main__":
    main()
