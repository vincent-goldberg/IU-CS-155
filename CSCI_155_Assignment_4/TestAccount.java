/**
 * Demonstrates usage of the Account class.
 * 
 * Creates an account, performs a withdrawal and a deposit, and prints
 * the resulting account information after each operation.
 * 
 * @author Red Team
 * @version 1.0
 * @date 12 July 2025
 */

public class TestAccount {

    public static void main(String[] args) {

        // Create a new account with ID and initial balance
        System.out.println("=== Account Creation ===");
        Account testAccount = new Account(1122, 20000);
        Account.setAnnualInterestRate(4.5);
        System.out.println("Account successfully created.");
        System.out.println(testAccount);

        // Perform a withdrawal and display updated account info
        System.out.println("\n=== Withdrawal ===");
        testAccount.withdraw(2500);
        System.out.println("Withdraw of $2500 complete.");
        System.out.println(testAccount);

        // Perform a deposit and display updated account info
        System.out.println("\n=== Deposit ===");
        testAccount.deposit(3000);
        System.out.println("Deposit of $3000 complete.");
        System.out.println(testAccount);
    }
}

