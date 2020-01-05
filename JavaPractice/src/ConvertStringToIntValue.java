
public class ConvertStringToIntValue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(convertStringToIntegerValues("1242"));
		System.out.println(convertStringToIntegerValues("    acdd 234324234"));
		System.out.println(convertStringToIntegerValues(" acdd 234324234"));
		System.out.println(convertStringToIntegerValues("     21332 ad"));
		System.out.println(convertStringToIntegerValues("     21332"));
		System.out.println(convertStringToIntegerValues("     -21332"));
		System.out.println(convertStringToIntegerValues("-1242"));
		System.out.println(convertStringToIntegerValues("-9343232242"));
		System.out.println(convertStringToIntegerValues("9343232242"));
	}

	public static int convertStringToIntegerValues(String inputString) {

		int negative = -1;
		boolean flag = false;
		int index=0;
		if(inputString == null || inputString.length() < 1 || Character.isLetter(inputString.charAt(0))) {
			throw new IllegalArgumentException("Pass Valid input");
		}
		
		inputString = inputString.trim();
		char [] inputCharArray = inputString.toCharArray();
		
		double result = 0;
		
		if(inputCharArray[0] == '-') {
			 flag = true;
			 index = 1;
		}
		if(inputCharArray[0] == '+') {
			index = 1;
		}
		
		for(int i=index ;i<inputCharArray.length; i++) {

			if(Character.isAlphabetic(inputCharArray[i]) || Character.isLetter(inputCharArray[i]) || Character.isSpaceChar(inputCharArray[i]))
				break;
			// if(inputCharArray[i] < '0' || inputCharArray[i] > '9') break;
			int val = (inputCharArray[i]) - '0';
			result = result*10 + val;
		}
		if(flag)
			result = result*negative;
		
		if(result > Integer.MAX_VALUE)
			return Integer.MAX_VALUE;
		else if(result < Integer.MIN_VALUE)
			return Integer.MIN_VALUE;
		else
			return (int) result;
		
	}
}
