from typing import List
from collections import deque

class BasicCalculator:
    def calculate(self, s: str) -> int:
        if not isinstance(s, str):
            raise TypeError("Input must be a string")

        stack = deque()
        num = 0
        result = 0
        sign = 1  # 1 means positive, -1 means negative

        i = 0
        while i < len(s):
            c = s[i]

            if c.isdigit():
                num = num * 10 + int(c)
            elif c == '+':
                result += sign * num
                num = 0
                sign = 1
            elif c == '-':
                result += sign * num
                num = 0
                sign = -1
            elif c == '(':
                stack.append(result)
                stack.append(sign)
                result = 0
                sign = 1
            elif c == ')':
                result += sign * num
                num = 0
                result *= stack.pop()  # Multiply by the sign before the parenthesis
                result += stack.pop()  # Add the result before the parenthesis
            # Ignore any whitespace
            elif c.isspace():
                pass
            else:
                raise ValueError(f"Unexpected character '{c}' in the expression")

            i += 1

        result += sign * num
        return result

# Example usage
if __name__ == "__main__":
    calculator = BasicCalculator()

    expressions = [
        "1 + 1",
        " 2-1 + 2 ",
        "(1+(4+5+2)-3)+(6+8)"
    ]

    for expression in expressions:
        print(f"Expression: {expression}")
        print(f"Result: {calculator.calculate(expression)}")
