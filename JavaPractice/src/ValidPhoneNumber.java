
import java.util.regex.*;
/**
 * Find phone number using regular expressions
 * @author divyesh.shah
 *
 */
public class ValidPhoneNumber {


	static boolean findValidPhoneNumberRegex(String inputString) {

		if(inputString == null || inputString.isEmpty() || inputString.length() == 0)
			return false;

		// String regex = "^(https?|http)://[-a-zA-Z0-9+/%?_|:.]*[-a-zA-Z0-9](\\.[a-z]{2,3})$";
		//String regex1 = "^(https://|http://|www.)[-a-zA-Z0-9+/%?_|:.]*[-a-zA-Z0-9](\\.[a-z]{2,3})$";
		String regex1 = "[0-9]{10}|([0-9]{3}(-|\\.|\\s)[0-9]{3}(-|\\.|\\s)[0-9]{4})";
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
		System.out.println(findValidPhoneNumberRegex("413-344-5454"));
		System.out.println(findValidPhoneNumberRegex("413.344.5454"));
		System.out.println(findValidPhoneNumberRegex("4133445454"));
		System.out.println(findValidPhoneNumberRegex("413345454"));
		System.out.println(findValidPhoneNumberRegex("413.3445454"));
		System.out.println(findValidPhoneNumberRegex("413-344.5454"));
		System.out.println(findValidPhoneNumberRegex("413_344_5454"));
		System.out.println(findValidPhoneNumberRegex("413 344 5454"));
		

	}

}
