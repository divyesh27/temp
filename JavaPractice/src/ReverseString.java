
public class ReverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(RevString("Divyesh"));
	}
	private static String RevString(String str)
	{
		if(str == null)
			return null;
		if(str.length() == 1)
			return str;
		char [] ch = str.toCharArray();
		int start = 0;
		int end = ch.length-1;
		char c;
		while(start <= end)
		{
			c = ch[end];
			ch[end] = ch[start];
			ch[start] = c;
			start ++;
			end --;
		}
		return new String(ch);
	}


}
