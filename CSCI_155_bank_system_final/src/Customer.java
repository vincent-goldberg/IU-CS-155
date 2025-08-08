/**
 * Represents a bank customer. 
 * Stores identifying information such as ID and name. 
 * 
 * @author Red Team
 * @version 1.0
 * @date  7 August 2025
 */
import java.io.Serializable;

/**
 * 
 */
/**
 * 
 */
/**
 * 
 */
public class Customer implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String customerId;
	private String name;
	
	/**
	 * Constructs a Customer object with the given ID and name.
	 * @param customerId Unique identified for the customer. 
	 * @param name Name of the customer. 
	 * @throws IllegalArgumentException if inputs are invalid.
	 */
	public Customer(String customerId, String name) {
		if (customerId == null || customerId.isBlank()) {
			throw new IllegalArgumentException("Customer ID cannot be null or empty.");
		}
		if (name == null || name.isBlank()) {
			throw new IllegalArgumentException("Customer name cannot be null or empty.");
		}
		this.customerId = customerId;
		this.name = name;
	}
	
	// Getters
	public String getCustomerId() {
		return customerId;
	}
	
	public String getName() {
		return name;
	}
	
	
	/**
	 * Updates the customer's name.
	 * 
	 * @param name New name to set. Must not be null or empty.
	 * @param IllegalArgumentException if name is invalid.
	 */
	public void setName(String name) {
		if (name == null || name.isBlank()) {
			throw new IllegalArgumentException("Customer name cannot be null or empty.");
		}
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Customer ID: " + customerId + ", Name: " + name;
	}
	
	
	
}















