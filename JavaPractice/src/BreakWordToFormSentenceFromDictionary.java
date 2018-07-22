import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class BreakWordToFormSentenceFromDictionary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> dict = new ArrayList<String>();
		dict.add("I");
		dict.add("like");
		dict.add("had");
		dict.add("play");
		dict.add("to");
        String str = "playtoIliketo";
        System.out.println(breakWord(str,dict));
	}
	
	/*
	static List<String> breakWordFromString(String str, List<String> dict ) {
		return breakWordUtil(str, dict, new HashMap<String, LinkedList<String>>());
	}
	static List<String> breakWordUtil(String str, List<String> dict, HashMap<String, LinkedList<String>> map) {

		if(map.containsKey(str)) {
			return map.get(str);
		}
		
		LinkedList<String> result = new LinkedList<String>();
		if(str.length() == 0) {
			return result;
		}
		
		for(String word : dict) {
			if(str.startsWith(word)) {
				List<String> sublist = breakWordUtil(str.substring(word.length()), dict, map);
				for(String sub : sublist)
					result.add(word + (sub.isEmpty() ? "" : " ") + sub);
			}
		}
		map.put(str, result);
		return result;
	}*/
	
	public static String breakWord(String str, List<String> dict) {
		return breakWordUtil(str,0,dict);
	}
	
	static String breakWordUtil(String str, int low, List<String> dict) {
		if (str == null || str.length() < 1)
			return str;
		
		StringBuffer strbuffer = new StringBuffer();
		for(int i=low; i < str.length(); i++) {
			strbuffer.append(str.charAt(i));
			if(dict.contains(strbuffer.toString())) {
				String result = breakWordUtil(str, i+1, dict);
				if(result != null) {
					return strbuffer.toString() + " " + result;
				}
			}
		}
		if(dict.contains(strbuffer.toString())) {
			return strbuffer.toString();
		}
		return null;
	}
	
}
