
/**
 * This algorithm will take one character and it will traverse one left and one right and
 * keep comparing the characters till left most and till right most or till it finds the
 * and compare with the longest string if it is greater than replace
 * as well as find for even characters by running it for rightmost + 1 
 * @author jinashah
 *
 */
public class FindLongestPalindromeString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(LongestPalindrome("HYTBCABADEFGHABCDEDCBAGHTFYW12345678987654321ZWETYGDE"));
		System.out.println(LongestPalindrome("1234"));
        System.out.println(LongestPalindrome("12321"));
        System.out.println(LongestPalindrome("9912321456"));
        System.out.println(LongestPalindrome("9912333321456"));
        System.out.println(LongestPalindrome("12145445499"));
        System.out.println(LongestPalindrome("1223213"));
        System.out.println(LongestPalindrome("abb"));
        System.out.println(LongestPalindrome("Hello how are you madam hope you are fine"));
        System.out.println(LongestPalindrome("abba madam you are malayalamabcbaabcba"));
	}
	private static String LongestPalindrome(String input)
	{
		if(input == null || input.length() <=1 || input.isEmpty())
			return input;
		
		String maxPalin = input.substring(0,1);
		
		for(int i=0; i<input.length()-1; i++)
		{
			String palin = isPalindrome(input,i,i);
			if(palin.length() > maxPalin.length())
				maxPalin = palin;
			
			palin = isPalindrome(input,i,i+1);
			if(palin.length() > maxPalin.length())
				maxPalin = palin;
		}
		return maxPalin;
	}
	private static String isPalindrome(String str, int left, int right)
	{
		if(str.isEmpty())
			return str;
		if(left > right)
			return null;
		
		while(left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right))
		{
			left --;
			right ++;
		}
		return str.substring(left+1, right);
	}
}
