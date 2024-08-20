def find_shortest_distance(input_list, word1, word2):
    if input_list is None or len(input_list) < 2 or word1 is None or word2 is None:
        return -1

    word_indices = {}
    for index, word in enumerate(input_list):
        word_indices[word] = index

    if word1 not in word_indices or word2 not in word_indices:
        return -1

    distance = abs(word_indices[word1] - word_indices[word2])
    return distance

def main():
    input_list = ["practice", "makes", "perfect", "coding", "makes"]

    print(find_shortest_distance(input_list, "coding", "practice"))  # Output: 3
    print(find_shortest_distance(input_list, "makes", "coding"))    # Output: 1

if __name__ == "__main__":
    main()
