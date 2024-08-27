from typing import List, Optional

class TreeNode:
    def __init__(self, data: int) -> None:
        if not isinstance(data, int):
            raise TypeError("Data must be an integer")
        self.data = data
        self.left: Optional['TreeNode'] = None
        self.right: Optional['TreeNode'] = None

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
    # Example input array
    a = [1, 8, 4, 5, 6, 7, 16, 10, 11, 13, 15]

    # Sorting the array
    a.sort()

    # Creating and displaying the tree
    tree = create_tree(a)
    display(tree)
