from typing import Optional

class TreeNode:
    def __init__(self, data: int):
        if not isinstance(data, int):
            raise TypeError("Data must be an integer")

        self.data: int = data
        self.left: Optional['TreeNode'] = None
        self.right: Optional['TreeNode'] = None

def find_min_value_binary_tree(root: Optional[TreeNode]) -> int:
    if root is None:
        return float('inf')  # Using infinity to represent the maximum possible value

    min_value = root.data

    lmin = find_min_value_binary_tree(root.left)
    rmin = find_min_value_binary_tree(root.right)

    if lmin < min_value:
        min_value = lmin
    if rmin < min_value:
        min_value = rmin

    return min_value

def find_max_value_binary_tree(root: Optional[TreeNode]) -> int:
    if root is None:
        return float('-inf')  # Using negative infinity to represent the minimum possible value

    max_value = root.data

    lmax = find_max_value_binary_tree(root.left)
    rmax = find_max_value_binary_tree(root.right)

    if lmax > max_value:
        max_value = lmax
    if rmax > max_value:
        max_value = rmax

    return max_value

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
    node.left.left.left.left = TreeNode(11)
    node.left.left.left.right = TreeNode(15)
    node.left.left.left.left.right = TreeNode(14)
    node.left.left.left.right.right = TreeNode(16)
    node.left.left.left.right.right.left = TreeNode(17)

    print("Minimum value:", find_min_value_binary_tree(node))
    print("Maximum value:", find_max_value_binary_tree(node))
