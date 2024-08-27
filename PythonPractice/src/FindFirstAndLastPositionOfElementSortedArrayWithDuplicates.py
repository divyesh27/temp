from typing import List, Optional, Tuple

def find_first_and_last_position(nums: Optional[List[int]], target: int) -> List[int]:
    if nums is None or len(nums) <= 1:
        raise ValueError("The input array must not be None and must have more than one element.")

    if not all(isinstance(x, int) for x in nums):
        raise ValueError("The input array must contain only integers.")

    if nums[0] > nums[1] or nums[-2] > nums[-1] or nums[1] > nums[-2]:
        nums.sort()

    low, high = 0, len(nums) - 1

    while low <= high:
        mid = (low + high) // 2
        if nums[mid] == target:
            return find_position_start_end(nums, mid, mid - 1, mid + 1)
        elif nums[mid] > target:
            high = mid - 1
        else:
            low = mid + 1

    raise ValueError("Value not found")

def find_position_start_end(nums: List[int], mid: int, leftpos: int, rightpos: int) -> List[int]:
    size = len(nums) - 1

    while rightpos <= size and nums[rightpos] == nums[mid]:
        rightpos += 1
    while leftpos >= 0 and nums[leftpos] == nums[mid]:
        leftpos -= 1

    return [leftpos + 1, rightpos - 1]

def extreme_insertion_index(nums: List[int], target: int, left: bool) -> int:
    lo, hi = 0, len(nums)

    while lo < hi:
        mid = (lo + hi) // 2
        if nums[mid] > target or (left and target == nums[mid]):
            hi = mid
        else:
            lo = mid + 1

    return lo

def search_range(nums: Optional[List[int]], target: int) -> List[int]:
    if nums is None or len(nums) == 0:
        raise ValueError("The input array must not be None and must have at least one element.")

    if not all(isinstance(x, int) for x in nums):
        raise ValueError("The input array must contain only integers.")

    target_range = [-1, -1]
    left_idx = extreme_insertion_index(nums, target, True)

    if left_idx == len(nums) or nums[left_idx] != target:
        return target_range

    target_range[0] = left_idx
    target_range[1] = extreme_insertion_index(nums, target, False) - 1

    return target_range

def main():
    a = [1, 1, 4, 5, 6, 7, 8, 9, 10, 11, 11, 12, 13, 14, 17, 17, 17, 17, 20]

    try:
        for i in find_first_and_last_position(a, 11):
            print(i)

        for i in search_range(a, 11):
            print(i)
    except ValueError as e:
        print(e)

if __name__ == "__main__":
    main()
