
public class RemoveDupSortedArrayInt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//	int [] a = {1,1,1,2,3,4,5,6,7,7,7,7,8};
		int [] a = {1,5,7,23,4,5,1,5,7,10,8};
	//	System.out.println(RemoveDuplicates(a));
		System.out.println(RemovDup(a));
		
	}

	public static int RemoveDuplicates(int[] num)
	{
		if(num.length < 2)
			return num.length;
		int dest = 1;
		for(int i=1; i< num.length; i++)
		{
			if(num[i-1] < num[i])
				num[dest++] = num[i];
			
		}
		return dest;
	}
	
	private static int RemovDup(int[] num)
	{
		if(num.length < 2)
			return 0;
		boolean [] flag = new boolean[100]; // When the input number is not greater than 100
		
		for(int i=0; i< num.length; i++)
		{
			if(!flag[num[i]])
				flag[num[i]] = true;
			else
				return num[i];
		}
		return 0;
	}
	
	
}
