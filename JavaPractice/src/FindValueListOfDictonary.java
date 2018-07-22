import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Input Dictonary from the user and check if the dictionary exists in the list of dictionaries
 * @author divyesh.shah
 *
 */

public class FindValueListOfDictonary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<HashMap<String, String>> listOfDict = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> inputDictionary = new HashMap<String, String>();
		
		/*
		 *  This is to generate data for different dictionary with different key/values and add it to the list
		 */
		int count = 1;
		for(int i=1; i<5; i++) {
			HashMap<String, String> hs = new HashMap<String,String>();
			for(int j=1; j<5; j++) {
				hs.put(count+"K", + count+"V");
				count++;
			}
			listOfDict.add(hs);
		}
		
		// This is to consider input value from user.
		inputDictionary.put("16K", "16V");
		inputDictionary.put("13K","13V");
		inputDictionary.put("15K", "15V");
		inputDictionary.put("14K","14V");
		
		System.out.println(findListOfDictEntry(listOfDict,inputDictionary));
		
	}
	/**
	 * This will take input parameter as list of dictionary and dictionary from user input and validates whether
	 * the dictionary exists or not.
	 * @param listDict
	 * @param inputDict
	 * @return
	 */
	public static boolean findListOfDictEntry(List<HashMap<String, String>> listDict, HashMap<String, String> inputDict) {
		
		for(int i=0; i < listDict.size(); i++) {
			HashMap<String, String> dictVal = listDict.get(i);
			if(dictVal.equals(inputDict)) {
				return true;
			}
		}
		return false;
	}
}
