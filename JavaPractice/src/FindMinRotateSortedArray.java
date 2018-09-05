
public class FindMinRotateSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] input = {4,5,6,7,0,1,2};
		int[] input = {3,4,5,1,2};
		System.out.println(findMinElementRotateSortedArray(input));
	}

	public static int findMinElementRotateSortedArray(int [] inputArray) {
		int start = 0;
		int end = inputArray.length - 1;
		
		while(start < end) {
			if(inputArray[start] < inputArray[end])
				return inputArray[start];
			
			int mid = (start + end) / 2;
			
			if(inputArray[mid] >= inputArray[start])
				start = mid+1;
			else
				end = mid;
		}
		return inputArray[start];
	}
}
