import java.util.*;


public class checkAnagramQiagen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(CheckAnagram("A Rope Ends It", "Desperation"));
		System.out.println(CheckAnagram("Desperation", "A Rope Ends It"));
	}
	
	private static boolean CheckAnagram(String str1, String str2)
	{
		if(str1 == null || str2 == null)
			return false;
		
		if(str1.length() == 0 || str2.length() == 0)
			return false;
		
		char [] char1 = str1.toCharArray();
		char [] char2 = str2.toCharArray();
		
		System.out.println(char1);
		
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
		
		for(char c : char1)
		{
			c = Character.toLowerCase(c);
			int count=1;
			if(hm.containsKey(c))
				count = hm.get(c) + 1;
			hm.put(c,count);
		}
		for(char c : char2)
		{
			c = Character.toLowerCase(c);
			int count = -1;
			if(hm.containsKey(c))
				count = hm.get(c) - 1;
			hm.put(c, count);
		}
		for(char c : hm.keySet())
		{
			if(hm.get(c) != 0 && c != ' ')
				return false;
		}
		return true;
	}
	
}
