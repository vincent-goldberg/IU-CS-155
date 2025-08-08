/**
 * Abstract base class for all bank account types. 
 * Encapsulates common fields and behavior for checking, gold, and regular accounts. 
 * 
 * @author Red Team
 * @version 1.0
 * @date  7 August 2025
 */
import java.io.Serializable;

public abstract class Account implements Serializable {
	private static final long serialVersionUID = 1l;
	
	protected String accountNumber;
	protected double balance;
	protected Customer customer; 
	
	/**
	 * Constructs an Account with the specified account number and customer.
	 * 
	 * @param accountNumber Unique account number. Must not be null or empty.
	 * @param customer Associated customer. Must not be null. 
	 * @throws IllegalArgumentException if parameters are invalid. 
	 */
	public Account(String accountNumber, Customer customer) {
		if (accountNumber == null || accountNumber.isBlank()) {
			throw new IllegalArgumentException("Account number cannot be null or empty.");
		}
		if (customer ==null) {
			throw new IllegalArgumentException("Custommer cannot be null.");
		}
		this.accountNumber = accountNumber;
		this.customer = customer;
		this.balance = 0.0;
	}
	
	// Getters
	public String getAccountNumber() {
		return accountNumber;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	
	/**
	 * Deposits the specified amount into the account.
	 * Ignores zero or negative amounts.
	 * 
	 * @param amount Amount to deposit.
	 * @throws IllegalArgumentException if amount is non-positive.
	 */
	public void deposit(double amount) {
		if (amount <= 0) {
			throw new IllegalArgumentException("Deposit amount must be positive.");
		}
		balance += amount;
	}
	
	/**
	 * Applies account-specific monthly interest or fees.
	 */
	public abstract void applyMonthlyUpdate();
	
	/**
	 * Checks if the account number matches the given input.
	 * 
	 * @param accNum Account number to compare.
	 * @return true if account numbers match.
	 */
	public boolean matchesAccountNumber(String accNum) {
		return this.accountNumber.equals(accNum);
	}
	
	@Override
	public String toString() {
		return "Account Number: " + accountNumber + 
				", Balance: $" + String.format("%.2f", balance) +
				", " + customer.toString();
	}
	
}	
	














