

public class ConvertIntegerToRoman {

	public static String ConvertIntToRomanValues(int inputNumber) {
		
		int [] arabicValues = {1000,900,500,400,100,90,50,40,10,5,4,1};
		String [] romanValues = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X","V", "IV","I"};
		StringBuilder sb = new StringBuilder ();
		for(int i=0; i< arabicValues.length; i++) {
			
			while(inputNumber - arabicValues[i] >= 0) {
				sb.append(romanValues[i]);
				inputNumber = inputNumber - arabicValues[i];
			}
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(ConvertIntToRomanValues(1200));
		System.out.println(ConvertIntToRomanValues(100));
		System.out.println(ConvertIntToRomanValues(1999));
	}	
}