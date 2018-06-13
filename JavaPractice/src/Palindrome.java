

public class Palindrome {
	public static void main(String[] args) {
	String str="12321";
	int num = 1221;
	//System.out.println(isPalindrome(str));
	System.out.println(isPalindrome2(str));
	System.out.println(isPalindromeNumber(num));
	}
	public static boolean isPalindrome(String str)
	{
		//char[] array=str.toCharArray();
		int len=str.length()/2;
		//boolean flag=false;
		for(int i=0, j=str.length()-1;i<=len;i++,j--)
		{
			if(str.charAt(i)!=str.charAt(j))
			return false;
		}
		return true;
	}
	
	public static boolean isPalindrome2(String str)
	{
		int left=0;
		int right = str.length()-1;
		while(left<right)
		{
			if(str.charAt(left)!=str.charAt(right))
			{
				return false;
			}
				left++;
				right--;
			
		}
		return true;
	}
	// You can not convert in to string
	public static boolean isPalindromeNumber(int input) {
		if(input < 0 || (input % 10 == 0 && input != 0))
			return false;
		int res = 0;
		while(input > res) {
			res = res * 10 + input % 10;
			input /= 10;
		}
		return input == res || input == res/10;
	}
}