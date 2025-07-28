/**
 * Represents a checking account with a minimum balance and check style.
 * Inherits basic account behavior from Account and adds account-specific attributes.
 * 
 * Implements getAccountInfo() to return formatted checking account details.
 * 
 * @author Red Team
 * @version 1.0
 * @date 28 July 2025
 */

public class CheckingAccount extends Account {
	private String checkStyle; 
	private double minimumBalance;
	
	/**
     * Constructs a CheckingAccount with all required details.
     *
     * @param accountNumber  the account number
     * @param initialBalance the initial deposit amount
     * @param customer       the owning customer
     * @param branch         the branch servicing this account
     * @param checkStyle     the type/style of checks for this account
     * @param minimumBalance the required minimum balance
    
     */
	public CheckingAccount(String accountNumber, double initialBalance, Customer customer,
						   Branch branch, String checkStyle, double minimumBalance) {
		super(accountNumber, initialBalance, customer, branch);
		this.checkStyle = (checkStyle != null && !checkStyle.isBlank() ? checkStyle : "Standard");
		this.minimumBalance = minimumBalance;
	}
	
	// Setters
	public void setCheckStyle(String checkStyle) {
		if (checkStyle != null && !checkStyle.isBlank()) {
			this.checkStyle = checkStyle;
		}
	}
	
	public void setMinimumBalance(double minimumBalance) {
		if (minimumBalance >= 0) {
			this.minimumBalance = minimumBalance;
		}
	}
	
	// Getters
	public String getCheckStyle() {
		return checkStyle;
	}
	
	public double getMinimumBalance() {
		return minimumBalance;
	}
	
	/**
     * Returns a formatted string with checking account-specific details.
     *
     * @return account summary
     */
	@Override
	public String getAccountInfo() {
		return  "Customer: " + getCustomer().getName() +
				"\nChecking Account #: " + getAccountNumber() +
				"\nBalance: $" + String.format("%.2f", getBalance()) +
				"\nMinimum Balance: $" + String.format("%.2f", minimumBalance) +
				"\nCheck Style: " + checkStyle + 
				"\nOpened: " + getDateOpened() +
				"\nBranch: " + getBranch().getName();	}
	
}