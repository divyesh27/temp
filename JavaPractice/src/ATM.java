/**
 * @author divyesh.shah
 */
import java.util.Arrays;
/*
* Withdraw bills from ATM or dispense money bill or cash
* Find number of counts
* */
public class ATM {
    public static int[] withdrawAmount(int[] billsAvailable, int desiredAmount) {
        if (desiredAmount % 10 != 0) {
            System.out.println("Desired amount must be a multiple of 10.");
            return new int[0];  // Return an empty array
        }

        int[] sortedBills = Arrays.stream(billsAvailable)
                .boxed()
                .sorted((bill1, bill2) -> Integer.compare(bill2, bill1))
                .mapToInt(Integer::intValue)
                .toArray();

        int[] withdrawBills = new int[sortedBills.length];
        int remainingAmount = desiredAmount;

        for (int i = 0; i < sortedBills.length; i++) {
            int billCount = remainingAmount / sortedBills[i];
            withdrawBills[i] = billCount;
            remainingAmount -= sortedBills[i] * billCount;
        }

        if (remainingAmount != 0) {
            System.out.println("Unable to dispense the desired amount with available bills.");
            return new int[0];  // Return an empty array
        }

        return withdrawBills;
    }

    public static void main(String[] args) {
        int[] billsAvailable = {10, 40, 20, 50};
        int desiredAmount = 330;

        int[] withdrawBills = withdrawAmount(billsAvailable,desiredAmount);
        int count = 0;
        if (withdrawBills.length > 0) {
            System.out.println("Bills returned:");
            for (int i = 0; i < withdrawBills.length; i++) {
                if (withdrawBills[i] > 0) {
                    System.out.println(billsAvailable[i] + " * " + withdrawBills[i]);
                    count += withdrawBills[i];
                }
            }
        }
        System.out.println("No of bills - " + count);
    }
}
