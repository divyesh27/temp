def print_unique_numbers(num1, num2):
    if not num1 or not num2:
        raise ValueError("Both arrays must be non-empty.")

    i, j = 0, 0

    while i < len(num1) and j < len(num2):
        if num1[i] < num2[j]:
            print(num1[i])
            i += 1
        elif num2[j] < num1[i]:
            print(num2[j])
            j += 1
        else:
            i += 1
            j += 1

    while i < len(num1):
        if i == len(num1) - 1 or num1[i] != num1[i + 1]:
            print(num1[i])
        i += 1

    while j < len(num2):
        if j == len(num2) - 1 or num2[j] != num2[j + 1]:
            print(num2[j])
        j += 1


if __name__ == "__main__":
    numA = [2, 4, 5, 7, 8, 9, 33, 32, 2, 5, 6]
    numB = [1, 2, 6, 7, 10]
    print_unique_numbers(numA, numB)
