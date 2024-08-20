from typing import Dict, Union

def find_min_value(budget: Dict[str, int]) -> int:
    if budget is None:
        raise ValueError("Pass valid input")

    if not budget:
        raise ValueError("Empty dictionary provided")

    min_value = float('inf')
    for value in budget.values():
        if value is not None and value < min_value:
            min_value = value
    return min_value

def find_max_value(budget: Dict[str, int]) -> int:
    if budget is None:
        raise ValueError("Pass valid input")

    if not budget:
        raise ValueError("Empty dictionary provided")

    max_value = float('-inf')
    for value in budget.values():
        if value is not None and value > max_value:
            max_value = value
    return max_value

def find_min_nested_value(data: Dict[str, Union[int, Dict]]) -> int:
    if data is None:
        raise ValueError("Pass valid input")

    min_value = float('inf')
    for value in data.values():
        if isinstance(value, dict):
            nested_min = find_min_nested_value(value)
            if nested_min < min_value:
                min_value = nested_min
        elif isinstance(value, int):
            if value < min_value:
                min_value = value
    return min_value

def find_max_nested_value(data: Dict[str, Union[int, Dict]]) -> int:
    if data is None:
        raise ValueError("Pass valid input")

    max_value = float('-inf')
    for value in data.values():
        if isinstance(value, dict):
            nested_max = find_max_nested_value(value)
            if nested_max > max_value:
                max_value = nested_max
        elif isinstance(value, int):
            if value > max_value:
                max_value = value
    return max_value

def main():
    # Define the nested dictionary similar to Java's nested HashMap
    nested_dict = {
        "Test1": 100,
        "Test2": {"Test3": 200},
        "Test3": 500,
        "Test4": {"Test6": {"Test8": 600}},
        "Test9": {"Test10": {"Test11": {"Test12": 10}}},
        "Test": 110,
        "Test13": {"Test14": {"Test15": 900}}
    }

    # Print min and max values of the nested dictionary
    print("Found Min value:", find_min_nested_value(nested_dict))
    print("Found Max value:", find_max_nested_value(nested_dict))

    # Define a simple budget dictionary
    budget = {
        "clothes": 120,
        "grocery": 150,
        "transportation": 100,
        "utility": 130,
        "rent": 1150,
        "miscellaneous": 90
    }

    # Print min and max values of the budget dictionary
    print("Minimum value in budget:", find_min_value(budget))
    print("Maximum value in budget:", find_max_value(budget))

if __name__ == "__main__":
    main()
