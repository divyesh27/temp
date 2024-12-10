"""
Dynamic path Accessor

Implement a function called get_dict_value that takes two arguments a dictionary called dct and a string called path. The path string represents the nested keys of the dictionary, separated by dots. The function should return the value at the specified path or None ( the python null value, not a string ) if the path does not exist.

example

obj = {
          "car" :
                     "wheels":2,
                     "gears": 5
            }
}
path = "car.gears"

The function call get_dict_value(obj, "car.gears) should return 5.

Complete the function geT_dict_value in the editor below.

get_dict_Value has following param
obj : a python dictionary
string path: the path to desired value if exists

Returns

the value at the specified path, or None (python null value, not a string) if the path does not exist
"""

def get_dict_value(dct, path):
    # Split the path into individual keys
    keys = path.split('.')

    # Traverse through the dictionary using the keys
    for key in keys:
        # Check if the key exists in the current dictionary level
        if isinstance(dct, dict) and key in dct:
            dct = dct[key]
        else:
            # If the key does not exist, return None
            return None
    return dct

# Example usage
obj = {
    "car": {
        "wheels": 2,
        "gears": 5,
        "Brake": None
    }
}

path = "car.gears"
print(get_dict_value(obj, path))  # Output: 5

path = "car.wheels"
print(get_dict_value(obj, path))  # Output: 2

path = "car.doors"
print(get_dict_value(obj, path))  # Output: None

path = "car.Brake"
print(get_dict_value(obj, path))  # Output: None
