from typing import Optional

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
