

public class factorial {
	public static void main(String[] args) {
		int n=4;
		System.out.println(factorial(n));
	}
	
		public static int factorial(int n)
		{
			int fac=0;
			if(n==0)
				return 1;
			
			return n*factorial(n-1);
			
			
}
}