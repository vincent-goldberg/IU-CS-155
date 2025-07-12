import java.util.Scanner;

/**
 * Manages a set of 8 bank accounts and provides a console interface
 * for users to interact with them based on ID.
 * 
 * @author Red Team
 * @version 1.0
 * @date 12 July 2025
 */

public class UserAccounts {
	private Account[] accounts = new Account[8];
	
	/**
     * Initializes 8 accounts with IDs 0 through 7 and balance $50 each.
     */
	public UserAccounts() {
		for (int i = 0; i < accounts.length; i++) {
			accounts[i] = new Account(i, 50.0);
		}
	}
	
	/**
     * Starts the interactive console session for users.
     */
	public void run() {
		Scanner scanner = new Scanner(System.in);
		
		while (true) {
			System.out.print("Enter an id: ");
			int id = scanner.nextInt();
			
			if (id < 0 || id >= accounts.length) {
				System.out.println("Invalid ID. Please try again.");
				continue;
			}
			
			Account currentAccount = accounts[id];
			int choice;
			
			do {
				System.out.printf("%nMain menu for Account ID: %d%n", currentAccount.getId());
                System.out.println("1: check balance");
                System.out.println("2: withdraw");
                System.out.println("3: deposit");
                System.out.println("4: exit");
                System.out.print("\nEnter a choice: ");
                choice = scanner.nextInt();
                
                switch (choice) {
                	case 1:
                		System.out.printf("The balance is $%.2f%n", currentAccount.getBalance());
                		break;
                	case 2:
                		System.out.print("Enter an amount to withdraw: ");
                		double withdrawAmt = scanner.nextDouble();
                		currentAccount.withdraw(withdrawAmt);
                		break;
                	case 3:
                		System.out.print("Enter an amount to deposit: ");
                		double depositAmt = scanner.nextDouble();
                		currentAccount.deposit(depositAmt);
                		break;
                	case 4:
                		System.out.println("\nExiting to ID prompt...\n");
                		break;
            		default:
            			System.out.println("Invalid choice. Please try again.");
                	
                }
			} while (choice != 4);
		}
		
	}
	/**
     * Launches the UserAccounts interactive session.
     */
    public static void main(String[] args) {
        UserAccounts manager = new UserAccounts();
        manager.run();
    }
}






