from typing import Dict, List, Iterator, Optional

class Flatten2DNestedList(Iterator[int]):

    def __init__(self, map_data: Optional[Dict[str, List[str]]] = None):
        if map_data is None:
            raise ValueError("Pass valid input")

        self.flatten_list = []
        for value_list in map_data.values():
            if value_list is not None:
                self.flatten_list.extend(value_list)

        # Alternatively, using list comprehension
        # self.flatten_list = [item for sublist in map_data.values() if sublist for item in sublist]

        self._iterator = iter(self.flatten_list)

    def __iter__(self):
        return self

    def __next__(self) -> int:
        try:
            return next(self._iterator)
        except StopIteration:
            raise StopIteration ("Iteration is stopped")

    def has_next(self) -> bool:
        try:
            next(self._iterator)
            return True
        except StopIteration:
            print ("Iteration stopped")
            return False

def main():
    map_data = {
        "key1": ["12", "2", "3"],
        "key2": ["4", "5"],
        "key3": ["6", "71", "8"],
        "key4": [],
        "key5": ["91", "10"]
    }

    flatten_iterator = Flatten2DNestedList(map_data)

    print("Flattened List:")
    while flatten_iterator.has_next():
        print(flatten_iterator.__next__(), end=" ")
    print()

if __name__ == "__main__":
    main()
