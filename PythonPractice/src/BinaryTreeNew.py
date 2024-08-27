from typing import Optional

class Node:
    def __init__(self, key: int, name: str):
        if not isinstance(key, int):
            raise TypeError("Key must be an integer")
        if not isinstance(name, str):
            raise TypeError("Name must be a string")

        self.key: int = key
        self.name: str = name
        self.left_child: Optional['Node'] = None
        self.right_child: Optional['Node'] = None

    def __str__(self) -> str:
        return f"{self.name} has value as - {self.key}"

class BinaryTreeNew:
    def __init__(self):
        self.root: Optional[Node] = None

    def add_node(self, key: int, name: str):
        if not isinstance(key, int) or not isinstance(name, str):
            raise TypeError("Key must be an integer and name must be a string")

        new_node = Node(key, name)

        if self.root is None:
            self.root = new_node
        else:
            focus_node = self.root
            parent: Optional[Node] = None

            while True:
                parent = focus_node

                if key < focus_node.key:
                    focus_node = focus_node.left_child
                    if focus_node is None:
                        parent.left_child = new_node
                        return
                else:
                    focus_node = focus_node.right_child
                    if focus_node is None:
                        parent.right_child = new_node
                        return

    def in_order_traverse_tree(self, focus_node: Optional[Node]):
        if focus_node is not None:
            self.in_order_traverse_tree(focus_node.left_child)
            print(focus_node)
            self.in_order_traverse_tree(focus_node.right_child)

if __name__ == "__main__":
    bt = BinaryTreeNew()

    bt.add_node(50, "Boss")
    bt.add_node(25, "Vice President")
    bt.add_node(15, "Office Manager")
    bt.add_node(30, "Secretary")
    bt.add_node(75, "Sales Manager")
    bt.add_node(85, "Salesman 1")

    bt.in_order_traverse_tree(bt.root)
