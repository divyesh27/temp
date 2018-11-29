
public class RemoveMultiSpace {

	public static void main(String args[]) {
		String s1 = "Jinal    Shah";
		System.out.println("output - "+ removeSpace(s1));
		String s = "   my    name is    mr    space  ";
		System.out.println("output-"+ RemoveMultipleSpace(s));
		//s = s.replaceAll("\\s+", " ");
		//System.out.println(s);
		String text = "This  is   a    test";
		//System.out.println(removeSpace(s));
		int index = 0;
		while (index >= 0) {
			index = text.indexOf("  ");
			//System.out.println("inbetween=" + text.indexOf("  "));
			text = text.replaceAll("  ", " ");
		}
		//System.out.println("output text - " + text);
	}

	public static String removeSpace(String s1) {
		int count = 0;
		int index = -1;
		int lastIndex = 0;
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) == ' ') {
				count++;
				//System.out.println("Count - " + count);
			}
		}
		if (count > 1) {

			index = s1.indexOf(' ');
			//System.out.println("indext - " + index);
			int nextIndex = count + index;
			// StringBuffer sb=new StringBuffer();
			sb.append(s1.substring(lastIndex, index)).append(" ").append(s1.substring(nextIndex));

		}

		return sb.toString();

	}

	private static String RemoveExtraSpacesEfficient(String s) {

		char[] charArray = s.toCharArray();

		char prev = s.charAt(0);

		for (int i = 0; i < charArray.length; i++) {
			char cur = charArray[i];
			if (cur == ' ' && prev == ' ') {
				continue;
			} else {
				charArray[i] = cur;
				//System.out.print(cur);
			}
			prev = cur;
		}

		return String.valueOf(charArray);
	}
	
	static String RemoveMultipleSpace(String inputString) {
		
		if(inputString == null || inputString.length() < 2)
			return inputString;
		
		char [] inputChar = inputString.toCharArray();
		int len = inputChar.length;
		
		int i;
		int j;
		int size=0;
		j=0;
		boolean flag = false;
		//while(j<len && Character.isSpaceChar(inputChar[j++]))
		
		for(i = j; j<len;) {
			
			if(!Character.isSpaceChar(inputChar[j])) {
				
				if((inputChar[j]=='.' || inputChar[j]=='?' || inputChar[j]==',') && i-1 >=0 && inputChar[i-1] ==' ')
					inputChar[i-1] = inputChar[j++];
				else
					inputChar[i++] = inputChar[j++];
				flag = false;
			}
			
			else if(Character.isSpaceChar(inputChar[j++])) {
				if(!flag) {
					flag = true;
					inputChar[i++]=' ';
				}
					
			}
			size = i;
		}
		
		return new String(inputChar,0,size);
	}
}
