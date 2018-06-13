import java.util.Stack;

public class ReversePolishOperatorOperandNotation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//	String [] st =  new String[] {"2", "1", "+", "3", "*"};
		String [] st =  new String[] {"4", "13", "5", "/", "+"};
		System.out.println(evalRPN(st));
	}

	private static int evalRPN(String [] token)
	{
		if(token == null || token.length ==0)
			return -1;
		
		int returnValue = 0;
		String operator = "/*+-";
		
		Stack<String> stack = new Stack<String>();
		
		for(String t : token)
		{
			if(!operator.contains(t))
				stack.push(t);
			else
			{
				int a = Integer.parseInt(stack.pop());
				int b = Integer.parseInt(stack.pop());
				
				int index = operator.indexOf(t);
				switch(index)
				{
					case 0:
						stack.push(String.valueOf(b / a));
						break;
					case 1:
						stack.push(String.valueOf(a * b));
						break;
					case 2:
						stack.push(String.valueOf(a + b));
						break;
					case 3:
						stack.push(String.valueOf(b - a));
						break;
				}
			}
		}
		returnValue = Integer.parseInt(stack.pop());
		return returnValue;
	}
}
