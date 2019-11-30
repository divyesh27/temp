import java.util.HashMap;
import java.util.Map;

public class ConvertRomanToInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(ConvertRomanValuesToInteger("V"));
		System.out.println(ConvertRomanValuesToInteger("XI"));
		System.out.println(ConvertRomanValuesToInteger("XICM"));
		System.out.println(ConvertRomanValuesToInteger("MC"));
		System.out.println(ConvertRomanValuesToInteger("MCMLXXI"));
		System.out.println(ConvertRomanValuesToInteger("MCMXCIV"));
	}	
	
	public static int ConvertRomanValuesToInteger(String inputRoman) {
		
		if(inputRoman == null || inputRoman.length() < 1)
			throw new IllegalArgumentException("Pass valid input");
		
		Map<Character, Integer> roman = getMap();
		char[] romanArray = inputRoman.toCharArray();
		int size = romanArray.length;
		int result = roman.get(romanArray[size-1]);
		for(int i=size-2; i>=0; i--) {
			if(romanArray[i] < romanArray[i+1])
				result -= roman.get(romanArray[i]);
			else
				result += roman.get(romanArray[i]);
		}
		return result;
	}
	
	private static Map<Character, Integer> getMap() {
		
		Map<Character, Integer> romanMap = new HashMap<Character, Integer>();
		romanMap.put('I', 1);
		romanMap.put('V', 5);
		romanMap.put('X', 10);
		romanMap.put('L', 50);
		romanMap.put('C', 100);
		romanMap.put('D', 500);
		romanMap.put('M', 1000);
		return romanMap;
	}
	
}