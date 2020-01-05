import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
		int [] num = {1,1,1,2,2,3};
		//int [] num = {1,2,3,4,5,6};
		//System.out.println(FindKthLargestElement(num,2));
		//System.out.println(FindKthLargestNum(num,2));
		//System.out.println(FindKthMostFrequentElement(num,3));
		for(int i : findKthMostFrequentElement(num,2)) {
			System.out.println(i);
		}
	}
	
	private static List<Integer> findKthMostFrequentElement(int [] num, int k){
		
		if(num == null || num.length < 1 || k == 0)
			throw new IllegalArgumentException();
		
		Map<Integer, Integer> hm = new HashMap<>();
		for(int i : num) {
			hm.put(i, hm.getOrDefault(i, 0) + 1);
		}
		
		PriorityQueue<Map.Entry	<Integer,Integer>> pq = new PriorityQueue<>(Comparator.comparing(e -> e.getValue()));
		
		for(Map.Entry<Integer, Integer> map : hm.entrySet()) {
			pq.offer(map);
			if(pq.size() > k) {
				pq.poll();
			}
		}
		
		List<Integer> list = new ArrayList<>();
		while(pq.size() > 0) {
			list.add(pq.poll().getKey());
		}
		Collections.reverse(list);
		return list;
	}
	 
}
