import java.io.*;
import java.util.*;
import java.util.HashSet;
/*
Part 1:

A car is broadcasting its position in x and y coordinates to our servers. Sadly, our servers are on fire, and the position messages have been corrupted. All formatting other than the digits has disappeared. For example, a position message: 'x: 1.2, y: 3' gets corrupted to: '123'.

Given a string of only digits, return all possible x and y coordinates the string can represent.

Restraints:
x and y are positive. 
Digits are from 1-9
x comes before y in the message string.

Example:
"123" would return:
[ { x: "1", y: "23" }, { x: "1", y: "2.3" }, { x: "12", y: "3" }, { x: "1.2", y: "3" } ]
Alternate format:
[ ["1", "23"], ["1", "2.3"], ["12", "3"], ["1.2", "3"] ]
 

class Solution {
  public static void main(String[] args) {
    coordinates("123");
    coordinates("123456");
  
  }
  
  public static void coordinates(String input) {
    System.out.println("Generating possibilities for: " + input);
    
    if(input == null || input.length() < 2) {
      throw new IllegalArgumentException("Invalid input");
    }
    
    int size = input.length();
    HashSet<String> hs = new HashSet<>();
    String temp="";
    String vartemp = "";
    for(int i = 0; i<size; i++) {
      for(int j=1; j<size; j++) {
        vartemp = input.substring(i,i);
        temp = input.substring(j,size-1);
        if(!hs.contains(vartemp)){
           hs.add(vartemp);
        }
        if(!hs.contains(temp)) {
          hs.add(temp);
        }
        
      }
    }
    for(String s : hs) {
      System.out.println(s);
                         
    }
           
  }
}
*/

public class FindDistinctCoordinatesFromStringAndSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		coordinates("12345");
	}
	
	
	public static void coordinates(String input) {
		System.out.println("Generating possibilities for: " + input);

		if (input == null || input.length() < 2) {
			throw new IllegalArgumentException("Invalid input");
		}

		int size = input.length();
		HashSet<String> hs = new HashSet<>();
		String [] singlestring = input.split("");

		for (int i = 0; i < size; i++) {
			for (int j = i + 1; j <= size; j++) {
				if (!hs.contains(input.substring(i, j)) && input.substring(i, j).length() != size) {
					hs.add(input.substring(i, j));
				}
			}
		}
		//
		for(Iterator<String> it = hs.iterator(); it.hasNext();) {
			String s = it.next();
			if(!(s.equals(singlestring[0]) || s.equals(singlestring[singlestring.length-1])) && s.length() == 1) {
				it.remove();
			}
		}
		
		for(String s : hs)
			System.out.println(s);
			
	} 
	
	

}
