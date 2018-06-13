
public class SizeOfMaxSubSquareMatrixWithOnes {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] matrix = new int[][]{
		  { 0, 0, 1, 1, 1 },
		  { 1, 0, 1, 1, 1 },
		  { 0, 1, 1, 1, 1 },
		  { 1, 0, 1, 1, 1 }
		};
		System.out.println(MaxSubSquareMatrix(matrix));
	}
	
	private static int MaxSubSquareMatrix(int[][] inputarray)
	{
		if(inputarray.length < 4)
			return -1;
		for(int i=0; i < inputarray.length; i++) {
			for(int j=0; j < inputarray[0].length; j++) {
				System.out.print(" " + inputarray[i][j] + " ");
			}
			System.out.println();
		}
		int[][] dp = new int[inputarray.length][inputarray[0].length];
		int max = -1;
		int i,j;
		
		for(j=0; j<inputarray[0].length; j++)
			dp[0][j] = inputarray[0][j];
		
		for(i=0; i<inputarray.length; i++ )
			dp[i][0] = inputarray[i][0];
		
		for(i=1;i<inputarray.length;i++)
		{
			for(j=1;j<inputarray[i].length;j++)
			{
				if(inputarray[i][j] == 1)
					dp[i][j] = (minOfThree(dp[i-1][j],dp[i-1][j-1],dp[i][j-1]) + 1);
				
				if(max < dp[i][j])
					max = dp[i][j];
			}
		}
		return max;
	}
	
	private static int minOfThree(int a, int b, int c)
	{
		int temp = Math.min(a, b);
		return Math.min(temp, c);
	}

}
