import java.util.Arrays;


public class MiddleValue {

	public static void main(String arg[])
	{
		int[] a={1,2,3,5,6,7,4};
		Arrays.sort(a);
		int len=a.length;
		if(len%2==1)
		{
			System.out.println("Middle value is - "+a[len/2]);
		}
		
	}
}
