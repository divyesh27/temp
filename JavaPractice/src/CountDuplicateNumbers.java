import java.util.*;
import java.util.HashMap;
/**
 * Implement java code for below questions -> Count Duplicate ElementsGiven
 * an integer array, numbers, count the number of elements that occur more than once.
 * Examplenumbers = [1, 3, 3, 4, 4, 4] There are two non-unique elements: 3 and 4.
 * Function DescriptionComplete the function countDuplicate in the editor below.
 * countDuplicate has the following parameter(s): int numbers[n]: an array of integers Returns: int: an
 * integer that denotes the number of non-unique values in the numbers array Constraints3 ≤ n ≤ 10001 ≤ numbers[i] ≤ 1000, 0 ≤ i < n
 * Input Format Format for Custom TestingSample Case 0Sample InputSTDIN Function----- -----8 → numbers[] size n = 8 1 → numbers = [1, 3, 1, 4, 5, 6, 3, 2]3145632
 * Sample Output2
 * @author divyesh.shah
 */
public class CountDuplicateNumbers {
    public static int countDuplicate(int[] numbers) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();

        // Count the frequency of each element in the array
        for (int i = 0; i < numbers.length; i++) {
            int frequency = map.getOrDefault(numbers[i], 0);
            map.put(numbers[i], frequency + 1);
        }

        // Count the number of elements that occur more than once
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(countDuplicate(new int[]{1, 2, 3, 4, 5, 2, 3, 5}));
    }
}
