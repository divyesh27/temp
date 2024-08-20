from collections import OrderedDict
from typing import Dict

class ListNode:
    def __init__(self, key: int, value: int) -> None:
        self.key = key
        self.value = value
        self.prev = None
        self.next = None

class LRUCache:
    def __init__(self, capacity: int) -> None:
        if not isinstance(capacity, int) or capacity <= 0:
            raise ValueError("Capacity must be a positive integer")
        self.capacity = capacity
        self.size = 0
        self.map: Dict[int, ListNode] = {}
        self.head: ListNode = None
        self.tail: ListNode = None

    def put(self, key: int, value: int) -> None:
        if not isinstance(key, int) or not isinstance(value, int):
            raise ValueError("Key and value must be integers")

        if key in self.map:
            node = self.map[key]
            node.value = value
            self.remove_node(node)
            self.add_node(node)
        else:
            if self.size >= self.capacity:
                if self.head:
                    del self.map[self.head.key]
                    self.remove_node(self.head)
            node = ListNode(key, value)
            self.add_node(node)
            self.map[key] = node

    def get(self, key: int) -> int:
        if not isinstance(key, int):
            raise ValueError("Key must be an integer")

        node = self.map.get(key)
        if node is None:
            return -1

        self.remove_node(node)
        self.add_node(node)
        return node.value

    def add_node(self, node: ListNode) -> None:
        if not isinstance(node, ListNode):
            raise ValueError("Node must be an instance of ListNode")

        if self.tail:
            self.tail.next = node
        node.prev = self.tail
        node.next = None
        self.tail = node

        if self.head is None:
            self.head = self.tail

    def remove_node(self, node: ListNode) -> None:
        if not isinstance(node, ListNode):
            raise ValueError("Node must be an instance of ListNode")

        if node.prev:
            node.prev.next = node.next
        else:
            self.head = node.next

        if node.next:
            node.next.prev = node.prev
        else:
            self.tail = node.prev

# Example usage
if __name__ == "__main__":
    capacity = 2
    lru = LRUCache(capacity)
    lru.put(1, 1)
    lru.put(2, 2)
    print(lru.get(1))  # Output: 1
    lru.put(3, 3)      # Evicts key 2
    print(lru.get(2))  # Output: -1 (not found)
    lru.put(4, 4)      # Evicts key 1
    print(lru.get(1))  # Output: -1 (not found)
    print(lru.get(3))  # Output: 3
    print(lru.get(4))  # Output: 4
