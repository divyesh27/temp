"""
You are given an m x n matrix maze (0-indexed) with empty cells (represented as '.') and walls (represented as '+'). You are also given the entrance of the maze, where entrance = [entrancerow, entrancecol] denotes the row and column of the cell you are initially standing at.

In one step, you can move one cell up, down, left, or right. You cannot step into a cell with a wall, and you cannot step outside the maze. Your goal is to find the nearest exit from the entrance. An exit is defined as an empty cell that is at the border of the maze. The entrance does not count as an exit.

Return the number of steps in the shortest path from the entrance to the nearest exit, or -1 if no such path exists.



Example 1:


Input: maze = [["+","+",".","+"],[".",".",".","+"],["+","+","+","."]], entrance = [1,2]
Output: 1
Explanation: There are 3 exits in this maze at [1,0], [0,2], and [2,3].
Initially, you are at the entrance cell [1,2].
- You can reach [1,0] by moving 2 steps left.
- You can reach [0,2] by moving 1 step up.
It is impossible to reach [2,3] from the entrance.
Thus, the nearest exit is [0,2], which is 1 step away.
Example 2:


Input: maze = [["+","+","+"],[".",".","."],["+","+","+"]], entrance = [1,0]
Output: 2
Explanation: There is 1 exit in this maze at [1,2].
[1,0] does not count as an exit since it is the entrance cell.
Initially, you are at the entrance cell [1,0].
- You can reach [1,2] by moving 2 steps right.
Thus, the nearest exit is [1,2], which is 2 steps away.
Example 3:


Input: maze = [[".","+"]], entrance = [0,0]
Output: -1
Explanation: There are no exits in this maze.
"""
from typing import List
from collections import deque

def nearest_exit(maze: List[List[str]], entrance: List[int]) -> int:
    rows, cols  = len(maze), len(maze[0])
    queue = deque([(entrance[0], entrance[1],0)])
    visited = set ()
    visited.add((entrance[0], entrance[1]))

    directions = [(-1,0),(1,0),(0,-1),(0,1)]

    while queue:
        x, y, steps = queue.popleft()

        if(x != entrance[0] or y != entrance[1]) and (x ==0 or x == rows -1 or y == 0 or y == cols-1):
            return steps

        for dx, dy in directions:
            new_x , new_y = x + dx, y + dy

            if 0 <= new_x < rows and 0 <= new_y < cols and maze[new_x][new_y] == '.' and (new_x, new_y) not in visited:
                visited.add((new_x, new_y))
                queue.append((new_x, new_y, steps + 1))

    return -1

if __name__ == "__main__":
    # Example 1
    maze1 = [["+", "+", ".", "+"], [".", ".", ".", "+"], ["+", "+", "+", "."]]
    entrance1 = [1, 2]
    print(nearest_exit(maze1, entrance1))  # Output: 1

    # Example 2
    maze2 = [["+", "+", "+"], [".", ".", "."], ["+", "+", "+"]]
    entrance2 = [1, 0]
    print(nearest_exit(maze2, entrance2))  # Output: 2

    # Example 3
    maze3 = [[".", "+"]]
    entrance3 = [0, 0]
    print(nearest_exit(maze3, entrance3))  # Output: -1