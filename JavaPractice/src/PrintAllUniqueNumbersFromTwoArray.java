
public class PrintAllUniqueNumbersFromTwoArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numA = {2,4,5,7,8,9};
		int[] numB = {1,2,6,7,10};
		PrintUniqueNumbers(numA,numB);
	}
	private static void PrintUniqueNumbers(int[] num1, int[] num2)
	{
		int i,j;
		i=j=0;
		
		
		while(i < num1.length && j < num2.length)
		{
			if(num1[i] < num2[j])
			{
				System.out.println(""+num1[i]);
				i++;
			}
			else if(num2[j] < num1[i])
			{
				System.out.println(""+num2[j]);
				j++;
			}
			else if(num1[i] == num2[j])
			{
				i++;
				j++;
			}
		}
		while(i < num1.length)
		{
			if(i == num1.length-1)
				System.out.println(""+num1[i]);
			else if(num1[i] != num1[i+1])
				System.out.println(""+num1[i]);
			i++;
		}
		while(j < num2.length)
		{
			if(j == num2.length-1)
				System.out.println(""+num2[j]);
			else if(num2[j] != num2[j+1])
				System.out.println(""+num2[j]);
			j++;
		}
		
	}

}
