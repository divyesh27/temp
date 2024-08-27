class DoubleNode:
    def __init__(self, data: int):
        if not isinstance(data, int):
            raise TypeError("Data must be an integer")
        self.data = data
        self.prev = None
        self.next = None

def insert_double_list(head: DoubleNode, data: int) -> DoubleNode:
    if not isinstance(data, int):
        raise TypeError("Data must be an integer")

    new_node = DoubleNode(data)

    if head is None:
        return new_node

    current = head
    prev = None

    while current is not None and current.data < data:
        prev = current
        current = current.next

    if prev is None:  # Insert at the beginning
        new_node.next = head
        head.prev = new_node
        head = new_node
    else:  # Insert after prev
        new_node.next = current
        new_node.prev = prev
        prev.next = new_node
        if current is not None:
            current.prev = new_node

    return head

def print_list(head: DoubleNode):
    if not isinstance(head, DoubleNode) and head is not None:
        raise TypeError("Head must be a DoubleNode instance or None")

    current = head
    while current is not None:
        print(current.data, end=" ")
        current = current.next
    print()  # for a new line

if __name__ == "__main__":
    head = None
    head = insert_double_list(head, 5)
    head = insert_double_list(head, 10)
    head = insert_double_list(head, 1)
    head = insert_double_list(head, 11)
    head = insert_double_list(head, 13)
    head = insert_double_list(head, 3)
    head = insert_double_list(head, 7)
    print_list(head)
