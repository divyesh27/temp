
public class FindSubStringCountOccurrence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count = CountSubString("aabcdedfaafadfagafaeerwaa","aa");
		System.out.println(count);

	}
	private static int CountSubString(String str, String subStr)
	{
		if(str == null || subStr == null || str.length() < subStr.length())
			return -1;
					
		int count = 0;
		int subCount = 0;
		for(int i=0; i< str.length(); i++)
		{
			if(subCount != str.length() && str.charAt(i) == subStr.charAt(subCount))
				subCount++;
			
			else if(subCount > 0)
				subCount=0;
			
			if(subCount == subStr.length())
			{
				count++;
				subCount = 0;
			}
				
		}
		return count;
	}

}
