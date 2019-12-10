import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * Find first and last position of a given
 * @author divyesh.shah
 *
 */
public class FindFirstAndLastPositionOfElementSortedArrayWithDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,1,4,5,6,7,8,9,10,11,11,12,13,14,17,17,17,17,20};
		for(int i : (findFirstAndLastPositionOfElementGivenArrayWithBinarySearch(a,11)))
			System.out.println(i);
	}
	
	static int [] findFirstAndLastPositionOfElementGivenArrayWithBinarySearch(int[] num, int target)
	{
		if(num.length <=1 || num == null)
			return num;
		
		if(num[0] > num[1] || num[num.length-2] > num[num.length-1] || num[1] > num[num.length-2])
			Arrays.sort(num);
		
		int size = num.length-1;
		int low = 0;
		int high = size;
		int mid;
		while(low <= high) {
			mid = (high+low)/2;
			if(num[mid] == target) {
				return (findPositionStartEndForElement(num, mid, mid-1, mid+1));
			}
			else if(num[mid] > target)
				high = mid-1;
			else
				low = mid+1;
		}
		throw new NoSuchElementException("Value not found");
	}
	
	private static int[] findPositionStartEndForElement(int[] num, int mid, int leftpos, int rightpos)  {
		
		int size = num.length-1;
		
		while(rightpos <= size && num[rightpos] == num[mid]) rightpos++;
		while(leftpos >= 0 && num[leftpos] == num[mid]) leftpos--;
		
		return new int[] {leftpos+1,rightpos-1};
	}
}
