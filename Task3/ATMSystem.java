package Task3;
import java.util.Scanner;

public class ATMSystem {
    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.addAccount(12345, 1000.0);
        atm.run();
    }
}

class ATM {
    private BankAccount[] accounts;
    private int accountCount;
    private Scanner scanner;

    public ATM() {
        this.accounts = new BankAccount[10]; // Assume max 10 accounts
        this.accountCount = 0;
        this.scanner = new Scanner(System.in);
    }

    public void addAccount(int accountNumber, double initialBalance) {
        if (accountCount < accounts.length) {
            accounts[accountCount] = new BankAccount(accountNumber, initialBalance);
            accountCount++;
        } else {
            System.out.println("Cannot add more accounts. Limit reached.");
        }
    }

    public void run() {
        System.out.println("Welcome to the ATM");
        System.out.print("Enter your account number: ");
        int accountNumber = scanner.nextInt();

        BankAccount account = findAccount(accountNumber);
        if (account == null) {
            System.out.println("Account not found. Exiting...");
            return;
        }

        boolean running = true;
        while (running) {
            displayMenu();
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance(account);
                    break;
                case 2:
                    deposit(account);
                    break;
                case 3:
                    withdraw(account);
                    break;
                case 4:
                    running = false;
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private BankAccount findAccount(int accountNumber) {
        for (int i = 0; i < accountCount; i++) {
            if (accounts[i].getAccountNumber() == accountNumber) {
                return accounts[i];
            }
        }
        return null;
    }

    private void displayMenu() {
        System.out.println("\nPlease choose an option:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    private void checkBalance(BankAccount account) {
        System.out.printf("Your current balance is: $%.2f\n", account.getBalance());
    }

    private void deposit(BankAccount account) {
        System.out.print("Enter the amount to deposit: $");
        double amount = scanner.nextDouble();
        if (amount <= 0) {
            System.out.println("Invalid amount. Deposit amount must be positive.");
            return;
        }
        account.deposit(amount);
        System.out.printf("Deposit successful. Your new balance is: $%.2f\n", account.getBalance());
    }

    private void withdraw(BankAccount account) {
        System.out.print("Enter the amount to withdraw: $");
        double amount = scanner.nextDouble();
        if (amount <= 0) {
            System.out.println("Invalid amount. Withdrawal amount must be positive.");
            return;
        }
        if (account.getBalance() < amount) {
            System.out.println("Insufficient funds. Withdrawal canceled.");
            return;
        }
        account.withdraw(amount);
        System.out.printf("Withdrawal successful. Your new balance is: $%.2f\n", account.getBalance());
    }
}

class BankAccount {
    private int accountNumber;
    private double balance;

    public BankAccount(int accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }
}
