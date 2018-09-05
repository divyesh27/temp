import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindPairInArrayTotalSumAndCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum = 11;
	//	int[] inputarr = {8, 1, 4, 45, 6, 10, 8, 7, 2, 9};sum=16
	//	int[] inputarr = {1, 5, 7, -1}; sum=6
	//	int[] inputarr = {1, 5, 7, -1, 5};sum=6
	//	int[] inputarr = {1, 1, 1, 1}; sum=2
		int[] inputarr = {10, 12, 10, 15, -1, 7, 6, 5, 4, 2, 1, 1, 1};
		
		for(int i : findPairValueToSumAndPrintCount(inputarr, sum)) {
			System.out.println(i);
		}
	}

	public static int[] findPairValueToSumAndPrintCount(int [] arr1, int sum) {
		if(arr1 == null || arr1.length < 2 || sum <= 1)
			throw new IllegalArgumentException("Values can't be null or less than 2 or sum can't be less than 1");
		
		HashSet<Integer> val = new HashSet<>();
		List<Integer>result = new ArrayList<>();
		int tempval;
		for(int i=0; i<arr1.length; i++) {
			
			tempval = sum - arr1[i];
			if(tempval >=0 && val.contains(tempval)) {
				result.add(arr1[i]);  // or print value over here or add List
				result.add(tempval);
			}
			val.add(arr1[i]);
		}
		System.out.println("No of pairs found " + result.size() / 2);
		int[] arr = result.stream().mapToInt(i->i).toArray();
		return arr;
	}
	
}
