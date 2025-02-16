import java.util.Scanner;
public class Banking {
    static double balance = 0; // Initial balance
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n======= Project Banking =======");
            System.out.println("1. Deposit Money");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Fix Deposit");
            System.out.println("4. View Balance");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    depositMoney(scanner);
                    break;
                case 2:
                    withdrawMoney(scanner);
                    break;
                case 3:
                    fixDeposit(scanner);
                    break;
                case 4:
                    viewBalance();
                    break;
                case 5:
                    System.out.println("Exiting program... Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a valid option.");
            }
        } while (choice != 5);
        scanner.close();
    }
    public static void depositMoney(Scanner scanner) {
        System.out.print("Enter deposit amount: $");
        double amount = scanner.nextDouble();
        if (amount > 0) {
            balance += amount;
            System.out.println(" Deposited $" + amount + " successfully!");
        } else {
            System.out.println(" Invalid deposit amount!");
        }
    }

    public static void withdrawMoney(Scanner scanner) {
        System.out.print("Enter withdrawal amount: $");
        double amount = scanner.nextDouble();

        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println(" Withdrawn $" + amount + " successfully!");
        } else {
            System.out.println(" Insufficient balance or invalid amount!");
        }
    }

public static void fixDeposit(Scanner scanner) {
    if (balance == 0) {
        System.out.println("You cannot open a Fixed Deposit with $0 balance.");
        return;
    }

    System.out.print("Enter Fixed Deposit amount: $");
    double amount = scanner.nextDouble();

    if (amount > balance) {
        System.out.println("Insufficient balance for Fixed Deposit!");
        return;
    }

    System.out.print("Enter number of years: ");
    int years = scanner.nextInt();
    double interestRate;

    // Assign interest rate based on years using if-else
    if (years == 1){
        interestRate = 4.0;
    } else if (years == 2) {
        interestRate = 6.0;
    } else if (years == 3) {
        interestRate = 8.0;
    } else if (years == 4) {
        interestRate = 10.0;
    } else {
        interestRate = 12.0; // 5 or more years
    }

    if (amount > 0 && years > 0) {
        balance -= amount; // Deduct FD amount from balance
        double totalAmount = amount * Math.pow((1 + interestRate / 100), years);

        System.out.println("Fixed Deposit Created!");
        System.out.println("Initial Deposit: $" + amount);
        System.out.println("Interest Rate: " + interestRate + "%");
        System.out.println("Years: " + years);
        System.out.println("Total Amount After " + years + " years: $" + String.format("%.2f", totalAmount));
    } else {
        System.out.println("Invalid Fixed Deposit details!");
    }
}



    public static void viewBalance() {
        System.out.println("\n Current Balance: $" + balance);
    }
}
