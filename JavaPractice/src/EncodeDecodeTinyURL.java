
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.regex.*;

public class EncodeDecodeTinyURL {

	static Map<String, String> hm = new HashMap<>();
	static String key = null;
	static String returnURL = "http://tinyURL.com/";
	
	static void tinyURLEncodeDecode(String inputString) {

		if(inputString == null || inputString.isEmpty() || inputString.length() == 0 || !validURL(inputString))
			throw new IllegalArgumentException("Pass valid input");
		
		key = getRandomValue();
		String shortURL;
		System.out.println(shortURL = encodeURL(inputString));
		System.out.println(decodeURL(shortURL));
		
	}
	
	static String encodeURL(String longURL) {
		while(hm.containsKey(key)) {
			key = getRandomValue();
		}
		hm.put(key, longURL);
		return returnURL + key;
	}
	
	static String decodeURL(String shortURL) {
		return hm.get(shortURL.replace(returnURL, ""));
	}
	
	static String getRandomValue() {
		
		String alphabet = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Random rm = new Random();
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<10; i++) {
			sb.append(alphabet.charAt(rm.nextInt(62)));
		}
		return sb.toString();
	}
	static boolean validURL(String inputString) {
		String regex1 = "^(https://|http://|www.)[-a-zA-Z0-9+/%?_|:.]*[-a-zA-Z0-9](\\.[a-z]{2,3})$";
		try {
			Pattern p = Pattern.compile(regex1);
			Matcher m = p.matcher(inputString);
			if(m.matches())
				return true;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		tinyURLEncodeDecode("https://www.helix.com");
		tinyURLEncodeDecode("https://www.abcdefghijladfafacsdcas.com");
		tinyURLEncodeDecode("www.timeofindiaahmedabadtobombay.com");
		tinyURLEncodeDecode("www.vyavsaividhyapratishthanrajkotaliasvvp.com");
		tinyURLEncodeDecode("https://leetcode.com/problems/design-tinyurl");
		tinyURLEncodeDecode("www.om");
		

	}

}
