def print_match_and_mismatch_elements(arr1, arr2):
    if arr1 is None or arr2 is None or len(arr1) != len(arr2):
        raise ValueError("Pass valid input")

    hm = {}

    # Check for exact matches
    for i in range(len(arr1)):
        if arr1[i] == arr2[i]:
            print(f"Exact Match {arr1[i]}")
        else:
            if arr1[i] in hm:
                hm[arr1[i]] += 1
            else:
                hm[arr1[i]] = 1

    # Check for mismatches
    for i in range(len(arr2)):
        if arr2[i] in hm and hm[arr2[i]] > 0:
            print(f"Mis Match {arr2[i]}")
            hm[arr2[i]] -= 1

def main():
    arr1 = [3, 4, 5, 7, 2, 6, 8, 0, 1, 3, 5, 7, 9]
    arr2 = [3, 4, 6, 3, 5, 7, 9, 3, 5, 2, 4, 7, 9]
    print_match_and_mismatch_elements(arr1, arr2)

if __name__ == "__main__":
    main()
