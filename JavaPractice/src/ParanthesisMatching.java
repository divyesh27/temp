/*
author -divyesh
Match exact paranthesis by pushing and poping if the paranthesis is missing or different one. Return False.

You can also extend this program by adding counter of how many counts
*/
import java.util.Stack;

public class ParanthesisMatching {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		System.out.println(" " + Paranthesis("[()]{}{[()()]()}"));
		System.out.println(" " + Paranthesis("(()"));
		System.out.println(" " + Paranthesis("(]([))"));
		System.out.println(" " + Paranthesis("{{{{}}}}(())"));
		System.out.println(" " + Paranthesis("{(([][][]))}"));

	}
	private static boolean Paranthesis(String input)
	{
		if(input == null)
			return false;
		Stack<Character> st = new Stack<Character>();
		char[] ch = input.toCharArray();
		
		for(int i=0; i<ch.length;i++)
		{
			if(ch[i]=='(' || ch[i]=='{' || ch[i]=='[')
				st.push(ch[i]);
			else
			{
				if(st.isEmpty())
					return false;
				if(ch[i]==']' || ch[i]=='}'||ch[i]==')')
				{
					if(!isMatch(st.pop(),ch[i]))
						return false; 
				}
			}
			
				
		}
		if(st.isEmpty())
			return true;
					
		return false;
		
	}
	private static boolean isMatch(Character pop, char c)
	{
		// TODO Auto-generated method stub
		char cpop = pop.charValue();
		
		if(cpop == '(' && c== ')')
			return true;
		else if(cpop == '{' && c=='}')
			return true;
		else if(cpop =='[' && c==']')
			return true;
		else
			return false;
		
	}

}


