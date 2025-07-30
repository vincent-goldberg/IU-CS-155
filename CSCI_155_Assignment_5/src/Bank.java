/*
 * Test driver for the banking system. 
 * Demonstrates functionality of customers, branches, and accounts
 * 
 * @author Red Team
 * @version 1.0
 * @date 30 July 2025
 */
import java.util.ArrayList;

public class Bank {

	public static void main(String[] args) {
		ArrayList<Account> allAccounts = new ArrayList<>();
		
		System.out.println("\n--- Commercial Banking ---\n");
		
		// 1. Create Chicago branch and commercial customer
		Branch chicagoBranch = new Branch("Chicago Central", "Chicago, Il");
		Customer bizCustomer = new CommercialCustomer(
				"Tech Corp", "456 Market St", "312-555-0123",
				"A", "Jordan Smith", "312-555-0456"
				);
		Account checking = new CheckingAccount(
				"CHK101", 500.0, bizCustomer,
				chicagoBranch, "Business", 100.0
				);
		bizCustomer.addAccount(checking);
		chicagoBranch.addAccount(checking);
		allAccounts.add(checking);
		
		// 2. Display Customer info and account balance
		displayCustomerInfo(checking);
		
		// 3. Deposit $100 and show updated info
		checking.makeDeposit(100.0);
		System.out.println("\n---> After depositing $100\n");
		displayCustomerInfo(checking);
		
		System.out.println("\n--- Personnal Banking ---\n");
		
		// 4. Create person customer and savings account in another branch
		Branch springBranch = new Branch("Springfield Branch", "Springfield, Il");
		Customer personalCustomer = new PersonalCustomer(
				"Jane Doe", "789 Elm St", "217-555-0198",
				"217-555-2222", "217-555-3333"
				);
		Account savings = new SavingsAccount("SAV2001", 100.0, personalCustomer, springBranch, 10.0);
		personalCustomer.addAccount(savings);
		springBranch.addAccount(savings);
		allAccounts.add(savings);
		
		// 5. Display savings account info
		System.out.println("\nSavings Account Info:");
		System.out.println(savings.getAccountInfo());
		
		// 6. Deposit $100, calculate interest, display info
		savings.makeDeposit(100.0);		
		System.out.println("\n---> After depositing $100\n");
		System.out.println(savings.getAccountInfo());
		if (savings instanceof SavingsAccount) {
			double earned = ((SavingsAccount) savings).calculateInterest();
			System.out.println("\n---> Balance after adding your earned interest of: $" + String.format("%.2f", earned));
		}
		System.out.println(savings.getAccountInfo());
		
		// 7. Print all accounts
		System.out.println("\n--- All Accounts in Bank System ---\n");
		for (Account acc : allAccounts) {
			System.out.println(acc.getAccountInfo());
			System.out.println("----------");
		}
	}
	
	/**
	 * Display the customer's name and current account balance.
	 * 
	 * @param account the account to display
	 */
	public static void displayCustomerInfo(Account account) {
		System.out.println("Customer Info:" );
		System.out.println(account.getCustomer().getCustomerInfo());
		System.out.println("Balance: $" + String.format("%.2f", account.getBalance()));
	}

}
