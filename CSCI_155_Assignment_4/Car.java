/**
 * The Car class represents a vehicle with basic attributes and an associated owner.
 * A car must have make, model, year, and price information.
 * The owner may be null, indicating that the car is currently unowned.
 * 
 * @author Red Team
 * @version 1.0
 * @date 12 July 2025
 */

public class Car {
    private String make;
    private String model;
    private int year;
    private double price;
    private CarOwner owner; // may be null if the car is unowned

    /**
     * Default constructor initializes attributes to default values.
     * Owner is set to null to represent an unowned car.
     */
    public Car() {
        this.make = "";
        this.model = "";
        this.year = 0;
        this.price = 0.0;
        this.owner = null;
    }

    /**
     * Constructs a Car with specified details.
     *
     * @param make  the car make (manufacturer)
     * @param model the car model
     * @param year  the manufacturing year (must be >= 0)
     * @param price the price of the car (must be >= 0)
     * @param owner the CarOwner object (nullable if car is unowned)
     */
    public Car(String make, String model, int year, double price, CarOwner owner) {
        setMake(make);
        setModel(model);
        setYear(year);
        setPrice(price);
        this.owner = owner;
    }

    /** @return the make of the car */
    public String getMake() {
        return make;
    }

    /**
     * Sets the car's make.
     *
     * @param make the make to set
     */
    public void setMake(String make) {
        this.make = make;
    }

    /** @return the model of the car */
    public String getModel() {
        return model;
    }

    /**
     * Sets the car's model.
     *
     * @param model the model to set
     */
    public void setModel(String model) {
        this.model = model;
    }

    /** @return the manufacturing year of the car */
    public int getYear() {
        return year;
    }

    /**
     * Sets the manufacturing year. Must be non-negative.
     *
     * @param year the year to set
     * @throws IllegalArgumentException if year is negative
     */
    public void setYear(int year) {
        if (year < 0) {
            throw new IllegalArgumentException("Year cannot be negative");
        }
        this.year = year;
    }

    /** @return the price of the car */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the car price. Must be non-negative.
     *
     * @param price the price to set
     * @throws IllegalArgumentException if price is negative
     */
    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        this.price = price;
    }

    /** @return the owner of the car, or null if unowned */
    public CarOwner getOwner() {
        return owner;
    }

    /**
     * Sets the car's owner.
     *
     * @param owner the CarOwner object (nullable)
     */
    public void setOwner(CarOwner owner) {
        this.owner = owner;
    }

    /**
     * Returns a string representation of the car's details.
     *
     * @return a formatted string with car attributes and owner information
     */
    @Override
    public String toString() {
        return "Car: " + year + " " + make + " " + model + ", Price: $" + String.format("%.2f", price) + "\n" +
               (owner != null ? owner.toString() : "No Owner");
    }
}
