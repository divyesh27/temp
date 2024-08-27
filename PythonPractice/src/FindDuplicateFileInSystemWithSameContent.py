from typing import List, Dict
import re

def find_duplicate(paths: List[str]) -> List[List[str]]:
    # Check for null or empty input list
    if paths is None:
        raise ValueError("Input cannot be None.")
    if not isinstance(paths, list) or not all(isinstance(path, str) for path in paths):
        raise ValueError("Input must be a list of strings.")

    content_map: Dict[str, List[str]] = {}

    for path in paths:
        values = path.split(" ")
        root_path = values[0]

        for i in range(1, len(values)):
            file_info = values[i]
            name, content = re.match(r"(.+)\((.+)\)", file_info).groups()

            # Add the file path to the corresponding content entry in the map
            if content not in content_map:
                content_map[content] = []
            content_map[content].append(f"{root_path}/{name}")

    # Compile the result list with only those entries that have duplicates
    result = [file_list for file_list in content_map.values() if len(file_list) > 1]

    return result

def main():
    input_paths = ["root/a 1.txt(abcd) 2.txt(efgh)",
                   "root/c 3.txt(abcd)",
                   "root/c/d 4.txt(efgh)",
                   "root 4.txt(efgh)"]

    try:
        duplicates = find_duplicate(input_paths)
        print(duplicates)
    except ValueError as e:
        print(e)

if __name__ == "__main__":
    main()
