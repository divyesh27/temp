/**
 * Find number of island in given matrix of zero and one. Zero is water and one is island
 * All adjacent one should be counted as island except diagonal
 * @author divyesh.shah
 *
 */
public class FindNumberOfIslandRepresentsAdjacentOnesAndWaterZero {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		char[][] matrix = new char[][]{
		  { 0, 0, 1, 1, 1 },
		  { 1, 0, 1, 1, 1 },
		  { 0, 1, 1, 1, 1 },
		  { 1, 0, 1, 1, 1 }
		};
		char[][] matrix1 = new char[][]{
			{1,1,1,1,0},
			{1,1,0,1,0},
			{1,1,0,0,0},
			{0,0,0,0,0}
		};
		char[][] matrix2 = new char[][]{
			{1,1,0,0,0},
			{1,1,0,0,0},
			{0,0,1,0,0},
			{0,0,0,1,1}
		};
		
		System.out.println(FindNumberOfIsland(matrix));
		System.out.println(FindNumberOfIsland(matrix1));
		System.out.println(FindNumberOfIsland(matrix2));
	}
	
	public static int FindNumberOfIsland(char[][] inputarray)
	{
		if(inputarray == null || inputarray[0].length < 1 || inputarray.length < 1)
			return 1;
		
		int numisland = 0;
		for(int i=0; i < inputarray.length; i++) {
			for(int j=0; j < inputarray[0].length; j++) {
				if(inputarray[i][j] == 1) {
					numisland++;
					dfs(inputarray, i, j);
				}
			}
		}
		return numisland;
		
	}
	private static void dfs(char[][]inputarray,int row,int col) {
		
		if(row < 0 || col < 0 || row >= inputarray.length || col >= inputarray[0].length || inputarray[row][col] == 0)
			return;
		inputarray[row][col] = 0;
		dfs(inputarray,row-1,col);
		dfs(inputarray,row+1,col);
		dfs(inputarray,row,col-1);
		dfs(inputarray,row,col+1);
	}
	

}
