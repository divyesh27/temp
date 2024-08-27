from typing import Optional

class Node:
    def __init__(self, key: int):
        if not isinstance(key, int):
            raise TypeError("Key must be an integer")
        self.key: int = key
        self.right_child: Optional['Node'] = None
        self.left_child: Optional['Node'] = None

class BinaryTreePruneIgnoreZeroChildNodeAndConsiderOne:

    def prune_tree_based_on_zero_and_one(self, root: Optional[Node]) -> Optional[Node]:
        if root is None or not isinstance(root, Node):
            return None
        return root if self.contains_one(root) else None

    @staticmethod
    def contains_one(root: Optional[Node]) -> bool:
        if root is None:
            return False

        left_contains_one = BinaryTreePruneIgnoreZeroChildNodeAndConsiderOne.contains_one(root.left_child)
        right_contains_one = BinaryTreePruneIgnoreZeroChildNodeAndConsiderOne.contains_one(root.right_child)

        if not left_contains_one:
            root.left_child = None
        if not right_contains_one:
            root.right_child = None

        return root.key == 1 or left_contains_one or right_contains_one

    @staticmethod
    def print_tree(result: Optional[Node]):
        if result is None:
            return
        BinaryTreePruneIgnoreZeroChildNodeAndConsiderOne.print_tree(result.left_child)
        BinaryTreePruneIgnoreZeroChildNodeAndConsiderOne.print_tree(result.right_child)
        print(result.key)

if __name__ == "__main__":
    bt = BinaryTreePruneIgnoreZeroChildNodeAndConsiderOne()

    root = Node(1)
    root.left_child = Node(1)
    root.right_child = Node(1)
    root.left_child.right_child = Node(0)
    root.right_child.right_child = Node(1)
    root.left_child.left_child = Node(1)

    result = bt.prune_tree_based_on_zero_and_one(root)
    bt.print_tree(result)
