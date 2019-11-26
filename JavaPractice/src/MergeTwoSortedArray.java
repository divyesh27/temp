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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] nums1 = {1,2,3,4};
		int [] nums2 = {2,5,6};
		for(int i : (mergeTwoSortArray(nums1, nums2))){
			System.out.println(i);
		}
		
	}


}
