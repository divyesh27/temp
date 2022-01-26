import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class FindPairInArrayTotalSumAndCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum = 12;
		// int[] inputarr = {8, 1, 4, 45, 6, 10, 8, 7, 2, 9};sum=16
		// int[] inputarr = {1, 5, 7, -1}; sum=6
		// int[] inputarr = {1, 5, 7, -1, 5};sum=6
		// int[] inputarr = {1, 1, 1, 1}; sum=2
		// int[] inputarr = {10, 12, 10, 15, -1, 7, 6, 5, 4, 2, 1, 1, 1};
		// int[] inputarr = { 6, 12, 3, 9, 3, 5, 1 };
		// int[] inputarr = { 1, 3, 46, 1, 3, 9, 47 }; // sum=47
		// int[] inputarr = { 6, 6, 3, 9, 3, 5, 1 }; //sum=12
		int[] inputarr = { 6, 12, 3, 9, 3, 5, 1 }; // sum=12

		for (int i : findPairValueToSumAndPrintCount(inputarr, sum)) {
			System.out.println(i);
		}
		System.out.println("***********************");
		System.out.println(numberOfDistinctPairs(inputarr, sum));
		
		int[] array1 = {1, 3, 2, 2, 3};
	    int targetSum1 = 4;
	    int [] array2 = {2, 2, 2, 2, 2};
	    int targetSum2 = 4;
	    int [] array3 = {1, 3, 2, 2, 3, 1};
	    int targetSum3 = 4;
	    
	    System.out.println("--------");
	    printPairs(array1, targetSum1);
	    System.out.println("--------");
	    printPairs(array2, targetSum2);
	    System.out.println("--------");
	    printPairs(array3, targetSum3);
		
	}

	public static int[] findPairValueToSumAndPrintCount(int[] arr1, int sum) {
		if (arr1 == null || arr1.length < 2 || sum <= 1)
			throw new IllegalArgumentException("Values can't be null or less than 2 or sum can't be less than 1");

		HashSet<Integer> val = new HashSet<>();
		List<Integer> result = new ArrayList<>();
		int tempval;
		for (int i = 0; i < arr1.length; i++) {

			tempval = sum - arr1[i];
			if (tempval >= 0 && val.contains(tempval)) {
				result.add(arr1[i]); // or print value over here or add List
				result.add(tempval);
			}
			val.add(arr1[i]);
		}
		System.out.println("No of pairs found " + result.size() / 2);
		int[] arr = result.stream().mapToInt(i -> i).toArray();
		return arr;
	}

	static int numberOfDistinctPairs(int[] array, long sum) {

		if (array.length < 2 || sum < 1)
			return -1;

		Map<Long, Integer> map = new HashMap<>();
		for (int i : array) {
			map.put((long) i, map.getOrDefault((long) i, 0) + 1);
		}

		Set<String> uniquePairs = new HashSet<>();
		for (int i : array) {
			long x = sum - i;
			if (map.containsKey(x)) {
				if (x == i && map.get(x) <= 1) {
					continue;
				}
				long[] y = new long[] { x, i };
				Arrays.sort(y);
				uniquePairs.add(Arrays.toString(y));
			}
		}
		return uniquePairs.size();
	}
	
	public static void printPairs(int[] array, int targetSum){
		
		 /*
		  Given an unsorted array of integers and an integer number targetSum, find all pairs that sum up to the given number targetSum.

		1. Sorting the array is not allowed.
		2. Number can be used only once to be a pair
		3. Duplicated pairs are possible
		4. Time optimized


		* Example 1
		array = [1, 3, 2, 2, 3], targetSum = 4
		print [1, 3], [2, 2]

		* Example 2
		array = [1, 3, 2, 2, 3, 1], targetSum = 4
		print [1, 3], [2, 2], [1, 3]

		* Example 3
		array = [2, 2, 2, 2, 2], targetSum = 4
		print [2, 2], [2, 2]



		Any Questions? 3 minutes
		Design Discussion: 10 minutes

		  - Hashmap with key -> value to be 
		  - Create a set with all unique numbers.
		  - Array of booleans to flag the indexes that have been used.
		  - 
		*/
		if (array == null || targetSum < 1)
			return;

		Map<Integer, Integer> map = new HashMap<>();
		for (int i : array) {
			map.put(i, map.getOrDefault(i,0) + 1);

		}

		//Map.Entry<Integer, Integer> kv = 

		for (Entry<Integer, Integer> e : map.entrySet() ){
			Integer key2 = targetSum - e.getKey();
			Integer count1 =0;
			Integer count2 =0;
			// Handle the case when element is half the value of targetSum.
			Integer threshold = 0;
			if(e.getKey() == key2){
				threshold = 1;
			}
			if(threshold == 1) {
				count1 = e.getValue();
				while(count1 > 1) {
					System.out.println(e.getKey() + "," + key2);
					count1-=2;
				}
			}
			else if(map.containsKey(key2)) {
				count1 = e.getValue();
				count2 = map.get(key2);

				if(count1 > threshold && count2 > threshold) {
					map.put(e.getKey(), --count1);
					map.put(key2, --count2);
					System.out.println(e.getKey() + "," + key2);
				}  

			}
		}
	}
	/**
	Test with all duplicate values
	Test with null input
	Test with 0 taget value
	Test with all 1 values
	Test with all 0 values
	Test with Integer boundary values +-32767

	*/
}
