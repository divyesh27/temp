from typing import List, Tuple

# Define a tuple structure to store character, index, and count
class CharTuple:
    def __init__(self, character: str, index: int, count: int):
        self.character = character
        self.index = index
        self.count = count

    def __str__(self):
        return f"('{self.character}', {self.index}, {self.count})"

def find_substring_counter(input_string: str) -> List[CharTuple]:
    # Check for null or non-string inputs
    if input_string is None or not isinstance(input_string, str):
        raise ValueError("Pass a valid input string.")

    # Check for empty input
    if input_string.strip() == "":
        raise ValueError("Input string cannot be empty.")

    # Initialize the result list
    result: List[CharTuple] = []

    # If the input string has less than 2 characters, return an empty result
    if len(input_string) < 2:
        return result

    size = len(input_string)
    start = 0

    # Iterate through the string to find repeating characters
    while start < size:
        current_character = input_string[start]
        end = start

        while end < size and input_string[end] == current_character:
            end += 1

        count = end - start
        # If repeating characters are found, add to the result
        if count > 1:
            result.append(CharTuple(current_character, start, count))

        start = end

    return result

def main():
    input_string = "aabcdeee"

    try:
        subset_string = find_substring_counter(input_string)
        for char_tuple in subset_string:
            print(char_tuple)
    except ValueError as e:
        print(f"Error: {e}")

if __name__ == "__main__":
    main()
