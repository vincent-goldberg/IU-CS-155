/**
 * Represents a sports car, which is a specific type of Car
 * with additional race statistics.
 * 
 * @author Red Team
 * @version 1.0
 * @date 31 July 2025
 * 
 */

public class SportCar extends Car {
	private int raceStats;

	/**
	 * Constructs a SportCar with all attributes.
	 * @param make the car make
     * @param model the car model
     * @param year the manufacturing year
     * @param vin the unique VIN
     * @param owner the car owner
     * @param raceStats performance metric (non-negative)
	 */
	public SportCar(String make, String model, int year, String vin, CarOwner owner, int raceStats) {
		super(make, model, year, vin, owner);
		setRaceStats(raceStats);
	}

	/**
	 * @return the raceStats
	 */
	public int getRaceStats() {
		return raceStats;
	}

	/**
	 * @param raceStats the race performance metric (must be non-negative)
	 */
	public void setRaceStats(int raceStats) {
		if (raceStats < 0 ) {
			throw new IllegalArgumentException("Race stats must be non-negative.");
		}
		this.raceStats = raceStats;
	}
	
	@Override
	public String toString() {
		return String.format(
				"SportCar {make='%s', model='%s', year=%d, vin='%s', raceStats=%d, owner='%s'", 
				getMake(), getModel(), getYear(), getVin(), raceStats, getOwner().getName());
	}	
}
