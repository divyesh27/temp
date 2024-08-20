from typing import List

def histogram(input: List[int]) -> int:
    if not input or not all(isinstance(x, int) for x in input):
        raise ValueError("Input must be a list of integers")

    stack = []
    max_area = 0
    i = 0

    while i < len(input):
        if not stack or input[stack[-1]] <= input[i]:
            stack.append(i)
            i += 1
        else:
            top = stack.pop()
            area = (input[top] * i) if not stack else (input[top] * (i - stack[-1] - 1))
            max_area = max(max_area, area)

    while stack:
        top = stack.pop()
        area = (input[top] * i) if not stack else (input[top] * (i - stack[-1] - 1))
        max_area = max(max_area, area)

    return max_area

def minhistogram(input: List[int]) -> int:
    if not input or not all(isinstance(x, int) for x in input):
        raise ValueError("Input must be a list of integers")

    stack = []
    min_area = float('inf')
    i = 0

    while i < len(input):
        if not stack or input[stack[-1]] >= input[i]:
            stack.append(i)
            i += 1
        else:
            top = stack.pop()
            area = (input[top] * i) if not stack else (input[top] * (i - stack[-1] - 1))
            min_area = min(min_area, area)

    while stack:
        top = stack.pop()
        area = (input[top] * i) if not stack else (input[top] * (i - stack[-1] - 1))
        min_area = min(min_area, area)

    return min_area if min_area != float('inf') else 0

if __name__ == "__main__":
    input_data = [6, 2, 5, 4, 5, 1, 6]
    # input_data = [2, 2, 2, 6, 1, 5, 4, 2, 2, 2, 2]

    print(histogram(input_data))
    print(minhistogram(input_data))
