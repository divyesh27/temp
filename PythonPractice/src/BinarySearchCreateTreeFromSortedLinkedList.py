from typing import Optional, List, Union

class LinkListNode:
    def __init__(self, data: int, next: Optional['LinkListNode'] = None) -> None:
        if not isinstance(data, int):
            raise TypeError("Data must be an integer")
        self.data = data
        self.next = next

class TreeNode:
    def __init__(self, data: int) -> None:
        if not isinstance(data, int):
            raise TypeError("Data must be an integer")
        self.data = data
        self.left: Optional['TreeNode'] = None
        self.right: Optional['TreeNode'] = None

def create_list(head: Optional[LinkListNode]) -> Optional[List[int]]:
    if head is None:
        return None

    # Collecting data from linked list
    data_list = []
    while head is not None:
        data_list.append(head.data)
        head = head.next

    # Sorting the list
    data_list.sort()
    return data_list

def create_tree(input_list: List[int]) -> Optional[TreeNode]:
    if not isinstance(input_list, list) or not all(isinstance(x, int) for x in input_list):
        raise TypeError("Input must be a list of integers")

    def create_tree_helper(start: int, end: int) -> Optional[TreeNode]:
        if end < start:
            return None

        mid = (start + end) // 2
        node = TreeNode(input_list[mid])
        node.left = create_tree_helper(start, mid - 1)
        node.right = create_tree_helper(mid + 1, end)
        return node

    return create_tree_helper(0, len(input_list) - 1)

def display(root: Optional[TreeNode]) -> None:
    if root is not None:
        display(root.left)
        print(f"Number {root.data}")
        display(root.right)

if __name__ == "__main__":
    # Create and display tree from sorted array
    a = [1, 8, 4, 5, 6, 7, 16, 10, 11, 13, 15]
    a.sort()  # Sorting array as required
    tree = create_tree(a)
    display(tree)

    # Create and display sorted list from linked list
    head = LinkListNode(5)
    head.next = LinkListNode(51)
    head.next.next = LinkListNode(41)
    head.next.next.next = LinkListNode(31)
    head.next.next.next.next = LinkListNode(11)
    head.next.next.next.next.next = LinkListNode(61)

    sorted_list = create_list(head)
    if sorted_list is not None:
        for num in sorted_list:
            print(num)
