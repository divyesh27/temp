import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IsomorphicString {

	static int size = 256; 
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(findMatchString("batat","catat"));
		System.out.println(findMatchString("aab","xyz"));
		System.out.println(findMatchString("egg","add"));
		System.out.println(findMatchString("foo","bar"));
		System.out.println(findMatchString("paper","title"));
		System.out.println(findMatchString("bar","foo"));
		
		System.out.println("******************************");
		System.out.println(findMatchString1("batat","catat"));
		System.out.println(findMatchString1("aab","xyz"));
		System.out.println(findMatchString1("egg","add"));
		System.out.println(findMatchString1("foo","bar"));
		System.out.println(findMatchString1("paper","title"));
		System.out.println(findMatchString1("bar","foo"));
	}
	
	static boolean findMatchString(String s1, String s2) {
		if(s1 == null || s2 == null)
			throw new IllegalArgumentException("Pass valid input");
		
		if(s1.length() != s2.length())
			return false;
		
		Map<Character, Integer> s1hm = new HashMap<>();
		List<Integer> ls1 = new ArrayList<>();
		Map<Character,Integer> s2hm = new HashMap<>();
		List<Integer> ls2 = new ArrayList<>();
		for(char c : s1.toCharArray()) {
			s1hm.put(c, s1hm.getOrDefault(c, 0) + 1);
		}
		for(int i : s1hm.values()) {
			ls1.add(i);
		}
		for(char c : s2.toCharArray()) {
			s2hm.put(c, s2hm.getOrDefault(c, 0) + 1);
		}
		for(int i : s2hm.values()) {
			ls2.add(i);
		}
		for(int i : s1hm.values()) {
			if(!ls2.contains(i))
				return false;
		}
		for(int i : s2hm.values()) {
			if(!ls1.contains(i))
				return false;
		}
		return true;
	}
	
	static boolean findMatchString1(String str1, String str2) 
    { 
        int m = str1.length(); 
        int n = str2.length(); 
          
        
        // Length of both strings must be same for one to one 
        // corresponance 
        if(m != n) 
            return false; 
              
        // To mark visited characters in str2 
        Boolean[] marked = new Boolean[size]; 
        Arrays.fill(marked, Boolean.FALSE); 
          
        // To store mapping of every character from str1 to 
        // that of str2. Initialize all entries of map as -1. 
        int[] map = new int[size]; 
        Arrays.fill(map, -1); 
          
        // Process all characters one by on 
        for (int i = 0; i < n; i++) 
        { 
            // If current character of str1 is seen first 
            // time in it. 
            if (map[str1.charAt(i)] == -1) 
            { 
                // If current character of str2 is already 
                // seen, one to one mapping not possible 
                if (marked[str2.charAt(i)] == true) 
                    return false; 
  
                // Mark current character of str2 as visited 
                marked[str2.charAt(i)] = true; 
  
                // Store mapping of current characters 
                map[str1.charAt(i)] = str2.charAt(i); 
            } 
  
            // If this is not first appearance of current 
            // character in str1, then check if previous 
            // appearance mapped to same character of str2 
            else if (map[str1.charAt(i)] != str2.charAt(i)) 
            return false; 
        } 
  
        return true; 
    } 

}
