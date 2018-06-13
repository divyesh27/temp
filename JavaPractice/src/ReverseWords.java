
public class ReverseWords {
	
	public static void main(String arg[])
	{
		String s1="apple red";
		int len=s1.length();
		int lastIndex=0;
		int index=s1.indexOf(" ");
		int l=len-index;
		StringBuffer buffer = new StringBuffer();
		buffer.append(s1.substring(index)).append(" ").append(s1.substring(0,index));
		System.out.println("Output is"+buffer.toString());
		String s2="My name is Jinal";
		System.out.println("Output is"+reverseMulWords(s2));
		
		System.out.println("Output is"+reverseEachWord(s2));
	}

	public static String reverseMulWords(String s1)
	{
		String[] str=s1.split(" ");
		StringBuffer sb=new StringBuffer();
		sb.append(str[str.length-1]);
		for(int i=str.length-2;i>=0;i--)
		{
			sb.append(" ").append(str[i]);
		}
		
		return sb.toString();
	}
	
	public static String reverseEachWord(String s1)
	{
		String[] str=s1.split(" ");
		//String[] s2 = null;
		String s2;
		char[] c = null;
		StringBuffer sb=new StringBuffer();
		
		int len=str.length;
		int k=0;
		while(k<len)
		{
			int count =str[k].length();
			System.out.println("count = "+count);
			if(count>0)
			{
				int i=k;
				int j=count-1;
				String temp="";
				
				while(i<=j)
				{
					temp= temp + str[k].charAt(j);	
					i++;
					j--;
				}
				sb.append(temp);
				System.out.println("inside ----" + sb.toString());
				
			}
			k++;
		}
		return s1;
	}
	
}
