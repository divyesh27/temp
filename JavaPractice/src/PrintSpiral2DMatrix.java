/**
 * Program to print Spiral anti clock wise as show in below figure.
 * Time complexity O(row*col)
 * @author divyesh.shah
 *
 */
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
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//printSpiralMatrix(10,10);
		//printSpiralMatrix(4,4);
		//printSpiralMatrix(5,5);
		//printSpiralMatrix(4,16);
		//printSpiralMatrix(7,9);
		//printSpiralMatrix(8,12);
		//printSpiralMatrix(0,0);
		//printSpiralMatrix(4,0);
		//printSpiralMatrix(15,19);
		printSpiralMatrix(5,15);
		
	}
	
	public static void printSpiralMatrix(int row, int col)
	{
		// Check for if any input is given 0 or -ve numbers then return
		if(row <= 0 || col <= 0)
			return;
	    char[][] inputMatrix = new char[row][col];  // matrix to add 1 and ' '
	    int left = 0;      // start of row index
	    int up = 0;        // start of col index
	    int right = inputMatrix[0].length-1; // end of col index
	    int down = inputMatrix.length-1;     // end of row index
	    int i;
	    boolean flag = true;                 // flag to track alternative approach for 1 and ' '
	    
	    
        // condition to make sure start index is less or equal to end index of col and row
	    while(left <= right && up <= down) 
	    {
	    	if(flag)  // flag to add 1
	    	{
	    		// Add 1 to row from right to left index
			    for (i = right; i >= left; i--) {
		            inputMatrix[up][i] = '1';
		        }
			    up++;
			    
			    // Add 1 to left col from up to down index
		        for (i = up; i <= down; i++) {
		        	inputMatrix[i][left] = '1';
		        }
		        left++;
		        
		        // This is to add from left to right index from the down index
		        // Also check for the last iteration when the up and down is equal
		        // we want to add space.
		        if(left <= right) {
		        	for(i = left; i <= right; i++) {
		        		if(up == down) {
		        			inputMatrix[down][i] = ' ';
		        		}
		        		else {
		        			inputMatrix[down][i] = '1';
		        		}
	        		}
	        	}
		        down--;
		        // This is to add from down index to up index on right most col.
		    	for(i = down; i >= up; i--) {
	        		inputMatrix[i][right] = '1';
	        	}
		        right--;
		    
		        flag = false; // set flag to iterate for space
		    }
	    	else {
	    		// This is to add alternative one with space from
	    		// right to left index for row
	    		for (i = right+1; i >= left; i--) {
		            inputMatrix[up][i] = ' ';
		        }
			    up++;
			    
			    // This is to add alternative one with space from
	    		// up to down on left cols
		        for (i = up; i <= down; i++) {
		        	inputMatrix[i][left] = ' ';
		        }
		        left++;
		        
		        // This is to add alternative one with space from
	    		// right to left index for down row
		       	for(i = left; i <= right; i++) {
		        		inputMatrix[down][i] = ' ';
		        	}
		        down--;
		        
		        // This is to add alternative one with space from
		        // down to up index for right col.
		        // and Add 1 to end of it overwrite with 1.
		        if(up <= down) {
		        	for(i = down; i >= up; i--) {
		        		inputMatrix[i][right] = ' ';
		        	}
		        	inputMatrix[i+1][right]= '1';
		        }
		        right--;
	    		flag = true;
	    	}
	    }	
	    // Call print function with updated matrix
        print(inputMatrix);
	}

	// Print entire matrix with all given values of 1 and space.
	public static void print(char[][] matrix) {
		for(int i=0; i < matrix.length; i++) {
			for(int j=0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
	}
}
	
	