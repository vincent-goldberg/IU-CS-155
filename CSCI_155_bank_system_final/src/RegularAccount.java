import java.io.Serializable;

/**
 * A regular account that earns monthly interest (6%) and incurs a monthly fee.
 * Withdrawals are capped at the available balance; no overdraft. 
 * 
 * @author Red Team
 * @version 1.0
 * @since 2025-08-08
 */

public class RegularAccount extends Account implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/** Monthly interest rate for Regular accounts, 6%. */
	private static final double INTEREST_RATE = 0.06;
	
	/** Monthly maintenance fee for Regular accounts. */
	private static final double MAINTENANCE_FEE = 10.0;

	/**
	 * Constructs a RegaularAccount for a given customer.
	 * 
	 * @param accountNumber Unique account number; can't be null or blank.
	 * @param customer The account holder; can't be null.
	 * @throws IllegalArgumentException if any argument is invalid.
	 */
	public RegularAccount(String accountNumber, Customer customer) {
		super(accountNumber, customer);
	}
	
	/**
	 * Withdrawals the specified amount, up to the available balance.
	 * No overdraft allowed.
	 * 
	 * @param amount The amount to withdraw; must be positive.
	 * @throws IllegalArgumentException if the amount is non-positive
	 */
	@Override
	public void withdraw(double amount) {
		if (amount <=0) {
			throw new IllegalArgumentException("Withdrawal amount must be positive.");
		}
		double amountToWithdraw = Math.min(amount, balance);
		if (amountToWithdraw < amount) {
			System.out.println("\nNote: Insufficient funds; only " + String.format("$%.2f", amountToWithdraw) + " withdrawn.");
		}
		balance -= amountToWithdraw;
		
		// Transaction receipt
		System.out.println("\nTransaction completed:\n" + 
				"---> " + String.format("$%.2f", amountToWithdraw) + " withdrawn" +
				"\n---> " + String.format("$%.2f", balance) + " balance");
	}
	
	/**
	 * Applies monthly interest and deducts the maintenance fee.
	 * Interest is only applied if balance is positive.
	 * The maintenance fee is always deducted and may drive the balance negative.
	 */
	@Override
	public void applyMonthlyUpdate() {
		if (balance > 0) {
			balance += balance * INTEREST_RATE;
		}
		balance -= MAINTENANCE_FEE;
	}
	
	@Override
	public String toString() {
		return super.toString() + 
				"\nAccount type: Regular Account" +
				"\nInterest: " + (INTEREST_RATE * 100) + "%" + 
				"\nMaintenance Fee: $" + MAINTENANCE_FEE;
	}
}
