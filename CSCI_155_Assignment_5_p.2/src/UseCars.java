
/**
 * Test driver class for creating and managing Car and CarOwner objects.
 * 
 * @author Red Team
 * @version 1.0
 * @date 31 July 2025
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UseCars {
	private static final Scanner scanner = new Scanner(System.in);
	private static final List<Car> carList = new ArrayList<>();
	
	public static void main(String[] args) {
		System.out.println("=== Car System Demo ===");

		// Creating owners
		CarOwner owner1 = createCarOwner();
		CarOwner owner2 = createCarOwner();
		// Creating cars and adding to list
		carList.add(createSportCar(owner1));
		carList.add(createSedanCar(owner2));
		
		// Searching for cars
		System.out.print("\nEnter a VIN to search: ");
		String vinSearch = scanner.nextLine();
		findCarByVin(vinSearch);
		
		// Showing all cars in system
		System.out.println("\nAll cars in system:");
		for (Car car : carList) {
			System.out.println(car);
		}
	}
	
	public static CarOwner createCarOwner() {
	    // Prompts the user for owner information and returns a new CarOwner instance
	    System.out.print("Enter owner's name: ");
	    String name = scanner.nextLine();
	    System.out.print("Enter owner's address: ");
	    String address = scanner.nextLine();
	    return new CarOwner(name, address);
	}

	public static SportCar createSportCar(CarOwner owner) {
	    // Prompts the user for SportCar details and returns a new SportCar linked to the given owner
	    System.out.print("Enter sport car make: ");
	    String make = scanner.nextLine();
	    System.out.print("Enter model: ");
	    String model = scanner.nextLine();
	    System.out.print("Enter year: ");
	    int year = Integer.parseInt(scanner.nextLine());
	    System.out.print("Enter VIN: ");
	    String vin = scanner.nextLine();
	    System.out.print("Enter race stats: ");
	    int raceStats = Integer.parseInt(scanner.nextLine());

	    return new SportCar(make, model, year, vin, owner, raceStats);        
	}

	public static SedanCar createSedanCar(CarOwner owner) {
	    // Prompts the user for SedanCar details and returns a new SedanCar linked to the given owner
	    System.out.print("Enter sedan car make: ");
	    String make = scanner.nextLine();
	    System.out.print("Enter model: ");
	    String model = scanner.nextLine();
	    System.out.print("Enter year: ");
	    int year = Integer.parseInt(scanner.nextLine());
	    System.out.print("Enter VIN: ");
	    String vin = scanner.nextLine();
	    System.out.print("Enter number of doors: ");
	    int doors = Integer.parseInt(scanner.nextLine());
	    System.out.print("Enter trunksize: ");
	    int trunk = Integer.parseInt(scanner.nextLine());

	    return new SedanCar(make, model, year, vin, owner, doors, trunk);        
	}

	public static void findCarByVin(String vin) {
	    // Searches the car list for a car with the given VIN and prints its details if found
	    for (Car car : carList) {
	        if (car.getVin().equalsIgnoreCase(vin)) {
	            System.out.println("Car found: " + car);
	            return;
	        }
	    }
	    System.out.println("No car found with VIN: " + vin);
	}
}