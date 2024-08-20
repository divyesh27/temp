from typing import List, Optional

def find_middle_value(arr: Optional[List[int]]) -> Optional[int]:
    """
    Find the middle value of an array if the length is odd.

    Args:
    arr (Optional[List[int]]): The input list of integers.

    Returns:
    Optional[int]: The middle value if the length of the list is odd, otherwise None.
    """
    if arr is None or len(arr) == 0:
        return None

    if not all(isinstance(x, int) for x in arr):
        raise ValueError("All elements in the list must be integers.")

    # Sort the array
    sorted_arr = sorted(arr)
    length = len(sorted_arr)

    # Check if the length is odd and return the middle value
    if length % 2 == 1:
        return sorted_arr[length // 2]
    else:
        return None

# Example usage
if __name__ == "__main__":
    result = find_middle_value([1, 2, 3, 5, 6, 7, 4])
    if result is not None:
        print(f"Middle value is - {result}")
    else:
        print("The list is empty or the length is not odd.")
