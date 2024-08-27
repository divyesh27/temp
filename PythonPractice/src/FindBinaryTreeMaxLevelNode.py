from typing import Optional

class TreeNode:
    def __init__(self, data: int):
        self.data: int = data
        self.left: Optional['TreeNode'] = None
        self.right: Optional['TreeNode'] = None

class FindBinaryTreeMaxLevelNode:
    def find_max_level_node(self, root: Optional[TreeNode]) -> int:
        if root is None:
            return -1
        else:
            return 1 + max(self.find_max_level_node(root.left), self.find_max_level_node(root.right))

if __name__ == "__main__":
    bt = FindBinaryTreeMaxLevelNode()
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

    print(bt.find_max_level_node(node))
