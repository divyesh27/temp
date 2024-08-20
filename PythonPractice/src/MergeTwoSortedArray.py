from typing import List

def merge_two_sorted_arrays(nums1: List[int], nums2: List[int]) -> List[int]:
    """
    Merge two sorted arrays into one sorted array.

    Args:
    nums1 (List[int]): The first sorted array.
    nums2 (List[int]): The second sorted array.

    Returns:
    List[int]: The merged sorted array.
    """
    if nums1 is None or nums2 is None or len(nums1) < 1 or len(nums2) < 1:
        raise ValueError("Pass valid input")

    size_num1 = len(nums1)
    size_num2 = len(nums2)
    index_nums1 = 0
    index_nums2 = 0
    result_index = 0
    result = [0] * (size_num1 + size_num2)

    while index_nums1 < size_num1 and index_nums2 < size_num2:
        if nums1[index_nums1] < nums2[index_nums2]:
            result[result_index] = nums1[index_nums1]
            index_nums1 += 1
        else:
            result[result_index] = nums2[index_nums2]
            index_nums2 += 1
        result_index += 1

    while index_nums1 < size_num1:
        result[result_index] = nums1[index_nums1]
        index_nums1 += 1
        result_index += 1

    while index_nums2 < size_num2:
        result[result_index] = nums2[index_nums2]
        index_nums2 += 1
        result_index += 1

    return result

def merge_array(input_array1: List[int], input_array2: List[int]) -> List[int]:
    """
    Merge two arrays and then reverse the merged array.

    Args:
    input_array1 (List[int]): The first array.
    input_array2 (List[int]): The second array.

    Returns:
    List[int]: The merged and reversed array.
    """
    if input_array1 is None or input_array2 is None or len(input_array1) < 1 or len(input_array2) < 1:
        raise ValueError("Pass valid input")

    size_array1 = len(input_array1)
    size_array2 = len(input_array2)
    index_nums1 = 0
    index_nums2 = 0
    result_index = 0
    result = [0] * (size_array1 + size_array2)

    while index_nums1 < size_array1 and index_nums2 < size_array2:
        if input_array1[index_nums1] < input_array2[index_nums2]:
            result[result_index] = input_array1[index_nums1]
            index_nums1 += 1
        else:
            result[result_index] = input_array2[index_nums2]
            index_nums2 += 1
        result_index += 1

    while index_nums1 < size_array1:
        result[result_index] = input_array1[index_nums1]
        index_nums1 += 1
        result_index += 1

    while index_nums2 < size_array2:
        result[result_index] = input_array2[index_nums2]
        index_nums2 += 1
        result_index += 1

    reverse_array(result)
    return result

def reverse_array(input_arr: List[int]):
    """
    Reverse the elements of the array in place.

    Args:
    input_arr (List[int]): The array to be reversed.
    """
    start = 0
    end = len(input_arr) - 1

    while start < end:
        input_arr[start], input_arr[end] = input_arr[end], input_arr[start]
        start += 1
        end -= 1

# Example usage
if __name__ == "__main__":
    nums1 = [1, 2, 3, 4]
    nums2 = [2, 5, 6]

    merged_sorted = merge_two_sorted_arrays(nums1, nums2)
    for i in merged_sorted:
        print(i)

    print()

    merged_reversed = merge_array(nums1, nums2)
    for i in merged_reversed:
        print(i)
