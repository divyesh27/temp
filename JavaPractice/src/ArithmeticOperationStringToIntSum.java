import java.util.HashSet;
import java.util.Stack;


public class ArithmeticOperationStringToIntSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	//	String input = "2-4+1";
		String input = "-3+55";
		String [] tokens = new String[] {"2","1","+","3","*"};
		String [] tokens1 = new String[] {"4","13","5","/","+"};
		String [] tokens2 = new String[] {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
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
		System.out.println(ArithmeticOperatorExpression(input));
		System.out.println(ArithmeticEvalOperator(tokens));
		System.out.println(ArithmeticEvalOperator(tokens1));
		System.out.println(ArithmeticEvalOperator(tokens2));
	}

	
	// TODO - Add proper stack for pushing into all values
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

	public static int ArithmeticOperatorExpression(String expression) {
		char[] tokens = expression.toCharArray();
		int result = 0;
		int num = 0;

		for (int i = 0; i < tokens.length; i++) {
			if (Character.isDigit(tokens[i])) {
				num = num * 10 + tokens[i] - '0';
			}
			if (!Character.isDigit(tokens[i]) || i <= tokens.length - 1) {
				if (tokens[i] == '+') {
					result += num;
				} else if (tokens[i] == '-') {
					result -= num;
				} else if (tokens[i] == '*') {
					result *= num;
				} else if (tokens[i] == '/') {
					result /= num;
				}
			}
		}
		return result;
	}

	public static int ArithmeticEvalOperator(String[] tokens) {


			Stack<Integer> stack = new Stack<>();

			for (String token : tokens) {
				if (isOperator(token)) {
					int operand2 = stack.pop();
					int operand1 = stack.pop();
					int result = performOperation(token, operand1, operand2);
					stack.push(result);
				} else {
					int operand = Integer.parseInt(token);
					stack.push(operand);
				}
			}

			return stack.pop();
		}

		private static boolean isOperator(String token) {
			return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
		}

		private static int performOperation(String operator, int operand1, int operand2) {
			switch (operator) {
				case "+":
					return operand1 + operand2;
				case "-":
					return operand1 - operand2;
				case "*":
					return operand1 * operand2;
				case "/":
					return operand1 / operand2;
				default:
					throw new IllegalArgumentException("Invalid operator: " + operator);
			}
		}
}
