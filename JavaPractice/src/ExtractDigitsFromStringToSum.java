
import java.util.regex.*;

public class ExtractDigitsFromStringToSum {

	public static void ExtractDigitsToSum(String s) {
		Pattern p = Pattern.compile("\\-?\\d+"); // - is to consider -(-ve) and ? is to check option if it is there or
		// not,
		// \\d is to consider any digit from 0-9 and then + will be for more
		// then one
		// another way to add can be "\\-?[0-9]+
		Matcher m = p.matcher(s);
		int sum = 0;
		int n = 0;
		while (m.find()) {
			n = Integer.parseInt(m.group());
			sum += n;
		}
		System.out.println(sum);

	}

	static int addSummation(String inputString) {

		if (inputString == null || inputString.length() < 2)
			throw new IllegalArgumentException("Pass valid input");

		char[] inputChar = inputString.toCharArray();
		boolean flag = true;
		int sum = 0;
		String result = "";

		for (int i = 0; i < inputChar.length; i++) {

			if (Character.isDigit(inputChar[i])) {
				result = result + inputChar[i];
				flag = true;
				//System.out.println(result);
			} else {
				try { 
					if(!Character.isDigit(inputChar[i]) && flag) {
						sum += Integer.parseInt(result);
						flag = false;
						result = "";
					}
				}
				catch (NumberFormatException e) {
					result = "";
				}
			}

		}
		if(!result.isEmpty())
			sum += Integer.parseInt(result);
		return sum;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("*** Extract Digits Method ***");
		ExtractDigitsToSum("23adf5dsf4"); 
		ExtractDigitsToSum("235a4");
		ExtractDigitsToSum("2354a"); 
		ExtractDigitsToSum("a2354");
		ExtractDigitsToSum("a2a3a5a4a"); 
		ExtractDigitsToSum("123a-bc-22");

		System.out.println("\n*** ******** ***\n");
		System.out.println("*** Add summation method ***");
		System.out.println(addSummation("123abc45def6gh78"));
		System.out.println(addSummation("23adf5dsf4"));
		System.out.println(addSummation("235a4"));
		System.out.println(addSummation("2354a"));
		System.out.println(addSummation("a2a3a5a4a"));
		System.out.println(addSummation("232345"));
		System.out.println(addSummation("abcde"));
		System.out.println(addSummation("1abcde1"));
	}

}
