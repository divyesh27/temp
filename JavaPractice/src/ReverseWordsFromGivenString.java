
/*
 * I/P -  I am divyesh shah 
 *  O/P - shah divyesh am I
 */

public class ReverseWordsFromGivenString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(ReverseWordsString("Hi my name is Divyesh"));
	}
	private static String ReverseWordsString(String str)
	{
		if(str == null || str.length() == 0)
			return str;
		String [] strarray = str.split(" ");
		StringBuilder sb = new StringBuilder();
		for(int i = strarray.length-1; i>=0; i--)
		{
			if(!strarray[i].equals(" "))
			{
				sb.append(strarray[i]).append(" ");
			}
		}
		return sb.length() == 0 ? "" : sb.toString();
	}

}
