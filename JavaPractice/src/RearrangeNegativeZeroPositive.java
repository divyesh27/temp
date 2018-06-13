
public class RearrangeNegativeZeroPositive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//	int[] arr = {-5,-7,0,0,0,0,3,3,5,22,6,7};
		int[] arr = {5,2,6,8,0,0,0,-2,-6,-7,-7};
	//	int[] arr = {-5,0,-2,-6,-8,0,0,0,-2,-6,-7,-7};
	//	int[] arr = {5,0,2,6,8,0,0,0,2,6,7,7};
		
	//	int[] arr = {-5,-7};
	//	int[] arr = {0,0,0,0};
	//	int[] arr = {6,8,2,6,7};
		
		RearrangeNegZeroPos(arr);
		for (int i=0; i<arr.length; i++)
            System.out.print(arr[i]+" ");
	}
	public static void RearrangeNegZeroPos(int [] input)
	{	
		int size = input.length;
		if(size == 0 || size == 1)
			return;
		int [] negative = new int[size];
		int [] positive = new int[size];
		int zeroCount, i, j, k;
		zeroCount = j = k = 0;
		for(i=0; i<size; i++)
		{
			if(input[i] < 0)
				negative[j++] = input[i];
			else if(input[i] > 0)
				positive[k++] = input[i];
			else
				zeroCount++;
		
		}
		i=0;
		int a=0;
		while(i<size)
		{
			if(i<j)
				input[i] = negative[i];
			else if(i<(j+zeroCount))
				input[i] = 0;
			else
				input[i] = positive[a++];
			i++;
			
		}
		
				
		
	}

}
