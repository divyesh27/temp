'''
find closest temperature to zero. If there is negative and positive both then return positive.
There will be given array of temperature. If array is empty then return 0. Implement in python
'''
def closest_to_zero(temperatures):
    if not temperatures or len(temperatures) < 1:  # Check if the array is empty
        return 0

    # Find the closest temperature to zero
    return min(temperatures, key=lambda x: (abs(x), -x))

# Example usage:
temperatures = [-5, -1, 2, -2, 3]
print(closest_to_zero(temperatures))  # Output: 2
