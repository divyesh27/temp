from typing import List, Optional

def binary_search(input_list: Optional[List[int]], low: int, high: int) -> int:
    # Check for null inputs
    if input_list is None:
        raise ValueError("Input list cannot be None.")

    # Check if all elements in the list are integers
    if not all(isinstance(x, int) for x in input_list):
        raise ValueError("Input list must contain only integers.")

    # Perform binary search to find the fixed point
    if low <= high:
        mid = (low + high) // 2

        # Check if the mid index is equal to the element at mid
        if mid == input_list[mid]:
            return mid

        # If mid index is greater, search in the left subarray
        elif mid < input_list[mid]:
            return binary_search(input_list, low, mid - 1)

        # If mid index is less, search in the right subarray
        else:
            return binary_search(input_list, mid + 1, high)

    # Return -1 if no fixed point is found
    return -1

def main():
    arr = [-10, -1, 0, 3, 10, 11, 30, 50, 100]

    try:
        result = binary_search(arr, 0, len(arr) - 1)
        if result != -1:
            print(f"Fixed Point is {result}")
        else:
            print("No fixed point found in the array.")
    except ValueError as e:
        print(e)

if __name__ == "__main__":
    main()
