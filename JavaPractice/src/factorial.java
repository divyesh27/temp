import java.math.BigInteger;

public class factorial {
	public static void main(String[] args) {
		int n=4;
		System.out.println(computeFactorial(n));
		System.out.println(bigFactCompute(20));
	}
	public static int computeFactorial(int n)
	{
		if(n==0)
			return 1;
		
		return n*computeFactorial(n-1);
	}
	// This helps to computer very big integer
	public static BigInteger bigFactCompute(int n) {
		BigInteger f = new BigInteger("1");
		for(int i=2; i<=n; i++) {
			f = f.multiply(BigInteger.valueOf(i));
		}
		return f;
	}
}