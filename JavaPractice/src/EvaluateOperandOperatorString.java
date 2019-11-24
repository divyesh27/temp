import java.util.Stack;


public class EvaluateOperandOperatorString {

	public static int Evaluate(String input){
		
		char [] tokens = input.toCharArray();
		
		Stack <Integer> operand = new Stack<Integer>();
		Stack <Character> operator = new Stack<Character>();
		
		for(int i=0; i < tokens.length; i++)
		{
			if(tokens[i] == ' ')
				continue;
			
			if(tokens[i] >= '0' && tokens[i] <= '9')
			{
				StringBuffer sb = new StringBuffer();
				while(i< tokens.length && tokens[i] >= '0' && tokens[i] <= '9')
				{
					sb.append(tokens[i++]);
				}
				operand.push(Integer.parseInt(sb.toString()));
			}
			else if(tokens[i] == '(')
			{
				operator.push(tokens[i]);
			}
			else if(tokens[i] == ')')
			{
				while(operator.peek()!='(' && !operator.isEmpty())
					operand.push(Arithmetic(operand.pop(), operand.pop(), operator.pop()));
				operator.pop();
			}
			else if(tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '*' || tokens[i]== '/')
			{
				while(!operator.isEmpty() && isPrecendance(tokens[i],operator.peek()))
				{
					operand.push(Arithmetic(operand.pop(),operand.pop(),operator.pop()));
				}
				operator.push(tokens[i]);
			}
		}	
		
		while(!operator.empty())
		{
			operand.push(Arithmetic(operand.pop(),operand.pop(),operator.pop()));
			
		}
		return operand.pop();
	}
	public static boolean isPrecendance(char op1, char op2)
	{
		if(op1 == '(' || op2 == ')')
			return false;
		else if((op1 == '/' || op1 == '*') && (op2 == '+' || op2 == '-'))
			return false;
		else if((op2 == '(' || op2 == ')'))
			return false;
		return true;
	}
	public static int Arithmetic(int val2, int val1, char op)
	{
		switch(op)
		{
			case '+':
				return val1 + val2;
			case '-':
				return val1 - val2;
			case '*':
				return val1 * val2;
			case '/':
				if(val2 == 0)
					throw new UnsupportedOperationException("Can't divide by zero");
				return val1 / val2;
		}
		return 0;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		System.out.println(Evaluate("10 + 2 * 6"));
		System.out.println(Evaluate("100 * 2 + 12"));
		*/
		System.out.println(Evaluate("100 * ( 2 + 12 )" ));
		System.out.println(Evaluate("100 * ( 2 + 12 ) / 14"));
		//System.out.println(Evaluate("10 + 2 * 6"));
		
	}	

}
