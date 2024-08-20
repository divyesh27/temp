def is_match(opening, closing):
    return (opening == '(' and closing == ')') or \
        (opening == '{' and closing == '}') or \
        (opening == '[' and closing == ']')

def paranthesis_matching(input_string):
    if input_string is None:
        return False
    if not isinstance(input_string, str):
        raise ValueError("Input must be a string")
    if input_string == "":
        return True

    stack = []

    for char in input_string:
        if char in '({[':
            stack.append(char)
        elif char in ')}]':
            if not stack:
                return False
            if not is_match(stack.pop(), char):
                return False

    return len(stack) == 0

if __name__ == "__main__":
    print(paranthesis_matching("[()]{}{[()()]()}"))  # Output: True
    print(paranthesis_matching("(()"))              # Output: False
    print(paranthesis_matching("(]([))"))           # Output: False
    print(paranthesis_matching("{{{{}}}}(())"))     # Output: True
    print(paranthesis_matching("{(([][][]))}"))     # Output: True
