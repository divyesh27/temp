"""
There are n cities numbered from 0 to n - 1 and n - 1 roads such that there is only one way to travel between two different cities (this network form a tree). Last year, The ministry of transport decided to orient the roads in one direction because they are too narrow.

Roads are represented by connections where connections[i] = [ai, bi] represents a road from city ai to city bi.

This year, there will be a big event in the capital (city 0), and many people want to travel to this city.

Your task consists of reorienting some roads such that each city can visit the city 0. Return the minimum number of edges changed.

It's guaranteed that each city can reach city 0 after reorder.



Example 1:


Input: n = 6, connections = [[0,1],[1,3],[2,3],[4,0],[4,5]]
Output: 3
Explanation: Change the direction of edges show in red such that each node can reach the node 0 (capital).
Example 2:


Input: n = 5, connections = [[1,0],[1,2],[3,2],[3,4]]
Output: 2
Explanation: Change the direction of edges show in red such that each node can reach the node 0 (capital).
Example 3:

Input: n = 3, connections = [[1,0],[2,0]]
Output: 0


"""
from collections import defaultdict

class CityNetworkFindMapDirectionGraph:
    def __init__(self, n, connections):
        self.n = n  # Number of cities
        self.connections = connections  # List of roads (connections)
        self.graph = defaultdict(list)  # Graph to hold roads with directions
        self._build_graph()

    def _build_graph(self):
        """
        Build a bidirectional graph from the connections, marking the direction of the roads.
        A tuple (neighbor, direction) is used to represent the direction:
            - direction = 1: road is directed from current city to neighbor.
            - direction = 0: road is directed from neighbor to current city.
        """
        for a, b in self.connections:
            self.graph[a].append((b, 1))  # Road from 'a' to 'b' (forward)
            self.graph[b].append((a, 0))  # Road from 'b' to 'a' (reverse)

    def _dfs(self, city, parent):
        """
        Depth-First Search (DFS) to count the number of roads that need to be reoriented.
        """
        reorientations = 0
        for neighbor, direction in self.graph[city]:
            if neighbor == parent:  # Avoid going back to the parent node
                continue
            # Add to reorientations if the road points away from city 0
            reorientations += direction
            # Recursively visit neighboring cities
            reorientations += self._dfs(neighbor, city)
        return reorientations

    def minimum_reorders(self):
        """
        Returns the minimum number of roads to reorient so that all cities can reach city 0.
        """
        return self._dfs(0, -1)  # Start DFS from city 0, with no parent (-1)


# Example usage:
if __name__ == "__main__":
    # Example 1
    n = 6
    connections = [[0, 1], [1, 3], [2, 3], [4, 0], [4, 5]]
    network = CityNetworkFindMapDirectionGraph(n, connections)
    print(network.minimum_reorders())  # Output: 3

    # Example 2
    n = 5
    connections = [[1, 0], [1, 2], [3, 2], [3, 4]]
    network = CityNetworkFindMapDirectionGraph(n, connections)
    print(network.minimum_reorders())  # Output: 2

    # Example 3
    n = 3
    connections = [[1, 0], [2, 0]]
    network = CityNetworkFindMapDirectionGraph(n, connections)
    print(network.minimum_reorders())  # Output: 0
