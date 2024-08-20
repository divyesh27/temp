import numpy as np

def find_max_sub_square(input_matrix):
    """
    Finds the largest square submatrix of 1s in a given binary matrix and prints it.

    Args:
    input_matrix (List[List[int]]): A 2D list representing the binary matrix.

    Returns:
    None
    """
    if not input_matrix or not input_matrix[0]:
        raise ValueError("Pass a valid input matrix")

    rows = len(input_matrix)
    cols = len(input_matrix[0])

    # Create a result matrix with the same dimensions as input_matrix
    result = np.zeros((rows, cols), dtype=int)

    # Initialize variables to store the position and size of the largest square
    max_i = max_j = max_result = 0

    # Fill the first row and column of the result matrix
    for i in range(rows):
        result[i][0] = input_matrix[i][0]
    for j in range(cols):
        result[0][j] = input_matrix[0][j]

    # Compute the maximum size of the square submatrix of 1s
    for i in range(1, rows):
        for j in range(1, cols):
            if input_matrix[i][j] == 1:
                result[i][j] = min(result[i-1][j], min(result[i][j-1], result[i-1][j-1])) + 1
            else:
                result[i][j] = 0

    # Find the maximum value and its position in the result matrix
    for i in range(rows):
        for j in range(cols):
            if result[i][j] > max_result:
                max_result = result[i][j]
                max_i = i
                max_j = j

    # Print the largest square submatrix
    for i in range(max_i, max_i - max_result, -1):
        for j in range(max_j, max_j - max_result, -1):
            print(input_matrix[i][j], end=" ")
        print()

if __name__ == "__main__":
    input_matrix1 = [
        [1, 1, 1, 0],
        [1, 1, 1, 1],
        [0, 1, 1, 0],
        [0, 1, 1, 1],
        [1, 0, 0, 1],
        [1, 1, 1, 1]
    ]

    input_matrix2 = [
        [0, 1, 1, 0, 1],
        [1, 1, 0, 1, 0],
        [0, 1, 1, 1, 0],
        [1, 1, 1, 1, 0],
        [1, 1, 1, 1, 1],
        [0, 0, 0, 0, 0]
    ]

    print("Max Sub Square for input_matrix1:")
    find_max_sub_square(input_matrix1)

    print("\nMax Sub Square for input_matrix2:")
    find_max_sub_square(input_matrix2)
