
public class FillOsWIthXsIfSurroundedByXs {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		char[][] matrix = new char[][]{
		  { 'O', 'O', 'X', 'X', 'X' },
		  { 'X', 'O', 'X', 'X', 'X' },
		  { 'O', 'X', 'X', 'O', 'O' },
		  { 'X', 'O', 'X', 'X', 'X' }
		};
		
		char[][] matrix = new char[][]{
			  { 'X', 'X', 'X', 'X', 'X' },
			  { 'X', 'O', 'O', 'X', 'X' },
			  { 'X', 'X', 'X', 'O', 'X' },
			  { 'X', 'O', 'X', 'X', 'X' }
			}; 
		char[][] matrix = new char[][]{
				{'X','X','X','X'},
		        {'X','X','O','X'},
		        {'X','O','X','X'},
		        {'X','X','O','X'}};
		*/
        char matrix[][] =  new char[][]{
        		 {'X', 'O', 'X', 'O', 'X', 'X'},
                 {'X', 'O', 'X', 'X', 'O', 'X'},
                 {'X', 'X', 'X', 'O', 'X', 'X'},
                 {'O', 'X', 'X', 'X', 'X', 'X'},
                 {'X', 'X', 'X', 'O', 'X', 'O'},
                 {'O', 'O', 'X', 'O', 'O', 'O'},
                };
			replaceVal(matrix);
			printMatrix(matrix);
		
	}
	
	static void replaceVal(char[][] matrix) {
		int row = matrix.length;
		int col = matrix[0].length;
		int i,j;
		for(i=0; i<row; i++) {
			for(j=0; j<col; j++) {
				if(matrix[i][j] == 'O')
					matrix[i][j] = '+';
			}
		}
		printMatrix(matrix);
		for(i=0; i<row; i++) {
			if(matrix[i][0] == '+')
				fillColorAround(matrix,i,0,'+','O');
		}
		for(i=0; i<row; i++) {
			if(matrix[i][col-1] == '+')
				fillColorAround(matrix,i,col-1,'+','O');
		}
		for(i=0; i<col; i++) {
			if(matrix[0][i] == '+')
				fillColorAround(matrix,0,i,'+','O');
		}
		for(i=0; i<col; i++) {
			if(matrix[row-1][i] == '+')
				fillColorAround(matrix,row-1,i,'+','O');
		}
		printMatrix(matrix);
		for(i=0; i<row; i++) {
			for(j=0; j<col; j++) {
				if(matrix[i][j] == '+')
					matrix[i][j] = 'X';
			}
		}
		printMatrix(matrix);
		
	}
	static void fillColorAround(char[][] matrix, int x, int y, char prevVal, char newVal) {
		if(x < 0 || y < 0 || x >= matrix.length || y >= matrix[0].length) 
			return;
		if(matrix[x][y] != prevVal)
			return;
		
		matrix[x][y] = newVal;
		
		fillColorAround(matrix, x+1, y, prevVal, newVal);
		fillColorAround(matrix, x-1, y, prevVal, newVal);
		fillColorAround(matrix, x, y+1, prevVal, newVal);
		fillColorAround(matrix, x, y-1, prevVal, newVal);
		
	}
	
	static void printMatrix(char[][] matrix) {
		System.out.println("**************************");
		for(int i=0; i < matrix.length; i++) {
			for(int j=0; j < matrix[0].length; j++) {
				System.out.print(" " + matrix[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("**************************");
	}
	
}
