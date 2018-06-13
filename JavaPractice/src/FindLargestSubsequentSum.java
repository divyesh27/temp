
public class FindLargestSubsequentSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] input = {-10,3,5,6,-10,8,2,7,9,-30, 3, 7};
	//	int [] input = {1, 101, 10, 2, 3, 100,4};
	//	int [] input = {4,6,1,3,8,4,6};
	//	System.out.println(FindMaxSumSubsequence(input));
		System.out.println(maxSum(input));
		
	}
	
	// This function will take negative numbers as well.
	private static int FindMaxSumSubsequence(int[] arr)
	{
		if(arr.length <= 1)
			return -1;
		
		int sum=0;
		int maxsum=0;
		int start=0;
		int end=0;
		int current=0;
		for(int i=0; i< arr.length; i++){
			
			sum = sum + arr[i];
			if(sum > maxsum)
			{
				maxsum = sum;
				start = current;
				end = i;
			}
			if(sum <=0)
			{
				sum = 0;
				current = i+1;
			}
		}
		System.out.println("Array between" + arr[end] + "Start" + arr[start]);
		return maxsum;
	}
	//Dynamic Programming. This function will not take negative. Only positive.
	public static int maxSum(int arr[])
	{
		if(arr.length <= 1)
			return -1;
		
		int size = arr.length;
		int [] T = new int [size];
		int [] loc = new int [size];
		int i,j,k=0;
		for(i=0; i < size; i++)
		{
			T[i] = arr[i];
			loc[i] = i;
		}
		
		for(i=1; i < size; i++)
		{
			for(j=0; j < i; j++)
			{
				if(arr[j] < arr[i]) {
					if(T[i] != Math.max(T[i], T[j] + arr[i]))
					{
						T[i] = Math.max(T[i], T[j] + arr[i]);
						loc[i] = j;
					}
				}
			}
		}
		int max = T[0];
		for(i=1; i < size; i++)
		{
			if(max < T[i])
			{
				max = T[i];
				k = i;
			}
		}
		/*
		while(k >= 0)
		{
			System.out.println(arr[k]);
			if(k == 0)
				break;
			k = loc[k];
		}
		*/
		return max;
    }

}
