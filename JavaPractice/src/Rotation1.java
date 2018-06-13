
public class Rotation1 {

	
	public static void main(String arg[])
	{
		String s1="abcd";
		String s2="cdab";
		//System.out.println("output"+isRotation(s1,s2));
		  String[][] pairs = {{"apple", "pleap"}, {"waterbottle", "erbottlewat"}, {"camera", "macera"}};
	        for (String[] pair : pairs)
	        {
	            String word1 = pair[0];
	            String word2 = pair[1];
	            boolean is_rotation = isRotation(word1, word2);
	            System.out.println(word1 + ", " + word2 + ": " + is_rotation);
	        }
	}

	  public static boolean isSubstring(String big, String small)
	    {
	        if (big.indexOf(small) >= 0)
	        {
	            return true;
	        }//if
	 
	        else
	        {
	            return false;
	        }//else
	    }
	 
	    public static boolean isRotation(String s1, String s2)
	    {
	        int len = s1.length();
	 
	            /* check that s1 and s2 are equal length and not empty */
	        if (len == s2.length() && len > 0)
	        {
	            /* concatenate s1 and s1 within new buffer */
	            String s1s1 = s1 + s1;
	            return isSubstring(s1s1, s2);
	        }//if
	        return false;
	    }//rotation
	 
	   
	}//class
	
	

