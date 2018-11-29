import java.util.*;


public class ConvertStringOneToAnotherStringFindMinCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(StepsToConvertOneStringToAnotherString("ABD","BAD"));
		System.out.println(StepsToConvertOneStringToAnotherString("EACBD","EABCD"));
	}
	private static int StepsToConvertOneStringToAnotherString(String str1, String str2)
	{
		if(str1 == null || str2 == null)
			return -1;
		if(str1.length() != str2.length())
			return -1;
		
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
		for(int i : hm.values())
		{
			if(i != 0)
				return -1;
		}
		int result = 0;
		int s1len = str1.length()-1;
		int s2len = str2.length()-1;
		
		while(s1len >= 0) {
			
			if(char1[s1len] != char2[s2len])
				result++;
			else
				s2len--;
			s1len--;
		}
		return result;
	}
	
}
