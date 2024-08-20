def rearrange_neg_zero_pos(arr):
    if arr is None or len(arr) <= 1:
        return

    size = len(arr)
    negative = []
    positive = []
    zero_count = 0

    # Separate the array into negatives, positives, and count zeros
    for num in arr:
        if num < 0:
            negative.append(num)
        elif num > 0:
            positive.append(num)
        else:
            zero_count += 1

    i = 0
    a = 0

    # Rearrange the array
    while i < size:
        if i < len(negative):
            arr[i] = negative[i]
        elif i < len(negative) + zero_count:
            arr[i] = 0
        else:
            arr[i] = positive[a]
            a += 1
        i += 1

def print_array(arr):
    print(" ".join(map(str, arr)))

def main():
    arr = [5, 2, 6, 8, 0, 0, 0, -2, -6, -7, -7]
    # arr = [-5, -7, 0, 0, 0, 0, 3, 3, 5, 22, 6, 7]
    # arr = [-5, 0, -2, -6, -8, 0, 0, 0, -2, -6, -7, -7]
    # arr = [5, 0, 2, 6, 8, 0, 0, 0, 2, 6, 7, 7]
    # arr = [-5, -7]
    # arr = [0, 0, 0, 0]
    # arr = [6, 8, 2, 6, 7]

    rearrange_neg_zero_pos(arr)
    print_array(arr)

if __name__ == "__main__":
    main()
