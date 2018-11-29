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

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	static void findPermutation(String input) {
		 String regex = "\\{(\\w+,?\\s?)+\\}";	
		 Pattern p = Pattern.compile(regex);
		 Matcher m = p.matcher(input);
		 List<List<String>> al = new ArrayList<>();
		 int count = 0;
		 while(m.find()) {
			
		 }
		 
	}
}
