
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
	    String name = promptString("Enter owner's name: ");
	    String address = promptString("Enter owner's address: ");
	    return new CarOwner(name, address);
	}

	public static SportCar createSportCar(CarOwner owner) {
		// Prompts the user for SportCar details and returns a new SportCar linked to the given owner
		String make = promptString("Enter sport car make: ");
	    String model = promptString("Enter model: ");
	    int year = promptInt("Enter year (>= 1886): ", 1886);
	    String vin = promptString("Enter VIN: ");
	    int raceStats = promptInt("Enter race stats (>= 0): ", 0);

	    return new SportCar(make, model, year, vin, owner, raceStats);
	}
	
	private static SedanCar createSedanCar(CarOwner owner) {
		// Prompts the user for SedanCar details and returns a new SedanCar linked to the given owner
        String make = promptString("Enter sedan car make: ");
        String model = promptString("Enter model: ");
        int year = promptInt("Enter year (>= 1886): ", 1886);
        String vin = promptString("Enter VIN: ");
        int doors = promptInt("Enter number of doors (>= 1): ", 1);
        int trunk = promptInt("Enter trunk size (>= 0): ", 0);
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
	

    /**
     * Prompts for a non-blank string. Allows user to type 'quit' to exit.
     */
    private static String promptString(String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("quit")) {
                System.out.println("Exiting application.");
                System.exit(0);
            }
            if (!input.isEmpty()) return input;
            System.out.println("Input cannot be blank. Try again or type 'quit'.");
        }
    }

    /**
     * Prompts for an integer >= minValue. Allows user to type 'quit' to exit.
     */
    private static int promptInt(String message, int minValue) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("quit")) {
                System.out.println("Exiting application.");
                System.exit(0);
            }
            try {
                int value = Integer.parseInt(input);
                if (value >= minValue) return value;
                System.out.printf("Value must be at least %d. Try again or type 'quit'.%n", minValue);
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Try again or type 'quit'.");
            }
        }
    }
}