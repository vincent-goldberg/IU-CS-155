/**
 * Represents a bank branch which services multiple accounts.
 * Each branch has a unique name, a location, and manages a list of associated accounts.
 *  
 * @author Red Team
 * @version 1.0
 * @date 28 July 2025
 */
		 
import java.util.ArrayList;
import java.util.List; 


public class Branch {
	private String name;
	private String location;
	private List<Account> accounts;

    /**
     * Constructs a new Branch with a given name and location.
     *
     * @param name     the name of the branch
     * @param location the physical location of the branch
     */
    public Branch(String name, String location) {
    	this.name = name;
    	this.location = location;
    	this.accounts = new ArrayList<>();
    }

    /**
     * Adds an account to this branch, if it's not already added.
     *
     * @param account the account to associate with this branch
     */
    public void addAccount(Account account) {
    	if (account != null && !accounts.contains(account)) {
    		accounts.add(account);
    	}
    }

    /**
     * Gets the name of the branch.
     *
     * @return the branch name
     */
    public String getName() {
    	return name;
    }
    
    /**
     * Updates the name of the branch.
     *
     * @param name the new name for the branch
     */
    public void setName(String name) {
    	if (name != null && !name.isBlank()) {
    		this.name = name;
    	}
    }

    /**
     * Gets the physical location of the branch.
     *
     * @return the location string
     */
    public String getLocation() {
    	return location;
    }

    /**
     * Sets a new location for the branch.
     *
     * @param location the new branch location
     */
    public void setLocation(String location) {
    	if (location != null && !location.isBlank()) {
    		this.location = location;
    	}
    }

    /**
     * Returns a copy of the accounts serviced by this branch.
     *
     * @return a list of accounts
     */
    public List<Account> getAccounts() {
    	return new ArrayList<>(accounts); // defensive copy
    }
    
    /**
     * Returns a readable summary of the branch.
     *
     * @return formatted branch description
     */
    @Override 
    public String toString() {
    	return "Branch: " + name + " (" + location + ")";
    }
}
