'''
Given the two dimensional char matrix find longest word that. satisfies the following constraint:
- The char in the word are in strictly decreasing order.
- Words can go in any cardinal direction, bend, but can't self-intersect

char_matrix = [['A','B','C','D'], ['A','B','D','D'], ['A','B','K','X'], ['A','B','C','D'], ]
# This is a valid Descending-Char-Word : "KDBA"
#This is an invalid Descending-Char-Word : "AB"

'''

def find_longest_desc_word(matrix):
    # Directions for all 8 possible movements: N, NE, E, SE, S, SW, W, NW
    directions = [(-1, 0), (-1, 1), (0, 1), (1, 1), (1, 0), (1, -1), (0, -1), (-1, -1)]
    # Directions for all 4 possible movements: N, E, S, W
    four_directions = [(-1, 0), (0, 1), (1, 0), (0, -1)]

    def dfs(x, y, word, visited):
        nonlocal longest_word
        # Update longest word if the current word is longer
        if len(word) > len(longest_word):
            longest_word = word

        # Explore all 8 possible directions
        for dx, dy in directions: #four_directions
            nx, ny = x + dx, y + dy
            # Check boundaries and visited cells
            if 0 <= nx < len(matrix) and 0 <= ny < len(matrix[0]) and (nx, ny) not in visited:
                # Check strictly decreasing order
                if matrix[nx][ny] > matrix[x][y]:
                    visited.add((nx, ny))
                    dfs(nx, ny, word + matrix[nx][ny], visited)
                    visited.remove((nx, ny))

    longest_word = ""

    # Start DFS from each cell
    for i in range(len(matrix)):
        for j in range(len(matrix[0])):
            dfs(i, j, matrix[i][j], {(i, j)})

    return longest_word

# Given matrix
char_matrix = [['A', 'B', 'C', 'D'],
               ['A', 'B', 'D', 'D'],
               ['A', 'B', 'K', 'X'],
               ['A', 'B', 'C', 'D']]

result = find_longest_desc_word(char_matrix)
print("Longest Ascending-Char-Word:", result)
