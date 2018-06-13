import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;


public class FindKthMostFrequentElementArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int [] num = {3,2,1,5,5,6,4,7,88,33,21,3,4,6,7,8,96,5,4,3,5,6,77,4,3,3};
		//int [] num = {3,2};
		//int [] num = {1};
		//int [] num = {1,1};
		//int [] num = {1,1,1};
		//int [] num = {1,1,1,1,1,1,1,1};
		int [] num = {1,2,3,4,5,6};
		
		//System.out.println(FindKthLargestElement(num,2));
		//System.out.println(FindKthLargestNum(num,2));
		System.out.println(FindKthMostFrequentElement(num,3));
	}
	private static List<Integer> FindKthMostFrequentElement(int[] num, int k)
	{
		List<Integer> res = new ArrayList<>();
		//List<Integer>[] bucket = new List[num.length + 1];
		ArrayList<Integer> al = new ArrayList<Integer>();
		List<Integer>[] bucket = new List[num.length + 1];
		if(num.length <=1)
			return res;
		
		HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
		for(int i : num) {
			if(!hm.containsKey(i))
				hm.put(i, 1);
			else 
				hm.put(i, hm.get(i) + 1);
		} 
		
		for(int key : hm.keySet()) {
			int freq = hm.get(key);
			if(bucket[freq] == null) {
				bucket[freq] = new ArrayList<>();
			}
			System.out.println(freq);
			System.out.println(bucket[freq].add(key));
				
		}
		
		
		for(int pos = bucket.length - 1; pos >=0 && res.size() < k; pos--) {
			if(bucket[pos]!=null) {
				res.addAll(bucket[pos]);
			}
		}
		for(int a : al)
			System.out.println(a);
		return res;
	}
	
	 
}
