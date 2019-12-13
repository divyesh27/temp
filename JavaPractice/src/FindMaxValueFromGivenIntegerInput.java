import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class FindMaxValueFromGivenIntegerInput {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(findMaxValueFromGivenInteger(1432));
		System.out.println(findMaxValueFromGivenInteger(999));
		System.out.println(findMaxValueFromGivenInteger(111));
		System.out.println(findMaxValueFromGivenInteger(10));
		System.out.println(findMaxValueFromGivenInteger(4321));
		System.out.println(findMaxValueFromGivenInteger(12341583));
		
	}
	
	public static int findMaxValueFromGivenInteger(int input) {
		
		if(input < 1)
			throw new IllegalArgumentException("Pass valid input");
		
		//List<Integer> ch = new ArrayList<>();
		Comparator<Integer> intCompare = new Comparator<Integer>() {
			
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2 - o1;  // Comparator to compare value for the order o1 - o2 will make 
				// it in asc and o2-o1 will be in desc.
			}
		};
		PriorityQueue<Integer> pq = new PriorityQueue<>(intCompare);
		int value = input;
		int result = 0;
		while(value != 0) {
			//ch.add(value % 10);
			pq.offer(value % 10);
			value = value / 10;
		}
		//Collections.reverse(ch);  // We can also do collections.reverse for desc order
		while(pq.size() > 0) {
			//result = result*10 + i;
			//System.out.println(pq.peek());
			result = result*10 + pq.poll();
		}
	return result;
	}
}
