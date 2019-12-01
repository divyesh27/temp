import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *  String s = "{Valery,Jason,Peter} was in {good,bad} mood and he went to the {beach, party, library}";
 * @author divyesh.shah
 *
 */

public class StringPermutationsPrintAllCombinations {

	private static int count;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		findPermutation("{Valery,Jason,Peter} was in {good,bad} mood and he went to the {beach,party,library}");
		findPermutation("{Valery,Jason,Peter} was in");
	}

	static void findPermutation(String input) {
		
		if(input == null || input.length() < 2)
			throw new IllegalArgumentException("Pass valid input");
		
		List<String> al = new ArrayList<>();
		String regex = "\\{(\\w+,?\\s?)+\\}";	
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(input);
		int count = 0;
		while(m.find()) {
			al.add(m.group(0));
			count++;
		}
		System.out.println(count);
		if(count != 3) {
			throw new IllegalArgumentException("Input String is not pass with all needed values");
		}
		
		String[] name;
		String [] emotions;
		String [] locations;
		
		name = al.get(0).replaceAll("^\\{|\\}$", "").split(",");  //This remove open/end brackets and splits all values
		emotions = al.get(1).replaceAll("^\\{|\\}$", "").split(",");
		locations = al.get(2).replaceAll("^\\{|\\}$", "").split(",");
		
		for(String n : name) {
			for(String e : emotions) {
				for(String l : locations) {
					System.out.println(n + " was in " + e + " mood and he went to the " + l);
				}
			}
		}
	}


	public static void permutation(String[] emotions, String[] locations) {

	}
}
