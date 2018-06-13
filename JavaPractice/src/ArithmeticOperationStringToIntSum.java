import java.util.Stack;


public class ArithmeticOperationStringToIntSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String input = "2-4+1";
	//	String input = "-3+55";
	//	String input = "11+2";
	//	String input = "1+-2";
	//	String input = "1--2";
	//	String input = "1-+2";
	//	String input = "2-4-1";
	//	String input = "2+4-1-6+9+9";
	//	String input = "--4-1"; /// This is not supported.
	//	String input = "2-4+";
		
	//	System.out.println(ArithOperationStringToIntSum(input));
		System.out.println(ArithOpStringToIntSum(input));
	}

	
	private static int ArithOpStringToIntSum(String input)
	{
		if(input == null || input.length() ==0 || input.length() < 3 || input.charAt(input.length() -1) == '-' || input.charAt(input.length() -1) == '+')
			return -1;
		
		String [] str = input.split("(-)|(\\+)");
		int returnValue = 0;
		boolean flag = false;
		Stack <Integer> st = new Stack<Integer>();
		int i=1;
		int j=0;
		
		if(input.charAt(i-1) == '-' && (!str[i].isEmpty()))
		{
			returnValue = -1 * Integer.parseInt(str[i]);
			st.push(returnValue);
			flag = true;
			j=2;
		}
		else if(Integer.parseInt(str[i-1]) < 9)
		{
			returnValue = Integer.parseInt(str[i-1]);
			st.push(returnValue);
			j=1;
		}
		else
			return -1;
		
		for(i=1; i < str.length; i++)
		{
			if(str[i].isEmpty() && (!flag))
				return -1;
			else if(Integer.parseInt(str[i]) > 9)
				return -1;
		}
		i=1;
		while(i < str.length && j < input.length())
		{
			if(input.charAt(j) == '-')
			{
				returnValue = st.pop() - Integer.parseInt(str[i]);
				st.push(returnValue);
			}
			else if(input.charAt(j) == '+')
			{
				returnValue = st.pop() + Integer.parseInt(str[i]);
				st.push(returnValue);
			}
			i++;
			j=j+2;
		}
		
		return returnValue;
	}
}
