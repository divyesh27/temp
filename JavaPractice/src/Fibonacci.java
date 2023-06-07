

public class Fibonacci {
	public static void main(String[] args) {
		int sum=0;
		int[] number = new int[10];
		number[0]=1;
		number[1]=1;
		
		for(int i=2;i<number.length;i++)
		{
			number[i]=number[i-1]+number[i-2];
		}
		 for(int i=0; i< number.length; i++){
             System.out.print(number[i] + " ");
		 }
		 
		 
		 //---------
		 System.out.println("\n");
		 for(int i=1;i<10;i++)
		 {
			 System.out.println(recuresiveFibo(i) +"");
		 }
		 System.out.println(evenFibonumber(400));

		 System.out.println();
		 System.out.println(dynamicProgramFibonacci(19));
		 System.out.println();
		 System.out.println(fibonacciIterative(19));
}

	private static int recuresiveFibo(int i) {
		// TODO Auto-generated method stub
		if(i == 0)
	        return 0;
	    else if(i == 1)
	      return 1;
	    else
	    	return recuresiveFibo(i-1)+recuresiveFibo(i-2);
	}
	
	private static long evenFibonumber(int val) {
		
		if(val < 2)
			return 0;
		
		long even1 = 0;
		long even2 = 2;
		long sum = even1 + even2;
		
		while(even2 <= val) {
			
			long even3 = 4 * even2 + even1;
			if(even3 > val)
				break;
			
			even1 = even2;
			even2 = even3;
			sum = sum + even2;
		}
		return sum;
	}
	private static int dynamicProgramFibonacci(int n) {
		int [] lookup = new int[n + 2];
		int i;
		lookup[0] = 0;
		lookup[1] = 1;

		for(i = 2; i <= n; i++) {
			lookup[i] = lookup[i-1] + lookup[i-2];
		}
		return lookup[n];

	}

	private static int fibonacciIterative(int n) {
		int [] f = new int [n+1];
		int i;
		if (n <= 1)
			return n;
		f[0] = 0; f[1] = 1;
		for(i = 2; i <= n; i++) {
			f[i] = f[i-1] + f[i-2];
		}
		return f[n];
	}
}