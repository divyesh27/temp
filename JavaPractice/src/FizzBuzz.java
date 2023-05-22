/**
 * @author divyesh.shah
 */
public class FizzBuzz {
    public static void main(String[] args) {
        int n = 100; // set the range of integers to 1 to 100 (inclusive)

        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("FizzBuzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
    }
}
