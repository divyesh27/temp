public class ConvertStringToIntValue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(convertStringToIntegerValues("1242"));
		//System.out.println(convertStringToIntegerValues("    acdd 234324234"));
		//System.out.println(convertStringToIntegerValues(" acdd 234324234"));
		//System.out.println(convertStringToIntegerValues("     21332 ad"));
		System.out.println(convertStringToIntegerValues("     -21332"));
	}

	public static int convertStringToIntegerValues(String inputString) {

		int negative = -1;
		boolean flag = false;
		StringBuilder sb = new StringBuilder(inputString.trim());
		System.out.println(sb);
		if(inputString == null || inputString.length() < 1 || Character.isLetter(sb.charAt(0))) {
			throw new IllegalArgumentException("Pass Valid input");
		
		}
		char [] inputCharArray = inputString.trim().toCharArray();
		int result =0;
		
		if(inputCharArray[0] == '-') {
			 flag = true;
		}
		for(int i=0; i<inputCharArray.length; i++) {

			if(Character.isAlphabetic(inputCharArray[i]) || Character.isLetter(inputCharArray[i]))
				break;
			int val = (inputCharArray[i]) - '0';
			result = result*10 + val;
		}
		return result;
	}

}
