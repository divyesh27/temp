import os
from collections import defaultdict

def add_dup_words(file_path):
    if not os.path.isfile(file_path):
        print(f"File not found: {file_path}")
        return

    word_count = defaultdict(int)

    try:
        with open(file_path, 'r') as file:
            for line in file:
                words = line.lower().split()
                for word in words:
                    word_count[word] += 1

        # Print words that occur more than once
        for word, count in word_count.items():
            if count > 1:
                print(f"Key {word} - {count}")

        # Find the word with the maximum occurrence
        max_occurrence_word = None
        max_count = 0

        for word, count in word_count.items():
            if count > max_count:
                max_occurrence_word = word
                max_count = count

        print(f"The word with the maximum occurrence is: {max_occurrence_word}")

    except IOError as e:
        print(f"An error occurred while reading the file: {e}")

def main():
    file_path = "/Users/divyesh.shah/Documents/workspace/JavaPractice/input.txt"
    add_dup_words(file_path)

if __name__ == "__main__":
    main()
