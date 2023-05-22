import java.util.*;
/**
 * @author divyesh.shah
 *
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 *
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 * Note:
 *
 * A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 * Only the filled cells need to be validated according to the mentioned rules.
 *
 * Input: board =
 * [["5","3",".",".","7",".",".",".","."]
 * ,["6",".",".","1","9","5",".",".","."]
 * ,[".","9","8",".",".",".",".","6","."]
 * ,["8",".",".",".","6",".",".",".","3"]
 * ,["4",".",".","8",".","3",".",".","1"]
 * ,["7",".",".",".","2",".",".",".","6"]
 * ,[".","6",".",".",".",".","2","8","."]
 * ,[".",".",".","4","1","9",".",".","5"]
 * ,[".",".",".",".","8",".",".","7","9"]]
 * Output: true
 *
 * Input: board =
 * [["8","3",".",".","7",".",".",".","."]
 * ,["6",".",".","1","9","5",".",".","."]
 * ,[".","9","8",".",".",".",".","6","."]
 * ,["8",".",".",".","6",".",".",".","3"]
 * ,["4",".",".","8",".","3",".",".","1"]
 * ,["7",".",".",".","2",".",".",".","6"]
 * ,[".","6",".",".",".",".","2","8","."]
 * ,[".",".",".","4","1","9",".",".","5"]
 * ,[".",".",".",".","8",".",".","7","9"]]
 * Output: false
 * Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8.
 * Since there are two 8's in the top left 3x3 sub-box, it is invalid.
 */
public class SudokuGame {
    public boolean isValidSudoku(char[][] board) {
        // Initialize hash sets for rows, columns and sub-boxes
        Set<Character>[] rows = new HashSet[9];
        Set<Character>[] cols = new HashSet[9];
        Set<Character>[] boxes = new HashSet[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<Character>();
            cols[i] = new HashSet<Character>();
            boxes[i] = new HashSet<Character>();
        }

        // Traverse through the board and check for each cell
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    // Check for duplicate values in row, column and sub-box
                    if (!rows[i].add(c) || !cols[j].add(c) || !boxes[(i/3)*3+j/3].add(c)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    /*
    * [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]
    *
    * [["8","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]
    * */

    public void solveSudoku(char[][] board) {
        solveSudokuHelper(board, 0, 0);
    }

    private boolean solveSudokuHelper(char[][] board, int row, int col) {
        if (col == 9) {  // end of row, move to next row
            row++;
            col = 0;
        }
        if (row == 9) {  // finished all rows, puzzle solved
            return true;
        }
        if (board[row][col] != '.') {  // skip non-empty cells
            return solveSudokuHelper(board, row, col+1);
        }
        for (char ch = '1'; ch <= '9'; ch++) {  // try all possible values
            if (isValid(board, row, col, ch)) {
                board[row][col] = ch;
                if (solveSudokuHelper(board, row, col+1)) {
                    return true;
                }
                board[row][col] = '.';  // backtrack
            }
        }
        return false;
    }

    private boolean isValid(char[][] board, int row, int col, char ch) {
        for (int i = 0; i < 9; i++) {  // check row and column
            if (board[row][i] == ch || board[i][col] == ch) {
                return false;
            }
        }
        int subgridRow = (row / 3) * 3;
        int subgridCol = (col / 3) * 3;
        for (int i = subgridRow; i < subgridRow + 3; i++) {  // check 3x3 subgrid
            for (int j = subgridCol; j < subgridCol + 3; j++) {
                if (board[i][j] == ch) {
                    return false;
                }
            }
        }
        return true;
    }
}
