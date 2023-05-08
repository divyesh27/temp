import java.util.ArrayList;
import java.util.List;

/*** Find all permutations and combinations using backtracking or backtrack with no duplicate subsets
 * 78. Subsets
Medium
216154FavoriteShare
Given a set of distinct integers, nums, return all possible subsets (the power set).
Note: The solution set must not contain duplicate subsets.
Example:
Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]

 * @author divyesh.shah
 *
 */
public class FindDistinctPairFromGivenIntegerArrayWithAllPermutations {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(subsets(new int[]{3,5,7,9}));
	}
	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		backtrack(nums, 0, new ArrayList<Integer>(), result);
		return result;
	}

	private static void backtrack(int[] nums, int start, List<Integer> curr, List<List<Integer>> result) {
		result.add(new ArrayList<>(curr)); // add current subset to the result

		for (int i = start; i < nums.length; i++) {
			// skip duplicates
			if (i > start && nums[i] == nums[i-1]) {
				continue;
			}
			curr.add(nums[i]);
			backtrack(nums, i+1, curr, result); // explore further
			curr.remove(curr.size()-1); // backtrack
		}
	}
}

