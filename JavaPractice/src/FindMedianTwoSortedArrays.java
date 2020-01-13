import java.util.ArrayList;
import java.util.List;

public class FindMedianTwoSortedArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] input1 = {1,3,8,9,15};
		int [] input2 = {7,11,18,19,21,25};
		System.out.println(findMedianSortedArrays(input1,input2));
		System.out.println(findMedianSortArraysDiffSize(input1,input2));
	}
	
	public static double findMedianSortedArrays(int[] inputArray1, int[] inputArray2) {
		
		if(inputArray1 == null || inputArray2 == null || inputArray1.length < 1 || inputArray2.length < 1)
			throw new IllegalArgumentException("Pass valid input");
		
		if(inputArray1.length > inputArray2.length)
			findMedianSortedArrays(inputArray2,inputArray1);
			
		int x = inputArray1.length;
		int y = inputArray2.length;
		
		int low = 0;
		int high = x;
		
		while(low<=high) {
			int partitionX = (low + high) / 2;
			int partitionY = ((x + y + 1) / 2) - partitionX;
			
			int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : inputArray1[partitionX-1];
			int minRightX = (partitionX == x) ? Integer.MAX_VALUE : inputArray1[partitionX];
			
			int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : inputArray2[partitionY-1];
			int minRightY = (partitionY == y) ? Integer.MAX_VALUE : inputArray2[partitionY];
			
			
			if(maxLeftX <= minRightY && maxLeftY <= minRightX) {
				if((x+y) % 2 == 0)
					return (double)Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY) / 2;
				
				else {
					return (double)Math.max(maxLeftX, maxLeftY);
				}
			}
			else if(maxLeftX > minRightY)
				high = partitionX-1;
			else
				low = partitionX+1;
		}
		throw new IllegalArgumentException("Pass valid input");
	}
	
	public static double findMedianSortArraysDiffSize(int[] input1, int[] input2) {
		
		if(input1 == null || input2 ==null || input1.length <1 || input2.length < 1) {
			throw new IllegalArgumentException("Pass valid input");
		}	
		List<Integer> inputArray = new ArrayList<>();
		
		int len1 = input1.length;
		int len2 = input2.length;
		int startindex1 = 0;
		int startindex2 = 0;
		int end = 0;
		if(len1 < len2)
			end = len1;
		else
			end = len2;
		while(startindex1 < end) {
			
			if(input1[startindex1] < input2[startindex2]) {
				inputArray.add(input1[startindex1++]);
			}
			else {
				inputArray.add(input2[startindex2++]);
			}
		}
		while(startindex2 < len2) {
			inputArray.add(input2[startindex2++]);
		}
		
		for(int i : inputArray)
			System.out.println(i);
		return (double)inputArray.get(len1 + len2 / 2); 
	

	}
	
}
