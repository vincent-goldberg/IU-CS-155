/**
 * Represents a personal (individual) customer of the bank.
 * Adds home and work phone contact details in addition to inherited information.
 * 
 * Inherits name, address, phone, and account list from Customer.
 * Implements getCustomerInfo() to provide formatted personal customer details.
 * 
 * @author Red Team
 * @version 1.0
 * @date 28 July 2025
 */

public class PersonalCustomer extends Customer{
	private String homePhone;
	private String workPhone;
	
	/**
     * Constructs a PersonalCustomer with basic and extended contact information.
     *
     * @param name       the customer's name
     * @param address    the customer's address
     * @param phone      the customer's primary phone
     * @param homePhone  the customer's home phone
     * @param workPhone  the customer's work phone
     */
	public PersonalCustomer(String name, String address, String phone, String homePhone, String workPhone) {
		super(name, address, phone);
		this.homePhone = homePhone;
		this.workPhone = workPhone;
	}
	
	// Setters
	public void setHomePhone(String homePhone) {
		if (homePhone != null && !homePhone.isBlank()) {
			this.homePhone = homePhone;
		}
	}
	
	public void setWorkPhone(String workPhone) {
		if (workPhone != null && !workPhone.isBlank()) {
			this.workPhone = workPhone;
		}
	}
	
	// Getters
	public String getHomePhone() {
		return homePhone;
	}
	
	public String getWorkPhone() {
		return workPhone;
	}
	
	/**
     * Returns a string representation of this customer's information.
     *
     * @return formatted personal customer info
     */
	@Override
	public String getCustomerInfo() {
		return "Personal Customer: " + getName() +
				"\nAddress: " + getAddress() +
				"\nHome Phone: " + homePhone +
				"\nWork Phone: " + workPhone;
	}	
	
	@Override
	public String toString() {
		return getCustomerInfo(); 
	}
}
