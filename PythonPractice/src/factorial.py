from typing import Union
from math import factorial as math_factorial
from functools import lru_cache
from decimal import Decimal, getcontext

# Set precision for Decimal operations
getcontext().prec = 1000

def compute_factorial(n: int) -> int:
    if not isinstance(n, int):
        raise TypeError("Input must be an integer")
    if n < 0:
        raise ValueError("Input must be a non-negative integer")

    if n == 0:
        return 1
    return n * compute_factorial(n - 1)

def big_fact_compute(n: int) -> Decimal:
    if not isinstance(n, int):
        raise TypeError("Input must be an integer")
    if n < 0:
        raise ValueError("Input must be a non-negative integer")

    result = Decimal(1)
    for i in range(2, n + 1):
        result *= Decimal(i)
    return result

def factorial(n: int) -> int:
    if not isinstance(n, int):
        raise TypeError("Input must be an integer")
    if n < 0:
        raise ValueError("Input must be a non-negative integer")

    result = 1
    for i in range(2, n + 1):
        result *= i
    return result

def factorial_from_math(n: int) -> int:
    if not isinstance(n, int):
        raise TypeError("Input must be an integer")
    if n < 0:
        raise ValueError("Input must be a non-negative integer")

    return math_factorial(n)

# Example usage
try:
    n = 4
    print("compute_factorial:", compute_factorial(n))
    print("big_fact_compute:", big_fact_compute(5))
    print("factorial:", factorial(8))
    print("factorial_from_math:", factorial_from_math(8))
except Exception as e:
    print(f"An error occurred: {e}")
