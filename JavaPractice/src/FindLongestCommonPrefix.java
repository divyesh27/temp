
public class FindLongestCommonPrefix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//	FindLongCommonSubsequence("abcdaf","acbcf");
	//	FindLongCommonSubsequence("ABCDGH","AEDFHR");
		String[] input = {"f","flower","flower","flower", "flower", "flowea"};
		String[] input1 = {"dog","racecar","car"};
		String[] input2 = {"maggi","magic","magical"};
		System.out.println(FindLongCommonPrefixInString(input));
		System.out.println(FindLongCommonPrefixInString(input1));
		System.out.println(FindLongCommonPrefixInString(input2));
		System.out.println(findLongestCommonPrefix(input));
		System.out.println(findLongestCommonPrefix(input1));
		System.out.println(findLongestCommonPrefix(input2));
	}
	public static String FindLongCommonPrefixInString(String [] str)
	{
		if(str == null || str.length == 0)
			return "";
		String prefix = str[0];
		for(int i=1; i < str.length; i++) {
			while(str[i].indexOf(prefix) != 0) {
				prefix = prefix.substring(0, prefix.length()-1);
				if(prefix.isEmpty())
					return "";
			}
		}
		return prefix;
		
	}	
	
	public static String findLongestCommonPrefix(String[] inputString) {
		
		if(inputString == null || inputString.length < 2)
			throw new IllegalArgumentException("Pass valid input");
		
		int max = inputString[0].length();
		char [] comp = inputString[0].toCharArray();
		for(int i=1 ; i<inputString.length; i++) {
			char[] temp = inputString[i].toCharArray();
			int j = 0;
			int k = 0;
			while(k < temp.length && k < max) {
				if(temp[j] == comp[j])
					j++;
				k++;
			}
			if(j < max)
				max = j;
		}
		return inputString[0].substring(0, max);
	}
	
}
