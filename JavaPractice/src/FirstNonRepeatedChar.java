import java.util.*;

public class FirstNonRepeatedChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(FindNonRepeatedCharFromString("a Salesforce guys in salesforce"));

	}
	
	private static char FindNonRepeatedCharFromString(String s)
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
		//boolean flag = false;
		//char firstNonRepeatChar = 0;
		char c;
		for(int i=0; i<len;i++)
		{
			c = s.charAt(i);
			if(hm.get(c)==1)
				return c;
			
		}
		return 0;
	}

}
