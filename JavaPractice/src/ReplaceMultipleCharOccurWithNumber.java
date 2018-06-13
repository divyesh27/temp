/*
 * I/P - aaaabbbbccccddd
 * O/P - a4b4c4d3
 */
public class ReplaceMultipleCharOccurWithNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(ReplaceMultCharOccurWithNumber("aaaabbbbcdddee"));
		System.out.println(ReplaceMultCharOccurWithNumber("abbbbcddde"));
	}
	public static String ReplaceMultCharOccurWithNumber(String str)
	{
		if(str == null || str.length() ==0)
			return str;
		
		char c = str.charAt(0);
		int count = 0;
		StringBuilder sb = new StringBuilder();
		for(char t : str.toCharArray())
		{
			if(t == c)
				count++;
			else
			{
				sb.append(c);
				if(count > 1)  // When you want to not append counter when 1 char is there
					sb.append(count);
				count = 1;
				c = t;
			}
		}
		sb.append(c);
		if(count > 1)  // When you want to not append counter when last char is 1. Skip count
			sb.append(count);
		return sb.toString();
	}
}
