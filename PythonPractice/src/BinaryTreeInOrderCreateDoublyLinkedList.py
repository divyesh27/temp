from typing import Optional

class Node:
    def __init__(self, data: int):
        if not isinstance(data, int):
            raise TypeError("Data must be an integer")

        self.data: int = data
        self.right: Optional['Node'] = None
        self.left: Optional['Node'] = None

class BinaryTreeInOrderCreateDoublyLinkedList:
    def __init__(self):
        self.first: Optional[Node] = None
        self.last: Optional[Node] = None

    def create_doubly_linked_list(self, root: Optional[Node]) -> Optional[Node]:
        if root is None:
            return None

        self.dfs_inorder(root)
        if self.first and self.last:
            self.first.left = self.last  # Close the loop by linking first and last
            self.last.right = self.first

        return self.first

    def dfs_inorder(self, root: Optional[Node]):
        if root is None:
            return

        self.dfs_inorder(root.left)  # Go left in DFS manner

        if self.last is not None:  # If last node is initialized, link it with the current root
            self.last.right = root
            root.left = self.last
        else:
            self.first = root  # If last is None, this is the first node

        self.last = root  # Update last to the current node

        self.dfs_inorder(root.right)  # Go right in DFS manner

if __name__ == "__main__":
    tree = BinaryTreeInOrderCreateDoublyLinkedList()

    root = Node(4)
    root.left = Node(2)
    root.left.left = Node(1)
    root.right = Node(5)
    root.left.right = Node(3)

    first_node = tree.create_doubly_linked_list(root)

    # Print the doubly linked list
    if first_node:
        current = first_node
        while current.right != first_node:
            print(current.data)
            current = current.right
        print(current.data)
