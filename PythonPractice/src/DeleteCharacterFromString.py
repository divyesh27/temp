def delete_characters_from_string(input_string: str, remove_chars: str) -> str:
    if not isinstance(input_string, str) or not isinstance(remove_chars, str):
        raise TypeError("Both input_string and remove_chars must be strings")

    if input_string is None or remove_chars is None:
        raise ValueError("Neither input_string nor remove_chars can be None")

    # Create a set of characters to remove for quick lookup
    remove_set = set(remove_chars)

    # Use list comprehension to filter out the characters
    filtered_chars = [char for char in input_string if char not in remove_set]

    # Join the list into a new string
    result_string = ''.join(filtered_chars)
    return result_string

if __name__ == "__main__":
    try:
        print(delete_characters_from_string("I am divyesh and you are dont know", "aeiou"))
    except (TypeError, ValueError) as e:
        print(f"Error: {e}")
