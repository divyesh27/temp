

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
		 
		 for(int i=1;i<10;i++)
		 {
			 System.out.println(recuresiveFibo(i) +"");
		 }
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
}