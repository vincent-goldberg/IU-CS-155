import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Represents a bank account with ID, balance, and interest rate.
 * Includes methods for deposit, withdrawal, and interest calculation.
 * 
 * @author Red Team
 * @version 1.0
 * @date 12 July 2025
 */
public class Account {
    
    // Instance data fields
    private int id = 0;
    private double balance = 0;
    private static double annualInterestRate = 0; // Shared across all accounts
    private LocalDateTime dateCreated;

    /**
     * Default constructor that creates an account with default values.
     */
    public Account() {
        this.dateCreated = LocalDateTime.now();
    }

    /**
     * Constructs an account with the specified ID and balance.
     * @param id The account ID.
     * @param balance The initial balance.
     */
    public Account(int id, double balance) {
        this.id = id;
        this.balance = balance;
        this.dateCreated = LocalDateTime.now();
    }

    // Getters

    /**
     * Returns the account ID.
     * @return The ID.
     */
    public int getId() {
        return this.id;
    }

    /**
     * Returns the account balance.
     * @return The balance.
     */
    public double getBalance() {
        return this.balance;
    }

    /**
     * Returns the annual interest rate for all accounts.
     * @return The annual interest rate.
     */
    public static double getAnnualInterestRate() {
        return annualInterestRate;
    }

    /**
     * Returns the date and time the account was created.
     * @return The creation date.
     */
    public LocalDateTime getDateCreated() {
        return this.dateCreated;
    }

    /**
     * Returns the monthly interest rate.
     * @return The monthly interest rate.
     */
    public double getMonthlyInterestRate() {
        return annualInterestRate / 12;
    }

    /**
     * Returns the monthly interest amount.
     * @return The monthly interest in dollars.
     */
    public double getMonthlyInterest() {
        return this.balance * (getMonthlyInterestRate() / 100);
    }

    // Setters

    /**
     * Sets the account ID.
     * @param id The new ID.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Sets the annual interest rate shared across all accounts.
     * @param rate The annual interest rate.
     */
    public static void setAnnualInterestRate(double rate) {
        annualInterestRate = rate;
    }

    // Core operations

    /**
     * Withdraws the specified amount if sufficient balance exists.
     * @param amount The amount to withdraw.
     */
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
        } else if (amount > this.balance) {
            System.out.println("Insufficient balance.");
        } else {
            this.balance -= amount;
        }
    }

    /**
     * Deposits the specified amount to the account.
     * @param amount The amount to deposit.
     */
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be positive.");
        } else {
            this.balance += amount;
        }
    }

    /**
     * Returns a formatted string representing the account's state.
     * @return A string containing account details.
     */
    @Override
    public String toString() {
        return String.format(
            "Account ID: %d%nBalance: $%.2f%nMonthly Interest: $%.2f%nCreated On: %s",
            this.id,
            this.balance,
            getMonthlyInterest(),
            this.dateCreated.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
        );
    }
}
