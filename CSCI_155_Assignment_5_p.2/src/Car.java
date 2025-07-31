/**
 * Abstract class representing a generic car.
 * All cars have make, model, year, VIN, and a CarOwner.
 * Subclasses must define their own toString()
 * 
 * @author Red Team
 * @version 1.0
 * @date 31 July 2025
 * 
 */

public abstract class Car {
	private String make;
	private String model;
	private int year;
	private String vin;
	private CarOwner owner;
	
	/**
     * Constructs a Car with the specified parameters.
     * @param make the car make (non-null, non-empty)
     * @param model the car model (non-null, non-empty)
     * @param year the manufacture year (> 1885)
     * @param vin the Vehicle Identification Number (non-null, non-empty)
     * @param owner the car owner (must not be null; a car must always have an owner)

     */
	public Car(String make, String model, int year, String vin, CarOwner owner) {
		setMake(make);
		setModel(model);
		setYear(year);
		setVin(vin);
		setOwner(owner);
	}


	// Setters with validation
	public void setMake(String make) {
		if (make == null || make.isBlank()) {
			throw new IllegalArgumentException("Make cannot be null or blank.");
		}
		this.make = make;
	}

	public void setModel(String model) {
		if (model == null || model.isBlank()) {
			throw new IllegalArgumentException("Model cannot be null or blank.");
		}
		this.model = model;
	}

	public void setYear(int year) {
		if (year < 1886) {
			throw new IllegalArgumentException("Year must be 1886 or later.");
		}
		this.year = year;
	}

	public void setVin(String vin) {
		if (vin == null || vin.isBlank()) {
			throw new IllegalArgumentException("VIN cannot be null or blank.");
		}
		this.vin = vin;
	}

	public void setOwner(CarOwner owner) {
		if (owner == null ) {
			throw new IllegalArgumentException("Car must have an owner.");
		}
		if (this.owner != owner) {
			if (this.owner != null) {
				this.owner.removeCar(this);
			}
			this.owner = owner;
			owner.addCar(this);
		}
		
	}

	// Getters
	public String getMake() {
		return make;
	}
	
	public String getModel() {
		return model;
	}

	public int getYear() {
		return year;
	}

	public String getVin() {
		return vin;
	}

	public CarOwner getOwner() {
		return owner;
	}

	/**
	 * Abstract class representation to be implemented by subclasses.
	 * @return car details in string format
	 */
	@Override
	public abstract String toString();	
}
