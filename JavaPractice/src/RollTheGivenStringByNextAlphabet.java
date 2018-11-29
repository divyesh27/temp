import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class RollTheGivenStringByNextAlphabet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(shiftAndRollTheString("abc",Arrays.asList(3)));
		System.out.println(shiftAndRollTheString("abz",Arrays.asList(3)));
		System.out.println(shiftAndRollTheString("vwxyz",Arrays.asList(1,2,3,4,5)));
		System.out.println(shiftAndRollTheString("vgxgpuamkx",Arrays.asList(5,5,2,4,7,6,2,2,8,7)));
		System.out.println("*************************************");
		//System.out.println(shiftLetterGivenRollCount("abc",new int [] {3}));
		//System.out.println(shiftLetterGivenRollCount("abz",new int [] {3}));
		//System.out.println(shiftLetterGivenRollCount("vwxyz",new int [] {1,2,3,4,5}));
		//System.out.println(shiftLetterGivenRollCount("vgxgpuamkx",new int [] {5,5,2,4,7,6,2,2,8,7}));
	}

	static String shiftAndRollTheString(String s, List<Integer> roll) {

		int slen = s.length();
		int rolCounts[] = new int[slen];

		roll.stream().forEach(rollCount -> rolCounts[rollCount - 1]++);
		for (int index = slen - 2; index >= 0; index--) {
			rolCounts[index] += rolCounts[index + 1];
		}

		char rolArray[] = s.toCharArray();
		IntStream.range(0, slen).forEach(index -> {
			rolArray[index] = (char) ('a' + (rolCounts[index] % 26 + rolArray[index] - 'a') % 26);
		});
		return String.valueOf(rolArray);
	}
	
	/*
	static String shiftLetterGivenRollCount(String s, int[] shifts) {
		
		if(s == null || s.length() < 2 || shifts == null || shifts.length == 0 || shifts.length > s.length())
			return null;
	
		StringBuilder sb = new StringBuilder();
		int X = 0;
		int i,j;
		i=0;
		int rolcount[] = new int[s.length()];
		for(int shift : shifts) {
			X = (X + shift) % 26;
			rolcount[i++] = shift;
		}
		for(i = 0, j=0; i < s.length() && j < rolcount.length; i++, j++) {
			int index = s.charAt(i) - 'a';
			sb.append((char) ((index + rolcount[j]) % 26 + 97));
			if(i < shifts.length)
				X = Math.floorMod(X - rolcount[i], 26);
		}
		
		return sb.toString();
	}
	*/

}
