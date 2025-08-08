import java.io.IOException;
import java.util.Scanner;

/**
 * Provide a command-line interface for interacting with the Bank system.
 * Allows bankers to perform account operations, view reports, and manage data.
 * 
 * This class serves as the entry point and user-facing component of the program.
 * 
 * @author Red Team
 * @version 1.0 
 * @since 2025-08-08
 */


public class BankSystem {

	private static final String DATA_FILE = "bank_data.ser";
	private final Bank bank;
	private final Scanner scanner;
	
	/**
	 * Constructs a BankSystem and loads any previously saved state.
	 * 
	 */
	public BankSystem() {
		this.scanner = new Scanner(System.in);
		Bank loaded;
		try {
			loaded = Bank.loadFromFile(DATA_FILE);
			System.out.println("Bank data loaded successfully.");
		} catch (Exception e) {
			System.out.println("Starting with a new bank (no saved data found).");
			loaded = new Bank();
		}
		this.bank = loaded;
	}
	
	/**
	 * Starts the main menu loop.
	 */
	public void run() {
		boolean running = true;
		while (running) {
			printMenu();
			String choice = scanner.nextLine().trim();
			switch (choice) {
			case "1" -> createAccount("checking");
			case "2" -> createAccount("gold");
			case "3" -> createAccount("regular");
			case "4" -> deposit();
			case "5" -> withdraw();
			case "6" -> displayAccount();
			case "7" -> removeAccount();
			case "8" -> applyMonthlyUpdates();
			case "9" -> displayStatistics();
			case "10" -> listAccountIds();
			case "11" -> {
				saveAndExit();
				running = false;
			}
			default -> System.out.println("Invalid selection. Please enter a number between 1 and 10.");
			}
		}
	}
	
	private void printMenu() {
		System.out.println("\n===== Bank Menu =====");
        System.out.println("1. Create a Checking account");
        System.out.println("2. Create a Gold account");
        System.out.println("3. Create a Regular account");
        System.out.println("4. Deposit");
        System.out.println("5. Withdraw");
        System.out.println("6. Display account info");
        System.out.println("7. Remove an account");
        System.out.println("8. Apply end-of-month updates");
        System.out.println("9. Display bank statistics");
        System.out.println("10. List all account IDs");
        System.out.println("11. Exit");
        System.out.print("Choose an option: ");
	}
	
	private void createAccount(String type) {
		String accNum = promptForNonEmptyString("\nEnter account number");
		if (accNum == null) return; // User canceled - return to main menu
		
		String customerId = promptForNonEmptyString("\nEnter customer ID");
		if (customerId == null) return; // User canceled - return to main menu
		
		String name = promptForNonEmptyString("\nEnter custoer name");
		if (name == null) return; // User canceled - return to main menu
		
		try {
			Customer customer = new Customer(customerId, name);
			bank.createAccount(type, accNum, customer);
			System.out.println(type + " account created.");
		} catch (IllegalArgumentException e) {
			System.err.println("Error creating account: " + e.getMessage());
		}
	}
	
	private void deposit() {
		String accNum = promptForNonEmptyString("\nEnter account number");
		if (accNum == null) return; // User canceled - return to main menu
		
		double amount = promptForPositiveDouble("\nEnter deposite amount");
		if (amount < 0) return; // User canceled - return to main menu
		
		if (!bank.deposit(accNum, amount)) {
			System.err.println("\nDeposit failed. Account not found.");
		} else {
			System.out.println("\nDeposit successful.");
		}
	}
	
	private void withdraw() {
		String accNum = promptForNonEmptyString("\nEnter account number");
		if (accNum == null) return; // User canceled - return to main menu
		
		double amount = promptForPositiveDouble("\nEnter withdrawal amount");
		if (amount < 0) return; // User canceled - return to main menu
		
		if (!bank.withdraw(accNum, amount)) {
			System.err.println("\nWithdraw failed. Account not found.");
		} else {
			System.out.println("\nWithdrawal complete.");
		}
	}
	
	private void displayAccount() {
		String accNum = promptForNonEmptyString("\nEnter account number");
		if (accNum == null) return;
		
		System.out.println("\n---Review account: " + accNum + "---");
		System.out.println(bank.displayAccountInfo(accNum));
	}
	
	private void removeAccount() {
		String accNum = promptForNonEmptyString("\nEnter account number to remove");
		if (accNum == null) return; // User canceled - return to main menu
		
		boolean removed = bank.removeAccount(accNum);
		System.out.println(removed ? "\nAccount removed." : "\nAccount not found.");
	}
	
	private void applyMonthlyUpdates() {
		bank.applyMonthlyUpdates();
		System.out.println("\nMonthly updates applied.");
	}
	
	/**
	 * Displays all account numbers in bank, or a friendly message if none exists.
	 */
	private void listAccountIds() {
		var ids = bank.getAllAccountNumbers();
		if (ids.isEmpty()) {
			System.out.println("No accounts found.");
			return;
		}
		System.out.println("\nAccounts in bank:");
		for (String id : ids) {
			System.out.println(" - " + id);
		}
				
	}
	
	private void displayStatistics() {
		System.out.println("\n--- Bank Statistics ---");
		System.out.printf("Total balance: $%.2f%n", bank.getTotalBalance());
		System.out.printf("Average balance: $%.2f%n", bank.getAverageBalance());
		System.out.printf("Zero balance accounts: %d%n", bank.getZeroBalanceCount());
		Account largest = bank.getLargestAccount();
		if (largest != null) {
			System.out.println("Account with largest balance:\n" + largest);
		} else {
			System.out.println("No accounts found.");
		}
	}
	
	private void saveAndExit() {
		try {
			bank.saveToFile(DATA_FILE);
			System.out.println("\nBank data saved. Goodbye!");
		} catch (IOException e) {
			System.err.println("\nFailed to save bank data: " + e.getMessage());
		}
	}
	
	// -------- Input helpers methods with retry and cancel support for user --------
	
	private String promptForNonEmptyString(String prompt) {
		while (true) {
			System.out.print(prompt + " or Q to cancel:");
			String input = scanner.nextLine().trim();
			if (input.equalsIgnoreCase("q")) return null;
			if (!input.isBlank()) return input;
			System.out.println("Input cannot be empty");
		}
	}
	
	private double promptForPositiveDouble(String prompt) {
		while (true) {
			System.out.print(prompt + " (or Q to cancel): ");
			String input = scanner.nextLine().trim();
			if (input.equalsIgnoreCase("q")) return -1;
			try {
				double value = Double.parseDouble(input);
				if (value > 0) return value;
				System.out.println("Please enter a positive number.");
			} catch (NumberFormatException e) {
				System.out.println("Invalid number format.");
			}
		}
	}
	
	/**
	 * Main entry point for the application.
	 */
	public static void main(String[] args) {
		new BankSystem().run();
	}
}
