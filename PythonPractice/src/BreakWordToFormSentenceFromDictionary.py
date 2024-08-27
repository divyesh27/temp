from typing import List, Dict

def break_word(s: str, dictionary: List[str]) -> str:
    if not isinstance(s, str):
        raise TypeError("Input must be a string.")

    if not isinstance(dictionary, list) or not all(isinstance(word, str) for word in dictionary):
        raise TypeError("Dictionary must be a list of strings.")

    if not s or len(s) < 1:
        return s

    return break_word_util(s, 0, dictionary)

def break_word_util(s: str, low: int, dictionary: List[str]) -> str:
    if s is None or len(s) < 1:
        return s

    str_buffer = []

    for i in range(low, len(s)):
        str_buffer.append(s[i])
        word = ''.join(str_buffer)

        if word in dictionary:
            result = break_word_util(s, i + 1, dictionary)
            if result is not None:
                return word + " " + result

    if ''.join(str_buffer) in dictionary:
        return ''.join(str_buffer)

    return None

if __name__ == "__main__":
    dictionary = ["I", "like", "had", "play", "to"]
    s = "playtoIliketo"
    result = break_word(s, dictionary)

    if result:
        print(result)
    else:
        print("No valid sentence can be formed.")
