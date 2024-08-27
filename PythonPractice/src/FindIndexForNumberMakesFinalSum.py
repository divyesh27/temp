from typing import List, Dict, Optional

def two_target_sum(nums: Optional[List[int]], target: int) -> List[int]:
    if nums is None:
        raise ValueError("The input array must not be None.")
    if not isinstance(nums, list) or not all(isinstance(i, int) for i in nums):
        raise ValueError("The input must be a list of integers.")
    if len(nums) < 2:
        raise ValueError("The input array must contain at least two elements.")
    if not isinstance(target, int):
        raise ValueError("The target must be an integer.")

    for i in range(len(nums)):
        for j in range(i + 1, len(nums)):
            if nums[j] == target - nums[i]:
                return [i, j]

    raise ValueError("No two sum solution")

def two_sum_hash_final_target(nums: Optional[List[int]], target: int) -> List[int]:
    if nums is None:
        raise ValueError("The input array must not be None.")
    if not isinstance(nums, list) or not all(isinstance(i, int) for i in nums):
        raise ValueError("The input must be a list of integers.")
    if len(nums) < 2:
        raise ValueError("The input array must contain at least two elements.")
    if not isinstance(target, int):
        raise ValueError("The target must be an integer.")

    mp: Dict[int, int] = {}
    for i in range(len(nums)):
        complement = target - nums[i]
        if complement in mp:
            return [mp[complement], i]
        mp[nums[i]] = i

    raise ValueError("No two sum solution")

def main():
    nums = [2, 3, 64, 32, 67, 2, 6, 11, 4]
    target = 5

    try:
        print(two_target_sum(nums, target))
    except ValueError as e:
        print(e)

    try:
        print(two_sum_hash_final_target(nums, target))
    except ValueError as e:
        print(e)

if __name__ == "__main__":
    main()
