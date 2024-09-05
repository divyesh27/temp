import random
from typing import List, Optional


def main():
    row = 6
    col = 4
    bomb = 2

    # Initialize board
    board = [[0 for _ in range(col)] for _ in range(row)]
    print_board(board)

    plant_bombs(board, bomb)
    print_board(board)

    traverse_board(board)
    print_board(board)


def print_board(board: Optional[List[List[int]]]) -> None:
    if not board:
        print("Board is empty or null")
        return

    for row in board:
        print("\t".join(map(str, row)))
    print("***********************")


def plant_bombs(board: List[List[int]], bomb: int) -> None:
    if not board or bomb <= 0:
        return

    rows = len(board)
    cols = len(board[0]) if rows > 0 else 0
    count = 0
    rand = random.Random()

    while count < bomb:
        row = rand.randint(0, rows - 1)
        col = rand.randint(0, cols - 1)
        if board[row][col] == 0:
            board[row][col] = -1
            count += 1


def traverse_board(board: List[List[int]]) -> None:
    if not board:
        return

    rows = len(board)
    cols = len(board[0]) if rows > 0 else 0

    for i in range(rows):
        for j in range(cols):
            if board[i][j] == -1:
                continue
            update_value(board, i, j)


def update_value(board: List[List[int]], row: int, col: int) -> None:
    if not board:
        return

    count = 0
    rows = len(board)
    cols = len(board[0]) if rows > 0 else 0

    for x in range(max(0, row - 1), min(rows - 1, row + 1) + 1):
        for y in range(max(0, col - 1), min(cols - 1, col + 1) + 1):
            if board[x][y] == -1:
                count += 1
    board[row][col] = count


def dfs(board: List[List[int]], row: int, col: int) -> None:
    if row < 0 or col < 0 or row >= len(board) or col >= len(board[0]):
        return

    print(board[row][col])
    dfs(board, row - 1, col)
    dfs(board, row + 1, col)
    dfs(board, row, col - 1)
    dfs(board, row, col + 1)
    dfs(board, row - 1, col - 1)
    dfs(board, row + 1, col + 1)
    dfs(board, row - 1, col + 1)
    dfs(board, row + 1, col - 1)


if __name__ == "__main__":
    main()
