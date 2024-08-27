from typing import Optional, List, Deque
from collections import deque

class TreeNode:
    def __init__(self, data: int):
        if not isinstance(data, int):
            raise TypeError("Data must be an integer")

        self.data: int = data
        self.left: Optional['TreeNode'] = None
        self.right: Optional['TreeNode'] = None

def create_list(root: Optional[TreeNode]) -> List[Deque[TreeNode]]:
    if not isinstance(root, (TreeNode, type(None))):
        raise TypeError("Root must be a TreeNode or None")

    lists: List[Deque[TreeNode]] = []
    _create_list(root, lists, 0)
    return lists

def _create_list(root: Optional[TreeNode], lists: List[Deque[TreeNode]], level: int):
    if root is None:
        return

    if len(lists) == level:
        lists.append(deque())

    lists[level].append(root)

    _create_list(root.left, lists, level + 1)
    _create_list(root.right, lists, level + 1)

def display(lists: List[Deque[TreeNode]]):
    if not isinstance(lists, list):
        raise TypeError("Lists must be of type List")

    for level in lists:
        if not isinstance(level, Deque):
            raise TypeError("Each level must be a Deque")

        print("\t".join(str(node.data) for node in level))
        print()

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

    s = create_list(node)
    display(s)
