"""
To solve this problem, we will use a greedy approach to determine if it is possible to reach the last index of the array.

Greedy Approach
Initialize a variable max_reachable to keep track of the farthest index we can reach.
Iterate through each index of the array.
Check if the current index is reachable:
If i > max_reachable, it means we cannot reach this index, and we return False.
Update max_reachable to the maximum value between its current value and i + nums[i] (the furthest we can reach from the current index).
If max_reachable reaches or exceeds the last index, return True.

Explanation of the Code
Initialization: Start with max_reachable = 0, indicating the farthest index reachable from the start.
Loop through the array:
Check Reachability: If the current index i is greater than max_reachable, it means we can't reach this index, so return False.
Update max_reachable: Calculate the maximum reachable index by taking the maximum of the current max_reachable and i + nums[i].
Check if Last Index is Reachable: If max_reachable reaches or exceeds len(nums) - 1, return True.
Return Result: If the loop completes without finding that we can reach the last index, return False.
Example Outputs
Input: nums = [2, 3, 1, 1, 4]

Output: True
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
Input: nums = [3, 2, 1, 0, 4]

Output: False
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
This solution runs in O(n) time complexity and O(1) space complexity, making it efficient for large input sizes.

"""

from typing import List
class JumpGameFindPositionedIndexLength:
    @staticmethod
    def canJump(nums: List[int]) -> bool:
        if not all(isinstance(num, int) for num in nums):
            return TypeError("Pass valid input")

        size = len(nums)
        max_reachable = 0
        for index in range(size):
            if index > max_reachable:
                return False

            max_reachable = max(max_reachable, index + nums[index])
            if max_reachable >= len(nums) - 1:
                return True
        return False


if __name__ == "__main__":
    print (JumpGameFindPositionedIndexLength.canJump([2,3,1,1,4]))
    print (JumpGameFindPositionedIndexLength.canJump([3,2,1,0,4]))
    print (JumpGameFindPositionedIndexLength.canJump([2,3,1,2,4]))
    print (JumpGameFindPositionedIndexLength.canJump([4,3,1,2,4]))
    print (JumpGameFindPositionedIndexLength.canJump([5,3,1,2,4]))
    print (JumpGameFindPositionedIndexLength.canJump([1,1,0,5,4]))
    print (JumpGameFindPositionedIndexLength.canJump([3,0,8,2,0,0,1]))

