from typing import List, Optional

def dfs(matrix: List[List[int]], visited: List[int], index: int) -> None:
    for j in range(len(matrix)):
        if matrix[index][j] == 1 and visited[j] == 0:
            visited[j] = 1
            dfs(matrix, visited, j)

def find_circle(matrix: Optional[List[List[int]]]) -> int:
    if matrix is None:
        raise ValueError("The input matrix must not be None.")
    if not isinstance(matrix, list) or not all(isinstance(row, list) and all(isinstance(i, int) for i in row) for row in matrix):
        raise ValueError("The input must be a list of lists of integers.")
    if len(matrix) == 0 or any(len(row) != len(matrix) for row in matrix):
        raise ValueError("The input must be a non-empty square matrix.")

    visited = [0] * len(matrix)
    count = 0

    for i in range(len(matrix)):
        if visited[i] == 0:
            dfs(matrix, visited, i)
            count += 1

    return count

def main():
    matrix = [ [ 1, 1, 0 ],
               [ 1, 1, 0 ],
               [ 0, 0, 1 ] ]

    matrix1 = [ [ 1, 1, 0 ],
                [ 1, 1, 1 ],
                [ 0, 1, 1 ] ]

    matrix2 = [ [ 1, 1, 1, 1, 1 ],
                [ 0, 1, 0, 0, 0 ],
                [ 0, 0, 1, 0, 0 ],
                [ 0, 0, 0, 1, 1 ],
                [ 0, 0, 0, 1, 1 ] ]

    try:
        print(find_circle(matrix))
        print(find_circle(matrix1))
        print(find_circle(matrix2))
    except ValueError as e:
        print(e)

if __name__ == "__main__":
    main()
