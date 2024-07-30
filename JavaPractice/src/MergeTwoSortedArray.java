/***
 * Merge tow sort array in one. Asked in Workday phone screen
 * @author divyesh.shah
 *
 */
public class MergeTwoSortedArray {

	public static int[] mergeTwoSortArray(int[] nums1, int[] nums2) {
		
		int sizeNum1 = nums1.length;
		int sizeNum2 = nums2.length;
		if(nums1 == null || nums2 == null || sizeNum1 < 1 || sizeNum2 < 1) {
			throw new IllegalArgumentException("Pass valid input");
		}
		
		int indexNums1 = 0;
		int indexNums2 = 0;
		int resultIndex = 0;
		int[] result = new int[sizeNum1 + sizeNum2];
		while(indexNums1 < sizeNum1 && indexNums2 < sizeNum2) {
			
			if(nums1[indexNums1] < nums2[indexNums2]) {
				result[resultIndex] = nums1[indexNums1];
				indexNums1++;
			}
			else {
				result[resultIndex] = nums2[indexNums2];
				indexNums2++;
			}
			resultIndex++;
		}
		while(indexNums1 < sizeNum1) {
			result[resultIndex++] = nums1[indexNums1++];
		}
		while(indexNums2 < sizeNum2) {
			result[resultIndex++] = nums2[indexNums2++];
		}
		return result;
	}


	static int[] mergeArray(int[] inputArray1, int[] inputArray2) {
		int sizeArray1 = inputArray1.length;
		int sizeArray2 = inputArray2.length;
		if(inputArray1 == null || inputArray2 == null || sizeArray1 < 1 || sizeArray2 < 1)
			throw new IllegalArgumentException("Pass valid input");

		int indexNums1 = 0;
		int indexNums2 = 0;
		int resultIndex = 0;

		int[] result = new int[sizeArray1 + sizeArray2];

		while(indexNums1 < sizeArray1 && indexNums2 < sizeArray2) {
			if(inputArray1[indexNums1] < inputArray2[indexNums2]) {
				result[resultIndex] = inputArray1[indexNums1];
				indexNums1++;
			}
			else {
				result[resultIndex] = inputArray2[indexNums2];
				indexNums2++;
			}
			resultIndex++;
		}
		while(indexNums1 < sizeArray1)
			result[resultIndex++] = inputArray1[indexNums1++];
		while(indexNums2 < sizeArray2)
			result[resultIndex++] = inputArray2[indexNums2++];
		reverseArray(result);
		return result;
	}
	static void reverseArray(int[] inputArr) {
		int start =0;
		int end = inputArr.length - 1;

		while(start < end) {
			int temp = inputArr[start];
			inputArr[start] = inputArr[end];
			inputArr[end] = temp;
			start ++;
			end --;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] nums1 = {1,2,3,4};
		int [] nums2 = {2,5,6};
		for(int i : (mergeTwoSortArray(nums1, nums2))){
			System.out.println(i);
		}
		System.out.println();
		for(int i : (mergeArray(nums1, nums2))){
			System.out.println(i);
		}
		
	}

}
