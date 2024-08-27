from typing import Optional

class Node:
    def __init__(self, data: int):
        if not isinstance(data, int):
            raise TypeError("Data must be an integer")

        self.data: int = data
        self.left: Optional['Node'] = None
        self.right: Optional['Node'] = None

class BinaryTreeMirrorAndSymmetricTree:
    def __init__(self):
        self.a: Optional[Node] = None
        self.b: Optional[Node] = None
        self.root: Optional[Node] = None

    def tree_mirror(self, a: Optional[Node], b: Optional[Node]) -> bool:
        if a is None and b is None:
            return True
        if a is None or b is None:
            return False

        return (a.data == b.data and
                self.tree_mirror(a.left, b.right) and
                self.tree_mirror(a.right, b.left))

    def tree_symmetric(self, root: Optional[Node]) -> bool:
        if root is None:
            raise ValueError("Root cannot be None")
        return self.tree_mirror(root, root)

if __name__ == "__main__":
    tree = BinaryTreeMirrorAndSymmetricTree()

    tree.a = Node(1)
    tree.b = Node(1)

    tree.a.left = Node(2)
    tree.a.right = Node(3)
    tree.a.left.left = Node(4)
    tree.a.left.right = Node(5)

    tree.b.left = Node(3)
    tree.b.right = Node(2)
    tree.b.right.left = Node(5)
    tree.b.right.right = Node(4)

    tree.root = Node(1)
    tree.root.left = Node(2)
    tree.root.right = Node(2)
    tree.root.left.left = Node(3)
    tree.root.left.right = Node(4)
    tree.root.right.left = Node(4)
    tree.root.right.right = Node(3)

    if tree.tree_mirror(tree.a, tree.b):
        print("Yes, trees are mirror images")
    else:
        print("No, trees are not mirror images")

    if tree.tree_symmetric(tree.root):
        print("Yes, the subtree is a mirror image")
    else:
        print("No, the subtree is not a mirror image")
