import java.util.ArrayList;

/**
 * Demonstrates the Car and CarOwner classes by creating sample data
 * and printing formatted details of cars and their owners.
 * @author Red Team
 * @version 1.0
 * @date 12 July 2025
 */

public class UseCar {

    /**
     * The main method initializes sample CarOwner and Car objects,
     * stores them in a list, and displays their information.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        CarOwner owner1 = new CarOwner("Leonardo da Vinci", "123 Firenze St");
        CarOwner owner2 = new CarOwner("Theodore Roosevelt", "456 Sagamore Hill Rd");

        ArrayList<Car> cars = new ArrayList<>();
        cars.add(new Car("Toyota", "Camry", 2020, 22000, owner1));
        cars.add(new Car("Honda", "Civic", 2019, 18000, owner1));
        cars.add(new Car("Ford", "F-150", 2022, 35000, owner2));
        cars.add(new Car("Chevrolet", "Impala", 2021, 27000, null)); // no owner

        System.out.println("=== Car Inventory ===\n");

        int index = 1;
        for (Car car : cars) {
            System.out.println("Car #" + index++);
            System.out.println(car);
            System.out.println("------------------------------\n");
        }
    }
}
