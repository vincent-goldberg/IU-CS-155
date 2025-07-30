/**
 * Abstract base class representing a generic bank customer.
 * All customers have a name, address, phone number, and a list of associated accounts.
 *
 * Subclasses must implement getCustomerInfo() to return customer-specific details.
 *
 * @author Red Team
 * @version 1.0
 * @date 28 July 2025
 */
import java.util.ArrayList;
import java.util.List;

public abstract class Customer {
    private String name;
    private String address;
    private String phone;
    private List<Account> accounts;
	
	/**
     * Constructs a Customer with common identifying information.
     *
     * @param name    customer's name
     * @param address customer's address
     * @param phone   customer's general contact number
     */
	public Customer(String name, String address, String phone) {
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.accounts = new ArrayList<>();
	}
    /**
     * Adds an account to the customer's profile.
     *
     * @param account the account to associate with the customer
     */
	public void addAccount(Account account) {
		if (account != null && !accounts.contains(account)) {
			accounts.add(account);
		}
	}
	
	// Setter methods
    public void setAddress(String address) {
    	if (address != null && !address.isBlank()) {
    		this.address = address;
    	}
    }
    
    public void setPhone(String phone) {
    	if (phone != null && !phone.isBlank()) {
    		this.phone = phone;
    	}
    }
	
	// Getter methods
	public String getName() {
		return name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getPhone() {
		return phone;
	}

    /**
     * Returns a copy of all accounts owned by this customer.
     *
     * @return list of accounts
     */
    public List<Account> getAccounts() {
    	return new ArrayList<>(accounts);
    }
	
    /**
     * Returns a formatted string of customer-specific information.
     * Must be implemented by all subclasses.
     *
     * @return formatted customer info
     */
    public abstract String getCustomerInfo();
    
    @Override
	public String toString() {
		return name;
	}
}

