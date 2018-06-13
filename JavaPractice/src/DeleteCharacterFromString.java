import java.util.*;
//Remove aeiou string from given string.

public class DeleteCharacterFromString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(DeleteCharacterString("I am divyesh and you are dont know","aeiou"));
	}
	private static String DeleteCharacterString(String str1, String rem)
	{
		if(str1 == null || rem == null)
			return str1;
		
		char [] char1 = str1.toCharArray();
		char [] remove = rem.toCharArray();
		boolean [] flag = new boolean[256];
		int src;
		int dest=0;
		for(src=0; src < remove.length; src++)
		{
			flag[remove[src]] = true;
		}
		for(src=0; src < char1.length; src++)
		{
			if(!flag[char1[src]])
				char1[dest++] = char1[src];
		}
		char1 = Arrays.copyOf(char1, dest);
		return new String(char1);
	}

}
