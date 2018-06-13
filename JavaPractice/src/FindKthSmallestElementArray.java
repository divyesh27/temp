import java.util.Arrays;
import java.util.PriorityQueue;


public class FindKthSmallestElementArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] num = {3,2,1,5,6,4};
	//	System.out.println(findKthSmallestElement(num,2));
		System.out.println(findKthSmallestNum(num,2));
	}
	private static int findKthSmallestElement(int[] num, int k)
	{
		if(num.length <=1)
			return -1;
		
		Arrays.sort(num);
		return num[k-1];
	}
	
	private static int findKthSmallestNum(int[] num, int k)
	{
		PriorityQueue<Integer> q = new PriorityQueue<Integer>(k);
		for(int i : num)
		{
			q.offer(i);
			if(q.size() > k)
			{
				q.poll();
				break;
			}
			
		}
		return q.peek();
	}
}
