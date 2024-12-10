"""
Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.

Return the smallest level x such that the sum of all the values of nodes at level x is maximal.



Example 1:


Input: root = [1,7,0,7,-8,null,null]
Output: 2
Explanation:
Level 1 sum = 1.
Level 2 sum = 7 + 0 = 7.
Level 3 sum = 7 + -8 = -1.
So we return the level with the maximum sum which is level 2.
Example 2:

Input: root = [989,null,10250,98693,-89388,null,null,null,-32127]
Output: 2

"""

from typing import Optional
from collections import deque
class TreeNode:
    def __init__(self, data: int):
        self.data: int = data
        self.left: Optional['TreeNode'] = None
        self.right: Optional['TreeNode'] = None

class FindBinaryTreeMaxLevelNodeSum:
    def __init__(self):
        self.arr = [0] * 1000

    def find_max_level_node_sum(self, root: Optional[TreeNode]) -> int:
        if root is None:
            raise ValueError("Root cannot be None")

        self._in_order(root, 1)
        index_max = 0
        for i in range(1000):
            if self.arr[i] > self.arr[index_max]:
                index_max = i
        return index_max

    def _in_order(self, root: Optional[TreeNode], level: int):
        if root is not None:
            self._in_order(root.left, level + 1)
            self.arr[level] += root.data
            self._in_order(root.right, level + 1)

    def maxLevelSum(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0

        max_sum = float('-inf')  # Initialize max_sum as the smallest possible value
        max_level = 1  # The level that gives the maximum sum
        current_level = 1  # Start at level 1

        # Queue for BFS, initialized with the root node
        queue = deque([root])

        while queue:
            level_sum = 0  # Sum of the current level
            level_size = len(queue)  # Number of nodes at the current level

            # Process all nodes at the current level
            for _ in range(level_size):
                node = queue.popleft()
                level_sum += node.data

                # Add the left and right children if they exist
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)

            # Update max_sum and max_level if we find a larger sum
            if level_sum > max_sum:
                max_sum = level_sum
                max_level = current_level

            # Move to the next level
            current_level += 1

        return max_level

if __name__ == "__main__":
    bt = FindBinaryTreeMaxLevelNodeSum()
    node = TreeNode(35)
    node.right = TreeNode(50)
    node.left = TreeNode(25)
    node.right.left = TreeNode(45)
    node.left.right = TreeNode(30)
    node.left.left = TreeNode(15)
    node.right.right = TreeNode(65)
    node.right.right.right = TreeNode(-100)
    node.left.left.left = TreeNode(10)
    node.right.left.left = TreeNode(50)
    node.right.right.right.right = TreeNode(150)
    print(bt.find_max_level_node_sum(node))
    print("------**********---------")
    print(bt.maxLevelSum(node))
