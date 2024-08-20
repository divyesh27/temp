from typing import List, Optional
import itertools

def three_sum(input_list: Optional[List[int]]) -> List[List[int]]:
    if input_list is None or len(input_list) < 3:
        raise ValueError("Pass valid input")

    input_list.sort()  # Time complexity O(n^2) as worst case
    result = []

    for i in range(len(input_list) - 2):
        if i == 0 or (i > 0 and input_list[i] != input_list[i - 1]):
            low, high = i + 1, len(input_list) - 1
            target = -input_list[i]  # Get the first value and subtract it from 0 to get the target sum

            while low < high:
                current_sum = input_list[low] + input_list[high]
                if current_sum == target:
                    result.append([input_list[i], input_list[low], input_list[high]])

                    while low < high and input_list[low] == input_list[low + 1]:
                        low += 1  # Skip duplicates
                    while low < high and input_list[high] == input_list[high - 1]:
                        high -= 1  # Skip duplicates

                    low += 1
                    high -= 1
                elif current_sum > target:
                    high -= 1
                else:
                    low += 1

    return result

def main():
    input_list = [-1, 0, 1, 2, -1, -4]
    print(three_sum(input_list))

if __name__ == "__main__":
    main()
