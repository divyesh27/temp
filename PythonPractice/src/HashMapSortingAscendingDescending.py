from typing import Dict, List, Tuple

def sort_by_values_ascending(d: Dict[str, int]) -> Dict[str, int]:
    if d is None:
        raise ValueError("Input dictionary cannot be None")
    if not d:
        return {}
    return dict(sorted(d.items(), key=lambda item: item[1]))

def sort_by_values_descending(d: Dict[str, int]) -> Dict[str, int]:
    if d is None:
        raise ValueError("Input dictionary cannot be None")
    if not d:
        return {}
    return dict(sorted(d.items(), key=lambda item: item[1], reverse=True))

def main():
    budget = {
        "clothes": 120,
        "grocery": 150,
        "transportation": 100,
        "utility": 130,
        "rent": 1150,
        "miscellaneous": 90
    }

    print("map before sorting:", budget)

    # Sort by values in ascending order
    sorted_ascending = sort_by_values_ascending(budget)
    print("map after sorting by values:", sorted_ascending)

    # Sort by values in descending order
    sorted_descending = sort_by_values_descending(budget)
    print("map after sorting by values in descending order:", sorted_descending)

if __name__ == "__main__":
    main()
