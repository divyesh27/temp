import java.util.ArrayDeque;
import java.util.Deque;

public class DecodeStringParanthesis {

	
	public static String decodeString(String inputString) {
		
		if(inputString == null || inputString.length() < 1)
			throw new IllegalArgumentException("Pass valid input");
		
		Deque<Integer> intDeque = new ArrayDeque<Integer>();
		Deque<String> strDeque = new ArrayDeque<String>();
		char[] inputCharArray = inputString.toCharArray();
		StringBuilder sb = new StringBuilder();
		
		int len = inputString.length();
		
		for(int i=0; i<len; i++) {
			if(Character.isDigit(inputCharArray[i])) {
				int num = inputCharArray[i] - '0'; // This code can only be added if numbers are in 
													// two digits otherwise directly push number to deque
				while(i+1 < len && Character.isDigit(inputCharArray[i+1])) {
					num = num *10 + inputCharArray[i+1] - '0';
					i++;
				}
				intDeque.push(num);
			}
			else if(inputCharArray[i] == '[') {
				strDeque.push(sb.toString());
				sb = new StringBuilder();  // reset the stringbuilder
			}
			else if(inputCharArray[i] == ']') {
				StringBuilder temp = new StringBuilder(strDeque.pop());
				int repeat = intDeque.pop();
				for(int j=0; j < repeat; j++) {
					temp.append(sb);  // copy all iterations by appending to temporary builder
				}
				sb = temp;  // assign the temporary builder to the main builder
			}
			else {
				sb.append(inputCharArray[i]);
			}
		}
		return sb.toString();
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(decodeString("3[a]21[bc]"));
		System.out.println(decodeString("3[a2[c]]"));
		System.out.println(decodeString("2[abc]3[cd]ef"));

	}

}
