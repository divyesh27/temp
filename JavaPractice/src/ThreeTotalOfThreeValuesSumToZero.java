import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeTotalOfThreeValuesSumToZero {
	
	/**
	 * 3sum of given array to zero
	 * @param input
	 */
	public static List<List<Integer>> Threesum(int[] input) {
		
		if(input == null || input.length < 2) {
			throw new IllegalArgumentException("Pass valid input");
		}
		
		Arrays.sort(input);  // Time complexity O(n^2) as worst case
		int low;
		int high;
		int sum;
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		
		for(int i=0; i < input.length-2; i++) {
			
			if(i == 0 || (i > 0 && (input[i]!=input[i-1]))) {
				low = i+1;
				high = input.length-1;
				sum = 0-input[i];  // get the first value subtract it with 0 so that we get sum to look into for target
				while(low < high) {  // do binary search for the remaining array
					if(input[low] + input[high] == sum) {
						result.add(Arrays.asList(input[i],input[low],input[high]));
						while(low < high && input[low] == input[low+1]) low++;   // this is to ignore duplicate values
						while(low < high && input[high] == input[high-1]) high--;  // this is to ignore duplicate values
						low++;
						high--;
					}
					else if(input[low] + input[high] > sum) 
						high--;
					else
						low++;
				}
			}
		}
		return result;
	}
	public static void main(String[] args) {
		int [] input = {-1, 0, 1, 2, -1, -4};
		System.out.println(Threesum(input));
	}
}
