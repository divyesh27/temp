import java.util.Arrays;

public class FindElementInFirstArrayCountLessOrEqualInSecondArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//	int [] arr1 = {1, 2, 3, 4, 7, 9};
	//	int [] arr2 = {0, 1, 2, 1, 1, 4};
		int [] arr1 = {5, 10, 2, 6, 1, 8, 6, 12};
		int [] arr2 = {6, 5, 11, 4, 2, 3, 7};
		int [] results = findSmallOrEqualElements(arr1,arr2);
		for(int i : results) 
			System.out.println(i);
	}
	
	public static int[] findSmallOrEqualElements(int[] arr1, int[] arr2) {

		if(arr1 == null || arr2 == null)
			return null;
		int []results = new int[arr1.length];
		Arrays.sort(arr2);
		for(int i=0; i<arr1.length; i++) {
			results[i] = binarySearch(arr2,arr1[i]);
		}
		
		return results;
	}
	
	public static int binarySearch(int[] arr2, int val) {
		
		int start = 0;
		int end = arr2.length-1;
		while(start <= end) {
			int mid = (start + end) / 2;
			if(arr2[mid] <= val)
				start = mid + 1;
			else
				end = mid - 1;
		}
		return end+1;
	}

}
