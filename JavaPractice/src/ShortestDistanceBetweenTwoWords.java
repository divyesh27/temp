import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
For example, Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
Given word1 = “coding”, word2 = “practice”, return 3. Given word1 = "makes", word2 = "coding", return 1.
Note: You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.

 * @author divyesh.shah
 *
 */
public class ShortestDistanceBetweenTwoWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<String> input = new ArrayList<>(Arrays.asList("practice", "makes", "perfect", "coding", "makes"));

		System.out.println(findShortestDistance(input,"coding","practice"));
		System.out.println(findShortestDistance(input,"makes","coding"));
	}
	
	static int findShortestDistance(List<String> inputList, String word1, String word2) {

	    if(inputList == null || inputList.size() < 2 || word1 == null || word2 == null)
	      return -1;
	      
	    HashMap<String,Integer> hm = new HashMap<>();
	    int index=0;
	    for(String s : inputList) {
	    
	     // if(!hm.containsKey(s)) {    If we want to not override the index value for duplicate then
	    	                            // we can enable this condition so it will only consider 1st occurred word and not the last occurred word
	        hm.put(s,index);
	      //}
	      index++;
	    }
	  
	    int distance;
	    distance = Math.abs(hm.get(word1) - hm.get(word2));
	    return distance;

	}


}
