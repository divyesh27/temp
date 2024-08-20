from typing import List

def product_of_array_except_self(input_array: List[int]) -> List[int]:
    if not input_array or len(input_array) == 0:
        raise ValueError("Input array must not be null or empty.")

    result = [1] * len(input_array)

    # Right product calculation
    for i in range(len(input_array) - 2, -1, -1):
        result[i] = result[i + 1] * input_array[i + 1]

    # Left product multiplication
    left = 1
    for i in range(len(input_array)):
        result[i] *= left
        left *= input_array[i]

    return result

def product_of_array_except_self_element(input_array: List[int]) -> List[int]:
    if not input_array or len(input_array) == 0:
        raise ValueError("Input array must not be null or empty.")

    size = len(input_array)
    result = [1] * size

    t1 = [1] * size
    t2 = [1] * size

    # Fill t1 with products of elements to the left
    for i in range(1, size):
        t1[i] = t1[i - 1] * input_array[i - 1]

    # Fill t2 with products of elements to the right
    for i in range(size - 2, -1, -1):
        t2[i] = t2[i + 1] * input_array[i + 1]

    # Multiply t1 and t2 to get the final result
    for i in range(size):
        result[i] = t1[i] * t2[i]

    return result

def main():
    try:
        print(product_of_array_except_self([4, 2, 1, 3]))
        print(product_of_array_except_self_element([1, 2, 3, 1]))
    except ValueError as e:
        print(e)

if __name__ == "__main__":
    main()
