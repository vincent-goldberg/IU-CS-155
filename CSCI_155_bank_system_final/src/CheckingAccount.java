import java.io.Serializable;

/**
 * A checking account with transaction fees after a set number of free transactions.
 * 
 *  First two transactions each month are free; subsequent transaction incurs fixed fee.
 *  No interest is applied. Withdrawals are limited to available funds. 
 *  
 *  @author Red Team
 *  @version 1.0
 *  @since 2025-08-08
 */

public class CheckingAccount extends Account implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/** Number of free transactions per month. */
	private static final int FREE_TRANSACTIONS = 2;
	
	/** Fee charged for each transaction beyond the free limit. */
	private static final double TRANSACTION_FEE = 3.0;
	
	/** Counter for transaction this month (deposit or withdrawal). */
	private int transactionCount;

	/**
	 * Constructs a CheckingAccount for a given customer. 
	 * Initializes the transaction count to 0.
	 * 
	 * @param accountNumber Unique account number; can't be null or blank.
	 * @param customer The account holder; can't be null.
	 * @throws IllegalArgumentException if any argument is invalid.
	 */
	public CheckingAccount(String accountNumber, Customer customer) {
		super(accountNumber, customer);
		this.transactionCount = 0;
	}
	
	/**
	 * Deposits a specified positive amount into the account. 
	 * Increments the monthly transaction count.
	 * 
	 * @param amount The amount to deposit; must be positive. 
	 * @throws IllegalArgumentException if amount is non-positive.
	 */
	@Override
	public void deposit(double amount) {
		if (amount <= 0) {
			throw new IllegalArgumentException("Deposit amount must be positive.");
		}
		balance += amount;
		transactionCount ++;
	}
	
	/**
	 * Withdraws funds from the account, up to the available balance. 
	 * If the requested amount exceeds balance, withdraws only what is available. 
	 * Increments the monthly transaction count. 
	 * 
	 * @param amount The requested withdrawal amount; must be positive. 
	 * @throws IllegalArgumentException if amount is non-positive. 
	 */
	@Override
	public void withdraw(double amount) {
		if (amount <= 0) {
			throw new IllegalArgumentException("Withdrawal amount must be positive.");
		}
		double amountToWithdraw = Math.min(amount, balance); // can't withdraw more than available
		balance -= amountToWithdraw;
		transactionCount ++;
	}
	
	/**
	 * Applies monthly fees based on the number of transactions. 
	 * The first two are free; each additional costs $3.
	 * Fees are deducted from the balance without letting it go negative.
	 * Resets the transaction count for the new month.
	 */
	@Override 
	public void applyMonthlyUpdate() {
		if (transactionCount > FREE_TRANSACTIONS) {
			int extraTransactions = transactionCount - FREE_TRANSACTIONS;
			double totalFees = extraTransactions * TRANSACTION_FEE;
			
			// Deduct fees without letting balance go negative
			balance = Math.max(0, balance-totalFees);
		}
		transactionCount = 0;
	}
	
	@Override
	public String toString() {
		return super.toString() + " [Checking Account, Transactions this month: " + transactionCount + "]";
				
	}
}