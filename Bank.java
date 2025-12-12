import java.util.Scanner;

class BankAccount {

    String name;
    double balance;
    long accountNumber;
    

    void createAccount(String accName, long accNum, double initialAmount) {
        name = accName;
        accountNumber = accNum;
        balance = initialAmount;

        System.out.println("\n Account Created Successfully!");
        System.out.println("Account Holder : " + name);
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Initial Balance: ₹" + balance);
    }

    void deposit(double amount) {
        if (amount > 0) {
            balance = balance + amount;
            System.out.println("₹" + amount + " deposited successfully.");
        } else {
            System.out.println("Deposit amount must be positive!");
        }
    }

    void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance = balance - amount;
            System.out.println("₹" + amount + " withdrawn successfully.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance!");
        } else {
            System.out.println("Invalid withdrawal amount!");
        }
    }

    void checkBalance() {
        System.out.println("\n--- ACCOUNT DETAILS ---");
        System.out.println("Account Holder : " + name);
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Current Balance: ₹" + balance);
    }
}

public class Bank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount account = new BankAccount();

        System.out.println("=== Bank Balance & Transaction Tracker ===");

        System.out.print("Enter your Account Number: ");
        long accNum = sc.nextLong();
        sc.nextLine(); 

        System.out.print("Enter your Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Initial Deposit: ₹");
        double amount = sc.nextDouble();

        account.createAccount(name, accNum, amount);

        int choice;
        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Deposit Money");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            if (choice == 1) {
                System.out.print("Enter deposit amount: ₹");
                double dep = sc.nextDouble();
                account.deposit(dep);
            } 
            else if (choice == 2) {
                System.out.print("Enter withdrawal amount: ₹");
                double wd = sc.nextDouble();
                account.withdraw(wd);
            } 
            else if (choice == 3) {
                account.checkBalance();
            } 
            else if (choice == 4) {
                System.out.println("Thank you for using our Bank Tracker!");
            } 
            else {
                System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 4);

        sc.close();
    }
}
