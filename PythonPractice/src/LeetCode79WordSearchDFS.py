from typing import List, Optional

def exist(board: Optional[List[List[str]]], word: Optional[str]) -> bool:
    if board is None or len(board) == 0 or len(board[0]) == 0 or word is None or len(word) == 0:
        return False

    def dfs(i: int, j: int, k: int) -> bool:
        if k == len(word):
            return True
        if (i < 0 or i >= len(board) or
                j < 0 or j >= len(board[0]) or
                visited[i][j] or board[i][j] != word[k]):
            return False

        visited[i][j] = True
        res = (dfs(i + 1, j, k + 1) or
               dfs(i - 1, j, k + 1) or
               dfs(i, j + 1, k + 1) or
               dfs(i, j - 1, k + 1))
        visited[i][j] = False
        return res

    m = len(board)
    n = len(board[0])
    visited = [[False] * n for _ in range(m)]

    for i in range(m):
        for j in range(n):
            if dfs(i, j, 0):
                return True

    return False

# Example usage
if __name__ == "__main__":
    board = [['A', 'B', 'C', 'E'],
             ['S', 'F', 'C', 'S'],
             ['A', 'D', 'E', 'E']]

    print(exist(board, "ABCCED"))  # Output: True
    print(exist(board, "SEE"))     # Output: True
    print(exist(board, "ABCB"))    # Output: False
