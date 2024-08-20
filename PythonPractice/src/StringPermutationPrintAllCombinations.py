import re

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

def main():
    find_permutation("{Valery,Jason,Peter} was in {good,bad} mood and he went to the {beach,party,library}")
    find_permutation("{Valery,Jason,Peter} was in")

if __name__ == "__main__":
    main()
