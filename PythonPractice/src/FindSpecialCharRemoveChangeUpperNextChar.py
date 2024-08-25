def remove_special_char(input_val: str) -> str:
    if input_val is None or len(input_val) == 0:
        return input_val

    flag = False
    result = []

    for c in input_val:
        if not c.isalnum():  # Check if the character is not alphanumeric
            flag = True
        else:
            if flag:
                result.append(c.upper())
                flag = False
            else:
                result.append(c)

    return ''.join(result)

if __name__ == "__main__":
    print(remove_special_char("asbs%adsf^nsdeweokc#!rhslk*(("))
