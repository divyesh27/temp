class Node:
    def __init__(self, data: int):
        if not isinstance(data, int):
            raise TypeError("Node data must be an integer")
        self.data = data
        self.next = None

class AddNumberRepresentedByLinkedLists:
    @staticmethod
    def reverse_list(node: Node) -> Node:
        if node is None or node.next is None:
            return node

        current = node.next
        node.next = None
        head = AddNumberRepresentedByLinkedLists.reverse_list(current)
        current.next = node
        return head

    def add_num_list(self, l1: Node, l2: Node) -> Node:
        if l1 is None or l2 is None:
            raise ValueError("Both linked lists must be provided")

        l1_rev = self.reverse_list(l1)
        l2_rev = self.reverse_list(l2)
        carry = 0
        result = None

        while l1_rev is not None or l2_rev is not None:
            sum = carry
            if l1_rev is not None:
                sum += l1_rev.data
                l1_rev = l1_rev.next
            if l2_rev is not None:
                sum += l2_rev.data
                l2_rev = l2_rev.next

            carry = sum // 10
            sum = sum % 10
            temp = Node(sum)
            temp.next = result
            result = temp

        if carry > 0:
            temp = Node(carry)
            temp.next = result
            result = temp

        return result

    def add_num_list_same_size(self, l1: Node, l2: Node, carry: int) -> Node:
        if l1 is None:
            if carry > 0:
                return Node(carry)
            return None

        res = Node(0)
        res.next = self.add_num_list_same_size(l1.next, l2.next, carry)

        sum = l1.data + l2.data + carry
        carry = sum // 10
        sum = sum % 10
        res.data = sum

        return res

def print_linked_list(node: Node):
    while node:
        print(node.data, end=' ')
        node = node.next
    print()

# Example usage
if __name__ == "__main__":
    adder = AddNumberRepresentedByLinkedLists()

    l1 = Node(7)
    l1.next = Node(4)
    l1.next.next = Node(7)
    l1.next.next.next = Node(4)
    l1.next.next.next.next = Node(2)

    l2 = Node(8)
    l2.next = Node(6)
    l2.next.next = Node(4)

    # Add the two numbers represented by linked lists
    result = adder.add_num_list(l1, l2)
    print("Result of adding two numbers represented by linked lists:")
    print_linked_list(result)

    # Uncomment below to test add_num_list_same_size
    # l1 = Node(5)
    # l1.next = Node(3)
    # l1.next.next = Node(1)

    # l2 = Node(2)
    # l2.next = Node(2)
    # l2.next.next = Node(3)

    # sum_same_size = adder.add_num_list_same_size(l1, l2, 0)
    # print("Result of adding two numbers of the same size:")
    # print_linked_list(sum_same_size)
