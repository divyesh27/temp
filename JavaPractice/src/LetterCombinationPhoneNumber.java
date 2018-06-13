import java.util.*;

public class LetterCombinationPhoneNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(letterCombination("23"));
	}

	private static List<String> LetterCombination(String digits)
	{
		ArrayList <String> result = new ArrayList<String>();
		
		if(digits == null || digits.length() == 0)
			return  result;
		
		HashMap<Integer, String> map = new HashMap<Integer,String>();
		
		map.put(2, "abc");
		map.put(3, "def");
		map.put(4, "ghi");
		map.put(5, "jkl");
		map.put(6, "mno");
		map.put(7, "pqrs");
		map.put(8, "tuv");
		map.put(9, "wxyz");
		map.put(0, "");
		
				
		
		return result;
	}
	
	private static List<String> letterCombination(String digits)
	{
		LinkedList<String> ans = new LinkedList<String>();
		String [] mapping = new String [] {"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
		ans.add("");
		for(int i=0; i<digits.length(); i++)
		{
			int x = Character.getNumericValue(digits.charAt(i));
			while(ans.peek().length() == i)
			{
				String t = ans.remove();
				for(char s : mapping[x].toCharArray())
					ans.add(t+s);
			}
		}
		return ans;
	}
}
