import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// Write a function to return a line of text padded with spaces, given a length
// and a string.
// Example:
//
// padSpaces(50, "Hello world, it is a good day today.")
//
// Might return:
//
// "Hello world, it is a good day today."

// padSpaces(20, "How are you?")
//
// Might return:
//
// "How are you?"

public class PadSpaceTextJustification {

	static StringBuilder sb = new StringBuilder();
	public static void main(String args[]) throws Exception {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT */
		//System.out.println(padSpace("Hello world, it is a good day today.", 50));
		System.out.println(textJustify("Hello world, it is a good day today.", 50));
	}

	public static String padSpace(String inputString, int padSpace) {

		if (inputString == null || padSpace < inputString.length())
			return inputString;
		String[] inputArrayString = inputString.split(" ");
		List<String> result = new ArrayList<>();
		String returnOutput = "";

		for (int i = 0; i < inputArrayString.length; i++) {

			int totallen = inputArrayString[i].length();
			int j = i + 1;
			StringBuilder sb = new StringBuilder();
			sb.append(inputArrayString[i]);
			System.out.println(inputArrayString[i]);

			while (j < inputArrayString.length && totallen + inputArrayString[j].length() + 1 <= padSpace) {
				totallen = totallen + inputArrayString[j].length() + 1;
				j++;
			}

			int remaining = padSpace - totallen;

			if (j != inputArrayString.length) {

				int counter = j - i - 1;

				if (counter == 0) {
				//	spaceAdd(sb, remaining);
				} else {
					int quo = remaining / counter;
					int rem = remaining % counter;

					for (int k = i + 1; k < j; k++) {
					//	spaceAdd(sb, quo);
						if (rem > 0) {
							sb.append(" ");
							rem--;
						}
						sb.append(" ").append(inputArrayString[k]);
					}
				}

			} else {
				for (int m = i + 1; m < j; m++) {
					sb.append(" ").append(inputArrayString[m]);
				}
				//spaceAdd(sb, remaining);
			}
			result.add(sb.toString());
			i = j;

			// for(String s : result) {
			// returnOutput+=s;
			//System.out.println(result);
			// }

		}
		return returnOutput;
	}

	public static String textJustify(String inputString, int padSpace) {

		if (inputString == null || padSpace < inputString.length())
			return inputString;
		
		int len = inputString.length();
		String [] words = inputString.split(" ");
		int numOfWords = words.length;
		int space = padSpace - len + numOfWords - 1;
		
		int quo = space / numOfWords;
		int rem = space % numOfWords;
		
		
		System.out.println("Actual string length " + len);
		System.out.println("Space left after words " + space);
		System.out.println("Quotient " + quo);
		System.out.println("Rem " + rem);
		System.out.println("Num of Words " + numOfWords);
		
		for(int i=0, j=0; i<numOfWords; i++) {
			sb.append(words[i]);
			spaceAdd(quo);
			if(j < rem) {
				spaceAdd(1);
				j++;
			}
			
		}
		//System.out.print(sb);
		return sb.toString();
	}

	private static void spaceAdd(int counter) {
		for (int k = 0; k < counter; k++) {
			sb.append(" ");
		}
	}
}
