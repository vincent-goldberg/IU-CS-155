import java.io.Serializable;

/**
 * Abstract base class for all bank account types.
 * Encapsulates common fields and behavior for checking, gold, and regular accounts.
 *
 * @author Red Team
 * @version 1.0
 * @since 2025-08-07
 */
public abstract class Account implements Serializable {
    private static final long serialVersionUID = 1L; // Fixed capital "L"

    /** Unique account number (immutable once created). */
    protected final String accountNumber;
  
    /** Current balance in the account. */
    protected double balance;

    /** Customer who owns the account. */
    protected final Customer customer;

    /**
     * Constructs an Account with the specified account number and customer.
     *
     * @param accountNumber unique account number; must not be null or blank
     * @param customer      associated customer; must not be null
     * @throws IllegalArgumentException if parameters are invalid
     */
    public Account(String accountNumber, Customer customer) {
        if (accountNumber == null || accountNumber.isBlank()) {
            throw new IllegalArgumentException("Account number cannot be null or empty.");
        }
        if (customer == null) {
            throw new IllegalArgumentException("Customer cannot be null.");
        }
        this.accountNumber = accountNumber.trim();
        this.customer = customer;
        this.balance = 0.0;
    }
    
    /** @return the account number */
    public String getAccountNumber() {
        return accountNumber;
    }

    /** @return the current account balance */
    public double getBalance() {
        return balance;
    }

    /** @return the customer associated with this account */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Deposits the specified amount into the account.
     *
     * @param amount amount to deposit; must be positive
     * @throws IllegalArgumentException if amount is non-positive
     */
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive.");
        }
        balance += amount;
        
     // Transaction receipt
	System.out.println("\nTransaction completed:\n" + 
			"---> " + String.format("$%.2f", amount) + " withdrawn" +
			"\n---> " + String.format("$%.2f", balance) + " balance");
    }

    /**
     * Withdraws funds from the account.
     * Must be implemented by subclasses to enforce account-specific rules.
     *
     * @param amount amount to withdraw
     */
    public abstract void withdraw(double amount);

    /**
     * Applies account-specific monthly interest or fees.
     */
    public abstract void applyMonthlyUpdate();

    /**
     * Checks if this account's number matches the given account number.
     *
     * @param accNum account number to compare
     * @return true if account numbers match
     */
    public boolean matchesAccountNumber(String accNum) {
        return accountNumber.equals(accNum);
    }

    @Override
    public String toString() {
        return "Account: " + accountNumber +
        		"\nAccount Onwer: " + customer.toString() +
               "\nBalance: $" + String.format("%.2f", balance);
    }
}
