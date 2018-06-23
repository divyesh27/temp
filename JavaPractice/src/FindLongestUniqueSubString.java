import java.util.HashSet;
import java.util.Set;

public class FindLongestUniqueSubString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count = CountSubString("abcdedfaafadfagafaeerw");
		//int count = CountSubString("abcabcbb");
		//int count = CountSubString("bbbbb");
		//int count = CountSubString("pwwkew");
		System.out.println(count);

	}
	private static int CountSubString(String str)
	{
		if(str == null)
			return -1;
		if(str.length() <= 1)
			return 1;
		
		int size = str.length();
		int counter;
		int j;
		int i = j = counter = 0;
		Set<Character> set = new HashSet<>();
		
		while(i < size && j < size) {
			if(!set.contains(str.charAt(j))) {
				set.add(str.charAt(j++));
				counter = Math.max(counter,j-i);
			}
			else {
				set.remove(str.charAt(i++));
			}
		}
		return counter;
	}

}
