from typing import List

def find_max_sum_subsequence(arr: List[int]) -> int:
    if arr is None or len(arr) <= 1:
        return -1

    sum = 0
    max_sum = 0
    start = 0
    end = 0
    current = 0

    for i in range(len(arr)):
        sum += arr[i]

        if sum > max_sum:
            max_sum = sum
            start = current
            end = i

        if sum <= 0:
            sum = 0
            current = i + 1

    print(f"Array between {arr[start]} and {arr[end]} (start: {start}, end: {end})")
    return max_sum

def max_sum(arr: List[int]) -> int:
    if arr is None or len(arr) <= 1:
        return -1

    size = len(arr)
    T = arr[:]  # Copy of the array
    loc = list(range(size))

    for i in range(1, size):
        for j in range(i):
            if arr[j] < arr[i]:
                if T[i] < T[j] + arr[i]:
                    T[i] = T[j] + arr[i]
                    loc[i] = j

    max_value = T[0]
    k = 0

    for i in range(1, size):
        if max_value < T[i]:
            max_value = T[i]
            k = i

    # Uncomment this to print the subsequence
    # while k >= 0:
    #     print(arr[k])
    #     if k == loc[k]:
    #         break
    #     k = loc[k]

    return max_value

def main():
    input = [-10, 3, 5, 6, -10, 8, 2, 7, 9, -30, 3, 7]
    # input = [1, 101, 10, 2, 3, 100, 4]
    # input = [4, 6, 1, 3, 8, 4, 6]

    print(find_max_sum_subsequence(input))
    print(max_sum(input))

if __name__ == "__main__":
    main()
