/**
 * Function is to reverse the given integer int type and return the reverse order
 * @author divyesh.shah
 *
 */
public class ReverseInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverseInteger(123));
		System.out.println(reverseInteger(8765));
		System.out.println(reverseInteger(4421));
		System.out.println(reverseInteger(222));
	}
	public static int reverseInteger(int input) {
		
		if(input == 0)
			return 0;
		
		int neg = -1;
		boolean flag = false;
		if(input < 1)
			flag = true;
		
		int reverse = 0;
		while(input != 0) {
			reverse = reverse * 10 + input % 10;
			input = input / 10;
		}
		if(flag)
			reverse = reverse * neg;
		return reverse;
	}

}
