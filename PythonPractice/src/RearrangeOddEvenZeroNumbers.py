def rearrange_odd_zero_even_sort(arr):
    if not arr or len(arr) <= 1:
        return arr

    even_index = 0

    # Sort all even numbers to the start/left of the array
    for i in range(len(arr)):
        if arr[i] % 2 == 0:
            arr[i], arr[even_index] = arr[even_index], arr[i]
            even_index += 1

    # Place zeros in the correct location
    for i in range(even_index):
        if arr[i] == 0:
            arr[i], arr[even_index - 1] = arr[even_index - 1], arr[i]
            even_index -= 1

    return arr

def rearrange_array(arr):
    if not arr:
        raise ValueError("Pass valid input")

    left, right = 0, len(arr) - 1
    while left < right:
        while left < right and arr[left] % 2 != 0:
            left += 1
        while left < right and arr[right] % 2 == 0:
            right -= 1
        if left < right:
            arr[left], arr[right] = arr[right], arr[left]
            left += 1
            right -= 1

def rearrange_odd_left_even_right(arr):
    if arr is None or len(arr) < 1:
        raise ValueError("Pass valid input")

    odd_index = 0

    for i in range(len(arr)):
        if arr[i] % 2 != 0:
            arr[i], arr[odd_index] = arr[odd_index], arr[i]
            odd_index += 1

    # Place zeros in the correct location
    for i in range(odd_index):
        if arr[i] == 0:
            arr[i], arr[odd_index - 1] = arr[odd_index - 1], arr[i]
            odd_index -= 1

    return arr

def print_array(arr):
    print(" ".join(map(str, arr)))

def main():
    arr = [-5, -7, 0, 0, 0, 0, 3, 3, 5, 22, 6, 7]
    # arr = [5, 2, 6, 8, 0, 0, 0, -2, -6, -7, -7]
    # arr = [-1, 2, 4, -2, 5, 6, 45, 34, -34, -56, 0]
    # arr = [-5, 0, -2, -6, -8, 0, 0, 0, -2, -6, -7, -7]
    # arr = [5, 0, 2, 6, 8, 0, 0, 0, 2, 6, 7, 7]
    # arr = [-5, -7]
    # arr = [0, 0, 0, 0]
    # arr = [6, 8, 2, 6, 7]
    # arr = [5, 7, 6, 6, 6, 6]
    # arr = [5, 7, 0, 6, 6, 6, 6]
    # arr = [2, 4, 6, 8, 0, 5, 7, 9, 1]

    rearrange_odd_zero_even_sort(arr)
    print_array(arr)

    rearrange_array(arr)
    print_array(arr)

    rearrange_odd_left_even_right(arr)
    print_array(arr)

if __name__ == "__main__":
    main()
