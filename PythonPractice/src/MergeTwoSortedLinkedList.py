class Node:
    def __init__(self, data: int):
        self.data = data
        self.next = None

def merge_two_lists(head1: Node, head2: Node) -> Node:
    """
    Merge two sorted linked lists into one sorted linked list.

    Args:
    head1 (Node): The head node of the first sorted linked list.
    head2 (Node): The head node of the second sorted linked list.

    Returns:
    Node: The head node of the merged sorted linked list.
    """
    if head1 is None and head2 is None:
        return None

    dummy = Node(0)  # Dummy node to serve as the starting point of the merged list
    ptr = dummy

    while head1 is not None and head2 is not None:
        if head1.data <= head2.data:
            ptr.next = head1
            head1 = head1.next
        else:
            ptr.next = head2
            head2 = head2.next
        ptr = ptr.next

    # Append the remaining nodes of either list
    if head1 is not None:
        ptr.next = head1
    if head2 is not None:
        ptr.next = head2

    return dummy.next

def print_list(head: Node):
    """
    Print all the elements of the linked list.

    Args:
    head (Node): The head node of the linked list.
    """
    while head is not None:
        print(head.data)
        head = head.next

# Example usage
if __name__ == "__main__":
    # Create first sorted linked list: 4 -> 6 -> 7 -> 10
    h1 = Node(4)
    h1.next = Node(6)
    h1.next.next = Node(7)
    h1.next.next.next = Node(10)

    # Create second sorted linked list: 3 -> 5 -> 9 -> 11
    h2 = Node(3)
    h2.next = Node(5)
    h2.next.next = Node(9)
    h2.next.next.next = Node(11)

    # Merge the two sorted linked lists
    merged_head = merge_two_lists(h1, h2)

    # Print the merged linked list
    print_list(merged_head)
