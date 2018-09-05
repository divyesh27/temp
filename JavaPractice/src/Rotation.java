
public class Rotation {
	public static void main(String[] args) {

		String str1 = "abcd";
		String str2 = "cdab";
		System.out.println(isRotate(str1, str2));
		System.out.println(areRotations(str1, str2));
	}

	public static boolean isRotate(String str1, String str2) {
		if (str1.length() != str2.length()) {
			return false;
		}
		int length = str1.length() / 2;
		for (int i = 0; i < length; i++) {
			int j = 0;
			while (str1.charAt(i) != str2.charAt(j)) {
				j++;
			}

		}
		return true;
	}

	static boolean areRotations(String str1, String str2) {
		// There lengths must be same and str2 must be
		// a substring of str1 concatenated with str1.
		return (str1.length() == str2.length()) && ((str1 + str1).indexOf(str2) != -1);
	}
}
