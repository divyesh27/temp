from typing import List

def eval_rpn(tokens: List[str]) -> int:
    if tokens is None or len(tokens) == 0:
        return -1

    operators = "/*+-"
    stack = []

    for token in tokens:
        if token not in operators:
            stack.append(int(token))
        else:
            if len(stack) >= 2:
                a = stack.pop()
                b = stack.pop()
                if token == '/':
                    stack.append(int(b / a))
                elif token == '*':
                    stack.append(b * a)
                elif token == '+':
                    stack.append(b + a)
                elif token == '-':
                    stack.append(b - a)

    return stack.pop() if stack else -1

def main():
    tokens = ["4", "13", "5", "/", "+"]
    print(eval_rpn(tokens))  # Output: 6

if __name__ == "__main__":
    main()
