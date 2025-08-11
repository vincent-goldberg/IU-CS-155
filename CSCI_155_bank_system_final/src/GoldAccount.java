import java.io.Serializable;

/**
 * A gold account that earns a fixed monthly interest rate (5%)
 * and allows unlimited withdrawals (balance can go negative).
 * 
 * Interest is only applied when the balance is positive.
 * No transaction fees apply to Gold accounts.
 *  
 * @author Red Team
 * @version 1.0
 * @since 2025-08-08
 */

public class GoldAccount extends Account implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/** Fixed monthly interest rate for Gold accounts, 5%. */
	private static final double INTEREST_RATE = 0.05;

	/**
	 * Constructs a GoldAccount for a given customer. 
	 * 
	 * @param accountNumber Unique account number; can't be null or blank.
	 * @param customer The account holder; can't be null.
	 * @throws IllegalArgumentException if any argument is invalid.
	 */
	public GoldAccount(String accountNumber, Customer customer) {
		super(accountNumber, customer);
	}
	
	/**
	 * Withdraws the specified amount from the account.
	 * Gold accounts allow overdrawing, so the balance may become negative.
	 * 
	 * @param amount The amount to withdraw; must be positive. 
	 * @throws IllegalArgumentException if the amount is non-positive.
	 */
	@Override
	public void withdraw(double amount) {
		if (amount <= 0) {
			throw new IllegalArgumentException("Withdrawal amount must be positive.");
		}
		balance -= amount;
		
		// Transaction receipt
		System.out.println("\nTransaction completed:\n" + 
				"---> " + String.format("$%.2f", amount) + " withdrawn" +
				"\n---> " + String.format("$%.2f", balance) + " balance");
	}
	
	/**
	 * Applies monthly interest to the current balance.
	 * Interest is only applied if the balance is positive. 
	 */
	@Override
	public void applyMonthlyUpdate() {
		if (balance > 0) {
			balance += balance * INTEREST_RATE;
		}
	}
	
	@Override
	public String toString() {
		return super.toString() +
				"\nAccount type: Gold Account" +
				"\nInterest: " + (INTEREST_RATE * 100);
	}
}
