from collections import Counter, deque
import heapq

def rearrange_string(s: str) -> str:
    if not s or len(s) < 2:
        raise ValueError("Pass valid input")

    # Count the frequency of each character
    frequency_map = Counter(s)

    # Create a max heap based on character frequency
    max_heap = [(-freq, char) for char, freq in frequency_map.items()]
    heapq.heapify(max_heap)

    result = []
    queue = deque()

    while max_heap:
        freq, char = heapq.heappop(max_heap)
        result.append(char)
        queue.append((freq + 1, char))  # Decrement frequency

        if len(queue) >= 2:
            prev_freq, prev_char = queue.popleft()
            if -prev_freq > 0:  # If there's more of this character left
                heapq.heappush(max_heap, (prev_freq, prev_char))

    # If the resulting string length is not the same as the original string length, it's not possible
    if len(result) != len(s):
        return "Not possible to rearrange!"

    return ''.join(result)

def main():
    str1 = "bcaaa"
    str2 = "aabbccdd"
    print(rearrange_string(str1))  # Expected output: "abaca" (or similar valid rearrangement)
    print(rearrange_string(str2))  # Expected output: "Not possible to rearrange!" (as example)

if __name__ == "__main__":
    main()
