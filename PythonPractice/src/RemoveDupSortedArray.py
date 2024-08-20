from typing import List

def remove_dup(input_list: List[int]) -> List[int]:
    if input_list is None or len(input_list) < 1:
        raise ValueError("Pass valid input")

    # Remove duplicates while preserving order
    remove_dup = []
    for i in input_list:
        if i not in remove_dup:
            remove_dup.append(i)

    # Sort the list
    remove_dup.sort()
    return remove_dup

def main():
    input_list = [11, 11, 3, 4, 55, 55, 5, 6, 6, 7, 8]
    for i in remove_dup(input_list):
        print(i)

if __name__ == "__main__":
    main()
