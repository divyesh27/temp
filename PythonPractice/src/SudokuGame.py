from typing import List, Optional, Set

class SudokuGame:
    def is_valid_sudoku(self, board: Optional[List[List[str]]]) -> bool:
        if board is None or len(board) != 9 or any(len(row) != 9 for row in board):
            raise ValueError("Pass a valid 9x9 Sudoku board")

        # Initialize sets for rows, columns, and sub-boxes
        rows = [set() for _ in range(9)]
        cols = [set() for _ in range(9)]
        boxes = [set() for _ in range(9)]

        # Traverse through the board and check each cell
        for i in range(9):
            for j in range(9):
                c = board[i][j]
                if c != '.':
                    box_index = (i // 3) * 3 + j // 3
                    if (c in rows[i] or c in cols[j] or c in boxes[box_index]):
                        return False
                    rows[i].add(c)
                    cols[j].add(c)
                    boxes[box_index].add(c)
        return True

    def solve_sudoku(self, board: Optional[List[List[str]]]) -> None:
        if board is None or len(board) != 9 or any(len(row) != 9 for row in board):
            raise ValueError("Pass a valid 9x9 Sudoku board")

        self.solve_sudoku_helper(board, 0, 0)

    def solve_sudoku_helper(self, board: List[List[str]], row: int, col: int) -> bool:
        if col == 9:
            row += 1
            col = 0
        if row == 9:
            return True
        if board[row][col] != '.':
            return self.solve_sudoku_helper(board, row, col + 1)

        for ch in map(str, range(1, 10)):
            if self.is_valid(board, row, col, ch):
                board[row][col] = ch
                if self.solve_sudoku_helper(board, row, col + 1):
                    return True
                board[row][col] = '.'  # backtrack

        return False

    def is_valid(self, board: List[List[str]], row: int, col: int, ch: str) -> bool:
        for i in range(9):
            if board[row][i] == ch or board[i][col] == ch:
                return False
        subgrid_row = (row // 3) * 3
        subgrid_col = (col // 3) * 3
        for i in range(subgrid_row, subgrid_row + 3):
            for j in range(subgrid_col, subgrid_col + 3):
                if board[i][j] == ch:
                    return False
        return True

def main():
    board1 = [
        ["5","3",".",".","7",".",".",".","."],
        ["6",".",".","1","9","5",".",".","."],
        [".","9","8",".",".",".",".","6","."],
        ["8",".",".",".","6",".",".",".","3"],
        ["4",".",".","8",".","3",".",".","1"],
        ["7",".",".",".","2",".",".",".","6"],
        [".","6",".",".",".",".","2","8","."],
        [".",".",".","4","1","9",".",".","5"],
        [".",".",".",".","8",".",".","7","9"]
    ]

    board2 = [
        ["8","3",".",".","7",".",".",".","."],
        ["6",".",".","1","9","5",".",".","."],
        [".","9","8",".",".",".",".","6","."],
        ["8",".",".",".","6",".",".",".","3"],
        ["4",".",".","8",".","3",".",".","1"],
        ["7",".",".",".","2",".",".",".","6"],
        [".","6",".",".",".",".","2","8","."],
        [".",".",".","4","1","9",".",".","5"],
        [".",".",".",".","8",".",".","7","9"]
    ]

    game = SudokuGame()
    print(game.is_valid_sudoku(board1))  # Output: True
    print(game.is_valid_sudoku(board2))  # Output: False
    game.solve_sudoku(board1)
    for row in board1:
        print(row)

if __name__ == "__main__":
    main()
