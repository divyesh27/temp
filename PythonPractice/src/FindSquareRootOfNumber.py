import math
from typing import Optional

def my_sqrt(x: int) -> int:
    if x == 0:
        return 0
    left, right = 1, x
    while True:
        mid = left + (right - left) // 2
        if mid > x // mid:
            right = mid - 1
        elif mid + 1 > x // (mid + 1):
            return mid
        else:
            left = mid + 1

def find_sqrt(input_number: int) -> int:
    if input_number == 0 or input_number == 1:
        return input_number

    i, result = 1, 1
    while result <= input_number:
        i += 1
        result = i * i
    return i - 1

def floor_sqrt(x: int) -> int:
    if x == 0 or x == 1:
        return x

    start, end = 1, x
    ans = 0
    while start <= end:
        mid = (start + end) // 2
        if mid * mid == x:
            return mid
        if mid * mid < x:
            start = mid + 1
            ans = mid
        else:
            end = mid - 1
    return ans

def find_root(num: float) -> float:
    if num < 0:
        raise ValueError("Cannot find the square root of a negative number")

    start, end = 0.0, num
    while abs(start - end) > 0.01:
        print(f"Math Abs start-end: {abs(start - end)}")
        print(f"End value: {end}")
        print(f"Start value: {start}")
        end = (start + end) / 2
        start = num / end

    return end

if __name__ == "__main__":
    print(my_sqrt(4))
    print(find_sqrt(4))
    print(floor_sqrt(16))
    print(find_root(15))
