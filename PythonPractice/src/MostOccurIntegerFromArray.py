from collections import defaultdict
from typing import List, Optional

def find_most_occurring_int(arr: Optional[List[int]]) -> Optional[int]:
    """
    Find the integer that occurs the most in the array.

    Args:
    arr (Optional[List[int]]): The input array of integers.

    Returns:
    Optional[int]: The integer that occurs the most. Returns None if input is None or empty.
    """
    if arr is None or len(arr) == 0:
        return None

    if not all(isinstance(x, int) for x in arr):
        raise ValueError("Input must be a list of integers.")

    count_map = defaultdict(int)

    # Populate the count_map with the frequency of each integer
    for num in arr:
        count_map[num] += 1

    # Find the integer with the maximum frequency
    most_occurring = max(count_map.items(), key=lambda item: item[1])[0]

    return most_occurring

# Example usage
if __name__ == "__main__":
    input_array = [2, 3, 4, 5, 2, 3, 2]
    print(find_most_occurring_int(input_array))
