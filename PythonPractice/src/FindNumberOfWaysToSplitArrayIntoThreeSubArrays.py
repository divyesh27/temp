"""
# Function to count the number of ways
# to split array into three contiguous
# subarrays of the required type

"""

MOD = 10**9 + 7

def countWays(nums):
    n = len(nums)
    if n < 3:
        return 0

    # Step 1: Compute prefix sum array
    prefix = [0] * (n + 1)
    for i in range(1, n + 1):
        prefix[i] = prefix[i - 1] + nums[i - 1]

    total_ways = 0
    left = 1  # pointer for A1 end
    right = n  # pointer for A3 start

    # Step 2: Iterate over possible midpoints for A2 (from end of A1+1 to A3-1)
    for mid in range(2, n):
        # Adjust left pointer to ensure valid S1 <= S2
        while left < mid and prefix[left] < (prefix[mid] - prefix[left]):
            left += 1

        # Adjust right pointer to ensure valid S2 <= S3
        while right > mid and (prefix[n] - prefix[right]) < (prefix[mid] - prefix[left]):
            right -= 1

        # Count valid splits if pointers are within valid bounds
        if right > mid:
            total_ways += (right - left + 1)
            total_ways %= MOD  # Ensure we are within the modulo

    return total_ways

MOD = 10**9 + 7

def counterWays(nums):
    n = len(nums)
    if n < 3:
        return 0

    # Step 1: Compute prefix sum array
    prefix = [0] * (n + 1)
    for i in range(1, n + 1):
        prefix[i] = prefix[i - 1] + nums[i - 1]

    total_ways = 0
    left = 1  # pointer for A1 end
    right = n  # pointer for A3 start

    # Step 2: Iterate over possible midpoints for A2 (from end of A1+1 to A3-1)
    for mid in range(2, n):
        # Adjust left pointer to ensure valid S1 <= S2
        while left < mid and prefix[left] < (prefix[mid] - prefix[left]):
            left += 1

        # Adjust right pointer to ensure valid S2 <= S3
        while right > mid and (prefix[n] - prefix[right]) < (prefix[mid] - prefix[left]):
            right -= 1

        # Count valid splits if pointers are within valid bounds
        if right > mid:
            total_ways += (right - left + 1)
            total_ways %= MOD  # Ensure we are within the modulo

    return total_ways

# Example Usage
nums = [1, 2, 3, 4]
print(countWays(nums))  # Output: 3

# Example Usage
nums = [1, 2, 3, 4]
print(countWays(nums))  # Output: 3

nums2 = [ 2, 3, 1, 7 ]
print(counterWays(nums2))  # Output: 2


nums3 = [1, 2, 3, 4]
print(counterWays(nums3))  # Output: 2