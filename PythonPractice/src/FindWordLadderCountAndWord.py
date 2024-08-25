from collections import deque
from typing import Set, Optional

class WordNode:
    def __init__(self, word: str, steps: int):
        self.word = word
        self.steps = steps

def find_length_to_word_from_dictionary(begin_word: str, end_word: str, word_dict: Set[str]) -> int:
    if not begin_word or not end_word or not word_dict:
        raise ValueError("Invalid input: None or empty values are not allowed.")

    queue = deque([WordNode(begin_word, 1)])

    while queue:
        top = queue.popleft()
        word = top.word

        if word == end_word:
            return top.steps

        word_list = list(word)
        for i in range(len(word_list)):
            original_char = word_list[i]
            for c in 'abcdefghijklmnopqrstuvwxyz':
                if word_list[i] != c:
                    word_list[i] = c
                new_word = ''.join(word_list)
                if new_word in word_dict:
                    queue.append(WordNode(new_word, top.steps + 1))
                    word_dict.remove(new_word)
            word_list[i] = original_char

    return 0

if __name__ == "__main__":
    word_set = {"hot", "dot", "dog", "lot", "log", "cog"}  # Example set of words
    print(find_length_to_word_from_dictionary("hit", "cog", word_set))  # Output should be 5
    # word_set = {"poon", "plee", "same", "poie", "plie", "poin", "plea"}
    # print(find_length_to_word_from_dictionary("toon", "plea", word_set))  # Test with different word list
