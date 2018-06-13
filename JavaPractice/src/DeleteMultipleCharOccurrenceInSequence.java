
/*
 * I/P - hiiii hooowwww aaareee yooou?
 * O/P hi how are you?
 * 
 * Drawback/ limitation to this logic is if you have actual word tool or fool where
 * it occurs more than once it will also be removed.
 */
public class DeleteMultipleCharOccurrenceInSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(DeleteMultipleOccurrenceChar("hiii hoowww aaarrreee youuu?"));
	}
	private static String DeleteMultipleOccurrenceChar(String str)
	{
		if(str == null || str.length() == 0)
			return null;
		char last = '\u0000';
		StringBuilder sb = new StringBuilder();
		for(char c : str.toCharArray())
		{
			if(last == '\u0000' || c!= last)
			{
				sb.append(c);
				last = c;
			}
		}
		return sb.toString();
	}
}
