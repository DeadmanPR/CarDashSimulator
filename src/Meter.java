import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * Contains general operations related to the different meters used.
 * @author Jose Antonio Rodriguez Rivera
 *
 */
public abstract class Meter extends JPanel {

	private double currentValue, minimumValue, maximumValue;

	/**
	 * Sets the meter's current value.
	 * @param value the current value
	 */
	public void setCurrentValue(double value)
	{
		if(value>=minimumValue && value <=maximumValue)
			currentValue = value;
	}

	/**
	 * Sets the meter's minimum value.
	 * @param value the minimum value
	 */
	public void setMinimumValue(double value)
	{
		minimumValue = value;
	}

	/**
	 * Sets the meter's maximum value.
	 * @param value the maximum value
	 */
	public void setMaximumValue(double value)
	{
		maximumValue = value;
	}

	/**
	 * Returns the meter's current value.
	 * @return the current value
	 */
	public double getCurrentValue()
	{
		return currentValue;
	}

	/**
	 * Returns the meter's minimum value.
	 * @return the minimum value
	 */
	public double getMinimumValue()
	{
		return minimumValue;
	}

	/**
	 * Returns the meter's maximum value.
	 * @return the maximum value
	 */
	public double getMaximumValue()
	{
		return maximumValue;
	}

	/**
	 * Facilitates the super.paintComponent(g) instruction for subclasses.
	 * @param g
	 */
	public void paintTheComponent(Graphics g)
	{
		super.paintComponent(g);
	}

	/**
	 * Draws the graphics to the panel.
	 */
	public abstract void paintComponent(Graphics g);

	/**
	 * Controls the animation of the meter.
	 */
	public abstract void update();
}
