/**
 *Represents a car owner with a name, address, and list of owned cars.
 * 
 * @author Red Team
 * @version 1.0
 * @date 30 July 2025
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CarOwner {
	private String name;
	private String address;
	private List<Car> cars;
	
	/**
	 * Default constructor
	 */
	public CarOwner() {
		this.cars = new ArrayList<>();
	}
	
	/**
	 * Constructs a CarOwner with specified name and address
	 * @param name the owner's name (non-null, non-empty)
	 * @param address the owner's address (non-null, non-empty)
	 */
	public CarOwner(String name, String address) {
		setName(name);
		setAddress(address);
		this.cars = new ArrayList<>();
	}
	
	// Setters
	public void setName(String name) {
		if (name == null || name.isBlank()) {
			throw new IllegalArgumentException("Name cannot be null or blank.");
		}
		this.name = name;
	}
	
	public void setAddress(String address) {
		if (address == null || address.isBlank()) {
			throw new IllegalArgumentException("Address cannot be null or blank.");
		}
		this.address = address;
	}
	
	// Getters
	public String getName() {
		return name;
	}
	
	public String getAddress() {
		return address;
	}
	
	/**
	 * Returns list of cars owned by owner
	 */
	public List<Car> getCars() {
		return new ArrayList<>(cars); // Defensive copy
	}
	
	/**
	 * Adds car to owner's list and sets owner on car
	 * @param car The car to add
	 */
	public void addCar(Car car) {
		Objects.requireNonNull(car, "Car cannot be null.");
		if (!cars.contains(car) ) {
			cars.add(car);
			car.setOwner(this);
		}
	}
	
	/**
	 * Removes car from owner's list and disassociates the owner from car
	 * @param car The car to remove
	 */ 
	public void removeCar(Car car) {
		if (cars.remove(car)) {
			car.setOwner(null);
		}
	}
	
	@Override
	public String toString() {
		return "CarOwner{name='" + name + "', address='" + address + "', carsOwned=" + cars.size() + "}";
	}

}
