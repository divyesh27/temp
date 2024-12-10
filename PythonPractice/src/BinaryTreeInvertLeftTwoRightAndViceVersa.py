from typing import Optional, List
from collections import deque
class TreeNode:
    def __init__(self, data: int):
        if not isinstance(data, int):
            raise TypeError("Data must be an integer")

        self.data: int = data
        self.left: Optional['Node'] = None
        self.right: Optional['Node'] = None


class BinaryTreeInvertLeftTwoRightAndViceVersa:

    def invertTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        if root is None:
            return root

        root.left, root.right = root.right, root.left
        self.invertTree(root.left)
        self.invertTree(root.right)
        return root

    def display(self, root: Optional[TreeNode]) -> None:

        if root is not None:
            print(f"Number {root.data}")
            self.display(root.left)
            self.display(root.right)
            #print(f"Number {root.data}")

    def level_order_traversal(self, root : Optional[TreeNode]) -> List[int]:
        if not root:
            return []
        result = []
        queue = deque([root])
        while queue:
            node = queue.popleft()
            result.append(node.data if node else None)
            if node:
                queue.append(node.left)
                queue.append(node.right)
        # Remove trailing Nones from the result
        while result and result[-1] is None:
            result.pop()
        return result

if __name__ == "__main__":

    tree = BinaryTreeInvertLeftTwoRightAndViceVersa()
    tree.root = TreeNode(4)
    tree.root.left = TreeNode(2)
    tree.root.right = TreeNode(7)
    tree.root.left.left = TreeNode(1)
    tree.root.left.right = TreeNode(3)
    tree.root.right.left = TreeNode(6)
    tree.root.right.right = TreeNode(9)

    tree.display(tree.invertTree(tree.root))
    print ("*************")
    print (tree.level_order_traversal(tree.root))