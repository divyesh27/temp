import java.util.*;
/**
 * Basic calculator to calculate addition subtraction with brackets
 * @author divyesh.shah
 */
public class BasicCalculator {

        public int calculate(String s) {
            Stack<Integer> stack = new Stack<>();
            int num = 0;
            int result = 0;
            int sign = 1;

            for (char c : s.toCharArray()) {
                if (Character.isDigit(c)) {
                    num = num * 10 + (c - '0');
                } else if (c == '+') {
                    result += sign * num;
                    num = 0;
                    sign = 1;
                } else if (c == '-') {
                    result += sign * num;
                    num = 0;
                    sign = -1;
                } else if (c == '(') {
                    stack.push(result);
                    stack.push(sign);
                    result = 0;
                    sign = 1;
                } else if (c == ')') {
                    result += sign * num;
                    num = 0;
                    result *= stack.pop(); // sign before the parenthesis
                    result += stack.pop(); // result calculated before the parenthesis
                }
            }

            return result + (sign * num);
        }

        public static void main(String[] args) {
            BasicCalculator calculator = new BasicCalculator();

            String expression1 = "1 + 1";
            System.out.println("Expression: " + expression1);
            System.out.println("Result: " + calculator.calculate(expression1));

            String expression2 = " 2-1 + 2 ";
            System.out.println("Expression: " + expression2);
            System.out.println("Result: " + calculator.calculate(expression2));

            String expression3 = "(1+(4+5+2)-3)+(6+8)";
            System.out.println("Expression: " + expression3);
            System.out.println("Result: " + calculator.calculate(expression3));
        }
}
