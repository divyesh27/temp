class Node:
    def __init__(self, data: int):
        self.data = data
        self.next = None

class FindMthNodeFromLastNodeLinkList:
    def __init__(self):
        self.head = None

    def push(self, val: int):
        # Adding value at the front of the list
        new_node = Node(val)
        new_node.next = self.head
        self.head = new_node

    def find_mth_node(self, m: int):
        if self.head is None or self.head.next is None:
            return None

        first_pointer = self.head
        second_pointer = self.head

        count = 0
        while count < m:
            if first_pointer is None:
                return None  # The list has fewer than m nodes
            first_pointer = first_pointer.next
            count += 1

        while first_pointer is not None:
            second_pointer = second_pointer.next
            first_pointer = first_pointer.next

        if second_pointer:
            print(second_pointer.data)
            return second_pointer.data
        else:
            return None

def main():
    fml = FindMthNodeFromLastNodeLinkList()
    fml.push(4)
    fml.push(19)
    fml.push(77)
    fml.push(11)
    fml.find_mth_node(3)  # Output: 19

if __name__ == "__main__":
    main()
