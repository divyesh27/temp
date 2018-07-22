import java.util.HashSet;

public class FindLongestSubstringWithoutRepeatingCharacter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//System.out.println(FindLongCommSubstringInt("abcdperedfgwerasgdfsh","adgqtfbghfgaafrwelgdfglaewrdsaf"));
		//System.out.println(FindLongCommSubstringInt("abcdperedfgwerasgdfsh","adgqtfbghfga"));
		//System.out.println(FindLongCommSubstringInt("tesla","slate"));
		//System.out.println(FindLongCommSubstringInt("xxxx","slate"));
		System.out.println(longestSubstringWithoutRepeatingCharacter("slatevotea"));
		System.out.println(longestSubstringWithoutRepeatingCharacter("ABCDECAMNCZB"));
	}
	public static int longestSubstringWithoutRepeatingCharacter(String str)
	{
		HashSet<Character> hs = new HashSet<Character>();
		int start = 0;
		int maxSize = 0;
		for(int i = 0; i < str.length(); i++) {
			if(!hs.contains(str.charAt(i))) {
				hs.add(str.charAt(i));
				if(hs.size() > maxSize)
					maxSize = hs.size();
			}
			else {
				while(str.charAt(start) != str.charAt(i)) {
					hs.remove(str.charAt(start));
					start++;
				}
				start++;
			}
		}
		return maxSize;
	}
}
