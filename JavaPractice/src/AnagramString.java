import java.util.*;


public class AnagramString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(CheckAnagram("divyesh","jinal"));
		System.out.println(CheckAnagram("ljani","jinal"));
	}
	private static boolean CheckAnagram(String str1, String str2)
	{
		if(str1 == null || str2 == null)
			return false;
		char [] char1 = str1.toCharArray();
		char [] char2 = str2.toCharArray();
		
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
		
		for(char c : char1)
		{
			int count=1;
			if(hm.containsKey(c))
				count = hm.get(c) + 1;
			hm.put(c,count);
		}
		for(char c : char2)
		{
			int count = -1;
			if(hm.containsKey(c))
				count = hm.get(c) - 1;
			hm.put(c, count);
		}
		for(char c : hm.keySet())
		{
			if(hm.get(c) != 0)
				return false;
		}
		return true;
	}
}
