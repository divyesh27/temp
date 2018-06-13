
import java.util.regex.*;

public class ExtractDigitsFromStringToSum {

	public static void ExtractDigitsToSum(String s)
	{
		Pattern p = Pattern.compile("\\d+");
		Matcher m = p.matcher(s);
		int sum=0;
		int n=0;
		while(m.find())
		{
			n = Integer.parseInt(m.group());
			sum += n;
		}
		System.out.println(sum);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExtractDigitsToSum("23adf5dsf4");
		ExtractDigitsToSum("235a4");
		ExtractDigitsToSum("2354a");
		ExtractDigitsToSum("a2354");
		ExtractDigitsToSum("a2a3a5a4a");
	}

}
