from collections import defaultdict
from typing import List, Tuple, Optional


def find_pair_value_to_sum_and_print_count(arr1: Optional[List[int]], sum_val: int) -> List[int]:
    if arr1 is None or len(arr1) < 2 or sum_val <= 1:
        raise ValueError("Values can't be null, less than 2, or sum can't be less than 1")

    val_set = set()
    result = []
    for num in arr1:
        temp_val = sum_val - num
        if temp_val >= 0 and temp_val in val_set:
            result.extend([num, temp_val])
        val_set.add(num)

    print("No of pairs found", len(result) // 2)
    return result


def find_pair_value_to_sum(arr1: Optional[List[int]], sum_val: int) -> List[Tuple[int, int]]:
    if arr1 is None or len(arr1) < 2 or sum_val <= 1:
        raise ValueError("Values can't be null, less than 2, or sum can't be less than 1")

    val_set = set()
    result = []

    for num in arr1:
        temp_val = sum_val - num
        if temp_val >= 0 and temp_val in val_set:
            result.append((num, temp_val))
        val_set.add(num)

    print("No of pairs found", len(result))
    return result


def number_of_distinct_pairs(array: Optional[List[int]], sum_val: int) -> int:
    if array is None or len(array) < 2 or sum_val < 1:
        return -1

    count_map = defaultdict(int)
    for num in array:
        count_map[num] += 1

    unique_pairs = set()
    for num in array:
        x = sum_val - num
        if x in count_map:
            if x == num and count_map[x] <= 1:
                continue
            y = tuple(sorted((x, num)))
            unique_pairs.add(y)

    return len(unique_pairs)


def print_pairs(array: Optional[List[int]], target_sum: int) -> None:
    if array is None or target_sum < 1:
        return

    count_map = defaultdict(int)
    for num in array:
        count_map[num] += 1

    for key, count in count_map.items():
        key2 = target_sum - key
        threshold = 1 if key == key2 else 0

        if threshold == 1:
            while count > 1:
                print(f"[{key}, {key2}]")
                count -= 2
        elif key2 in count_map:
            count2 = count_map[key2]
            if count > threshold and count2 > threshold:
                count_map[key] -= 1
                count_map[key2] -= 1
                print(f"[{key}, {key2}]")


def main():
    sum_val = 12
    input_arr = [6, 12, 3, 9, 3, 5, 1]

    print(find_pair_value_to_sum_and_print_count(input_arr, sum_val))
    print("***********************")
    print(number_of_distinct_pairs(input_arr, sum_val))

    array1 = [1, 3, 2, 2, 3]
    target_sum1 = 4
    array2 = [2, 2, 2, 2, 2]
    target_sum2 = 4
    array3 = [1, 3, 2, 2, 3, 1]
    target_sum3 = 4

    print("--------")
    print_pairs(array1, target_sum1)
    print("--------")
    print_pairs(array2, target_sum2)
    print("--------")
    print_pairs(array3, target_sum3)

    print("-----------")
    print(find_pair_value_to_sum(array1, target_sum1))


if __name__ == "__main__":
    main()
