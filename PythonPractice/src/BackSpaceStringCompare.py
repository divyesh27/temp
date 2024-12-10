'''

Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.

Note that after backspacing an empty text, the text will continue empty.

'''

class BackSpaceStringCompare:

    def process_string(string_comp : str) -> str:
        stack = []
        for char in string_comp:
            if char != '#':
                stack.append(char)
            elif stack:
                stack.pop()

        return ''.join(stack)

    @staticmethod
    def backspaceCompare(input_string : str, compare_string: str) -> bool:
        return BackSpaceStringCompare.process_string(input_string) == BackSpaceStringCompare.process_string(compare_string)


if __name__ == "__main__":
    print(BackSpaceStringCompare.backspaceCompare("ab#c", "ad#c"))
    print(BackSpaceStringCompare.backspaceCompare("ab##", "c#d#"))
    print(BackSpaceStringCompare.backspaceCompare("a#c", "b"))