import java.io.Serializable;

/**
 * Represents a bank customer.
 * Stores identifying information such as ID and name.
 *
 * @author Red Team
 * @version 1.0
 * @since 2025-08-07
 */

public class Customer implements Serializable {
    private static final long serialVersionUID = 1L;

    /** Customer identifier (kept immutable once set). */
    private final String customerId;

    /** Customer display name. */
    private String name;

    /**
     * Constructs a Customer with the given ID and name.
     *
     * @param customerId unique identifier for the customer; must not be null/blank
     * @param name       customer name; must not be null/blank
     * @throws IllegalArgumentException if any argument is invalid
     */
    public Customer(String customerId, String name) {
        if (customerId == null || customerId.isBlank()) {
            throw new IllegalArgumentException("Customer ID cannot be null or empty.");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Customer name cannot be null or empty.");
        }
        this.customerId = customerId.trim();
        this.name = name.trim();
    }

    /** @return the customer's ID */
    public String getCustomerId() {
        return customerId;
    }

    /** @return the customer's name */
    public String getName() {
        return name;
    }

    /**
     * Updates the customer's name.
     *
     * @param name new name; must not be null/blank
     * @throws IllegalArgumentException if name is invalid
     */
    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Customer name cannot be null or empty.");
        }
        this.name = name.trim();
    }

    @Override
    public String toString() {
        return  name + " (Customer ID: " + customerId + ")";
    }
}
