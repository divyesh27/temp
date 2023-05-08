import java.util.Random;

/**
 * @author divyesh.shah
 *
 * for e.g
 * rows = 4
 * col = 4
 * bomb = 2;
 *
 * Place bomb to the given board at random location and update the surrounding values
 * accordingly.This is an classic example of game minesweeper using dfs or depth first search
 * Create a board with all 0 and for bomb place -1 and for adjacent cells it will be incremental
 * with 1 using DFS / dfs search within matrix
 *
 *  for e.g
 *  rows = 4
 *  col = 4
 *  bomb = 2;
 *
 * for e.g
 * 1  1  0  0
 *-1  2  1  1
 * 1  2 -1  1
 * 0  1  1  1
 */
public class FindBombAndValuesAssociatedToMinesweeperDFSAsZeroAndOne {

    public static void main(String[] args) {
        int row = 6;
        int col = 4;
        int bomb = 2;
        int[][] board = new int[row][col];
        printBoard(board);
        plantBombs(board,bomb);
        printBoard(board);
        traverseBoard(board);
        printBoard(board);

    }

    public static void printBoard(int[][] board) {
        for(int i=0; i< board.length; i++) {
            for(int j=0; j< board[0].length; j++){
                System.out.print(board[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("***********************");
    }

    private static void plantBombs(int[][] board, int bomb) {
        Random rand = new Random();
        int count = 0;
        while(count < bomb) {
            int row = rand.nextInt(board.length);
            int col = rand.nextInt(board[0].length );
            if(board[row][col] == 0) {
                board[row][col] = -1;
                count ++;
            }
        }
    }
    private static void traverseBoard(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        for(int i=0; i < rows; i++) {
            for(int j=0; j < cols; j++) {
                if(board[i][j]==-1) {
                    continue;
                }
                updateValue(board,i,j);
            }
        }
    }

    private static void updateValue(int[][]board, int row, int col) {
        int count = 0;
        int rows = board.length;
        int cols = board[0].length;
        for (int x = Math.max(0, row - 1); x <= Math.min(rows - 1, row + 1); x++) {
            for (int y = Math.max(0, col - 1); y <= Math.min(cols - 1, col + 1); y++) {
                if (board[x][y] == -1) {
                    count++;
                }
            }
        }
        board[row][col] = count;
    }
    private static void dfs(int[][]board,int row,int col) {

        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length)
            return;

        System.out.println(board[row][col]);
        dfs(board,row-1,col);
        dfs(board,row+1,col);
        dfs(board,row,col-1);
        dfs(board,row,col+1);
        dfs(board, row-1, col-1);
        dfs(board, row+1, col+1);
        dfs(board, row-1, col+1);
        dfs(board, row+1, col-1);

    }
}
