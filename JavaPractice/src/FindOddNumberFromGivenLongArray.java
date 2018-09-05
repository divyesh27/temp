
public class FindOddNumberFromGivenLongArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long[] arr = { -5234256, -723143678, 111111110, 1212450, 232421340, 24214120, 2432467 };
		// int[] arr = {5,2,6,8,0,0,0,-2,-6,-7,-7};
		// int[] arr = {-1,2,4,-2,5,6,45,34,-34,-56,0};
		// int[] arr = {-5,0,-2,-6,-8,0,0,0,-2,-6,-7,-7};
		// int[] arr = {5,0,2,6,8,0,0,0,2,6,7,7};

		// int[] arr = {-5,-7};
		// int[] arr = {0,0,0,0};
		// int[] arr = {6,8,2,6,7};
		// int[] arr = {5,7,6,6,6,6};
		// int[] arr = {5,7,0,6,6,6,6};
		// int[] arr = {2,4,6,8,0,5,7,9,1};

		System.out.println(RearrangeOddZeroEvenSort(arr));

	}

	// Re arrange odd and even on each side and if we encounter zero then
	// it should be an pivot between odd and even numbers on either side.
	public static long RearrangeOddZeroEvenSort(long[] inputArray) {
		int size = inputArray.length;
		if (size == 0 || size == 1)
			return -1;

		int evenIndex = 0; // Subscript for tracking even numbers
		long temp; // Variable to swap the element

		// This functionality will sort all the even numbers to the start/left of the
		// array
		for (int i = 0; i < size; i++) {

			// If it encounter even number just add to the left/start of the array
			if (inputArray[i] % 2 != 0) {
				return inputArray[i];
			}
		}

		return -1;
	}

}
