import java.util.HashMap;
import java.util.Map;

public class FindIndexForNumberMakesFinalSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	static int[] twoSum(int[] num, int target) {
		for(int i=0; i < num.length; i++) {
			for(int j = i+1; j< num.length; j++) {
				if(num[j] == target - num[i]) {
					return new int [] {i,j};
				}
			}
		}
		throw new IllegalArgumentException("No two sum solution");
	}
	
	static int[] twoSumHash(int [] num, int target) {
		Map<Integer, Integer> mp = new HashMap<>();
		for(int i=0; i<num.length; i++) {
			int comp = target - num[i];
			if(mp.containsKey(comp)) {
				return new int[] {mp.get(comp), i};
			}
			mp.put(num[i], i);
		}
		throw new IllegalArgumentException("No two sum solution");
	}
}
