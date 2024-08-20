from typing import List, Tuple

def remove_duplicates(num: List[int]) -> List[int]:
    if len(num) < 2:
        return num

    num.sort()
    dest = 1
    for i in range(1, len(num)):
        if num[i - 1] < num[i]:
            num[dest] = num[i]
            dest += 1

    return num[:dest]

def find_first_duplicate(num: List[int]) -> int:
    if len(num) < 2:
        return 0

    flag = [False] * 100  # Assumes input numbers are not greater than 100

    for n in num:
        if not flag[n]:
            flag[n] = True
        else:
            return n

    return 0

def main():
    a = [1, 5, 7, 23, 4, 5, 1, 5, 7, 10, 8]

    # Remove duplicates and print results
    result = remove_duplicates(a.copy())  # Use a copy to not modify original
    for i in result:
        print(i)

    print("***************")

    # Find the first duplicate and print result
    first_duplicate = find_first_duplicate(a)
    print(first_duplicate)

if __name__ == "__main__":
    main()
