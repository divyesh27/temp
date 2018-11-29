
public class ReverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(RevString("Divyesh"));
		System.out.println(revStringWithoutExtraMem("Divyesh Shah"));
		System.out.println(revStringWithoutExtraMem1("Divyesh Shah"));
		System.out.println(reverseStringAlphabetsOrLettersOnlyIgnoreNumbersSpecialChar("a3b5%dfy%67df^cs"));
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

	private static String revStringWithoutExtraMem(String str) {
		//char [] ch = str.toCharArray();
		
		for(int i=0; i< str.length(); i++) {
			str = str.substring(1, str.length() - i) + str.charAt(0) + str.substring(str.length() - i);
		}
		
		return str;
	}
	
	private static String revStringWithoutExtraMem1(String str) {
		
		int len = str.length();
		for(int i=len-1; i >= 0; --i) {
			str += str.charAt(i);
		}
		str = str.substring(len);
		
		return str;
	}
	
	private static String reverseStringAlphabetsOrLettersOnlyIgnoreNumbersSpecialChar(String input) {
		
		if(input == null || input.length() == 0)
			return input;
		
		char[] result = input.toCharArray();
		int start = 0;
		int end = result.length-1;
		char c = ' ';
		while(start < end) {
			
			if(Character.isAlphabetic(result[start]) && Character.isAlphabetic(result[end])) {
				c = result[start];
				result[start] = result[end];
				result[end] = c;
				start++;
				end--;
			}
			else if(Character.isAlphabetic(result[start]) && !Character.isAlphabetic(result[end]))
				end--;
			else if(!Character.isAlphabetic(result[start]) && Character.isAlphabetic(result[end]))
				start++;
			else {
				start++;
				end--;
			}
		}
		
		return String.valueOf(result);
	}

}
