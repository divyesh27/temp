public class PowerOf2 {
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
}