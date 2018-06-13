import java.util.Stack;

public class MaxAreaHistogram {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		//For both answer is 12
		int input[] = { 6, 2, 5, 4, 5, 1, 6 };
		//int input[] = {2,2,2,6,1,5,4,2,2,2,2};

		System.out.println(minhistogram(input));
		System.out.println(histogram(input));

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
	

	static int minhistogram(int[] input) {
		Stack<Integer> st = new Stack<>();
		int minArea = Integer.MAX_VALUE;
		int area =-1;
		int i;
		for(i=0; i< input.length;) {
			if(st.isEmpty() || input[st.peek()] >= input[i])
				st.push(i++);
			else {
				int top = st.pop();
				if(st.isEmpty())
					area = input[top] * i;
				else {
					area = input[top] * (i - st.peek() -1);
				}
				if(area < minArea)
					minArea = area;
				
			}
		}
		while(!st.isEmpty()) {
			int top = st.pop();
			if(st.isEmpty())
				area = input[top] * i;
			else 
				area = input[top] * (i-st.peek() -1);
			if(area < minArea)
				minArea = area;
		}
		return minArea;
	}
}


