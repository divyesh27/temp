from typing import Optional, List

class TreeNode:
    def __init__(self, data: int):
        if not isinstance(data, int):
            raise TypeError("Data must be an integer")

        self.data: int = data
        self.left: Optional['TreeNode'] = None
        self.right: Optional['TreeNode'] = None

class BinaryTreeMaxPathSum:
    def __init__(self):
        self.root: Optional[TreeNode] = None

    def max_path_sum(self, node: Optional[TreeNode]) -> int:
        if node is None:
            raise ValueError("Node cannot be None")

        if node.left is None and node.right is None:
            return node.data

        max_sum: List[int] = [float('-inf')]
        self.calculate_sum(node, max_sum)
        return max_sum[0]

    def calculate_sum(self, node: Optional[TreeNode], max_sum: List[int]) -> int:
        if node is None:
            return 0

        left: int = self.calculate_sum(node.left, max_sum)
        right: int = self.calculate_sum(node.right, max_sum)

        # Max path for parent call of root, left, and right
        current: int = max(node.data, max(node.data + left, node.data + right))

        # Max path with root as the highest node (not necessarily passing through root)
        max_sum[0] = max(max_sum[0], max(current, left + node.data + right))

        return current

if __name__ == "__main__":
    bt = BinaryTreeMaxPathSum()

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

    print("Root node data:", node.data)
    try:
        print("Maximum Path Sum:", bt.max_path_sum(node))
    except ValueError as e:
        print(f"Error: {e}")
