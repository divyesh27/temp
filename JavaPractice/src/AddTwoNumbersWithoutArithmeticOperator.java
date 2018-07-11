import java.util.HashMap;
import java.util.HashSet;



public class AddTwoNumbersWithoutArithmeticOperator {
	
	public static void main(String[] args)  {
		System.out.println(AddNumbers(5,9));
	}
	
	private static int AddNumbers(int a, int b) {
		while(b!=0) {
			int carry = a & b;
			a = a ^ b;
			
			b = carry << 1;
		}
		return a;
	}
}
