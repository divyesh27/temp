
public class StringWithOutGivenCharacter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(RemoveCharFromString("google",'g'));
	}
	private static String RemoveCharFromString(String str, char c)
	{
		if(str == null)
			return null;
		StringBuffer sb = new StringBuffer();
		for(int i=0; i< str.length(); i++)
		{
			if(str.charAt(i) != c)
				sb.append(str.charAt(i));
		}
		return new String(sb);
	}

}
