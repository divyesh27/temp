/*
Welcome to JDoodle!

You can execute code here in 88 languages. Right now you’re in the Java IDE.

  1. Click the orange Execute button ▶ to execute the sample code below and see how it works.

  2. Want help writing or debugging code? Type a query into JDroid on the right hand side ---------------->

  3.Try the menu buttons on the left. Save your file, share code with friends and open saved projects.

Want to change languages? Try the search bar up the top.

def find_substrings(input_string) -> | (char_1, index_1, length_1), (char_n, index_n, length_n)|

INPUT             OUTPUT
"aabcdeee"   ->    |("a", 0, 2), ("e", 5, 3)|
*/
import java.util.List;
import java.util.ArrayList;

/*
* Find string which are repeated characters along with character, index, count
* For e.g input string = "aabcdeee"
* return value as tuple of [('a',0,2), ('e',5,3)]
* */

public class FindSubStringAndReturnCharIndexCountAsTuple {

    public static class Tuple {
        private char character;
        private int index;
        private int count;


        public Tuple(char character, int index, int count) {
            this.character = character;
            this.index = index;
            this.count = count;
        }

        @Override
        public String toString() {
            return String.format("('%c', %d, %d)", character, index, count);
        }
    }
    public static List<Tuple> findSubStringCounter(String inputString) {
        if(inputString == null || inputString.isEmpty())
            throw new IllegalArgumentException("Pass Valid input");

        List<Tuple> result = new ArrayList<>();
        if(inputString.length() < 2)
            return result;

        int size = inputString.length();
        int start = 0;

        while(start < size) {
            char currentCharacter = inputString.charAt(start);
            int end = start;

            while(end < size && inputString.charAt(end) == currentCharacter) {
                end++;
            }

            int count = end - start;
            if(count > 1) {
                result.add(new Tuple(currentCharacter, start, count));
            }

            start = end;
        }
        return result;
    }

    public static void main(String args[]) {

        String inputString = "aabcdeee";

        List <Tuple> subsetString = findSubStringCounter(inputString);
        for(Tuple tuple : subsetString) {
            System.out.println(tuple);
        }
    }

}

