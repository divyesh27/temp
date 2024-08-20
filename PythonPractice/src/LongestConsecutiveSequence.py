from typing import List, Set

def longest_consecutive_sequence(nums: List[int]) -> int:
    if not isinstance(nums, list) or not all(isinstance(x, int) for x in nums):
        raise ValueError("Input must be a list of integers")

    if len(nums) == 0:
        return 0

    num_set: Set[int] = set(nums)
    max_length = 1

    for num in nums:
        if num - 1 not in num_set:
            current_num = num
            current_length = 1

            while current_num + 1 in num_set:
                current_num += 1
                current_length += 1

            max_length = max(max_length, current_length)

    return max_length

# Example usage
if __name__ == "__main__":
    # Test cases
    num1 = [100, 4, 200, 1, 3, 2]
    num2 = [1, 9, 3, 10, 4, 20, 2]
    num3 = [36, 41, 56, 35, 44, 33, 34, 92, 43, 32, 42]

    print(longest_consecutive_sequence(num1))  # Output: 4
    print(longest_consecutive_sequence(num2))  # Output: 4
    print(longest_consecutive_sequence(num3))  # Output: 5
