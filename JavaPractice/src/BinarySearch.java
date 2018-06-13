import java.util.Arrays;


public class BinarySearch {
	
	public static void main(String arg[])
	{
		int[] a = {1,8,4,5,6,7,16,10,11,13,15};
		int k = 11;
		Arrays.sort(a);
		System.out.println("output is "+ isFind(a,k));
		
		
		
	}
	
public static boolean isFind(int[] a, int k)
{
	int low=0;
	int high=a.length-1;
	
	while(low<=high)
	{
		int mid=(low+high)/2;
		if(a[mid]==k)
		{
			return true;
		}
		else if(a[mid]<k)
		{
			low=mid+1;	
		}
		else if(a[mid]>k)
		{
			high=mid-1;
		}
	}
	return false;
}

}
