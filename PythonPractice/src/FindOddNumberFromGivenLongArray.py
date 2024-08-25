from typing import List, Union

def rearrange_odd_zero_even_sort(input_array: List[int]) -> Union[int, None]:
    size = len(input_array)

    if input_array is None or size == 0:
        return None

    # Iterate through the array to find the first odd number
    for num in input_array:
        if num % 2 != 0:
            return num

    return None

def main():
    arr = [-5234256, -723143678, 111111110, 1212450, 232421340, 24214120, 2432467]
    print(rearrange_odd_zero_even_sort(arr))

if __name__ == "__main__":
    main()
