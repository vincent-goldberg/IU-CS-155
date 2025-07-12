/**
 * The CarOwner class represents an individual who may own one or more cars.
 * It includes basic contact information such as name and address.
 * 
 * @author Red Team
 * @version 1.0
 * @date 12 July 2025
 */
public class CarOwner {
    private String name;
    private String address;

    /**
     * Default constructor that initializes name and address to empty strings.
     */
    public CarOwner() {
        this.name = "";
        this.address = "";
    }

    /**
     * Constructs a CarOwner with the specified name and address.
     *
     * @param name the name of the car owner
     * @param address the address of the car owner
     */
    public CarOwner(String name, String address) {
        this.name = name;
        this.address = address;
    }

    /**
     * Returns the name of the car owner.
     *
     * @return the owner's name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the car owner.
     *
     * @param name the new name for the owner
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the address of the car owner.
     *
     * @return the owner's address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the address of the car owner.
     *
     * @param address the new address for the owner
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Returns a string representation of the CarOwner.
     *
     * @return a formatted string with the owner's name and address
     */
    @Override
    public String toString() {
        return "Owned By: " + name + ", Address: " + address;
    }
}
