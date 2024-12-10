"""
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

Explanation of the Two-Pointer Approach
The idea is to use two pointers (left and right) that start at the beginning and end of the height array, respectively. We also maintain two variables (left_max and right_max) to keep track of the maximum heights encountered from the left and right sides.

Initialize Pointers and Variables:

left = 0 (points to the beginning)
right = len(height) - 1 (points to the end)
left_max = 0 (maximum height seen from the left)
right_max = 0 (maximum height seen from the right)
water_trapped = 0 (total trapped water)
Move the Pointers Towards Each Other:

While left is less than right:
Compare height[left] with height[right]:
If height[left] is smaller:
If height[left] is greater than or equal to left_max, update left_max.
Otherwise, add the difference (left_max - height[left]) to water_trapped.
Move the left pointer to the right (left += 1).
If height[right] is smaller:
If height[right] is greater than or equal to right_max, update right_max.
Otherwise, add the difference (right_max - height[right]) to water_trapped.
Move the right pointer to the left (right -= 1).
Continue Until the Two Pointers Meet.

Why This Approach Works:
By maintaining left_max and right_max, the algorithm efficiently determines how much water can be trapped above each bar.
The two-pointer technique ensures that the solution runs in linear time (O(n)), which is optimal for this problem
"""

def trap(height):
    if not height:
        return 0

    left, right = 0, len(height) - 1
    left_max, right_max = 0, 0
    water_trapped = 0

    while left < right:
        if height[left] < height[right]:
            if height[left] >= left_max:
                left_max = height[left]
            else:
                water_trapped += left_max - height[left]
            left += 1
        else:
            if height[right] >= right_max:
                right_max = height[right]
            else:
                water_trapped += right_max - height[right]
            right -= 1

    return water_trapped

# Examples
print(trap([0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]))  # Output: 6
print(trap([4, 2, 0, 3, 2, 5]))  # Output: 9
