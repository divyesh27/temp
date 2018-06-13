
public class RemoveMultiSpace {

	public static void main(String args[])
	{
		String s1="Jinal    Shah";
		//System.out.println("output - "+ removeSpace(s1));
		String s = "my    name is    mr    space ";
		s = s.trim().replaceAll(" +", " ");
		System.out.println(s);
		String text = "This  is   a    test";
		System.out.println(RemoveExtraSpacesEfficient(s));
	  int index=0;
	while(index >= 0)
	{
		index=text.indexOf("  ");
		System.out.println("inbetween="+text.indexOf("  "));
	text = text.replaceAll("  ", " ");
	}
	System.out.println("output text - "+ text);
	}	
	public static String removeSpace(String s1)
	{
		int count=0;
		int index=-1;
		int lastIndex=0;
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<s1.length();i++)
		{
			if(s1.charAt(i)==' ')
			{
				count++;	
				System.out.println("Count - "+ count);
			}
		}
			if(count>1)
			{
				
					index=s1.indexOf(' ');
					System.out.println("indext - "+ index);
					int nextIndex=count+index;
					//StringBuffer sb=new StringBuffer();
					sb.append(s1.substring(lastIndex, index)).append(" ").append(s1.substring(nextIndex));
				
			}
		
		return sb.toString();
			
	}
	
	private static String RemoveExtraSpacesEfficient(String s)
	{

	    char[] charArray = s.toCharArray();

	    
        char prev = s.charAt(0);

        for (int i = 0; i < charArray.length; i++) {
            char cur = charArray[i];
            if (cur == ' ' && prev == ' ') {

            } else {
                System.out.print(cur);
            }
            prev = cur;
	    }
        
        return s;
	}
//	public static String removeMultiSpace(String s1)
//	{
//		int index=-1;
//		int count=0;
//		index=s1.indexOf(' ');
//		for(int i=index;i<s1.length();i++)
//		{
//			if(s1.charAt(i)==' ')
//			{
//				count++;
//			}
//		}
//	}
}
