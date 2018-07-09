
public class RearrangeOddEvenZeroNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {-5,-7,0,0,0,0,3,3,5,22,6,7};
	//	int[] arr = {5,2,6,8,0,0,0,-2,-6,-7,-7};
	//	int[] arr = {-1,2,4,-2,5,6,45,34,-34,-56,0};
	//	int[] arr = {-5,0,-2,-6,-8,0,0,0,-2,-6,-7,-7};
	//	int[] arr = {5,0,2,6,8,0,0,0,2,6,7,7};
		
	//	int[] arr = {-5,-7};
	//	int[] arr = {0,0,0,0};
	//	int[] arr = {6,8,2,6,7};
	//	int[] arr = {5,7,6,6,6,6};
	//	int[] arr = {5,7,0,6,6,6,6};
	//	int[] arr = {2,4,6,8,0,5,7,9,1};
		
		RearrangeOddZeroEvenSort(arr);
		print(arr);
		
	}
	// Re arrange odd and even on each side and if we encounter zero then
	// it should be an pivot between odd and even numbers on either side.
	public static int[] RearrangeOddZeroEvenSort(int [] inputArray)
	{	
		int size = inputArray.length;
		if(size == 0 || size == 1)
			return inputArray;
		
		int evenIndex=0;  //Subscript for tracking even numbers
		int temp;    // Variable to swap the element
		
		
		// This functionality will sort all the even numbers to the start/left of the array
		for(int i=0; i<size; i++) {
			
			// If it encounter even number just add to the left/start of the array
			if(inputArray[i] % 2 ==0) {
				temp = inputArray[i];
				inputArray[i] = inputArray[evenIndex];
				inputArray[evenIndex] = temp;
				evenIndex++;
			}
		}
		// This functionality helps to place zero at correct location. evenIndex is
		// now pointing to the end of even numbers so we can just swap to the
		// even index when we hit zero
		for(int i=0; i < evenIndex-1; i++) {
			if(inputArray[i] == 0) {
				temp = inputArray[evenIndex-1];
				inputArray[evenIndex-1] = inputArray[i];
				inputArray[i] = temp;
				evenIndex--;
			}
		}
		return inputArray;
	}
	
	public static void print(int[] arr) {
		for (int i=0; i<arr.length; i++)
            System.out.print(arr[i]+" ");
		System.out.println();
	}
}
