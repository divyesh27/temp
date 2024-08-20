from typing import List

def letter_combinations(digits: str) -> List[str]:
    if not isinstance(digits, str):
        raise ValueError("Input must be a string")

    if len(digits) == 0:
        return []

    # Mapping from digit to letters
    mapping = ["0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"]

    # Initialize the result with an empty string
    result = [""]

    for digit in digits:
        if not digit.isdigit() or int(digit) < 0 or int(digit) > 9:
            raise ValueError("Input must only contain digits from 2 to 9")

        num = int(digit)
        if num == 0 or num == 1:
            continue  # Skip '0' and '1' as they do not map to any letters

        # Generate combinations
        temp_result = []
        for prefix in result:
            for char in mapping[num]:
                temp_result.append(prefix + char)
        result = temp_result

    return result

# Example usage
if __name__ == "__main__":
    print(letter_combinations("23"))  # Example output: ['ad', 'ae', 'af', 'bd', 'be', 'bf', 'cd', 'ce', 'cf']
    print(letter_combinations("33"))  # Example output: ['ddd', 'dde', 'ddf', 'ded', 'dee', 'def', 'dfd', 'dfe', 'dff', 'edd', 'ede', 'edf', 'eed', 'eee', 'eef', 'ffd', 'ffe', 'fff']
