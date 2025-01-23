import java.util.Scanner;

public class BankATMSimulation {
    static double balance = 1000.0;  
    public static void checkBalance() {
        System.out.println("current balance is:" + balance);
    }

    public static void depositMoney() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter amount to deposit:");
        double depositAmount = scanner.nextDouble();
        if (depositAmount > 0) {
            balance += depositAmount;
            System.out.println("deposited: " + depositAmount);
        } else {
            System.out.println("Invalid ,enter a positive value");
        }
    }

    public static void withdrawMoney() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter amount to withdraw:");
        double withdrawAmount = scanner.nextDouble();

        if (withdrawAmount > 0 && withdrawAmount <= balance) {
            balance -= withdrawAmount;
            System.out.println("withdrawn amount" + withdrawAmount);
        } else if (withdrawAmount > balance) {
            System.out.println("Insufficient amount,current balance is: " + balance);
        } else {
            System.out.println("Invalid ,enter a positive value");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int userChoice;
        while (true) {
            System.out.println("\n--- Bank ATM ---");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Please select an option from 1 to 4: ");
            
            userChoice = scanner.nextInt();
            switch (userChoice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    depositMoney();
                    break;
                case 3:
                    withdrawMoney();
                    break;
                case 4:
                    System.exit(0);  
                    break;
                default:
                    System.out.println("Invalid selection.,Please choose a valid option (1-4).");
            }
        }
    }
}