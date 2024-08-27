from typing import List, Optional

def withdraw_amount(bills_available: List[int], desired_amount: int) -> Optional[List[int]]:
    # Check if the desired amount is a multiple of 10
    if desired_amount % 10 != 0:
        print("Desired amount must be a multiple of 10.")
        return []  # Return an empty list

    # Sort the bills in descending order
    sorted_bills = sorted(bills_available, reverse=True)

    # Initialize the list to hold the number of each bill to be withdrawn
    withdraw_bills = [0] * len(sorted_bills)
    remaining_amount = desired_amount

    # Calculate the number of each bill to withdraw
    for i, bill in enumerate(sorted_bills):
        if bill <= 0:
            print(f"Invalid bill denomination: {bill}.")
            return []  # Return an empty list

        bill_count = remaining_amount // bill
        withdraw_bills[i] = bill_count
        remaining_amount -= bill * bill_count

    # Check if the remaining amount is zero
    if remaining_amount != 0:
        print("Unable to dispense the desired amount with available bills.")
        return []  # Return an empty list

    return withdraw_bills

def main():
    bills_available = [10, 40, 20, 50]
    desired_amount = 330

    withdraw_bills = withdraw_amount(bills_available, desired_amount)
    count = 0

    if withdraw_bills:
        print("Bills returned:")
        for i, bill_count in enumerate(withdraw_bills):
            if bill_count > 0:
                print(f"{bills_available[i]} * {bill_count}")
                count += bill_count

    print(f"No of bills - {count}")

if __name__ == "__main__":
    main()
