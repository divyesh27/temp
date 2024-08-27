from typing import Optional

class TreeNode:
    def __init__(self, data: int):
        self.data = data
        self.left: Optional['TreeNode'] = None
        self.right: Optional['TreeNode'] = None

def kth_smallest_element(root: Optional[TreeNode], k: int) -> int:
    if root is None:
        raise ValueError("The tree must not be None.")
    if not isinstance(k, int) or k <= 0:
        raise ValueError("k must be a positive integer.")

    stack = []
    p = root
    result = None

    while stack or p:
        if p:
            stack.append(p)
            p = p.left
        else:
            t = stack.pop()
            k -= 1
            if k == 0:
                result = t.data
                break
            p = t.right

    if result is None:
        raise ValueError("k is larger than the number of nodes in the tree.")

    return result

def kth_largest_element(root: Optional[TreeNode], k: int) -> int:
    if root is None:
        raise ValueError("The tree must not be None.")
    if not isinstance(k, int) or k <= 0:
        raise ValueError("k must be a positive integer.")

    stack = []
    p = root
    result = None

    while stack or p:
        if p:
            stack.append(p)
            p = p.right
        else:
            t = stack.pop()
            k -= 1
            if k == 0:
                result = t.data
                break
            p = t.left

    if result is None:
        raise ValueError("k is larger than the number of nodes in the tree.")

    return result

def main():
    root = TreeNode(40)
    root.right = TreeNode(60)
    root.left = TreeNode(20)
    root.right.right = TreeNode(70)
    root.left.right = TreeNode(30)
    root.right.left = TreeNode(50)
    root.left.left = TreeNode(10)
    root.right.right.left = TreeNode(65)
    root.left.left.right = TreeNode(15)

    print(kth_smallest_element(root, 6))  # Example for the 6th smallest element
    print(kth_largest_element(root, 6))   # Example for the 6th largest element

if __name__ == "__main__":
    main()
