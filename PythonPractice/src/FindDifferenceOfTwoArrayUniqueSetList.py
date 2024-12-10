"""
Given two 0-indexed integer arrays nums1 and nums2, return a list answer of size 2 where:

answer[0] is a list of all distinct integers in nums1 which are not present in nums2.
answer[1] is a list of all distinct integers in nums2 which are not present in nums1.
Note that the integers in the lists may be returned in any order.

Explanation
Convert to Sets: Convert both nums1 and nums2 to sets (set1 and set2) to remove any duplicate elements within the arrays and to perform set operations.
Compute Differences:
set1 - set2: Elements in nums1 that are not in nums2.
set2 - set1: Elements in nums2 that are not in nums1.
Return the Results: Convert the resulting sets back to lists as the required output format.
"""

from typing import List
class FindDifferenceOfTwoArrayUniqueSetList:
    def findDifference(nums1: List[int], nums2: List[int]) -> List[List[int]]:
        # Convert lists to sets to remove duplicates and allow for easy difference operations
        set1, set2 = set(nums1), set(nums2)

        # Calculate distinct elements in nums1 not in nums2 and vice versa
        answer = [
            list(set1 - set2),  # Elements in nums1 but not in nums2
            list(set2 - set1)   # Elements in nums2 but not in nums1
        ]

        return answer


if __name__ == "__main__":
    # Test cases
    nums1 = [1, 2, 3]
    nums2 = [2, 4, 6]
    print(FindDifferenceOfTwoArrayUniqueSetList.findDifference(nums1, nums2))  # Output: [[1, 3], [4, 6]]

    nums1 = [1, 2, 3, 3]
    nums2 = [1, 1, 2, 2]
    print(FindDifferenceOfTwoArrayUniqueSetList.findDifference(nums1, nums2))  # Output: [[3], []]