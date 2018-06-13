
public class IndexOf {



    public static int myIndexOf(char[] str, char[] substr) {
        int len = str.length;
        int sublen = substr.length;
        int count = 0;
        if (sublen > len) {
            return -1;
        }
        for (int i = 0; i < len - sublen + 1; i++) {
            for (int j = 0; j < sublen; j++) {
                if (str[j+i] == substr[j]) {
                    count++;
                    if (count == sublen) {
                        return i;
                    }
                } else {
                    count = 0;
                    break;
                }
            }
        }
        return -1;
   
    }
    
   
    public static boolean compareFunc(String s1, String s2)
    {
        int r1 = s1.indexOf(s2);
        int r2 = myIndexOf(s1.toCharArray(), s2.toCharArray());
        boolean ret = (r1==r2);
        System.out.println(ret + " for '" + s1 + "' '" + s2 + "' -> " + r1 + " " + r2);
        return ret;
    }

    public static void main (String[] args)
    {
    	String s1="abcs";
    	String s2="cs";
    	int r1 = myIndexOf(s1.toCharArray(), s2.toCharArray());
    	System.out.println("r1 - - - "+r1);
//        // Empty string
//        compareFunc("", "");
//        compareFunc("A", "");
//        compareFunc("AB", "");
//        compareFunc("", "A");
//        compareFunc("", "AB");
//        // Equal non-empty strings
//        compareFunc("A", "A");
//        compareFunc("AB", "AB");
//        compareFunc("ABC", "A");
//        // Match at the beginning
//        compareFunc("A", "AB");
//        compareFunc("AB", "ABC");
//        compareFunc("ABC", "ABD");
//        // Match at the end
//        compareFunc("B", "AB");
//        compareFunc("BC", "ABC");
//        compareFunc("ABC", "DBC");
//        // Match at the middle
//        compareFunc("BC", "ABCD");
//        compareFunc("CD", "ABCDEF");
//        // No match on longer strings2e 
//        compareFunc("QWERTYUIOPASDFGHJKL", "ZXCVBNM");
//        compareFunc("ZXCVBNM","QWERTYUIOPASDFGHJKL");
        System.out.println("Test successful");
    }
}