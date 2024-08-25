from typing import List

def subset_target(input_array: List[int], target_sum: int, subset_size: int) -> List[List[int]]:
    if not input_array or target_sum < 1 or subset_size < 1 or len(input_array) < subset_size:
        raise ValueError("Pass valid value")
    result = []
    backtrack(result, [], input_array, target_sum, subset_size, 0)
    return result

def backtrack(result: List[List[int]], temp: List[int], input_array: List[int], target_sum: int, subset_size: int, start: int):
    if len(temp) == subset_size and target_sum == 0:
        result.append(temp[:])
    elif len(temp) < subset_size:
        for i in range(start, len(input_array)):
            temp.append(input_array[i])
            backtrack(result, temp, input_array, target_sum - input_array[i], subset_size, i + 1)
            temp.pop()

def find_subsets(nums: List[int], target: int, subset_size: int) -> List[List[int]]:
    result = []
    if not nums or len(nums) < subset_size:
        return result
    nums.sort()
    find_subsets_helper(nums, target, subset_size, 0, [], result)
    return result

def find_subsets_helper(nums: List[int], target: int, subset_size: int, start: int, subset: List[int], result: List[List[int]]):
    if len(subset) == subset_size:
        if target == 0:
            result.append(subset[:])
        return
    for i in range(start, len(nums)):
        if i > start and nums[i] == nums[i - 1]:
            continue
        subset.append(nums[i])
        find_subsets_helper(nums, target - nums[i], subset_size, i + 1, subset, result)
        subset.pop()

def find_subset_sum(nums: List[int], target: int, subset_size: int) -> List[List[int]]:
    n = len(nums)
    res = []
    dp = [[[0 for _ in range(subset_size + 1)] for _ in range(target + 1)] for _ in range(n + 1)]

    for i in range(n + 1):
        dp[i][0][0] = 1

    for i in range(1, n + 1):
        for j in range(1, target + 1):
            for k in range(1, subset_size + 1):
                dp[i][j][k] = dp[i - 1][j][k]
                if j >= nums[i - 1]:
                    dp[i][j][k] += dp[i - 1][j - nums[i - 1]][k - 1]

    if dp[n][target][subset_size] > 0:
        find_subsets_with_dp(nums, n, target, subset_size, [], res, dp)

    return res

def find_subsets_with_dp(nums: List[int], i: int, j: int, k: int, curr: List[int], res: List[List[int]], dp: List[List[List[int]]]):
    if j == 0 and k == 0:
        res.append(curr[:])
        return
    if i <= 0 or j < 0 or k < 0 or dp[i][j][k] == 0:
        return
    if dp[i - 1][j][k] > 0:
        find_subsets_with_dp(nums, i - 1, j, k, curr, res, dp)
    if j >= nums[i - 1] and k >= 1 and dp[i - 1][j - nums[i - 1]][k - 1] > 0:
        curr.append(nums[i - 1])
        find_subsets_with_dp(nums, i - 1, j - nums[i - 1], k - 1, curr, res, dp)
        curr.pop()

if __name__ == "__main__":
    nums = [1, 2, 3, 4, 5]
    target = 8
    subset_size = 4

    result = subset_target(nums, target, subset_size)
    for subset in result:
        print("First iteration", subset)

    print()

    result = find_subsets(nums, target, subset_size)
    for subset in result:
        print("Second iteration", subset)

    print()

    result = find_subset_sum(nums, target, subset_size)
    for subset in result:
        print("Third iteration", subset)
