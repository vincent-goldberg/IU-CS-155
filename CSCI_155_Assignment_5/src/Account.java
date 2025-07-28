/**
 * Abstract base class representing a generic bank account.
 * Shared by both checking and savings accounts. 
 * Defines common fields and behavior such as deposit, withdrawal, and account identification.
 *
 * Subclasses must implement getAccountInfo() to return account-specific details.
 * 
 * @author Red Team
 * @version 1.0
 * @date 28 July 2025
 */
import java.time.LocalDate;

public abstract class Account {
	private String accountNumber;
	private double balance;
	private LocalDate dateOpened;
	private Customer customer;
	private Branch branch;
	
	/**
     * Constructs a new account and sets the opening date to today.
     *
     * @param accountNumber unique identifier for the account
     * @param initialBalance starting balance for the account
     * @param customer the account owner
     * @param branch the servicing branch
     */
	public Account(String accountNumber, double initialBalance, Customer customer, Branch branch) {
		this.accountNumber = accountNumber;
		this.balance = Math.max(0, initialBalance);
		this.customer = customer;
		this.branch = branch; 
		this.dateOpened = LocalDate.now();
	}
	
	/**
     * Deposits a positive amount into the account.
     *
     * @param amount the deposit amount
     */
	public void makeDeposit(double amount) {
		if (amount > 0) {
			balance += amount;
		}
	}
	
	 /**
     * Withdraws a positive amount if sufficient funds exist.
     *
     * @param amount the amount to withdraw
     */
	public void makeWithdrawal(double amount) {
		if (amount > 0 && amount <= balance) {
			balance -= amount;
		}
	}
	
	// Getters
	public String getAccountNumber() {
		return accountNumber;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public LocalDate getDateOpened() {
		return dateOpened;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	
	public Branch getBranch() {
		return branch;
	}
	
	// Setter
	public void setBranch(Branch branch) {
		if (branch != null) {
			this.branch = branch;
		}
	}
	
	/**
     * Returns a formatted string of account-specific details.
     * Must be implemented by subclasses.
     *
     * @return formatted account info
     */
	public abstract String getAccountInfo();
	
	/**
     * Returns a brief account summary.
     *
     * @return string summary of the account
     */
	@Override
	public String toString() {
		return "Account #: " + accountNumber +
				"\nBalance: $" + String.format("%.2f", balance) +
				"\nOpened: " + dateOpened +
				"\nBranch: " + (branch != null ? branch.getName() : "N/A");
	}
}
