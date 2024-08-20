class MaxHeap:
    def __init__(self, capacity):
        if not isinstance(capacity, int) or capacity <= 0:
            raise ValueError("Capacity must be a positive integer")
        self.capacity = capacity
        self.heap = [0] * (capacity + 1)  # Index 0 is unused
        self.position = 1

    def insert(self, val):
        if not isinstance(val, int):
            raise ValueError("Value to insert must be an integer")

        if self.position >= self.capacity:
            raise OverflowError("Heap is full")

        self.heap[self.position] = val
        child = self.position
        parent = child // 2

        while parent > 0 and self.heap[parent] < self.heap[child]:
            # Swap parent and child
            self.heap[parent], self.heap[child] = self.heap[child], self.heap[parent]

            child = parent
            parent = child // 2

        self.position += 1

    def print_heap(self):
        # Print the heap ignoring index 0
        print(" ".join(map(str, self.heap[1:self.position])))

if __name__ == "__main__":
    max_heap = MaxHeap(10)
    max_heap.insert(12)
    max_heap.insert(7)
    max_heap.insert(6)
    max_heap.insert(10)
    max_heap.insert(8)
    max_heap.insert(20)
    max_heap.print_heap()
