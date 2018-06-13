import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;


public class FindKthLargestElementArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer [] num = {3,2,1,5,6,4};
		//System.out.println(FindKthLargestElement(num,2));
		//System.out.println(FindKthLargestNum(num,2));
		kLargest(num,3);
	}
	private static int FindKthLargestElement(Integer[] num, int k)
	{
		if(num.length <=1)
			return -1;
		
		Arrays.sort(num);
		return num[num.length - k];
	}
	
	private static int FindKthLargestNum(Integer[] num, int k)
	{
		PriorityQueue<Integer> q = new PriorityQueue<Integer>(k);
		for(int i : num)
		{
			q.offer(i);
			if(q.size() > k)
				q.poll();
		}
		return q.peek();
	}
	
	// find the k number of largest numbers
	
	private static void kLargest(Integer [] arr, int k) 
	{
		// Sort the given array arr in reverse order
		// This method doesn't work with primitive data
		// types. So, instead of int, Integer type 
		// array will be used 
		Arrays.sort(arr, Collections.reverseOrder()); 
	
		// Print the first kth largest elements 
		for (int i = 0; i < k; i++) 
		System.out.print(arr[i] + " ");
		} 
}
