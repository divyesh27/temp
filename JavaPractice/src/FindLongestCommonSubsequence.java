
public class FindLongestCommonSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//	FindLongCommonSubsequence("abcdaf","acbcf");
	//	FindLongCommonSubsequence("ABCDGH","AEDFHR");
		FindLongCommonSubsequence("AGGTAB","GXTXAYB");
		FindLongCommonSubsequence("longestcommonsubsequence","dynamicprogramming");
		FindLongCommonSubsequence("alphabetagamma","applemangopineapple");
		FindLongCommonSubsequence("xxxxxx","yyyy");
		System.out.println("Longest common subsequence " + longestCommonSubsequence("abcetd", "cssftdsgsrhd"));
		
	}
	public static String FindLongCommonSubsequence(String str1, String str2)
	{
		if(str1 == null || str2 == null)
			return str1;
		
		char [] str1array = str1.toCharArray();
		char [] str2array = str2.toCharArray();
		int max = 0;
		StringBuilder sb = new StringBuilder();
		StringBuilder sb1 = new StringBuilder();
		int [][] matrix = new int [str1array.length + 1][str2array.length + 1];
		
		for(int i=1; i < matrix.length; i++)
		{
			for(int j=1; j < matrix[i].length; j++ )
			{
				if(str1array[i-1] == str2array[j-1])
					matrix[i][j] = matrix[i-1][j-1] + 1;
				else
					matrix[i][j] = Math.max(matrix[i][j-1], matrix[i-1][j]);
				if(matrix[i][j] > max)
				{
					max = matrix[i][j];
					//System.out.println("j" + j);
					//System.out.println(" ");
					//sb1.append(str2array[j-1]);
				}
					

			}
		}
		
		System.out.println(sb1);
		System.out.println(max);
		//return sb.toString();
		
		for (int x = str1.length(), y = str2.length();
		         x != 0 && y != 0; ) {
		        if (matrix[x][y] == matrix[x-1][y])
		            x--;
		        else if (matrix[x][y] == matrix[x][y-1])
		            y--;
		        else {
		            assert str1.charAt(x-1) == str2.charAt(y-1);
		            sb.append(str1.charAt(x-1));
		            x--;
		            y--;
		        }
		    }
		 System.out.println(sb.reverse());
		 return sb.reverse().toString();
		//return null;
	}

	private static int longestCommonSubsequence(String text1, String text2) {
		int m = text1.length();
		int n = text2.length();

		// Initialize the dp array with 0s
		int[][] dp = new int[m+1][n+1];

		// Fill the dp array using dynamic programming
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (text1.charAt(i-1) == text2.charAt(j-1)) {
					// If the characters match, add 1 to the LCS of the substrings
					dp[i][j] = dp[i-1][j-1] + 1;
				} else {
					// If the characters don't match, take the maximum LCS of the substrings
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}

		// Return the length of the LCS of the two strings
		return dp[m][n];
	}
}
