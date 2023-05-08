import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class FindSubCharactersFromAnotherString {

	//asbs%adsf^nsd(  --> asbsAdsfNsd
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(Character c : findSubChar("apple","pear"))
			System.out.print(c + "\t");
		System.out.println();
		for(Character c : findSubChar("lock","door"))
			System.out.print(c + "\t");
		System.out.println();
		for(Character c : findSubChar("foo","barf"))
			System.out.print(c + "\t");
		System.out.println();
		for(Character c : findSubChar("foo",""))
			System.out.print(c + "\t");
		System.out.println();
	}
	
	@SuppressWarnings("unchecked")
	public static Set<Character> findSubChar(String input1, String input2) {

		if(input1 == null || input2 == null)
			throw new IllegalArgumentException("Pass valid input");

		if(input1.isEmpty() || input2.isEmpty())
			return Collections.EMPTY_SET;

		Set<Character> unique = new HashSet<Character>();
		Set<Character> result = new HashSet<Character>();
		for(Character c : input1.toCharArray()) 
			unique.add(c);

		for(Character c : input2.toCharArray()) {
			if(unique.contains(c))
				result.add(c);
		}
		
		return result;
	}

}
