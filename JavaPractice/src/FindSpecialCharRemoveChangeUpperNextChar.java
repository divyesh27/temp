
public class FindSpecialCharRemoveChangeUpperNextChar {

	//asbs%adsf^nsd(  --> asbsAdsfNsd
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(removeSpecialChar("asbs%adsf^nsdeweokc#!rhslk*(("));
	}
	
	public static String removeSpecialChar(String inputVal) {
		
		if(inputVal == null || inputVal.length() == 0)
			return inputVal;
		boolean flag = false;
		StringBuilder sb = new StringBuilder();
		for(char c : inputVal.toCharArray()) {
			if(!Character.isLetterOrDigit(c)) {
			//if((c >= 27 && c <= 47) || (c >= 58 && c <= 63) ||(c >= 91 && c <= 96)) {
				flag = true;
			}
			else {
				if(flag) {
					sb.append(Character.toUpperCase(c));
					flag = false;
				}
				else 
					sb.append(c);
			}
		}
		return sb.toString();
	}
}
