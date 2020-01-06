/**
 * This will add numbers till it adds to single digit and return that value
 * Single number calculated in addition from double
 * @author divyesh.shah
 *
 */
public class AddTwoNumbersFromGivenNumberTillSingleDigit {
	
	public static void main(String[] args)  {
		System.out.println(AddNumbers(1));
		System.out.println(AddNumbers(2));
		System.out.println(AddNumbers(3));
		System.out.println(AddNumbers(4));
		System.out.println(AddNumbers(5));
		System.out.println(AddNumbers(6));
		System.out.println(AddNumbers(7));
		System.out.println(AddNumbers(8));
		System.out.println(AddNumbers(9));
		System.out.println(AddNumbers(10));
		System.out.println(AddNumbers(11));
		System.out.println(AddNumbers(12));
		System.out.println(AddNumbers(13));
		System.out.println(AddNumbers(14));
		System.out.println(AddNumbers(15));
		System.out.println(AddNumbers(16));
		System.out.println(AddNumbers(17));
		System.out.println(AddNumbers(18));
		System.out.println(AddNumbers(19));
		System.out.println(AddNumbers(20));
		System.out.println(AddNumbers(21));
		System.out.println(AddNumbers(22));
		System.out.println(AddNumbers(23));
		System.out.println(AddNumbers(24));
		System.out.println(AddNumbers(25));
		System.out.println(AddNumbers(26));
		System.out.println(AddNumbers(27));
		System.out.println(AddNumbers(28));
		System.out.println(AddNumbers(29));
		System.out.println(AddNumbers(30));
		System.out.println("*****************");
		System.out.println(AddNumber(21));
		System.out.println(AddNumber(22));
		System.out.println(AddNumber(23));
		System.out.println(AddNumber(24));
		System.out.println(AddNumber(25));
		System.out.println(AddNumber(26));
		System.out.println(AddNumber(27));
		System.out.println(AddNumber(28));
		System.out.println(AddNumber(29));
		System.out.println(AddNumber(30));
		System.out.println("*****************");
		System.out.println(AddNum(31));
		System.out.println(AddNum(32));
		System.out.println(AddNum(33));
		System.out.println(AddNum(34));
		System.out.println(AddNum(35));
		System.out.println(AddNum(36));
		System.out.println(AddNum(37));
		System.out.println(AddNum(38));
		System.out.println(AddNum(39));
		System.out.println(AddNum(40));
		
	}
	
	private static int AddNumbers(int num) {
		
		if(num == 0)
			return num;
		
		if(num % 9 == 0)
			return 9;
		else 
			return num % 9;
		
	}
	
	private static int AddNumber(int num) {
		return (num - 1) % 9 + 1;
	}
	
	private static int AddNum(int num) {

		return (num!=0 && num%9==0) ? 9 : num%9;
	}	
}
