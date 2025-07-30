/**
 * Represents a savings account with an interest rate.
 * Inherits basic account functionality from Account and adds interest-specific features.
 *
 * Implements getAccountInfo() to return savings account details,
 * and includes a method to calculate and apply interest to the balance.
 * 
 * @author Red Team
 * @version 1.0
 * @date 28 July 2025
 */

public class SavingsAccount extends Account {
	private double interestRate; 
	
	/**
     * Constructs a SavingsAccount with specified parameters.
     *
     * @param accountNumber  the account number
     * @param initialBalance initial deposit
     * @param customer       the owning customer
     * @param branch         the servicing branch
     * @param interestRate   annual interest rate in percentage (e.g., 5.0 for 5%)
     */
	public SavingsAccount(String accountNumber, double initialBalance, Customer customer,
						  Branch branch, double interestRate) {
		super(accountNumber, initialBalance, customer, branch);
		this.interestRate = Math.max(0, interestRate);
	}
	
	// Setter
	public void setInterestRate(double interestRate) {
		if (interestRate >= 0 ) {
			this.interestRate = interestRate;
		}
	}
	
	// Getter
	public double getInterestRate() {
		return interestRate;
	}
	
	/**
     * Applies interest to the current balance.
     * Uses the current interest rate as a percentage.
     */
	public void calculateInterest() {
		double interest = getBalance() * (interestRate / 100);
		makeDeposit(interest);
	}
	
	/**
     * Returns a formatted string with savings account-specific details.
     *
     * @return account summary
     */
	@Override
	public String getAccountInfo() {
		return "\nCustomer: " + getCustomer().getName() +
				"\nSavings Account #: " + getAccountNumber() + 
				"\nBalance: $" + String.format("%.2f", getBalance()) +
				"\nInterest Rate: " + interestRate + "%" +
				"\nBranch: " + getBranch().getName();
	}
	
	@Override
	public String toString() {
		return getAccountInfo(); 
	}
}