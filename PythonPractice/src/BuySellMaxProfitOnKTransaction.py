from collections import deque
from typing import List

def max_profit(prices: List[int], k: int) -> int:
    if not isinstance(prices, list) or not all(isinstance(price, int) for price in prices):
        raise ValueError("prices must be a list of integers")

    if not isinstance(k, int) or k < 0:
        raise ValueError("k must be a non-negative integer")

    if k == 0 or len(prices) == 0:
        return 0

    n = len(prices)
    Tran = [[0] * n for _ in range(k+1)]

    for i in range(1, k+1):
        max_diff = -prices[0]
        for j in range(1, n):
            Tran[i][j] = max(Tran[i][j-1], prices[j] + max_diff)
            max_diff = max(max_diff, Tran[i-1][j] - prices[j])

    # This will print out Max profit
    print(f"Max profit after {k} transactions: {Tran[k][n-1]}")
    print_solution(Tran, prices)

    return Tran[k][n-1]

def print_solution(T: List[List[int]], prices: List[int]) -> None:
    i = len(T) - 1
    j = len(T[0]) - 1

    stack = deque()

    while True:
        if i == 0 or j == 0:
            break

        if T[i][j] == T[i][j-1]:
            j -= 1
        else:
            stack.append(j)
            max_diff = T[i][j] - prices[j]

            for k in range(j-1, -1, -1):
                if T[i-1][k] - prices[k] == max_diff:
                    i -= 1
                    j = k
                    stack.append(j)
                    break

    while stack:
        sell_index = stack.pop()
        buy_index = stack.pop() if stack else 0
        print(f"Buy at price {prices[buy_index]} and sell at price {prices[sell_index]}")

def max_profit_single_transaction(prices: List[int]) -> int:
    if not isinstance(prices, list) or not all(isinstance(price, int) for price in prices):
        raise ValueError("prices must be a list of integers")

    profit = 0
    min_element = float('inf')

    for price in prices:
        min_element = min(min_element, price)
        profit = max(profit, price - min_element)

    print(f"Minimum element: {min_element}")
    return profit

if __name__ == "__main__":
    prices = [3, 5, 7, 3, 5, 7, 90, 6, 3, 32, 4, 54, 54, 2, 5, 79]

    # For single transaction
    print(f"Max profit for a single transaction: {max_profit_single_transaction(prices)}")

    # For k transactions
    k = 3
    max_profit(prices, k)
