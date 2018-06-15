import java.util.Stack;


public class MaxRectangleSubMatrixOf1s {

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

		System.out.println(maxRectangle(input));

	}
	
	static int histogram(int[] input) {
		Stack<Integer> st = new Stack<>();
		int maxArea = 0;
		int area =0;
		int i;
		for(i=0; i< input.length;) {
			if(st.isEmpty() || input[st.peek()] <= input[i])
				st.push(i++);
			else {
				int top = st.pop();
				if(st.isEmpty())
					area = input[top] * i;
				else {
					area = input[top] * (i - st.peek() -1);
				}
				if(area > maxArea)
					maxArea = area;
				
			}
		}
		while(!st.isEmpty()) {
			int top = st.pop();
			if(st.isEmpty())
				area = input[top] * i;
			else 
				area = input[top] * (i-st.peek() -1);
			if(area > maxArea)
				maxArea = area;
		}
		return maxArea;
	}
	
	static int maxRectangle(int [][] input) {
		int [] temp = new int [input[0].length];
		int maxArea = 0;
		int area = 0;
		for(int i=0; i<input.length;i++) {
			for(int j=0; j<temp.length;j++) {
				if(input[i][j]==0)
					temp[j]=0;
				else
					temp[j] = temp[j]+input[i][j];
			}
			area = histogram(temp);
			maxArea = Math.max(area, maxArea);
		}
		return maxArea;
	}
	
}


