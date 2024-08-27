from typing import Set

def find_most_occur_char_from_string(input_string: str, compare: str) -> int:
    # Input validation
    if not input_string or not compare:
        raise ValueError("Pass valid input: Both input_string and compare must be non-empty strings.")

    count = 0
    distinct_char: Set[str] = set(compare)

    for c in input_string:
        if c in distinct_char:
            count += 1

    return count

# Example usage
if __name__ == "__main__":
    print(find_most_occur_char_from_string("aaabbbbcbsbdddcbbbc", "dsa"))
    print(find_most_occur_char_from_string("SAAbbbbcbsbdddcbbbc", "dsa"))
