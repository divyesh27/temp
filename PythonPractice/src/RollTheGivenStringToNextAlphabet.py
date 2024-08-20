from typing import List

def shift_and_roll_the_string(s: str, roll: List[int]) -> str:
    if s is None or len(s) == 0 or roll is None or len(roll) == 0:
        return ""

    slen = len(s)
    roll_counts = [0] * slen

    for roll_count in roll:
        roll_counts[roll_count - 1] += 1

    for index in range(slen - 2, -1, -1):
        roll_counts[index] += roll_counts[index + 1]

    rolled_array = list(s)
    for index in range(slen):
        rolled_array[index] = chr((roll_counts[index] % 26 + ord(rolled_array[index]) - ord('a')) % 26 + ord('a'))

    return ''.join(rolled_array)

def main():
    print(shift_and_roll_the_string("abc", [3]))        # Output: "bcd"
    print(shift_and_roll_the_string("abz", [3]))        # Output: "bca"
    print(shift_and_roll_the_string("vwxyz", [1,2,3,4,5]))  # Output: "yzabc"
    print(shift_and_roll_the_string("vgxgpuamkx", [5,5,2,4,7,6,2,2,8,7]))  # Output: "xgzhswbmna"
    print("*************************************")

if __name__ == "__main__":
    main()
