public class RotateArrayByGivenValue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr = {2,3,4,5,2};
		for(int e : RotateByGivenNumber(arr,3))
			System.out.print(e + " ");
	}
	/**
	 * This method will divide array in to two segment. One from 0 to rotation-1 and remaining segment
	 * from rotation to remaining size of array. And call the reverse function to swap the value.
	 * First call reverse function from 0 to div-1(length of num array - k rotation)
	 * Second call reverse function from div to length of num array
	 * Third call reverse function from first element to last element for complete swap.
	 * @param num
	 * @param k
	 * @return 
	 */
	public static int[] RotateByGivenNumber(int[] num, int k) 
	{
		if(num == null || num.length == 0 || k < 0)
			throw new IllegalArgumentException("Illegal argument!");
		// This will take care of the value of k greater then the length of array
		if(k > num.length)
			k = k % num.length;
		int div = num.length - k;  // get the remaining segment of the array.
		//Reverse(num,0,num.length-1); // rotate left side
		Reverse(num,0,div-1); // rotate right side
		Reverse(num,div,num.length-1); // keep in middle to rotate right and left
		Reverse(num,0,num.length-1); // rotate right side
		//Reverse(num,0,div-1); // rotate left side
		//for(int e : Reverse(num,0,num.length-1))
		//	System.out.println(e);
		
		return num;
	}
	
	/**
	 * Helper method to reverse the given input array starting from the right and left index.
	 * and return the array.
	 * @param num
	 * @param left
	 * @param right
	 * @return
	 */
	private static int[] Reverse(int[] num, int left, int right)
	{
		if(num == null || num.length == 1)
			return num;
		
		// Swap values for the given point of left end and right end of the array.
		while(left < right)
		{
			int temp;
			temp = num[left];
			num[left++] = num[right];
			num[right--] = temp;
			//left ++;
			//right --;
		}
		return num;
	}

}
