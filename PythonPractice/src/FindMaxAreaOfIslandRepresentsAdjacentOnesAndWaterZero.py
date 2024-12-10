'''
Find how big island (1)(One) area is which is surrounded by water (0)(Zero)
Only find the adjacent which are horizontal and vertical and ignore diagonal
Out of all the found island area only return the max or biggest island
'''
from typing import List

def max_area_of_island(input_array: List[List[int]]) -> int:
    if input_array is None or len(input_array) == 0 or len(input_array[0]) == 0:
        return 0

    def dfs(matrix: List[List[int]], row: int, col: int) -> int:
        if row < 0 or col < 0 or row >= len(matrix) or col >= len(matrix[0]) or matrix[row][col] == 0:
            return 0

        matrix[row][col] = 0  # Mark the cell as visited
        area = 1  # Count the current cell

        # Explore adjacent cells (up, down, left, right)
        area += dfs(matrix, row - 1, col)
        area += dfs(matrix, row + 1, col)
        area += dfs(matrix, row, col - 1)
        area += dfs(matrix, row, col + 1)

        return area

    max_area = 0
    for i in range(len(input_array)):
        for j in range(len(input_array[0])):
            if input_array[i][j] == 1:
                # Calculate the area of the current island
                max_area = max(max_area, dfs(input_array, i, j))

    return max_area

def main():
    matrix = [
        [0, 0, 1, 1, 0],
        [1, 0, 1, 1, 0],
        [0, 1, 0, 0, 0],
        [0, 0, 0, 0, 1]
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

    print(max_area_of_island(matrix))   # Output: 4
    print(max_area_of_island(matrix1))  # Output: 9
    print(max_area_of_island(matrix2))  # Output: 4

if __name__ == "__main__":
    main()