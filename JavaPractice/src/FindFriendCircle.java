
public class FindFriendCircle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] matrix = { 	{ 1, 1, 0 }, 
							{ 1, 1, 0 }, 
							{ 0, 0, 1 } };
		
		int[][] matrix1 = { { 1, 1, 0 }, 
							{ 1, 1, 1 }, 
							{ 0, 1, 1 } };
		
		int[][] matrix2 = { { 1, 1, 1, 1, 1 }, 
				            { 0, 1, 0, 0, 0 }, 
				            { 0, 0, 1, 0, 0 },
				            { 0, 0, 0, 1, 1 },
				            { 0, 0, 0, 1, 1 } };
		System.out.println(findCircle(matrix));
		System.out.println(findCircle(matrix1));
		System.out.println(findCircle(matrix2));

	}

	public static void dfs(int[][] inputMatrix, int[] visited, int index) {
		for (int j = 0; j < inputMatrix.length; j++) {
			if (inputMatrix[index][j] == 1 && visited[j] == 0) {
				visited[j] = 1;
				dfs(inputMatrix, visited, j);
			}
		}
	}

	public static int findCircle(int[][] inputMatrix) {
		int[] visited = new int[inputMatrix.length];
		int count = 0;
		for (int i = 0; i < inputMatrix.length; i++) {
			if (visited[i] == 0) {
				dfs(inputMatrix, visited, i);
				count++;
			}
		}
		return count;
	}

}
