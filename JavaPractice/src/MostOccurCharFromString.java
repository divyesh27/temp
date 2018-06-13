import java.util.HashMap;
import java.util.Map;


public class MostOccurCharFromString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(FindMostOccurCharFromString("aaabbbbcbsbdddcbbbc"));
		System.out.println(FindMostOccurCharFromString("aaaaaaaaaa"));
		System.out.println(FindMostOccurCharFromString("abc"));
		System.out.println(FindMostOccurCharFromString(" "));
		System.out.println(FindMostOccurCharFromString("c"));
		System.out.println(FindMostOccurCharFromString("abc#a"));
		System.out.println(FindMostOccurCharFromString("SSSS"));
		System.out.println(FindMostOccurCharFromString("SS"));
		System.out.println(FindMostOccurCharFromString("SS     SS"));
		System.out.println(FindMostOccurCharFromString("SS ######SS"));
		System.out.println(FindMostOccurCharFromString("11111SSSS"));
		System.out.println(FindMostOccurCharFromString("0000"));
		System.out.println(FindMostOccurCharFromString("1111 23456SSSS"));
	}
	private static char FindMostOccurCharFromString(String s)
	{
		if(s == null)
			return 0;
		int len = s.length();
		if(len <=1)
			return s.charAt(0);
		
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
		for(int i=0; i<len;i++)
		{
			char currchar = s.charAt(i);
			if(!hm.containsKey(currchar))
				hm.put(currchar,1);
			else
				hm.put(currchar, hm.get(currchar)+1);
			
		}
		
		char c = ' ';
		int max = -1;
		
		for(int i=0; i<len;i++)
		{
			if(max < hm.get(s.charAt(i)))
			{ 
				max = hm.get(s.charAt(i));
				c = s.charAt(i);
			}
		}
		
		return c;
	}
}
