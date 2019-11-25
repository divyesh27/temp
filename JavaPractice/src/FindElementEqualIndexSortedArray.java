
public class FindElementEqualIndexSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[] = {-10, -1, 0, 3 , 10, 11, 30, 50, 100};
        int n = arr.length;
        System.out.println("Fixed Point is "
                   + binarySearch(arr,0, n-1));  
	}
	
	public static int binarySearch(int [] input, int low, int high) {
		
		if(low <= high) {
			int mid = (low + high) / 2;
			if(mid == input[mid])
				return mid;
			else if(mid <= input[mid])
				return binarySearch(input,low,mid-1);
			else
				return binarySearch(input,mid+1,high);
		}
		return -1;
	}

}
