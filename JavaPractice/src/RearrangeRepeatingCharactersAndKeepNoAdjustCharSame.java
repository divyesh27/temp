/**
 * @author divyesh.shah
 */

import java.util.*;

/*
n this code, we first count the frequency of each character in the given string and store it in the frequencyMap. Then, we create a max heap (PriorityQueue) of characters based on their frequency.

We iterate over the max heap and append each character to the result string. We also maintain a queue to keep track of the characters that were added to the result string. If the queue size reaches 2, we remove the top character and check if it still has a frequency greater than 0. If it does, we add it back to the max heap.

Finally, we check if the length of the result string is the same as the original string length. If it's different, it means it's not possible to rearrange the string to meet the given condition.

The output for the given sample input "bcaaa" would be "abaca".

We start by defining a class called RearrangeString which contains the rearrangeString method and the main method.

In the rearrangeString method, we take a string str as input and create a Map<Character, Integer> called frequencyMap to store the frequency of each character in the string.

We iterate through each character c in the input string str. For each character, we update its frequency in the frequencyMap by incrementing the count.

Next, we create a PriorityQueue<Character> called maxHeap. The max heap is used to store the characters based on their frequency in descending order.

We add all the keys (characters) from the frequencyMap to the maxHeap. The priority queue automatically orders the characters based on their frequencies, with the character having the highest frequency at the top of the heap.

We create a StringBuilder called result to store the rearranged string.

We also create a Queue<Character> called queue to keep track of the characters that have been added to the result string.

We start a loop that continues until the maxHeap is empty. Inside the loop, we perform the following steps:

a. Remove the character with the highest frequency from the maxHeap using the poll method. We store this character in the current variable.

b. Append the current character to the result string.

c. Decrease the frequency of the current character in the frequencyMap by 1.

d. Add the current character to the queue.

e. If the size of the queue reaches 2, it means we have added two characters to the result string. In this case, we remove the top character from the queue using the poll method and store it in the top variable.

f. Check if the frequency of the top character in the frequencyMap is still greater than 0. If it is, it means there are more occurrences of this character remaining. In that case, we add it back to the maxHeap using the offer method.

After the loop ends, we check if the length of the result string is the same as the length of the input string str. If the lengths are different, it means it's not possible to rearrange the string to satisfy the condition of having no adjacent characters the same.

Finally, we return the rearranged string by converting the result StringBuilder to a string using the toString method.

In the main method, we create a sample input string str with the value "bcaaa".

We call the rearrangeString method with the str as an argument and store the returned rearranged string in the rearrangedStr variable.

We print the rearrangedStr, which will output "abaca" for the given sample input "bcaaa".


* */
public class RearrangeRepeatingCharactersAndKeepNoAdjustCharSame {
    public static String rearrangeString(String str) {
        // Count the frequency of each character

        if(str.length() < 2 || str == null)
            throw new IllegalArgumentException("Pass valid input");

        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : str.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        // Create a max heap based on character frequency
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> frequencyMap.get(b) - frequencyMap.get(a));
        maxHeap.addAll(frequencyMap.keySet());

        StringBuilder result = new StringBuilder();
        Queue<Character> queue = new LinkedList<>();

        while (!maxHeap.isEmpty()) {
            char current = maxHeap.poll();
            result.append(current);
            frequencyMap.put(current, frequencyMap.get(current) - 1);

            queue.offer(current);

            if (queue.size() >= 2) {
                char top = queue.poll();
                if (frequencyMap.get(top) > 0) {
                    maxHeap.offer(top);
                }
            }
        }

        // If the resulting string is different from the original string length, it's not possible
        if (result.length() != str.length()) {
            return "Not possible to rearrange!";
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String str = "bcaaa";
        String str1 = "aabbccdd";
        String rearrangedStr = rearrangeString(str);
        System.out.println(rearrangedStr);
        System.out.println(rearrangeString(str1));
    }
}

