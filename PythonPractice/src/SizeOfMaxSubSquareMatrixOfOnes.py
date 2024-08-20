def min_of_three(a, b, c):
    return min(a, min(b, c))

def max_sub_square_matrix(input_array):
    if input_array is None or len(input_array) < 4:
        return -1

    for row in input_array:
        if row is None or len(row) < 1:
            return -1
        print(" ".join(map(str, row)))

    rows = len(input_array)
    cols = len(input_array[0])

    # Initialize the dp array
    dp = [[0] * cols for _ in range(rows)]
    max_size = -1

    # Fill the first row and first column
    for j in range(cols):
        dp[0][j] = input_array[0][j]

    for i in range(rows):
        dp[i][0] = input_array[i][0]

    # Fill the rest of the dp array
    for i in range(1, rows):
        for j in range(1, cols):
            if input_array[i][j] == 1:
                dp[i][j] = min_of_three(dp[i-1][j], dp[i-1][j-1], dp[i][j-1]) + 1
                max_size = max(max_size, dp[i][j])

    return max_size

def main():
    matrix = [
        [0, 0, 1, 1, 1],
        [1, 0, 1, 1, 1],
        [0, 1, 1, 1, 1],
        [1, 0, 1, 1, 1]
    ]
    print(max_sub_square_matrix(matrix))

if __name__ == "__main__":
    main()
