import java.util.Stack;


public class MaxSizeSubSquareMatrixOf1 {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		//For both answer is 12
		int[][]input = {{1,1,1,0},
		                {1,1,1,1},
		                {0,1,1,0},
		                {0,1,1,1},
		                {1,0,0,1},
		                {1,1,1,1}};

		int M[][] =  {{0, 1, 1, 0, 1}, 
                	  {1, 1, 0, 1, 0}, 
                	  {0, 1, 1, 1, 0},
                	  {1, 1, 1, 1, 0},
                	  {1, 1, 1, 1, 1},
                	  {0, 0, 0, 0, 0}};
		
		findMaxSubSquare(input);
		findMaxSubSquare(M);

	}
	
	static void findMaxSubSquare(int [][] input) {
		
		int row = input.length;
		int col = input[0].length;
		int[][] result = new int[row][col];
		int i,j;
		int max_i, max_j, max_result;
		for(i=0; i<row; i++) {
			result[i][0] = input[i][0];
		}
		for(j=0; j<col; j++) {
			result[0][j] = input[0][j];
		}
		
		for(i=1; i< row; i++) {
			for(j=1; j<col; j++) {
				if(input[i][j] == 1) {
					result[i][j] = Math.min(result[i-1][j], Math.min(result[i][j-1], result[i-1][j-1])) + 1;
				}
				else {
					result[i][j] = 0;
				}
			}
		}
		max_result = result[0][0];
		max_i = max_j = 0;
		
		for(i=0; i<row; i++) {
			for(j=0; j<col; j++) {
				if(max_result < result[i][j]) {
					max_result = result[i][j];
					max_i = i;
					max_j = j;
				}
			}
		}
		
		for(i=max_i; i>max_i-max_result; i--) {
			for(j=max_j; j>max_j-max_result; j--) {
				System.out.print(input[i][j] + " ");
			}
			System.out.println();
		}
		//Find max entry
	}
	
}


