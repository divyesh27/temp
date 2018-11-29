import java.util.*;


public class AnagramString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(CheckAnagram("divyesh","jinal"));
		System.out.println(CheckAnagram("ljani","jinal"));
		System.out.println(groupAnagrams(new String[] {"are","bat","ear","code","tab","era"}));
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
	
	static List<List<String>> groupAnagrams(String [] inputString) {
		
		if(inputString == null || inputString.length < 2)
			return Collections.emptyList();
		
		Map<String,List<String>> hm = new HashMap<String,List<String>>();
		for(String s : inputString) {
			char [] chararray = s.toCharArray();
			Arrays.sort(chararray);
			String key = String.valueOf(chararray);
			if(!hm.containsKey(key))
				hm.put(key, new ArrayList<>());
			hm.get(key).add(s);
		}
		return new ArrayList<>(hm.values()); 
	}
	
}
