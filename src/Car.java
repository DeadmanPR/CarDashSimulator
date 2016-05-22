/**
 * Creates a Car(with certain parameters), to be used in the program.
 * @author Jose Antonio Rodriguez Rivera
 *
 */
public class Car {
	private static double rpl;
	private static double rpm=0;
	private static double capacity;
	private static SystemController controller;

	/**
	 * Constructs a car, with the given RPL (Revolutions per Liter).
	 * @param rpl number of revolutions that use 1 liter of gas (RPL)
	 * @param capacity the maximum capacity of the tank (in liters)
	 */
	public Car(double rpl, double capacity, SystemController controller)
	{
		Car.rpl=rpl;
		Car.capacity=capacity;
		Car.controller = controller;
	}


	/**
	 * Calculates the RPM (Revolutions per Minute) and returns it.
	 * @return the current RPM (Revolutions per Minute)
	 */
	public static double getRPM()
	{
		//The getCurrentValue/getDelay returns the "velocity" deg/s. To convert to RPM, multiply by 60 and divide by 360 degrees.
		rpm =((controller.getCurrentValue()-14)/15.0/Wheel.getDelay())*60.0/360.0;
		return rpm;
	}

	/**
	 * Calculates the total gas used at the time this method is called.
	 * @return the amount of gas used as of this time
	 */
	public static double getGasUsage()
	{
		return Wheel.getRevolution()/(rpl*capacity);
	}

	/**
	 * Returns the RPL (Revolutions per Liter).
	 * @return revolutions per liter of this Car
	 */
	public static double getRPL()
	{
		return rpl;
	}

}
