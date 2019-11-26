import java.util.regex.*;


public class FindReplaceFinal {
	
	public static void main(String arg[])
	{
		String s1="I am Jinal Jinal Jinal I am Jinal";
		String find="Jinal";
		String replace="Kinal";
		
		//System.out.println("Output is ="+findReplace(s1,find,replace));
		System.out.println("Output is ="+findReplaceRegex(s1,find,replace));
	}
	
	
	public static String findReplace(String s1,String find, String replace)
	{
		if( s1.length()==0 || find.length()==0 || replace.length()==0 )
		{
			return s1;
		}
		int lastIndex=0;
		int index=s1.indexOf(find);
//
		StringBuilder buffer=new StringBuilder();
		while(index!=-1)
		{
			//StringBuffer buffer=new StringBuffer();
			buffer.append(s1.substring(lastIndex, index)).append(replace);
			lastIndex=index+find.length();
			index=s1.indexOf(find,lastIndex);
		}
		
		buffer.append(s1.substring(lastIndex));
		String s2 = buffer.toString();
		return s2;
		
	}
	
	private static String findReplaceRegex(String s1,String find, String replace)
	{
		if( s1.length()==0 || find.length()==0 || replace.length()==0 )
			return s1;
		
		Pattern p = Pattern.compile("Jinal");
		Matcher m = p.matcher(s1);
		StringBuffer sb = new StringBuffer();
		while(m.find())
		{
			m.appendReplacement(sb, "Kinal");
		}
		m.appendTail(sb);
		System.out.println(sb);
		return sb.toString();
	}
}
