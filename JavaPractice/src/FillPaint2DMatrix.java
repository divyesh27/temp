
public class FillPaint2DMatrix {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] matrix = new int[][]{
		  { 0, 0, 1, 1, 1 },
		  { 1, 0, 1, 1, 1 },
		  { 0, 1, 1, 1, 1 },
		  { 1, 0, 1, 1, 1 }
		};
		fillColor(matrix,1,1,3);
		for(int i=0; i < matrix.length; i++) {
			for(int j=0; j < matrix[0].length; j++) {
				System.out.print(" " + matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	static void fillColor(int[][] matrix, int x, int y, int newColor) {
		int prevColor = matrix[x][y];
		fillColorAround(matrix,x,y,prevColor,newColor);
		
	}
	static void fillColorAround(int[][] matrix, int x, int y, int prevColor, int newColor) {
		if(x < 0 || y < 0 || x >= matrix.length || y >= matrix[0].length) 
			return;
		if(matrix[x][y] != prevColor)
			return;
		
		matrix[x][y] = newColor;
		
		fillColorAround(matrix, x+1, y, prevColor, newColor);
		fillColorAround(matrix, x-1, y, prevColor, newColor);
		fillColorAround(matrix, x, y+1, prevColor, newColor);
		fillColorAround(matrix, x, y-1, prevColor, newColor);
	}
	
}
