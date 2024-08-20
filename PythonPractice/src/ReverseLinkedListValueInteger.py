class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

class ReverseLinkedListValueInteger:
    def __init__(self):
        self.sum = 0
        self.sb = ""
        self.head = None

    def reverse_valueto_string(self, node):
        if node is None:
            return
        self.reverse_valueto_string(node.next)
        self.append_string(node.data)

    def append_string(self, data):
        self.sb += str(data)

    def reverse_values(self, node):
        if node is None:
            return
        self.reverse_values(node.next)
        self.compute_values(node.data)

    def compute_values(self, val):
        self.sum = (self.sum * 100) + val

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
    rl = ReverseLinkedListValueInteger()

    # Initialize linked list
    rl.head = Node(53)
    rl.head.next = Node(41)
    rl.head.next.next = Node(23)
    rl.head.next.next.next = Node(21)

    # Reverse values to string
    rl.reverse_valueto_string(rl.head)
    print(rl.sb)  # Output the reversed value as a string

    # Convert string to integer and print
    n = int(rl.sb)
    print(n)  # Output the integer value

    # Print original linked list
    print("Original Linked list is :")
    rl.print_list(rl.head)

    # Reverse the linked list
    rl.head = rl.reverse(rl.head)

    # Print reversed linked list
    print("")
    print("Reversed linked list : ")
    rl.print_list(rl.head)

if __name__ == "__main__":
    main()
