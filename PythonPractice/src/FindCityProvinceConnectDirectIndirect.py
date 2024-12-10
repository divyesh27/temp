"""
There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.

A province is a group of directly or indirectly connected cities and no other cities outside of the group.

You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.

Return the total number of provinces.



Example 1:


Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
Output: 2
Example 2:


Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
Output: 3

"""
from typing import List
class FindCityProvinceConnectDirectIndirect:
    def findCircleNum(isConnected: List[List[int]]) -> int:
        n = len(isConnected)  # Number of cities
        visited = [False] * n  # To keep track of visited cities

        def dfs(city):
            """Perform DFS to mark all cities connected to the current city."""
            for neighbor in range(n):
                if isConnected[city][neighbor] == 1 and not visited[neighbor]:
                    visited[neighbor] = True
                    dfs(neighbor)

        provinces = 0  # To count the number of provinces
        for city in range(n):
            if not visited[city]:
                # Start a DFS from this city
                visited[city] = True
                dfs(city)
                provinces += 1  # Each DFS corresponds to a new province

        return provinces

if __name__ == "__main__":
    print (FindCityProvinceConnectDirectIndirect.findCircleNum([[1,1,0],[1,1,0],[0,0,1]]))
    print (FindCityProvinceConnectDirectIndirect.findCircleNum([[1,0,0],[0,1,0],[0,0,1]]))