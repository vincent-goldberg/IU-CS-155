import java.util.ArrayList;

public class UseCar {

	public static void main(String[] args) {
		CarOwner owner1  = new CarOwner("Leonardo da Vinci", "123 Firenze St");
		CarOwner owner2 = new CarOwner("Theodore Roosevelt", "456 Sagamore Hill Rd");
		
		ArrayList<Car> cars = new ArrayList<>();
		cars.add(new Car("Toyota", "Camry", 2020, 22000, owner1));
		cars.add(new Car("Honda", "Civic", 2019, 18000, owner1));
		cars.add(new Car("Ford", "F-150", 2022, 35000, owner2));
		
		for (Car car : cars) {
			System.out.println(car);
			System.out.println("\n-----\n");
		}

	}

}
