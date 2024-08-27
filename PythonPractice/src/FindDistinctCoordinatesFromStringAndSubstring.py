from typing import List, Set

def coordinates(input_str: str) -> None:
    print(f"Generating possibilities for: {input_str}")

    # Check if the input is None or too short
    if input_str is None or len(input_str) < 2:
        raise ValueError("Invalid input: Input must be a string with at least two characters.")

    size = len(input_str)
    unique_substrings: Set[str] = set()

    # Iterate over the input string to generate all possible substrings
    for i in range(size):
        for j in range(i + 1, size + 1):
            substring = input_str[i:j]
            if substring not in unique_substrings and len(substring) != size:
                unique_substrings.add(substring)

    # Remove invalid single-character substrings
    singlestring = list(input_str)
    for s in list(unique_substrings):
        if (s != singlestring[0] and s != singlestring[-1]) and len(s) == 1:
            unique_substrings.remove(s)

    # Print all valid unique substrings
    for s in unique_substrings:
        print(s)

# Example usage
if __name__ == "__main__":
    coordinates("12345")
