from typing import List, Optional
from collections import Counter
import heapq

def find_kth_most_frequent_element(num: Optional[List[int]], k: int) -> List[int]:
    if num is None:
        raise ValueError("The input array must not be None.")
    if not isinstance(num, list) or not all(isinstance(i, int) for i in num):
        raise ValueError("The input must be a list of integers.")
    if len(num) < 1:
        raise ValueError("The input array must contain at least one element.")
    if k <= 0 or not isinstance(k, int):
        raise ValueError("k must be a positive integer.")

    # Create a frequency map using Counter
    frequency_map = Counter(num)

    # Use a min-heap to keep track of the k most frequent elements
    min_heap = []

    for element, frequency in frequency_map.items():
        heapq.heappush(min_heap, (frequency, element))
        if len(min_heap) > k:
            heapq.heappop(min_heap)

    # Extract elements from the heap and reverse the list to get the correct order
    result = [element for frequency, element in heapq.nlargest(k, min_heap)]

    return result

def main():
    num = [1, 1, 1, 2, 2, 3]
    result = find_kth_most_frequent_element(num, 2)
    for i in result:
        print(i)

if __name__ == "__main__":
    main()
