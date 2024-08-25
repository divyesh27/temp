from typing import List

def find_one_duplicate(num: List[int]) -> int:
    if num is None or len(num) <= 1:
        return -1

    highest = len(num) - 1
    total = sum(num)
    duplicate = total - (highest * (highest + 1)) // 2
    return duplicate

def sum_array(arr: List[int]) -> int:
    return sum(arr)

def main():
    a = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 17]
    print(find_one_duplicate(a))

if __name__ == "__main__":
    main()
