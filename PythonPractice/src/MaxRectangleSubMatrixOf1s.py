def histogram(heights):
    """
    Calculates the maximum area of a rectangle in a histogram.

    Args:
    heights (List[int]): List of integers representing heights in the histogram.

    Returns:
    int: Maximum area of the rectangle.
    """
    stack = []
    max_area = 0
    index = 0

    while index < len(heights):
        if not stack or heights[stack[-1]] <= heights[index]:
            stack.append(index)
            index += 1
        else:
            top_of_stack = stack.pop()
            area = (heights[top_of_stack] *
                    ((index - stack[-1] - 1) if stack else index))
            max_area = max(max_area, area)

    while stack:
        top_of_stack = stack.pop()
        area = (heights[top_of_stack] *
                ((index - stack[-1] - 1) if stack else index))
        max_area = max(max_area, area)

    return max_area

def max_rectangle(matrix):
    """
    Finds the maximum area of a rectangle in a binary matrix of 1s and 0s.

    Args:
    matrix (List[List[int]]): 2D list representing the binary matrix.

    Returns:
    int: Maximum area of the rectangle.
    """
    if not matrix or not matrix[0]:
        raise ValueError("Pass a valid input matrix")

    num_rows = len(matrix)
    num_cols = len(matrix[0])

    temp = [0] * num_cols
    max_area = 0

    for i in range(num_rows):
        for j in range(num_cols):
            if matrix[i][j] == 0:
                temp[j] = 0
            else:
                temp[j] += matrix[i][j]

        area = histogram(temp)
        max_area = max(max_area, area)

    return max_area

if __name__ == "__main__":
    input_matrix = [
        [1, 1, 1, 0],
        [1, 1, 1, 1],
        [0, 1, 1, 0],
        [0, 1, 1, 1],
        [1, 0, 0, 1],
        [1, 1, 1, 1]
    ]

    print("Max Rectangle Area:", max_rectangle(input_matrix))
