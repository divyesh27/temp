from typing import List, Optional

def fill_color(matrix: List[List[int]], x: int, y: int, new_color: int) -> None:
    if not isinstance(matrix, list) or not all(isinstance(row, list) for row in matrix):
        raise TypeError("Matrix must be a list of lists")
    if not all(isinstance(cell, int) for row in matrix for cell in row):
        raise TypeError("Matrix must contain only integers")
    if not isinstance(x, int) or not isinstance(y, int) or not isinstance(new_color, int):
        raise TypeError("x, y, and new_color must be integers")
    if x < 0 or y < 0 or x >= len(matrix) or y >= len(matrix[0]):
        raise ValueError("x or y is out of bounds")

    prev_color = matrix[x][y]
    if prev_color == new_color:
        return

    def fill_color_around(matrix: List[List[int]], x: int, y: int, prev_color: int, new_color: int) -> None:
        if x < 0 or y < 0 or x >= len(matrix) or y >= len(matrix[0]):
            return
        if matrix[x][y] != prev_color:
            return

        matrix[x][y] = new_color

        fill_color_around(matrix, x + 1, y, prev_color, new_color)
        fill_color_around(matrix, x - 1, y, prev_color, new_color)
        fill_color_around(matrix, x, y + 1, prev_color, new_color)
        fill_color_around(matrix, x, y - 1, prev_color, new_color)

    fill_color_around(matrix, x, y, prev_color, new_color)

# Example usage:
matrix = [
    [0, 0, 1, 1, 1],
    [1, 0, 1, 1, 1],
    [0, 1, 1, 1, 1],
    [1, 0, 1, 1, 1]
]

fill_color(matrix, 1, 1, 3)

for row in matrix:
    print(' '.join(map(str, row)))
