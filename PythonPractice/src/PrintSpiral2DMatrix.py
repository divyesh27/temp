def print_spiral_matrix(rows: int, cols: int) -> None:
    if rows <= 0 or cols <= 0:
        return

    input_matrix = [[' ' for _ in range(cols)] for _ in range(rows)]

    left, up = 0, 0
    right, down = cols - 1, rows - 1
    flag = True

    while left <= right and up <= down:
        if flag:
            # Add '1' to the top row from right to left
            for i in range(right, left - 1, -1):
                input_matrix[up][i] = '1'
            up += 1

            # Add '1' to the left column from up to down
            for i in range(up, down + 1):
                input_matrix[i][left] = '1'
            left += 1

            # Add '1' to the bottom row from left to right
            if left <= right:
                for i in range(left, right + 1):
                    input_matrix[down][i] = '1' if up != down else ' '
            down -= 1

            # Add '1' to the right column from down to up
            for i in range(down, up - 1, -1):
                input_matrix[i][right] = '1'
            right -= 1

            flag = False
        else:
            # Add space to the top row from right to left
            for i in range(right + 1, left - 1, -1):
                input_matrix[up][i] = ' '
            up += 1

            # Add space to the left column from up to down
            for i in range(up, down + 1):
                input_matrix[i][left] = ' '
            left += 1

            # Add space to the bottom row from left to right
            for i in range(left, right + 1):
                input_matrix[down][i] = ' '
            down -= 1

            # Add space to the right column from down to up, then overwrite with '1'
            if up <= down:
                for i in range(down, up - 1, -1):
                    input_matrix[i][right] = ' '
                input_matrix[down + 1][right] = '1'
            right -= 1

            flag = True

    print_matrix(input_matrix)

def print_matrix(matrix: list[list[str]]) -> None:
    for row in matrix:
        print("".join(row))

def main():
    print_spiral_matrix(10, 10)
    print_spiral_matrix(4, 4)
    print_spiral_matrix(5, 5)
    print_spiral_matrix(4, 16)
    print_spiral_matrix(7, 9)
    print_spiral_matrix(8, 12)
    print_spiral_matrix(0, 0)  # This will return without printing anything
    print_spiral_matrix(4, 0)  # This will return without printing anything
    print_spiral_matrix(15, 19)
    print_spiral_matrix(5, 15)

if __name__ == "__main__":
    main()
