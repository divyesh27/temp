/**
 * This is incomplete code...
 * 
 * @author divyesh.shah
 *
 */
public class ConvertNumbersToWords {

	static String [] thousands = {"","thousand", "million", "billion","trillion","quadrillion","quintillion"};
	static String [] digits_20 = {"","one","two","three","four","six","seven","eight","nine","ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};
	static String [] tens = {"","ten","twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety"};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(NumToWords(123134));
		System.out.println(NumToWords(1000000004));
		System.out.println(NumToWords(00000004));
		System.out.println(NumToWords(00000000));
	}
	
	private static String NumToWords(int number)
	{
		
		if(number == 0)
			return "Zero";
		
		int count=0;
		String str = "";
		
		while(number > 0)
		{
			if(number % 1000 !=0)
				str = NumToString(number % 1000) + thousands[count] + " " + str;
			
			number/=1000;
			count++;
		}
 		return str;
	}
	private static String NumToString(int number)
	{
		if(number ==0)
			return "";
		else if(number < 20)
			return digits_20[number] + " ";
		else if(number < 100)
			return tens[number/10] + " " + NumToString(number % 10);
		else
			return digits_20[number/100] + " hundered " + NumToString(number % 100);
	}
}
