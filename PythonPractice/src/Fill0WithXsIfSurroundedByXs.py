def fill_color_around(matrix, x, y, prev_val, new_val):
    if x < 0 or y < 0 or x >= len(matrix) or y >= len(matrix[0]):
        return
    if matrix[x][y] != prev_val:
        return

    matrix[x][y] = new_val

    fill_color_around(matrix, x + 1, y, prev_val, new_val)
    fill_color_around(matrix, x - 1, y, prev_val, new_val)
    fill_color_around(matrix, x, y + 1, prev_val, new_val)
    fill_color_around(matrix, x, y - 1, prev_val, new_val)

def replace_val(matrix):
    row = len(matrix)
    col = len(matrix[0])

    for i in range(row):
        for j in range(col):
            if matrix[i][j] == 'O':
                matrix[i][j] = '+'

    print_matrix(matrix)

    for i in range(row):
        if matrix[i][0] == '+':
            fill_color_around(matrix, i, 0, '+', 'O')
    for i in range(row):
        if matrix[i][col - 1] == '+':
            fill_color_around(matrix, i, col - 1, '+', 'O')
    for i in range(col):
        if matrix[0][i] == '+':
            fill_color_around(matrix, 0, i, '+', 'O')
    for i in range(col):
        if matrix[row - 1][i] == '+':
            fill_color_around(matrix, row - 1, i, '+', 'O')

    print_matrix(matrix)

    for i in range(row):
        for j in range(col):
            if matrix[i][j] == '+':
                matrix[i][j] = 'X'

    print_matrix(matrix)

def print_matrix(matrix):
    print("**************************")
    for row in matrix:
        print(' '.join(row))
    print("**************************")

if __name__ == "__main__":
    matrix = [
        ['X', 'O', 'X', 'O', 'X', 'X'],
        ['X', 'O', 'X', 'X', 'O', 'X'],
        ['X', 'X', 'X', 'O', 'X', 'X'],
        ['O', 'X', 'X', 'X', 'X', 'X'],
        ['X', 'X', 'X', 'O', 'X', 'O'],
        ['O', 'O', 'X', 'O', 'O', 'O']
    ]
    replace_val(matrix)
