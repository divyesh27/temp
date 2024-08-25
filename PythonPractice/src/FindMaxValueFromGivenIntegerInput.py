import heapq

def find_min_or_max_value_from_given_integer(input_value):
    if input_value is None or input_value < 1:
        raise ValueError("Pass valid input")

    # Use a max heap (inverted min heap) to sort digits in descending order
    max_heap = []
    value = input_value
    result = 0

    while value != 0:
        # Push the digit onto the heap (inverted to simulate a max heap)
        heapq.heappush(max_heap, -(value % 10))
        value = value // 10

    while max_heap:
        # Extract the largest digit and add it to the result
        result = result * 10 - heapq.heappop(max_heap)

    return result

if __name__ == "__main__":
    # Test cases
    print(find_min_or_max_value_from_given_integer(1432))   # Output should be 4321
    print(find_min_or_max_value_from_given_integer(999))    # Output should be 999
    print(find_min_or_max_value_from_given_integer(111))    # Output should be 111
    print(find_min_or_max_value_from_given_integer(10))     # Output should be 10
    print(find_min_or_max_value_from_given_integer(4321))   # Output should be 4321
    print(find_min_or_max_value_from_given_integer(12341583)) # Output should be 85433211
