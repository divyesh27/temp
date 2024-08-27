class Node:
    def __init__(self, data: int):
        if not isinstance(data, int):
            raise TypeError("Data must be an integer")
        self.data = data
        self.next = None

class DetectLoopCycleLinkedList:

    @staticmethod
    def detect_remove_loop(head: Node) -> None:
        if not isinstance(head, Node):
            raise TypeError("Head must be a Node instance")

        fast = head
        slow = head

        # Detecting the loop using Floyd's Cycle-Finding Algorithm
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
            if slow == fast:
                print("Found loop")
                DetectLoopCycleLinkedList.remove_loop(head, slow)
                return

        print("No loop found")

    @staticmethod
    def remove_loop(head: Node, meeting_point: Node) -> None:
        if not isinstance(head, Node) or not isinstance(meeting_point, Node):
            raise TypeError("Head and meeting_point must be Node instances")

        # Find the start of the loop
        start = head
        while start != meeting_point:
            start = start.next
            meeting_point = meeting_point.next

        # Find the last node in the loop
        while meeting_point.next != start:
            meeting_point = meeting_point.next

        # Remove the loop
        meeting_point.next = None

    @staticmethod
    def print_list(head: Node) -> None:
        if not isinstance(head, Node):
            raise TypeError("Head must be a Node instance")

        current = head
        while current:
            print(current.data)
            current = current.next

# Example usage
if __name__ == "__main__":
    try:
        h1 = Node(4)
        h1.next = Node(6)
        h1.next.next = Node(7)
        h1.next.next.next = Node(10)
        h1.next.next.next.next = Node(11)
        h1.next.next.next.next.next = h1.next.next  # Creating a loop

        DetectLoopCycleLinkedList.detect_remove_loop(h1)
        DetectLoopCycleLinkedList.print_list(h1)
    except Exception as e:
        print(f"An error occurred: {e}")
