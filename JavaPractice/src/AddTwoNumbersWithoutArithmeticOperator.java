import java.util.HashMap;
import java.util.HashSet;



public class AddTwoNumbersWithoutArithmeticOperator {
	
	public static void main(String[] args)  {
		System.out.println(AddNumbers(5,9));
		System.out.println(addBinaryNumbersFromTwoGivenString("11","1"));
	}
	
	private static int AddNumbers(int a, int b) {
		while(b!=0) {
			int carry = a & b;
			a = a ^ b;
			
			b = carry << 1;
		}
		return a;
	}
	
	private static String addBinaryNumbersFromTwoGivenString(String x, String y) {
		
		String result = "";
		int i = x.length()-1;
		int j  = y.length()-1;
		int sum = 0;
		
		while(i >= 0 || j >= 0 || sum == 1) {
			
			if(i >= 0) {
				sum = sum + x.charAt(i) - '0';
			}
			
			if(j >= 0) {
				sum = sum + y.charAt(j) - '0';
			}
			
			result = (char) (sum % 2 + '0') + result;
			
			sum = sum / 2;
			i--;
			j--;
		}
		return result;
	}
}
