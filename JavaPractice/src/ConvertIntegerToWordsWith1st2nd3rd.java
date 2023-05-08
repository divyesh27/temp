
public class ConvertIntegerToWordsWith1st2nd3rd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		convertIntToWords(191);
		convertIntToWords(1);
		convertIntToWords(2);
		convertIntToWords(3);
		convertIntToWords(111);
		convertIntToWords(112);
		convertIntToWords(113);
		convertIntToWords(121);
		convertIntToWords(122);
		convertIntToWords(141);
		convertIntToWords(142);
	}
	
	public static void convertIntToWords(int input) {
		if(input > 200)
			throw new IllegalArgumentException("Pass valid input");
		
		if(input % 10 == 1 && input/10 != 11)
			System.out.print(input + "st\n");
		
		else if(input % 10 == 2 && input/10 != 11)
			System.out.print(input + "nd\n");
		
		else if(input % 10 == 3 && input/10 != 11)
			System.out.print(input + "rd\n");
		
		else
			System.out.print(input + "th\n");
	}

}
