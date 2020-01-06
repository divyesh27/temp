import java.util.HashSet;
import java.util.Set;

/**
 * Jewel stone problem on find available char from the given string and return count
 * @author divyesh.shah
 *
 */

public class FindCharMatchToGivenStringJewelStone {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(FindMostOccurCharFromString("aaabbbbcbsbdddcbbbc","dsa"));
		System.out.println(FindMostOccurCharFromString("SAAbbbbcbsbdddcbbbc","dsa"));
	}
		
	private static int FindMostOccurCharFromString(String inputString, String compare)
	{
		if(compare == null || inputString == null || compare.isEmpty() || compare.isEmpty() || inputString.length() < 1 || compare.length() < 1)
			throw new IllegalArgumentException("Pass valid input");
		
		int count = 0;
		Set<Character> distinctChar = new HashSet<>();
		for(char c : compare.toCharArray()) {
			distinctChar.add(c);
		}
		for(char c : inputString.toCharArray()) {
			if(distinctChar.contains(c))
				count++;
		}
		return count;
	}
}
