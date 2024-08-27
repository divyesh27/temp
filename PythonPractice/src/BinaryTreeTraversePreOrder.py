class Node:
    def __init__(self, data: int):
        if not isinstance(data, int):
            raise TypeError("Node data must be an integer.")
        self.data = data
        self.left = None
        self.right = None

class BinaryTreeTraversePreOrder:
    def __init__(self):
        self.root = None

    def find(self, id: int) -> bool:
        if not isinstance(id, int):
            raise TypeError("Input must be an integer.")
        current = self.root
        while current is not None:
            if current.data == id:
                return True
            elif current.data < id:
                current = current.right
            else:
                current = current.left
        return False

    def delete(self, id: int) -> bool:
        if not isinstance(id, int):
            raise TypeError("Input must be an integer.")
        if self.root is None:
            return False

        parent = self.root
        current = self.root
        is_left_child = False

        while current.data != id:
            parent = current
            if current.data > id:
                current = current.left
                is_left_child = True
            else:
                current = current.right
                is_left_child = False
            if current is None:
                return False

        if current.left is None and current.right is None:
            if current == self.root:
                self.root = None
            if is_left_child:
                parent.left = None
            else:
                parent.right = None

        elif current.right is None:
            if current == self.root:
                self.root = current.left
            elif is_left_child:
                parent.left = current.left
            else:
                parent.right = current.left

        elif current.left is None:
            if current == self.root:
                self.root = current.right
            elif is_left_child:
                parent.left = current.right
            else:
                parent.right = current.right

        else:
            successor = self.get_successor(current)
            if current == self.root:
                self.root = successor
            elif is_left_child:
                parent.left = successor
            else:
                parent.right = successor
            successor.left = current.left
        return True

    def insert(self, id: int):
        if not isinstance(id, int):
            raise TypeError("Input must be an integer.")
        if self.find(id):
            return
        new_node = Node(id)
        if self.root is None:
            self.root = new_node
            return

        current = self.root
        parent = self.root

        while True:
            parent = current
            if id < current.data:
                current = current.left
                if current is None:
                    parent.left = new_node
                    return
            else:
                current = current.right
                if current is None:
                    parent.right = new_node
                    return

    def get_successor(self, curr: Node) -> Node:
        if not isinstance(curr, Node):
            raise TypeError("Input must be a Node.")

        successor = None
        parent_successor = None
        current = curr.right

        while current is not None:
            parent_successor = successor
            successor = current
            current = current.left

        if successor != curr.right:
            parent_successor.left = successor.right
            successor.right = curr.right

        return successor

    def pre_order_traverse(self, root: Node):
        if root is None:
            return

        current = root
        while current is not None:
            if current.left is None:
                print(current.data, end=" ")
                current = current.right
            else:
                predecessor = current.left
                while predecessor.right is not None and predecessor.right != current:
                    predecessor = predecessor.right

                if predecessor.right is None:
                    print(current.data, end=" ")
                    predecessor.right = current
                    current = current.left
                else:
                    predecessor.right = None
                    current = current.right

    def pre_order_traverse_recursion(self, root: Node):
        if root is None:
            return
        print(root.data, end=" ")
        self.pre_order_traverse_recursion(root.left)
        self.pre_order_traverse_recursion(root.right)

    def display(self, root: Node):
        if root is not None:
            self.display(root.left)
            print(f"Number {root.data}")
            self.display(root.right)

if __name__ == "__main__":
    b = BinaryTreeTraversePreOrder()
    b.insert(3)
    b.insert(8)
    b.insert(1)
    b.insert(4)
    b.insert(6)
    b.insert(2)
    b.insert(10)
    b.insert(9)
    b.insert(20)
    b.insert(25)
    b.insert(15)
    b.insert(16)

    print("Original Tree:")
    b.display(b.root)
    print("\nPre-order Traversal with Iteration (Space complexity O(1)):")
    b.pre_order_traverse(b.root)
    print("\n\nPre-order Traversal with Recursion (Space complexity H or N):")
    b.pre_order_traverse_recursion(b.root)

    print(f"\n\nCheck whether Node with value 4 exists: {b.find(4)}")

    print(f"\nDelete Node with no children (2): {b.delete(2)}")
    b.display(b.root)

    print(f"\nDelete Node with one child (4): {b.delete(4)}")
    b.display(b.root)

    print(f"\nDelete Node with Two children (10): {b.delete(10)}")
    b.display(b.root)
