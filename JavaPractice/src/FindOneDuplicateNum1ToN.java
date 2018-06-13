
public class FindOneDuplicateNum1ToN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,17};
		System.out.println(findOneDuplicate(a));
	}
	
	private static int findOneDuplicate(int[] num)
	{
		if(num.length <=1)
			return -1;
		
		int total;
		int highest = num.length-1;
		total = sum(num);
		int dup = total - (highest * ( highest + 1)/2);
		return dup;
	}
	
	private static int sum(int[] arr)
	{
		int sum = 0;
		
		for(int i=0; i< arr.length; i++)
			sum += arr[i];
		return sum;
	}

}
