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
        self.max_sum = float('-inf')

    def max_path_sum(self, node: Optional[TreeNode]) -> int:
        if node is None:
            raise ValueError("Node cannot be None")

        def calculate_sum(node: Optional[TreeNode]) -> int:
            if node is None:
                return 0

            # Calculate maximum path sum through left and right children, only taking positive contributions
            left = max(calculate_sum(node.left), 0)
            right = max(calculate_sum(node.right), 0)

            # Current node's maximum path sum (as the root of a subtree)
            current_max = node.data + left + right

            # Update the global maximum path sum
            self.max_sum = max(self.max_sum, current_max)

            # Return the maximum sum path "including" the current node for one side (either left or right)
            return node.data + max(left, right)

        # Start the recursive function
        calculate_sum(node)
        return self.max_sum

if __name__ == "__main__":
    # Construct the binary tree
    root = TreeNode(35)
    root.right = TreeNode(50)
    root.left = TreeNode(25)
    root.right.left = TreeNode(45)
    root.left.right = TreeNode(30)
    root.left.left = TreeNode(15)
    root.right.right = TreeNode(65)
    root.right.right.right = TreeNode(-100)
    root.left.left.left = TreeNode(10)
    root.right.left.left = TreeNode(50)

    # Calculate and print the maximum path sum
    bt = BinaryTreeMaxPathSum()
    print("Root node data:", root.data)
    try:
        print("Maximum Path Sum:", bt.max_path_sum(root))
    except ValueError as e:
        print(f"Error: {e}")
