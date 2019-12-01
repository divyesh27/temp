
import java.util.regex.*;

public class ValidURL {


	static boolean findValidURL(String inputString) {

		if(inputString == null || inputString.isEmpty() || inputString.length() == 0)
			return false;

		// String regex = "^(https?|http)://[-a-zA-Z0-9+/%?_|:.]*[-a-zA-Z0-9](\\.[a-z]{2,3})$";
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
		System.out.println(findValidURL("https://www.helix.com"));
		System.out.println(findValidURL("1234"));
		System.out.println(findValidURL("htt://ee.ee.com"));
		System.out.println(findValidURL("http://abc.cde.fed.in"));
		System.out.println(findValidURL("http://www.abc.cde.fed.in"));
		System.out.println(findValidURL("http://www.abc/cde/fed.in"));
		System.out.println(findValidURL("https://www.helix.in"));
		System.out.println(findValidURL("https://helix.ca"));
		System.out.println(findValidURL("https://www.helix.abcd"));
		System.out.println(findValidURL("http://www.helix.abcd"));
		System.out.println(findValidURL("http://www.helix.com"));
		System.out.println(findValidURL("http://abc"));
		System.out.println(findValidURL("www.helix.com"));
		System.out.println(findValidURL("https://"));
		System.out.println(findValidURL("http://"));

	}

}
