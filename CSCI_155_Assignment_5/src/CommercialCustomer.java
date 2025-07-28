/**
 * Represents a commercial (business) customer of the bank.
 * Adds credit rating, contact person, and contact phone in addition to inherited details.
 *
 * Inherits name, address, phone, and account list from Customer.
 * Implements getCustomerInfo() to return formatted business customer information.
 * 
 * @author Red Team
 * @version 1.0
 * @date 28 July 2025
 */

public class CommercialCustomer extends Customer{
	private String creditRating;
	private String contactPerson;
	private String contactPhone;
	
	/**
     * Constructs a CommercialCustomer with identifying and contact information.
     *
     * @param name          the business name
     * @param address       the business address
     * @param phone         the main business phone
     * @param creditRating  the credit rating of the business
     * @param contactPerson the name of the main point of contact
     * @param contactPhone  the phone number of the contact person
     */
	public CommercialCustomer(String name, String address, String phone,
							  String creditRating, String contactPerson, String contactPhone) {
		super(name, address, phone);
		this.creditRating = creditRating;
		this.contactPerson = contactPerson;
		this.contactPhone = contactPhone;
	}
	
	// Setters
	public void setCreditRating(String creditRating) {
		if (creditRating != null && !creditRating.isBlank()) {
			this.creditRating = creditRating;
		}
	}
	
	public void setContactPerson(String contactPerson) {
		if (contactPerson != null && !contactPerson.isBlank()) {
			this.contactPerson = contactPerson;
		}
	}
	
	public void setContactPhone(String contactPhone) {
		if (contactPhone != null && !contactPhone.isBlank()) {
			this.contactPhone = contactPhone;
		}
	} 
	
	// Getters
	public String getCreditRating() {
		return creditRating;
	}
	
	public String getContactPerson() {
		return contactPerson;
	}
	
	public String getContactPhone() {
		return contactPhone;
	}
	
	 /**
     * Returns a string representation of this customer's business info.
     *
     * @return formatted commercial customer info
     */
    @Override
    public String getCustomerInfo() {
        return "Commercial Customer: " + getName() +
               "\nAddress: " + getAddress() +
               "\nPrimary Phone: " + getPhone() +
               "\nCredit Rating: " + creditRating +
               "\nContact Person: " + contactPerson +
               "\nContact Phone: " + contactPhone;
    }
} 