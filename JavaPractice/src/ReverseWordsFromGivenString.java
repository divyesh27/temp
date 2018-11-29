
/*
 * I/P -  I am divyesh shah 
 *  O/P - shah divyesh am I
 */

public class ReverseWordsFromGivenString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(ReverseWordsString("Hi my name is Divyesh"));
		System.out.println(ReverseEachWordsOfGivenString("Hi my name is Divyesh"));
	}

	private static String ReverseWordsString(String str) {
		if (str == null || str.length() == 0)
			return str;
		String[] strarray = str.split(" ");
		StringBuilder sb = new StringBuilder();
		for (int i = strarray.length - 1; i >= 0; i--) {
			if (!strarray[i].equals(" ")) {
				sb.append(strarray[i]).append(" ");
			}
		}
		return sb.length() == 0 ? "" : sb.toString();
	}

	private static String ReverseEachWordsOfGivenString(String str) {
		if (str == null || str.length() < 2)
			throw new IllegalArgumentException("Pass valid input");
		String[] substr = str.split(" ");
		StringBuilder sb = new StringBuilder();
		for (String s : substr) {
			sb.append(reverseString(s)).append(" ");
		}
		return sb.toString();
	}

	private static String reverseString(String str) {
		int start = 0;
		int end = str.length() - 1;
		char[] charArray = str.toCharArray();
		char c;
		while (start <= end) {
			c = charArray[start];
			charArray[start++] = charArray[end];
			charArray[end--] = c;
		}
		//return new String(charArray);  Can use both way
		return String.valueOf(charArray);
	}
}
