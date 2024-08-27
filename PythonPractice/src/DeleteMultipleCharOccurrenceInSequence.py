def delete_multiple_occurrence_char(s: str) -> str:
    if not isinstance(s, str):
        raise TypeError("Input must be a string")

    if not s:
        return None

    last_char = None
    result = []

    for char in s:
        if last_char is None or char != last_char:
            result.append(char)
            last_char = char

    return ''.join(result)

# Example usage
if __name__ == "__main__":
    try:
        print(delete_multiple_occurrence_char("hiii hoowww aaarrreee youuu?"))
    except Exception as e:
        print(f"An error occurred: {e}")
