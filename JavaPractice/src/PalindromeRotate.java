
public class PalindromeRotate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(IsRotationofPalindrome("aaaabbb"));
		System.out.println(IsRotationofPalindrome("hi how are you"));

	}
	public static boolean IsRotationofPalindrome(String input)
	{
		String s1 = "";
		String s2 = "";
		
		for(int i=0; i<input.length()-1;i++)
		{
			s1 = input.substring(i+1);
			s2 = input.substring(0,i+1);
			s1 += s2;
			if (IsPalindrome(s1))
				return true;
			
		}
		return false;
		
	}
	public static Boolean IsPalindrome(String input)
	{
		int i=0;
		int l = input.length()-1;
		char [] ch = input.toCharArray();
		while(l > i)
			if(ch[i++] != ch[l--])
				return false;	
		return true;
	}

}
