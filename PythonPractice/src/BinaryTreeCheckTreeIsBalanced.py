from typing import Optional

class TreeNode:
    def __init__(self, data: int):
        if not isinstance(data, int):
            raise TypeError("Data must be an integer")

        self.data: int = data
        self.left: Optional['TreeNode'] = None
        self.right: Optional['TreeNode'] = None

def find_balance_tree(root: Optional[TreeNode]) -> int:
    if not isinstance(root, (TreeNode, type(None))):
        raise TypeError("Root must be a TreeNode or None")

    if root is None:
        return 0  # Return 0 for height of empty tree

    left_height = find_balance_tree(root.left)
    if left_height == -1:
        return -1  # Left subtree is not balanced

    right_height = find_balance_tree(root.right)
    if right_height == -1:
        return -1  # Right subtree is not balanced

    height_diff = abs(left_height - right_height)
    if height_diff > 1:
        print(f"Tree is not balanced. Height difference: {height_diff}")
        return -1  # Not balanced
    else:
        return max(left_height, right_height) + 1  # Height of the current node

if __name__ == "__main__":
    # Create the binary tree
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

    is_balanced = find_balance_tree(node) != -1
    print("Tree is balanced" if is_balanced else "Tree is not balanced")
