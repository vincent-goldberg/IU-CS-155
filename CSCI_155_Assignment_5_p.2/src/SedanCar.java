
/**
 * Represents a sedan car with specific attributes for
 * number of doors and trunk size.
 * 
 *  @author Red Team
 *  @version 1.0
 *  @date 31 July 2025
 */

public class SedanCar extends Car{
	private int numDoors;
	private int trunkSize;
	
	/**
	 * Constructs a SedanCar with all attributes.
	 * 
	 * @param make the car make
     * @param model the car model
     * @param year the manufacturing year
     * @param vin the unique VIN
     * @param owner the car owner
     * @param numDoors the number of doors (must be > 0)
     * @param trunkSize trunk capacity in arbitrary units (must be >= 0)
     */
	public SedanCar(String make, String model, int year, String vin, CarOwner owner, int numDoors, int trunkSize) {
		super(make, model, year, vin, owner);
		setNumDoors(numDoors);
		setTrunkSize(trunkSize);
	}

	/**
	 * @return the numDoors
	 */
	public int getNumDoors() {
		return numDoors;
	}

	/**
	 * @return the trunkSize
	 */
	public int getTrunkSize() {
		return trunkSize;
	}

	/**
	 * Sets the number of doors.
	 * @param numDoors must be > 0
	 */
	public void setNumDoors(int numDoors) {
		if (numDoors <= 0) {
			throw new IllegalArgumentException("Number of doors must be positive.");
		}
		this.numDoors = numDoors;
	}
	
	/**
	 * Sets the trunk size.
	 * @param trunkSize the trunkSize to set > 0 
	 */
	public void setTrunkSize(int trunkSize) {
		if (trunkSize < 0) {
			throw new IllegalArgumentException("Trunk size must be non-negative.");
		}
		this.trunkSize = trunkSize;
	}

	@Override
	public String toString() {
		return String.format(
				"SedanCar {make='%s', model='%s', year=%d, vin='%s', numDoors=%d, trunkSize=%d, owner='%s'}",
				getMake(), getModel(), getYear(), getVin(), numDoors, trunkSize, getOwner().getName());
	}
}
