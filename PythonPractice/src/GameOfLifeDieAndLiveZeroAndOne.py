'''
According to Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

The board is made up of an m x n grid of cells, where each cell has an initial state: live (represented by a 1) or dead (represented by a 0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

Any live cell with fewer than two live neighbors dies as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population.
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously. Given the current state of the m x n grid board, return the next state.



Example 1:


Input: board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
Output: [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]
Example 2:


Input: board = [[1,1],[1,0]]
Output: [[1,1],[1,1]]

Matrix with 0 and 1

'''
from typing import List
class GameOfLifeDieAndLiveZeroAndOne:

    def __init__(self, matrix_board):
        """

        :param matrix_board:
        """
        self.matrix_board = matrix_board
        self.row_size = len(matrix_board)
        self.col_size = len(matrix_board[0])

    def count_live_neighbors(self, row, col):
        """
        Count the number of live neighbors for the cell at (r, c).

        :param r: int - Row index of the cell.
        :param c: int - Column index of the cell.
        :return: int - Number of live neighbors.
        """
        directions = [(-1, -1), (-1, 0), (-1, 1), (0, -1), (0, 1), (1, -1), (1, 0), (1, 1)]
        live_neighbors = 0

        for d_row, d_col in directions:
            n_row, n_col = row + d_row, col + d_col

            if 0 <= n_row < self.row_size and 0 <= n_col < self.col_size and abs(self.matrix_board[n_row][n_col] == 1):
                live_neighbors += 1

        return live_neighbors

    def apply_rules(self):
        """
                First pass: Apply rules and mark cells with temporary values

        :return:
        """
        for row in range(self.row_size):
            for col in range(self.col_size):

                live_neighbors = self.count_live_neighbors(row, col)

                if self.matrix_board[row][col] == 1 and (live_neighbors < 2 or live_neighbors > 3):
                    self.matrix_board[row][col] = -1 # Dying cell set with it
                elif self.matrix_board[row][col] == 0 and live_neighbors == 3:
                    self.matrix_board[row][col] = 2 # Mark as cell that becomes alive

        # # Second pass: Finalize the board state

        for row in range(self.row_size):
            for col in range(self.col_size):
                if self.matrix_board[row][col] > 0:
                    self.matrix_board[row][col] = 1   # Live cell
                else:
                    self.matrix_board[row][col] = 0   # dead cell

    def get_board(self):
        """
        Get the current state of the board.

        :return: List[List[int]] - The current board state.
        """
        return self.matrix_board

if __name__ == "__main__":
    initial_board1 = [[0, 1, 0], [0, 0, 1], [1, 1, 1], [0, 0, 0]]
    game1 = GameOfLifeDieAndLiveZeroAndOne(initial_board1)
    game1.apply_rules()
    print(game1.get_board())  # Output: [[0, 0, 0], [1, 0, 1], [0, 1, 1], [0, 1, 0]]

    initial_board2 = [[1, 1], [1, 0]]
    game2 = GameOfLifeDieAndLiveZeroAndOne(initial_board2)
    game2.apply_rules()
    print(game2.get_board())  # Output: [[1, 1], [1, 1]]


"""
OR EXECUTE BELOW WITHOUT OOPS

def game_of_life(board):
    # Get the dimensions of the board
    m, n = len(board), len(board[0])

    # Helper function to count live neighbors
    def count_live_neighbors(r, c):
        directions = [(-1, -1), (-1, 0), (-1, 1), (0, -1), (0, 1), (1, -1), (1, 0), (1, 1)]
        live_neighbors = 0
        for dr, dc in directions:
            nr, nc = r + dr, c + dc
            if 0 <= nr < m and 0 <= nc < n and abs(board[nr][nc]) == 1:
                live_neighbors += 1
        return live_neighbors

    # Update the board in place
    for i in range(m):
        for j in range(n):
            live_neighbors = count_live_neighbors(i, j)

            # Apply the rules to compute the next state
            if board[i][j] == 1 and (live_neighbors < 2 or live_neighbors > 3):
                board[i][j] = -1  # Dying cell (from live to dead)
            if board[i][j] == 0 and live_neighbors == 3:
                board[i][j] = 2   # Newborn cell (from dead to live)

    # Update the board to the final next state
    for i in range(m):
        for j in range(n):
            if board[i][j] > 0:
                board[i][j] = 1
            else:
                board[i][j] = 0

    return board

# Example usage:
board1 = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
print(game_of_life(board1))  # Output: [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]

board2 = [[1,1],[1,0]]
print(game_of_life(board2))  # Output: [[1,1],[1,1]]

"""