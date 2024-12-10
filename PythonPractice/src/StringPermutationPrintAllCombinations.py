import re
from typing import List

def find_permutation(input_string):
    if input_string is None or len(input_string) < 2:
        raise ValueError("Pass valid input")

    pattern = r"\{(\w+,?\s?)+\}"
    matches = re.findall(pattern, input_string)

    if len(matches) != 3:
        raise ValueError("Input string does not contain all needed values")

    names = matches[0].strip('{}').split(',')
    emotions = matches[1].strip('{}').split(',')
    locations = matches[2].strip('{}').split(',')

    for name in names:
        for emotion in emotions:
            for location in locations:
                print(f"{name} was in {emotion} mood and he went to the {location}")


def permutations(input : str) -> List[str]:

    if len(input) == 0:
        return [""]
    permutations_result = []

    for index, char in enumerate(input):

        remain_val = input[:index] + input[index + 1:]

        for val in permutations(remain_val):
            permutations_result.append(char + val)

    return permutations_result

def main():
    find_permutation("{Valery,Jason,Peter} was in {good,bad} mood and he went to the {beach,party,library}")
    #find_permutation("{Valery,Jason,Peter} was in")
    print (permutations("abc"))
if __name__ == "__main__":
    main()
