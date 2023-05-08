import java.math.BigInteger;

public class factorial {
	public static void main(String[] args) {
		int n=4;
		System.out.println(computeFactorial(n));
		System.out.println(bigFactCompute(5));
		System.out.println(factorial(8));
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

	public static int factorial(int n) {
		int i, result = 1;
		for(i = 2; i<=n; i++) {
			result *= i;
		}
		return result;
	}
}