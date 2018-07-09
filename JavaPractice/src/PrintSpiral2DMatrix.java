
public class PrintSpiral2DMatrix {

	// You are given two integers, width and height. Using width and height, draw a spiral to the screen.

	// e.g. 10 by 10
	// 1111111111
	// 1
	// 1 11111111
	// 1 1      1
	// 1 1 1111 1
	// 1 1 1  1 1
	// 1 1    1 1
	// 1 111111 1
	// 1        1
	// 1111111111
    /*
	
	1111111111
	1
	1 11111111
	1 1	 	 1
	1 1 1111 1
	1 1 11 1 1
	1 1    1 1
	1 111111 1	
	1	 	 1
	1111111111
	
	11111
	1 
	1 111
	1   1
	11111
	*/
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		printSpiralMatrix1(15,15);
	}
	

	public static void print(int[][] matrix) {
		for(int i=0; i < matrix.length; i++) {
			for(int j=0; j < matrix[0].length; j++) {
				System.out.print(" " + matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
	public static void printSpiralMatrix(int row, int col)
	{
	    int[][] inputMatrix = new int[row][col];
	    int j=0;
	    int k=0;
	    int i;
	    
	    for(i=0; i<row; i++) {
	      for(j=0; j<col; j++) {
	        inputMatrix[i][j] = 1;
	      }
	    }
	    //print(inputMatrix);
	    i = j = 0;
	    while (k < row && j < col)
	    {
	        // Print the first row from the remaining rows
	        for (i = j; i < col; ++i)
	        {
	            inputMatrix[k][i] = 1;
	        }
	        k++;
	        
	        // Print the last column from the remaining columns 
	        for (i = k; i < row; ++i)
	        {
	        	inputMatrix[i][col-1] = 1;
	        }
	        col--;
	
	        // Print the last row from the remaining rows 
	        if ( k < row)
	        {
	            for (i = row-1; i >= k; --i)
	            {
	                inputMatrix[row-1][i] = 1;
	            }
	            row--;
	        }
	        
	        // Print the first column from the remaining columns 
	        if (j < col)
	        {
	            for (i = col-1; i >= j; --i)
	            {
	                inputMatrix[i][j] = 1;
	                
	            }
	            j++;    
	        }  
	        
	    }
	    print(inputMatrix);
					   
	}
	
	public static void printSpiralMatrix1(int row, int col)
	{
	    int[][] inputMatrix = new int[row][col];
	    int left = 0;
	    int up = 0;
	    int right = col-1;
	    int down = row-1;
	    int i;
	    
	    /*
	    for(i=0; i<row; i++) {
	      for(j=0; j<col; j++) {
	        inputMatrix[i][j] = 1;
	      }
	    }*/
	    //print(inputMatrix);
	   // i = j = 0;
        // Print the first row from the remaining rows
	    while(left <= right && up <= down) {
		    for (i = left; i <= right; i++)
	        {
	            inputMatrix[up][i] = 1;
	        }
		    up=up+2;
		    //print(inputMatrix);
		    // Print the last column from the remaining columns 
	        for (i = up; i <= down; i++)
	        {
	        	inputMatrix[i][right] = 1;
	        }
	        right=right-2;
	        //print(inputMatrix);
	        
	        if(left <= right) {
	        	for(i = down; i > up; i--) {
	        		inputMatrix[i][left] = 1;
	        	}
	        }
	        //print(inputMatrix);
	        
	        down=down-2;
	        if(up <= down) {
	        	for(i = right; i >= left; i--) {
	        		inputMatrix[down][i] = 1;
	        	}
	        }
	        left = left+2;
	    }	
       
        
        
	    print(inputMatrix);
	}
}
