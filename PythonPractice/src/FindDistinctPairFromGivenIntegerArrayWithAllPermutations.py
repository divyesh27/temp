from typing import List

def subsets(nums: List[int]) -> List[List[int]]:
    # Check if nums is None or not a list
    if nums is None:
        raise ValueError("Input cannot be None.")
    if not isinstance(nums, list) or not all(isinstance(num, int) for num in nums):
        raise ValueError("Input must be a list of integers.")

    result: List[List[int]] = []
    nums.sort()  # Sorting to handle duplicates
    backtrack(nums, 0, [], result)
    return result

def backtrack(nums: List[int], start: int, curr: List[int], result: List[List[int]]):
    result.append(curr[:])  # Add a copy of the current subset to the result

    for i in range(start, len(nums)):
        # Skip duplicates
        if i > start and nums[i] == nums[i - 1]:
            continue
        curr.append(nums[i])
        backtrack(nums, i + 1, curr, result)  # Explore further
        curr.pop()  # Backtrack

def main():
    try:
        print(subsets([3, 5, 7, 9]))  # Example usage
    except ValueError as e:
        print(e)

if __name__ == "__main__":
    main()
