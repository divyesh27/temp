
public class RotationSample {

	public static void main(String args[])
	{
		String s1 ="apple";
		String s2="pleap";
		System.out.println("output is - "+isRotated(s1,s2));
	}
	
	public static boolean isRotated(String s1, String s2)
	{
		int s1len=s1.length();
		int s2len=s2.length();
		if(s1len!=s2len&&s1len==0)
		{
			return false;
		}
		String s1s1=s1+s1;
		return isSubstring(s1s1,s2);

		
	}
	
	public static boolean isSubstring(String big,String small)
	{
		if(big.indexOf(small)>=0)
		{
			return true;
		}
		return false;
	}
}
