import java.util.ArrayList;
import java.util.List;
import java.util.*;

/**
 * @author divyesh.shah
 *
 * Given list of integer or int array along with Target sum and the subset size
 * Find all subset values from list of array which totals the target sum or final sum
 * for e.g {1,2,3,4,5}, target sum = 8, subset size = 3, output should be
 * [1, 2, 5], [1, 3, 4], [2, 3, 3]
 *
 * Other inputs duplicates are allowed and can consider more than once for total sum or target sum
 * [1,1,1,1,1] , [5,4,3,2,1] , [5,6,3,5,1]
 */
public class FindTargetSumWithGivenSubsetSizeNoDuplicatesConsider {

    public static void main (String [] args) {
        //int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 3, 3, 7, 2};
        int[] nums = {1, 2, 3, 4, 5};
        //int[] nums = {3,2,2,5,2,9,7};
        int target = 8;
        int subsetSize = 4;
        List<List<Integer>> result = subsetTarget(nums, target, subsetSize);
        for(List<Integer> subset : result)
            System.out.println("First iteration " + subset);
        System.out.println();
        result = findSubsets(nums, target, subsetSize);
        for(List<Integer> subset : result)
            System.out.println("Second iteration " + subset);
        System.out.println();
        result = findSubsetSum(nums, target, subsetSize);
        for(List<Integer> subset : result)
            System.out.println("Third iteration " + subset);
    }

    private static List<List<Integer>> subsetTarget(int[] inputArray, int targetSum, int subSetSize) {
        if (inputArray == null || inputArray.length < 1 || targetSum < 1 || subSetSize < 1
                || inputArray.length < subSetSize)
            throw new IllegalArgumentException("Pass valid value");
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), inputArray, targetSum, subSetSize, 0);
        return result;
    }

    private static void backtrack(List<List<Integer>> result, List<Integer> temp, int[] inputArray, int targetSum, int subSetSize, int start ) {
        if(temp.size() == subSetSize && targetSum == 0)
            result.add(new ArrayList<>(temp));
        else if(temp.size() < subSetSize) {
            for(int i=start; i < inputArray.length; i++){
                temp.add(inputArray[i]);
                backtrack(result, temp, inputArray, targetSum - inputArray[i], subSetSize, i+1);
                temp.remove(temp.size()-1);
            }
        }
    }

    public static List<List<Integer>> findSubsets(int[] nums, int target, int subsetSize) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < subsetSize) {
            return result;
        }
        Arrays.sort(nums);
        findSubsetsHelper(nums, target, subsetSize, 0, new ArrayList<>(), result);
        return result;
    }

    private static void findSubsetsHelper(int[] nums, int target, int subsetSize, int start, List<Integer> subset, List<List<Integer>> result) {
        if (subset.size() == subsetSize) {
            if (target == 0) {
                result.add(new ArrayList<>(subset));
            }
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i-1]) {
                continue;
            }
            subset.add(nums[i]);
            findSubsetsHelper(nums, target - nums[i], subsetSize, i+1, subset, result);
            subset.remove(subset.size() - 1);
        }
    }

    public static List<List<Integer>> findSubsetSum(int[] nums, int target, int subsetSize) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();

        // Initialize the dp array with 0s
        int[][][] dp = new int[n+1][target+1][subsetSize+1];

        // Fill the dp array using dynamic programming
        for (int i = 0; i <= n; i++) {
            dp[i][0][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                for (int k = 1; k <= subsetSize; k++) {
                    if (j >= nums[i-1]) {
                        dp[i][j][k] = dp[i-1][j][k] + dp[i-1][j-nums[i-1]][k-1];
                    } else {
                        dp[i][j][k] = dp[i-1][j][k];
                    }
                }
            }
        }

        // Find all the subsets that add up to the target sum
        if (dp[n][target][subsetSize] > 0) {
            findSubsets(nums, n, target, subsetSize, new ArrayList<>(), res, dp);
        }

        return res;
    }

    private static void findSubsets(int[] nums, int i, int j, int k, List<Integer> curr, List<List<Integer>> res, int[][][] dp) {
        if (j == 0 && k == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }
        if (i <= 0 || j < 0 || k < 0 || dp[i][j][k] == 0) {
            return;
        }
        if (dp[i-1][j][k] > 0) {
            findSubsets(nums, i-1, j, k, curr, res, dp);
        }
        if (j >= nums[i-1] && k >= 1 && dp[i-1][j-nums[i-1]][k-1] > 0) {
            curr.add(nums[i-1]);
            findSubsets(nums, i-1, j-nums[i-1], k-1, curr, res, dp);
            curr.remove(curr.size()-1);
        }
    }
}
