/**
 * Demonstrates usage of the Account class.
 * 
 * Creates an account, performs a withdrawal and a deposit, and prints
 * the resulting account information after each operation.
 * 
 * @author Red Team
 * @version 1.0
 * @date 12 July 2025
 */

public class TestAccount {

    public static void main(String[] args) {
		
        //Create an Account object with ID 1122 and an initial balance of $20,000
        Account myAccount = new Account(1122, 20000.00);

        // Since Interest Rate is static, we call the method on the class itself.
        Account.setAnnualInterestRate(4.5);
        
        //Show account initialized correctly:
        System.out.println("--- Account Setup ---");
        System.out.println("Account ID: " + myAccount.getId());
        System.out.println("Initial Balance: $" + String.format("%.2f", myAccount.getBalance()));
        System.out.println("Annual Interest Rate: " + Account.getAnnualInterestRate() + "%");
        System.out.println("Account created on: " + myAccount.getDateCreated());
        System.out.println("---------------------\n");

		//Use the withdraw method to withdraw $2,500, use the deposit method to deposit $3,000. 
		//Print the balance, the monthly interest, and the date when this account was created.
        
        //Demonstrate a withdrawal.
        double withdrawAmount = 2500.00;
        System.out.println("--- Performing Withdrawal ---");
        //Show new balance.
        myAccount.withdraw(withdrawAmount); 
        System.out.println("-----------------------------\n");

        //Demonstrate a withdrawal for more than balance.
        double largeWithdrawAmount = 100000.00;
        System.out.println("--- Attempting Large Withdrawal ---");
        //Inform user of error.
        myAccount.withdraw(largeWithdrawAmount);
        System.out.println("-----------------------------------\n");
        
        //Demonstrate a deposit
        double depositAmount = 3000.00;
        System.out.println("--- Performing Deposit ---");
        myAccount.deposit(depositAmount); 
        System.out.println("--------------------------\n");
        
        //Display current balance:
        System.out.println("--- Account Balance ---");
        System.out.println("Current Balance: $" + String.format("%.2f", myAccount.getBalance()));
        System.out.println("-----------------------\n");
        
        //Calculate and display monthly interest
        System.out.println("--- Interest Calculation ---");
        System.out.println("Monthly Interest Rate (decimal): " + String.format("%.6f", Account.getMonthlyInterestRate()));
        System.out.println("Monthly Interest Amount: $" + String.format("%.2f", myAccount.getMonthlyInterest()));
        System.out.println("----------------------------\n");
        
        //Display age of account.
        System.out.println("--- Account Age ---");
        System.out.println("Account created on: " + myAccount.getDateCreated());
        System.out.println("-------------------\n");

        //Demonstrate functionality for changing the annual interest rate
        System.out.println("--- Changing Annual Interest Rate ---");
        Account.setAnnualInterestRate(4.0);
        System.out.println("New Annual Interest Rate: " + Account.getAnnualInterestRate() + "%");
        System.out.println("New Monthly Interest Rate (decimal): " + String.format("%.6f", Account.getMonthlyInterestRate()));
        System.out.println("New Monthly Interest Amount: $" + String.format("%.2f", myAccount.getMonthlyInterest()));
        System.out.println("-------------------------------------\n");
    }
}

