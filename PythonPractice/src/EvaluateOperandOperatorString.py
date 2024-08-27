from typing import Union
import re

def evaluate(input_str: str) -> int:
    if not isinstance(input_str, str):
        raise TypeError("Input must be a string")

    tokens = re.findall(r'\d+|[-+*/()]', input_str.replace(' ', ''))
    operand_stack = []
    operator_stack = []

    def arithmetic(val1: int, val2: int, op: str) -> int:
        if op == '+':
            return val1 + val2
        elif op == '-':
            return val1 - val2
        elif op == '*':
            return val1 * val2
        elif op == '/':
            if val2 == 0:
                raise ZeroDivisionError("Can't divide by zero")
            return val1 // val2
        raise ValueError(f"Unsupported operation {op}")

    def is_precedence(op1: str, op2: str) -> bool:
        precedence = {'+': 1, '-': 1, '*': 2, '/': 2}
        return precedence.get(op1, 0) > precedence.get(op2, 0)

    for token in tokens:
        if token.isdigit():
            operand_stack.append(int(token))
        elif token == '(':
            operator_stack.append(token)
        elif token == ')':
            while operator_stack and operator_stack[-1] != '(':
                operator_stack.append(arithmetic(operand_stack.pop(), operand_stack.pop(), operator_stack.pop()))
            operator_stack.pop()  # pop the '('
        elif token in '+-*/':
            while (operator_stack and operator_stack[-1] in '+-*/' and
                   is_precedence(token, operator_stack[-1])):
                operand_stack.append(arithmetic(operand_stack.pop(), operand_stack.pop(), operator_stack.pop()))
            operator_stack.append(token)

    while operator_stack:
        operand_stack.append(arithmetic(operand_stack.pop(), operand_stack.pop(), operator_stack.pop()))

    return operand_stack.pop()

# Example usage
try:
    print(evaluate("10 + 2 * 6"))
    print(evaluate("100 * 2 + 12"))
    print(evaluate("100 * ( 2 + 12 )"))
    print(evaluate("100 * ( 2 + 12 ) / 14"))
    print(evaluate("10 + 2 * 6"))
    print(evaluate("3 * 3 / 3 + 3 - 3"))
except Exception as e:
    print(f"An error occurred: {e}")
