from typing import Optional

class BinaryTree:
    def __init__(self):
        self.root: Optional['Node'] = None

    def add_node(self, key: int, name: str) -> None:
        if not isinstance(key, int) or not isinstance(name, str):
            raise TypeError("Key must be an integer and name must be a string")

        new_node = self.Node(key, name)
        if self.root is None:
            self.root = new_node
        else:
            focus_node = self.root
            while True:
                parent = focus_node
                if key < focus_node.key:
                    focus_node = focus_node.left_child
                    if focus_node is None:
                        parent.left_child = new_node
                        return
                elif key > focus_node.key:
                    focus_node = focus_node.right_child
                    if focus_node is None:
                        parent.right_child = new_node
                        return
                else:
                    # If key is equal, do not add the node (optional behavior)
                    return

    def __str__(self) -> str:
        return f"BinaryTree with root: {self.root}"

    class Node:
        def __init__(self, key: int, name: str):
            if not isinstance(key, int) or not isinstance(name, str):
                raise TypeError("Key must be an integer and name must be a string")

            self.key: int = key
            self.name: str = name
            self.left_child: Optional['Node'] = None
            self.right_child: Optional['Node'] = None

        def __str__(self) -> str:
            return f"{self.name} has key {self.key}"

if __name__ == "__main__":
    # Example usage
    tree = BinaryTree()
    tree.add_node(10, "Node1")
    tree.add_node(5, "Node2")
    tree.add_node(15, "Node3")

    # Display root node
    print(tree)
    print(tree.root)
    print(tree.root.left_child)
    print(tree.root.right_child)
