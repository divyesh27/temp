import java.util.*;
import java.lang.*;


public class RotateArrayByGivenValue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr = {2,3,4,5,2};
		//System.out.println(RotateByGivenNumber(arr,2));
		for(int e : RotateByGivenNumber(arr,1))
			System.out.println(e);
	}
	private static int[] RotateByGivenNumber(int[] num, int k) 
	{
		if(num == null || num.length == 0 || k < 0)
			throw new IllegalArgumentException("Illegal argument!");
		if(k > num.length)
			k = k % num.length;
		int div = num.length - k;
		Reverse(num,0,num.length-1); // rotate left side
		//Reverse(num,0,div-1); // rotate right side
		Reverse(num,div,num.length-1); // keep in middle to rotate right and left
		//Reverse(num,0,num.length-1); // rotate right side
		Reverse(num,0,div-1); // rotate left side
		//for(int e : Reverse(num,0,num.length-1))
		//	System.out.println(e);
		
		return num;
	}
	private static int[] Reverse(int[] num, int left, int right)
	{
		if(num == null || num.length == 1)
			return num;
		
		while(left < right)
		{
			int temp;
			temp = num[left];
			num[left] = num[right];
			num[right] = temp;
			left ++;
			right --;
		}
		return num;
	}

}
