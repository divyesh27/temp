from typing import List

def count_duplicate(numbers: List[int]) -> int:
    if not isinstance(numbers, list):
        raise ValueError("Input must be a list")

    if any(not isinstance(num, int) for num in numbers):
        raise ValueError("All elements in the list must be integers")

    if len(numbers) < 3 or len(numbers) > 10000:
        raise ValueError("The list length must be between 3 and 10,000")

    if any(num < 1 or num > 1000 for num in numbers):
        raise ValueError("All integers must be between 1 and 1000")

    count = 0
    frequency_map = {}

    # Count the frequency of each element in the list
    for num in numbers:
        if num in frequency_map:
            frequency_map[num] += 1
        else:
            frequency_map[num] = 1

    # Count the number of elements that occur more than once
    for frequency in frequency_map.values():
        if frequency > 1:
            count += 1

    return count

if __name__ == "__main__":
    try:
        # Test case
        print(count_duplicate([1, 2, 3, 4, 5, 2, 3, 5]))  # Output should be 3
    except ValueError as e:
        print(f"Error: {e}")
