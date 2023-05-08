import java.math.BigInteger;

public class AdditiveNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isAdditiveNumber1("112358"));
		System.out.println(isAdditiveNumber1("199100199"));
		System.out.println(isAdditiveNumber1("1234a5"));

        System.out.println(isAdditiveNumber("112358"));
        System.out.println(isAdditiveNumber("199100199"));
        System.out.println(isAdditiveNumber("1234a5"));

	}
	
	static boolean isAdditiveNumber(String num) {
        if (num.length() < 3) {
            return false;
        }
        for (int i = 0; i <= num.length()/2; i++) {
            if (num.charAt(0) == '0' && i > 0) {
                break;
            }
          
            BigInteger x1 = new BigInteger(num.substring(0, i + 1));
            //make sure remaining size is at least size of first and second integer.
            for (int j = i + 1; Math.max(i, j - (i + 1)) + 1 <= num.length() - j - 1 ; j++) {
                if (num.charAt(i + 1) == '0' && j > i + 1) {
                    break;
                }
                BigInteger x2 = new BigInteger(num.substring(i + 1, j + 1));
                if (isValid(num, j + 1, x1, x2)) {
                    return true;
                }
            }
        }
        return false;
    }

	static boolean isAdditiveNumber1(String num) {
        if (num.length() < 3) {
            return false;
        }
        for (int i = 1; i <= num.length()/2; i++) {
            if (num.charAt(0) == '0' && i > 1) {
                break;
            }
          
            Long first = Long.valueOf(num.substring(0, i));
            //make sure remaining size is at least size of first and second integer.
            for (int j = 1; num.length() - i -j >= Math.max(i, j) ; j++) {
                if (num.charAt(i) == '0' && j > 1) {
                    break;
                }
                Long second = Long.valueOf(num.substring(i , i + j));
                if (isValid1(first, second, i+j, num)) {
                    return true;
                }
            }
        }
        return false;
    }
	
    static boolean isValid(String num, int start, BigInteger x1, BigInteger x2) {
        if (start == num.length()) {
            return true;
        }
        BigInteger x3 = x1.add(x2);
        //if num starts with x3 from offset start means x3 is found. So look for next number.
        return num.startsWith(x3.toString(), start) && isValid(num, start + x3.toString().length(), x2, x3);
    }
    
    static boolean isValid1(Long x1, Long x2, int start, String num) {
        if (start == num.length()) {
            return true;
        }
        x2 = x2 + x1;
        x1 = x2 - x1;
        String sum = x2.toString();
        //if num starts with x3 from offset start means x3 is found. So look for next number.
        return num.startsWith(sum, start) && isValid1(x1,x2,start+sum.length(),num);
    }
}
