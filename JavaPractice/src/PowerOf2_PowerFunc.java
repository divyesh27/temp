public class PowerOf2_PowerFunc {
	public static void main(String[] args) {
		int n=24;
		System.out.println(powerOfTwo(n));
	}
	public static boolean powerOfTwo(int n) {
		if(n == 0)
			return false;
		while(n != 1) {
			if(n % 2 != 0)
				return false;
			n/=2;
		}
		return true;
	}
	
	public static int power(int n, int m) {
		if(m == 0) {
			return 1;
		}
		int pow = power(n,m/2);
		if(m % 2 == 0) {
			return pow*pow;
		}
		else {
			return n*pow*pow;
		}
	}
}