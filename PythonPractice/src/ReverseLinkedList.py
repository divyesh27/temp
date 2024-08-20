class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

class ReverseLinkedList:
    def __init__(self):
        self.head = None

    def reverse_list(self, node):
        prev = None
        current = node
        while current is not None:
            next_node = current.next
            current.next = prev
            prev = current
            current = next_node
        return prev

    def print_list(self, node):
        while node is not None:
            print(node.data, end=" ")
            node = node.next
        print()

    def reverse(self, node):
        if node is None or node.next is None:
            return node

        current = node.next
        node.next = None
        head = self.reverse(current)
        current.next = node

        return head

def main():
    rl = ReverseLinkedList()

    # Initialize linked list
    rl.head = Node(55)
    rl.head.next = Node(44)
    rl.head.next.next = Node(23)
    rl.head.next.next.next = Node(21)

    # Print original linked list
    print("Original Linked list is:")
    rl.print_list(rl.head)

    # Reverse the linked list
    rl.head = rl.reverse(rl.head)
    # Alternatively, you can use reverse_list method
    # rl.head = rl.reverse_list(rl.head)

    # Print reversed linked list
    print("")
    print("Reversed linked list:")
    rl.print_list(rl.head)

if __name__ == "__main__":
    main()
