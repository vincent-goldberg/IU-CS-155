import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Represents a bank containing customer accounts and provides core operations
 * such as creating accounts, transactions, monthly updates, and reporting. 
 * Also supports saving/loading state for long-term persistence.
 * 
 * This class is the central logic manager for the system.
 * 
 * @author Red Team
 * @version 1.0
 * @since 2025-08-08
 */

public class Bank implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/** List of all accounts in the bank. */
	private final List<Account> accounts;
	
	/** Constructs a new Bank with no accounts. */
	public Bank() {
		this.accounts = new ArrayList<>();
	}
	
	/**
	 * Creates a new account of the specified type and adds it to bank.
	 * 
	 * @param type "checking", "gold", "regular" (case-insensitive)
	 * @param accountNumber The unique account number. 
	 * @param customer The customer who owns the account.
	 * @throws IllegalArgumentException if type is invalid or inputs are null/empty
	 */
	public void createAccount(String type, String accountNumber, Customer customer) {
		if (type == null || type.isBlank() || accountNumber == null || accountNumber.isBlank() || customer == null) {
			throw new IllegalArgumentException("Type, account number, and customer cannot be null.");
		}
		Account newAccount;
		switch (type.toLowerCase()) {
		case "checking":
			newAccount = new CheckingAccount(accountNumber, customer);
			break;
		case "gold":
			newAccount = new GoldAccount(accountNumber, customer);
			break;
		case "regular":
			newAccount = new RegularAccount(accountNumber, customer);
			break;
		default:
			throw new IllegalArgumentException("Invalid account type: " + type);
		}
		accounts.add(newAccount);
	}
	
	/**
	 * Removes an account from the bank by account number.
	 * 
	 * @param accountNumber the account number to remove.
	 * @return true if removed successfully, false if not.
	 */
	public boolean removeAccount(String accountNumber) {
		Account acc = findAccount(accountNumber);
		if (acc != null) {
			return accounts.remove(acc);
		}
		return false;
	}
	
	/**
	 * Deposits a specified amount to the given account.
	 * 
	 * @param accountNumber The account number. 
	 * @param amount The amount to deposit.
	 * @return true if successful; false if account not found.
	 */
	public boolean deposit(String accountNumber, double amount) {
		Account acc = findAccount(accountNumber);
		if (acc == null) {
			System.err.println("Warning: Deposit failed. Account not found: " + accountNumber);
			return false;
		}
		acc.deposit(amount);
		return true;
	}
	
	/**
	 * Withdraws a specified amount from the given account. 
	 * 
	 * @param accountNumber The account number. 
	 * @param amount The amount to withdraw.
	 * @return true if successful; false if account not found.
	 */
	public boolean withdraw(String accountNumber, double amount) {
		Account acc = findAccount(accountNumber);
		if (acc == null) {
			System.err.println("Warning: Withdraw failed. Account not found: " + accountNumber);
			return false;
		}
		acc.withdraw(amount);
		return true;
	}
	
	/**
	 * Returns an unmodifiable, alphabetically sorted list of all account numbers.
	 * 
	 * @return immutable list of account numbers (may be empty)
	 */
	public List<String> getAllAccountNumbers() {
		List <String> ids = new ArrayList<>();
		for (Account acc : accounts) {
			ids.add(acc.getAccountNumber());
		}
		Collections.sort(ids);
		return Collections.unmodifiableList(ids);
	}
	
	/**
	 * Displays the details of a specific account.
	 * 
	 * @param accountNumber the account number. 
	 * @return the account's toString() output or not found message.
	 */
	public String displayAccountInfo(String accountNumber) {
		Account acc = findAccount(accountNumber);
		return acc != null ? acc.toString() : ("Account: " + accountNumber + " not found.");
	}
	
	/** Applies monthly updates (interest or fees) to all accounts. */
	public void applyMonthlyUpdates() {
		for (Account acc : accounts) {
			acc.applyMonthlyUpdate();
		}
	}
	
	/** @return the total combined balance of all accounts. */
	public double getTotalBalance() {
		return accounts.stream().mapToDouble(Account::getBalance).sum();
	}
	
	/** @return the average balance of all accounts (0 if none exist). */
	public double getAverageBalance() {
		if (accounts.isEmpty()) return 0.0;
		return getTotalBalance() / accounts.size();
	}
	
	/** @return the number of accounts with zero balance. */
	public int getZeroBalanceCount() {
		return (int) accounts.stream().filter(acc -> acc.getBalance() == 0.0).count();
	}
	
	/** @return the account with largest balance, or null if no accounts exist. */
	public Account getLargestAccount() {
		return accounts.stream().max(Comparator.comparingDouble(Account::getBalance)).orElse(null);
	}
	
	/** Save the current bank object to a file. */
	public void saveToFile(String filename) throws IOException {
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
			out.writeObject(this);
		}
	}
	
	/** Loads a bank object from a file. */
	public static Bank loadFromFile(String filename) throws IOException, ClassNotFoundException {
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
			return (Bank) in.readObject();
		}
	}
	
	/** Searches for an account by account number. */
	private Account findAccount(String accountNumber) {
		return accounts.stream()
				.filter(acc -> acc.matchesAccountNumber(accountNumber))
				.findFirst()
				.orElse(null);
	}
}