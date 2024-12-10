from typing import List
import heapq
class NumberOfBacklogOrderBuyAndSell:
    def getNumberOfBacklogOrders(self, orders: List[List[int]]) -> int:
        MOD = 10**9 + 7

        # Max-heap for buy orders (use negative prices for max heap)
        buy_heap = []
        # Min-heap for sell orders
        sell_heap = []

        for price, amount, orderType in orders:
            if orderType == 0:  # Buy order
                # Process against the sell heap
                while amount > 0 and sell_heap and sell_heap[0][0] <= price:
                    sell_price, sell_amount = heapq.heappop(sell_heap)
                    if sell_amount > amount:
                        heapq.heappush(sell_heap, (sell_price, sell_amount - amount))
                        amount = 0
                    else:
                        amount -= sell_amount

                if amount > 0:
                    heapq.heappush(buy_heap, (-price, amount))

            else:  # Sell order
                # Process against the buy heap
                while amount > 0 and buy_heap and -buy_heap[0][0] >= price:
                    buy_price, buy_amount = heapq.heappop(buy_heap)
                    if buy_amount > amount:
                        heapq.heappush(buy_heap, (buy_price, buy_amount - amount))
                        amount = 0
                    else:
                        amount -= buy_amount

                if amount > 0:
                    heapq.heappush(sell_heap, (price, amount))

        # Calculate the total number of orders in the backlog
        total_orders = 0
        for _, amount in buy_heap:
            total_orders += amount
        for _, amount in sell_heap:
            total_orders += amount

        return total_orders % MOD


if __name__ == "__main__":
    print (NumberOfBacklogOrderBuyAndSell.getNumberOfBacklogOrders())