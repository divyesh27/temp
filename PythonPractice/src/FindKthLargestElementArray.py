from typing import List, Optional
import heapq

def find_kth_largest_element(nums: Optional[List[int]], k: int) -> int:
    if nums is None:
        raise ValueError("The input array must not be None.")
    if not isinstance(nums, list) or not all(isinstance(i, int) for i in nums):
        raise ValueError("The input must be a list of integers.")
    if len(nums) <= 1:
        raise ValueError("The input array must contain more than one element.")
    if k <= 0 or not isinstance(k, int):
        raise ValueError("k must be a positive integer.")

    nums.sort()
    return nums[-k]

def find_kth_largest_num(nums: Optional[List[int]], k: int) -> int:
    if nums is None:
        raise ValueError("The input array must not be None.")
    if not isinstance(nums, list) or not all(isinstance(i, int) for i in nums):
        raise ValueError("The input must be a list of integers.")
    if len(nums) < 1:
        raise ValueError("The input array must contain at least one element.")
    if k <= 0 or not isinstance(k, int):
        raise ValueError("k must be a positive integer.")

    min_heap = []
    for num in nums:
        heapq.heappush(min_heap, num)
        if len(min_heap) > k:
            heapq.heappop(min_heap)

    return min_heap[0]

def k_largest(nums: Optional[List[int]], k: int) -> None:
    if nums is None:
        raise ValueError("The input array must not be None.")
    if not isinstance(nums, list) or not all(isinstance(i, int) for i in nums):
        raise ValueError("The input must be a list of integers.")
    if len(nums) < 1:
        raise ValueError("The input array must contain at least one element.")
    if k <= 0 or not isinstance(k, int):
        raise ValueError("k must be a positive integer.")
    if k > len(nums):
        raise ValueError("k must not be greater than the length of the array.")

    nums.sort(reverse=True)
    for i in range(k):
        print(nums[i], end=" ")
    print()

def main():
    nums = [13, 2, 1, 5, 6, 4, -1, -2]
    print(find_kth_largest_num(nums, 2))
    k_largest(nums, 3)

if __name__ == "__main__":
    main()
