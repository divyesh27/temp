
public class FindMissingNumArithmeticProgression {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int input[] = {1,7,10,13,16,19,22};
		int input[] = {1,3,7,9,11,13};
		int arr[] = {3,4,5,6,7,8,9,10,11,12};
		int arr1[] = {-5,-4,-3,-1,0,1,2,3};
        System.out.println(search(input));
        System.out.println(missingNum1ToN(arr));
        System.out.println(missingNum1ToN(arr1));
	}
	
	static int search(int[] input) {
		int low = 0;
		int high = input.length-1;
		int ap = (input[high] - input[low]) / input.length;
		int middle = -1;
		while(low <= high) {
			middle = (low + high) /2;
			if(input[middle] == input[0] + (middle)*ap) {
				low = middle + 1;
			}
			else if(input[middle] > input[0] + (middle)*ap 
					&& input[middle-1] == input[0] + (middle-1)*ap) {
				return input[0] + middle*ap;
			}
			else {
				high = middle - 1;
			}
		}
		return -1;
	}
	
	// Find missing number from consecutive 1toN
	
	static int missingNum1ToN(int [] input) {
		int lowNum = input[0];
		int low =0;
		int high = input.length-1;
		int middle;
		while(low <= high) {
			middle = (low + high) / 2;
			if(input[middle] == (middle + 1 + lowNum) && middle -1 >=0 && input[middle-1] == (middle + lowNum - 1)) {
				return middle + lowNum;
			}
			else if((middle + lowNum) == input[middle]) {
				low = middle + 1;
			}
			else {
				high = middle-1;
			}
		}
		return -1;
	}

}
