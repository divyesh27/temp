from typing import List, Optional

def arith_op_string_to_int_sum(input: str) -> int:
    if not input or len(input) < 3 or input[-1] in '-+':
        return -1

    # Split input by '-' or '+' operators
    import re
    str_tokens = re.split(r'(\+|\-)', input)
    str_tokens = [s for s in str_tokens if s]  # Remove empty strings

    if not str_tokens or any(not s.isdigit() for s in str_tokens[::2]):
        return -1

    stack = []
    i = 1
    result = 0
    if input[0] == '-':
        result = -int(str_tokens[0])
        stack.append(result)
        i = 2
    elif int(str_tokens[0]) <= 9:
        result = int(str_tokens[0])
        stack.append(result)
        i = 1
    else:
        return -1

    while i < len(str_tokens):
        if str_tokens[i] == '-':
            result = stack.pop() - int(str_tokens[i + 1])
        elif str_tokens[i] == '+':
            result = stack.pop() + int(str_tokens[i + 1])
        else:
            return -1
        stack.append(result)
        i += 2

    return result

def arithmetic_operator_expression(expression: str) -> int:
    result = 0
    num = 0
    op = '+'

    for ch in expression:
        if ch.isdigit():
            num = num * 10 + int(ch)
        elif ch in '+-*/':
            if op == '+':
                result += num
            elif op == '-':
                result -= num
            elif op == '*':
                result *= num
            elif op == '/':
                if num == 0:
                    raise ValueError("Division by zero is not allowed.")
                result //= num  # Use integer division
            op = ch
            num = 0

    # Apply the last operation
    if op == '+':
        result += num
    elif op == '-':
        result -= num
    elif op == '*':
        result *= num
    elif op == '/':
        if num == 0:
            raise ValueError("Division by zero is not allowed.")
        result //= num

    return result

def arithmetic_eval_operator(tokens: List[str]) -> int:
    stack = []

    for token in tokens:
        if is_operator(token):
            operand2 = stack.pop()
            operand1 = stack.pop()
            result = perform_operation(token, operand1, operand2)
            stack.append(result)
        else:
            try:
                operand = int(token)
                stack.append(operand)
            except ValueError:
                raise ValueError(f"Invalid token: {token}")

    return stack.pop()

def is_operator(token: str) -> bool:
    return token in {"+", "-", "*", "/"}

def perform_operation(operator: str, operand1: int, operand2: int) -> int:
    if operator == "+":
        return operand1 + operand2
    elif operator == "-":
        return operand1 - operand2
    elif operator == "*":
        return operand1 * operand2
    elif operator == "/":
        if operand2 == 0:
            raise ZeroDivisionError("Division by zero is not allowed.")
        return operand1 // operand2
    else:
        raise ValueError(f"Invalid operator: {operator}")

def main():
    input1 = "-3+55"
    tokens1 = ["2", "1", "+", "3", "*"]
    tokens2 = ["4", "13", "5", "/", "+"]
    tokens3 = ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]

    print(arith_op_string_to_int_sum(input1))
    print(arithmetic_operator_expression(input1))
    print(arithmetic_eval_operator(tokens1))
    print(arithmetic_eval_operator(tokens2))
    print(arithmetic_eval_operator(tokens3))

if __name__ == "__main__":
    main()
