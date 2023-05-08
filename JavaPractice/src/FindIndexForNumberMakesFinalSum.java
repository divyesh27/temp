import java.util.HashMap;
import java.util.Map;

public class FindIndexForNumberMakesFinalSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {2, 3, 64, 32, 67, 2, 6, 11, 4};
		int sum = 5;
		for(int i : twoTargetSum(num, sum)) {
			System.out.println(i);
		}
		for(int i : twoSumHashFinalTarget(num, sum)) {
			System.out.println(i);
		}
	}
	
	static int[] twoTargetSum(int[] num, int target) {
		for(int i=0; i < num.length; i++) {
			for(int j = i+1; j< num.length; j++) {
				if(num[j] == target - num[i]) {
					return new int [] {i,j};
				}
			}
		}
		throw new IllegalArgumentException("No two sum solution");
	}
	
	static int[] twoSumHashFinalTarget(int [] num, int target) {
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
