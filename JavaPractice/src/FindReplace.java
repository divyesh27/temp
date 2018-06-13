
public class FindReplace {
	
	
	public static void main(String args[])
	{
		String s1="Jinal shah";
		String f="Ji";
		String r="k";
		char[] s=s1.toCharArray();
		char[] find=f.toCharArray();
		char[] replace=r.toCharArray();
	//	boolean flag=findreplace(s,find,replace);
		System.out.println("flag=" +  replace(s1, f, r));
		
		
	}
	
	public static boolean findreplace(char[] s1, char[] find, char[] replace)
	{
		int slen=s1.length;
		int flen=find.length;
		int rlen=replace.length;
		
		for (int i=0;i<slen;i++)
		{
			int j=0;
			if(s1[i]==find[j]);
			{
				j++;
			if(j==flen)
			{
				return true;
			}
			}
		}
		return false;
	}
	
	
	
	 public static String replace(String value, String from, String to)
	    {
	        if ((value == null) || (value.length() == 0) || (from == null) || (from.length() == 0))
	        {
	            return value;
	        }

	        if (to == null)
	        {
	            to = "";
	        }


	        String result = value;
	        int lastIndex = 0;
	        int index = value.indexOf(from);

	        if (index != -1)
	        {
	            StringBuffer buffer = new StringBuffer();

	            while (index != -1)
	            {
	                buffer.append(value.substring(lastIndex, index)).append(to);
	                lastIndex = index + from.length();
	                index = value.indexOf(from, lastIndex);
	            }

	            buffer.append(value.substring(lastIndex));
	            result = buffer.toString();
	        }

	        return result;
	    }

}
