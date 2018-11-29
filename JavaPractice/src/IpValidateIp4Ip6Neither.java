import java.util.ArrayList;
import java.util.List;

public class IpValidateIp4Ip6Neither {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> addr = new ArrayList<>();
		addr.add("172.16.254.1");
		addr.add("2001:0db8:85a3:0:0:8A2E:0370:7334");
		addr.add("101:0db8:defa:0:0:92cF:0370:7334");
		addr.add("256.256.256.256");
		addr.add("0.42.42.42");
		addr.add("254.254.254.254");
		addr.add("192.168.0.0");
		addr.add("10.255.255.255");
		addr.add("0.0.0.0");
		addr.add("0.0.0.01");
		for(String s : validateIP(addr))
			System.out.println(s);

	}

	public static List<String> validateIP(List<String> ip) {
		List<String> result = new ArrayList<>();
		for(String ips : ip) {
			if(isValidIP4(ips))
				result.add("IPV4");
			else if(isValidIP6(ips))
				result.add("IPV6");
			else
				result.add("Neither");
		}
		return result;
	}
	
	private static boolean isValidIP4(String ip) {
		if(ip.length() < 7)
			return false;
		if(ip.charAt(0) == '.')
			return false;
		if(ip.charAt(ip.length()-1) == '.')
			return false;
		String [] tokens = ip.split("\\.");
		if(tokens.length!=4)
			return false;
		for(String token : tokens) {
			if(!isValidIP4Token(token))
				return false;
		}
		return true;
	}
	private static boolean isValidIP4Token(String token) {
		if(token.startsWith("0") && token.length() > 1)
			return false;
		try {
			int parseInt = Integer.parseInt(token);
			if(parseInt < 0 || parseInt > 255)
				return false;
			if(parseInt == 0 && token.charAt(0)!='0')
				return false;
		} catch(NumberFormatException e) {
			return false;
		} catch(Exception e) {
			System.out.println("Invalid parsing");
			return false;
		}
		return true;
	}
	private static boolean isValidIP6(String ip) {
		
		if(ip.length() < 15)
			return false;
		if(ip.charAt(0)==':')
			return false;
		if(ip.charAt(ip.length()-1)==':')
			return false;
		String [] tokens = ip.split(":");
		if(tokens.length != 8)
			return false;
		for(String token : tokens) {
			if(!isValidIP6Token(token))
				return false;
		}
		return true;
	}
	private static boolean isValidIP6Token(String token) {
		if(token.length() > 4 || token.length()==0)
			return false;
		char [] chars = token.toCharArray();
		for(char c: chars) {
			//boolean isUpperCase = c>=65 && c<=70;
			//boolean isLowerCase = c>=97 && c<=102;
			if(!(Character.isDigit(c) || Character.isUpperCase(c) || Character.isLowerCase(c)))
				return false;
		}
		return true;
	}
}
