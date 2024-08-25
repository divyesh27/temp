from typing import List

def find_number_of_islands(input_array: List[List[int]]) -> int:
    if input_array is None or len(input_array) == 0 or len(input_array[0]) == 0:
        return 0

    def dfs(matrix: List[List[int]], row: int, col: int):
        if row < 0 or col < 0 or row >= len(matrix) or col >= len(matrix[0]) or matrix[row][col] == 0:
            return

        matrix[row][col] = 0  # Mark the cell as visited

        # Explore adjacent cells (up, down, left, right)
        dfs(matrix, row - 1, col)
        dfs(matrix, row + 1, col)
        dfs(matrix, row, col - 1)
        dfs(matrix, row, col + 1)

    num_islands = 0
    for i in range(len(input_array)):
        for j in range(len(input_array[0])):
            if input_array[i][j] == 1:
                num_islands += 1
                dfs(input_array, i, j)

    return num_islands

def main():
    matrix = [
        [0, 0, 1, 1, 1],
        [1, 0, 1, 1, 1],
        [0, 1, 1, 1, 1],
        [1, 0, 1, 1, 1]
    ]
    matrix1 = [
        [1, 1, 1, 1, 0],
        [1, 1, 0, 1, 0],
        [1, 1, 0, 0, 0],
        [0, 0, 0, 0, 0]
    ]
    matrix2 = [
        [1, 1, 0, 0, 0],
        [1, 1, 0, 0, 0],
        [0, 0, 1, 0, 0],
        [0, 0, 0, 1, 1]
    ]

    print(find_number_of_islands(matrix))   # Output: 1
    print(find_number_of_islands(matrix1))  # Output: 1
    print(find_number_of_islands(matrix2))  # Output: 3

if __name__ == "__main__":
    main()
