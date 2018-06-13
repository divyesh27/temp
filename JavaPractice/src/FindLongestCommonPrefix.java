
public class FindLongestCommonPrefix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//	FindLongCommonSubsequence("abcdaf","acbcf");
	//	FindLongCommonSubsequence("ABCDGH","AEDFHR");
		String[] input = {"f","flower","flower","flower", "flower", "flowea"};
		String[] input1 = {"dog","racecar","car"};
		System.out.println(FindLongCommonPrefixInString(input));
		System.out.println(FindLongCommonPrefixInString(input1));
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
	
}
