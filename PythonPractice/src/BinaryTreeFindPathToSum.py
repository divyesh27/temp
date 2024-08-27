from typing import List, Optional

class TreeNode:
    def __init__(self, data: int):
        if not isinstance(data, int):
            raise TypeError("Data must be an integer")

        self.data: int = data
        self.left: Optional['TreeNode'] = None
        self.right: Optional['TreeNode'] = None

class BinaryTreeFindPathToSum:

    def has_path_sum(self, root: Optional[TreeNode], sum: int) -> bool:
        if root is None:
            return False
        if root.left is None and root.right is None:
            return root.data == sum
        return (self.has_path_sum(root.left, sum - root.data) or
                self.has_path_sum(root.right, sum - root.data))

    def path_sum_count(self, root: Optional[TreeNode], sum: int, result: List[List[int]], current_path: List[int]):
        if root is None:
            return

        if root.left is None and root.right is None:
            if root.data == sum:
                current_path.append(root.data)
                result.append(list(current_path))
                current_path.pop()
            return

        current_path.append(root.data)
        self.path_sum_count(root.left, sum - root.data, result, current_path)
        self.path_sum_count(root.right, sum - root.data, result, current_path)
        current_path.pop()

if __name__ == "__main__":
    bt = BinaryTreeFindPathToSum()
    result = []
    current_path = []

    node = TreeNode(5)
    node.right = TreeNode(8)
    node.left = TreeNode(4)
    node.right.left = TreeNode(13)
    node.left.left = TreeNode(11)
    node.left.left.right = TreeNode(2)
    node.right.right = TreeNode(4)
    node.right.right.right = TreeNode(1)
    node.left.left.left = TreeNode(7)
    node.right.right.left = TreeNode(5)

    bt.path_sum_count(node, 22, result, current_path)
    print(result)
