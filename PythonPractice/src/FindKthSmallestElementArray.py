from typing import List
import heapq

def find_kth_smallest_element(num: List[int], k: int) -> int:
    if not isinstance(num, list) or not all(isinstance(i, int) for i in num):
        raise ValueError("Input must be a list of integers.")

    if not isinstance(k, int) or k <= 0 or k > len(num):
        raise ValueError("k must be a positive integer within the range of the array length.")

    if len(num) <= 1:
        return -1

    num.sort()
    return num[k - 1]

def find_kth_smallest_num(num: List[int], k: int) -> int:
    if not isinstance(num, list) or not all(isinstance(i, int) for i in num):
        raise ValueError("Input must be a list of integers.")

    if not isinstance(k, int) or k <= 0 or k > len(num):
        raise ValueError("k must be a positive integer within the range of the array length.")

    q = []
    for i in num:
        heapq.heappush(q, i)
        if len(q) > k:
            heapq.heappop(q)

    return heapq.heappop(q)

def main():
    num = [3, 2, 1, 5, 6, 4]

    print(find_kth_smallest_element(num, 4))
    print(find_kth_smallest_num(num, 4))

if __name__ == "__main__":
    main()
