"""
To solve this problem, we will use a greedy approach to determine if it is possible to reach the last index of the array.

Greedy Approach
You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].

Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at nums[i], you can jump to any nums[i + j] where:

0 <= j <= nums[i] and
i + j < n
Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].



Example 1:

Input: nums = [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [2,3,0,1,4]
Output: 2


Constraints:

1 <= nums.length <= 104
0 <= nums[i] <= 1000
It's guaranteed that you can reach nums[n - 1]

Initialization: We initialize jumps to 0 since no jumps are required initially. We also use current_end to keep track of the end of the current jump's range and farthest to track the furthest index reachable within that range.

Iterating Through nums:

Loop through the array until the second last element (n-1), as we only need to consider jumps to reach or exceed the last index.
Update farthest to the maximum reach achievable from the current index.
Handling Jump Counts:

When i reaches current_end, it means we need to make another jump. Update the number of jumps and set current_end to farthest.
Termination: The loop terminates early if current_end reaches or exceeds n - 1, ensuring that we only count the necessary jumps.


Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
This solution runs in O(n) time complexity and O(1) space complexity, making it efficient for large input sizes.

"""

from typing import List
class JumpGameFindPositionedIndexMinJump:
    @staticmethod
    def canJump(nums: List[int]) -> int:
        if not all(isinstance(num, int) for num in nums):
            return TypeError("Pass valid input")

        size = len(nums)
        if size <= 1:
            return 0 # No jump needed for one element

        max_reachable = 0
        jumps = 0
        current_end = 0

        for index in range(size-1):

            max_reachable = max(max_reachable, index + nums[index])
            if index == current_end:
                jumps += 1
                current_end = max_reachable
                if current_end >= size-1:
                    break

        return jumps


if __name__ == "__main__":
    print (JumpGameFindPositionedIndexMinJump.canJump([2,3,1,1,4]))
    print (JumpGameFindPositionedIndexMinJump.canJump([3,2,1,0,4]))
    print (JumpGameFindPositionedIndexMinJump.canJump([2,3,1,2,4]))
    print (JumpGameFindPositionedIndexMinJump.canJump([4,3,1,2,4]))
    print (JumpGameFindPositionedIndexMinJump.canJump([5,3,1,2,4]))
    print (JumpGameFindPositionedIndexMinJump.canJump([1,1,0,5,4]))
    print (JumpGameFindPositionedIndexMinJump.canJump([3,0,8,2,0,0,1]))

