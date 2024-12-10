"""
Given an m x n integer matrix heightMap representing the height of each unit cell in a 2D elevation map, return the volume of water it can trap after raining.

To solve the problem of calculating the volume of water trapped in a 2D elevation map (represented as an m x n matrix), we can use a priority queue (min-heap) along with a Breadth-First Search (BFS) approach. This approach efficiently computes the trapped water volume by traversing the matrix from the outer boundary towards the inner cells.

Explanation of the Approach
Use a Priority Queue (Min-Heap):

Initialize a priority queue to keep track of the cells on the boundary.
Start by adding all the cells on the boundary (i.e., the outermost rows and columns) to the priority queue. The cells are added with their height as the priority.
Track Visited Cells:

Use a 2D list or set to keep track of visited cells to prevent reprocessing the same cell multiple times.
Process Cells Using BFS:

While the priority queue is not empty:
Pop the cell with the smallest height from the queue.
For each of its four neighboring cells (up, down, left, right), compute the trapped water if the neighboring cell is lower in height than the current cell.
Add the water trapped at this cell to the total volume.
Update the height of the neighboring cell to be the maximum of its current height or the height of the cell just processed.
Push the updated neighboring cell back into the priority queue.
Repeat Until All Cells Are Processed:

Continue this process until all the cells have been processed.

Why This Approach Works:
The use of a priority queue (min-heap) ensures that we always process the smallest boundary height first, which helps to accurately calculate how much water can be trapped as we expand inward.
The BFS approach guarantees that all cells are processed in the correct order, ensuring the accurate calculation of trapped water in O(m * n * log(m * n)) time complexity, which is efficient for this problem size.


"""


from typing import List
import heapq
def trapRainWater(heightMap: List[List[int]]) -> int:
    if not heightMap or not heightMap[0]:
        return 0

    row_size, col_size = len(heightMap), len(heightMap[0])
    visited = [[False] * col_size for _ in range(row_size)]
    heap_queue = []
    water_trapped = 0

    # Add all boundary cells to the priority queue
    for r in range(row_size):
        for c in range(col_size):
            if r == 0 or r == row_size - 1 or c == 0 or c == col_size - 1:
                heapq.heappush(heap_queue, (heightMap[r][c], r, c))
                visited[r][c] = True

    # Directions for neighbors (up, down, left, right)
    directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]

    while heap_queue:
        height, x_axis, y_axis = heapq.heappop(heap_queue)

        for dx_axis, dy_axis in directions:
            nx_axis, ny_axis = x_axis + dx_axis, y_axis + dy_axis

            if 0 <= nx_axis < row_size and 0 <= ny_axis < col_size and not visited[nx_axis][ny_axis]:
                # Calculate trapped water
                water_trapped += max(0, height - heightMap[nx_axis][ny_axis])
                # Update the neighbor's height to the max boundary height
                heapq.heappush(heap_queue, (max(height, heightMap[nx_axis][ny_axis]), nx_axis, ny_axis))
                visited[nx_axis][ny_axis] = True

    return water_trapped

# Examples
print(trapRainWater([[1,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]]))  # Output: 4
print(trapRainWater([[3,3,3,3,3],[3,2,2,2,3],[3,2,1,2,3],[3,2,2,2,3],[3,3,3,3,3]]))  # Output: 10
