def rotate_by_given_number(arr, k):
    if arr is None or len(arr) == 0 or k < 0:
        raise ValueError("Illegal argument!")

    # This will take care of the value of k greater than the length of the array
    if k > len(arr):
        k = k % len(arr)

    div = len(arr) - k  # get the remaining segment of the array.

    # Reverse the segments as described in the Java code
    reverse(arr, 0, div - 1)      # Rotate left side
    reverse(arr, div, len(arr) - 1)  # Rotate right side
    reverse(arr, 0, len(arr) - 1)    # Complete swap

    return arr

def reverse(arr, left, right):
    if arr is None or len(arr) == 1:
        return arr

    # Swap values from the left and right ends of the array
    while left < right:
        arr[left], arr[right] = arr[right], arr[left]
        left += 1
        right -= 1

    return arr

def main():
    arr = [2, 3, 4, 5, 2]
    rotated_arr = rotate_by_given_number(arr, 3)
    print(" ".join(map(str, rotated_arr)))  # Output: 4 5 2 2 3

if __name__ == "__main__":
    main()
