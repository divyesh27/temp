class Pair:
    def __init__(self, repeat=None, missing=None):
        self.repeat = repeat
        self.missing = missing

    def __str__(self):
        return f"{self.repeat} {self.missing}"


class FindMissingAndRepeatNumFrom1ToN:

    def find_numbers(self, input_list):
        if not input_list or len(input_list) < 2:
            return "Input array should have at least 2 elements."

        p = Pair()

        for i in range(len(input_list)):
            if input_list[abs(input_list[i]) - 1] < 0:
                p.repeat = abs(input_list[i])
            else:
                input_list[abs(input_list[i]) - 1] = -input_list[abs(input_list[i]) - 1]

        for i in range(len(input_list)):
            if input_list[i] < 0:
                input_list[i] = -input_list[i]
            else:
                p.missing = i + 1

        return p


def find_missing_number(input_list):
    if not input_list or len(input_list) < 1:
        return "Input array should have at least 1 element."

    count = 0
    sum_input = 0
    for i in range(1, len(input_list) + 1):
        count += i
        sum_input += input_list[i - 1]

    count += len(input_list) + 1
    return count - sum_input


if __name__ == "__main__":
    fm = FindMissingAndRepeatNumFrom1ToN()

    input_data1 = [5, 6, 8, 7, 4, 2, 9, 2, 1]
    input_data2 = [2, 5, 7, 9, 6, 1, 4, 3]

    print(fm.find_numbers(input_data1))  # Output should be "2 3"
    print(find_missing_number(input_data2))  # Output should be 8
