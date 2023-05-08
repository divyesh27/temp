/**
 * @author divyesh.shah
 *
 * Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:
 *
 * '.' Matches any single character.​​​​
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 *
 *
 *
 * Example 1:
 *
 * Input: s = "aa", p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 * Example 2:
 *
 * Input: s = "aa", p = "a*"
 * Output: true
 * Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
 * Example 3:
 *
 * Input: s = "ab", p = ".*"
 * Output: true
 * Explanation: ".*" means "zero or more (*) of any character (.)".
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 20
 * 1 <= p.length <= 20
 * s contains only lowercase English letters.
 * p contains only lowercase English letters, '.', and '*'.
 * It is guaranteed for each appearance of the character '*', there will be a previous valid character to match.
 *
 * ANSWER
 *
 * The idea behind the dynamic programming solution is to create a 2D boolean array dp where dp[i][j]
 * represents whether the substring of s up to index i matches the substring of p up to index j.
 * We initialize dp[0][0] to true since an empty string matches an empty pattern.
 * Then, we handle the cases where the pattern starts with * by setting dp[0][i] to true
 * if the pattern up to index i-2 matches an empty string.
 *
 * Next, we loop through the substrings of s and p and fill out the dp array using the following rules:
 *
 * If the current characters of s and p match, then the current substring matches if and only if the previous substrings match.
 * This is represented by dp[i][j] = dp[i - 1][j - 1].
 * If the current character of p is . (matches any character), then the current substring matches if and only if the previous substrings match.
 * This is also represented by dp[i][j] = dp[i - 1][j - 1].
 * If the current character of p is * (matches zero or more of the preceding element), then we have two cases:
 * If the preceding character of p matches the current character of s,
 * then the current substring matches if and only if either the preceding substring of p matches the
 * current substring of s without the * character (represented by dp[i][j - 2]) or the current
 * character of s matches the previous character of p and the current substring of s matches the current
 * substring of p without the last two characters (represented by dp[i - 1][j]).
 * Otherwise, the current substring matches if and only if the preceding substring of p
 * matches the current substring of s without the last two characters.
 * This is represented by dp[i][j] = dp[i][j - 2].
 * Finally, we return the value of dp[m][n] since we want to check whether the entire string s matches the entire pattern p.
 *
 * Here are some explanations of the variables used in the code:
 *
 * s: the input string.
 * p: the input pattern.
 * m: the length of s.
 * n: the length of p.
 * dp: the 2D boolean array used for dynamic programming.
 * Overall, the time complexity of this implementation is O(mn) and the space complexity is O(mn) as well,
 * where m and n are the lengths of the input strings.
 */
public class LeetCode10RegularExpressionMatchingDynamicProgramming {
    public static boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = dp[0][i - 2];
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char sc = s.charAt(i - 1);
                char pc = p.charAt(j - 1);
                if (pc == '.' || pc == sc) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pc == '*') {
                    char ppc = p.charAt(j - 2);
                    if (ppc == '.' || ppc == sc) {
                        dp[i][j] = dp[i][j - 2] || dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i][j - 2];
                    }
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println(isMatch("aa","a"));
        System.out.println(isMatch("aa","a*"));
        System.out.println(isMatch("aa",".*"));
    }
}
