import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * Contains several operations related to the Wheel used in the program's user interface.
 * @author Jose Antonio Rodriguez Rivera
 *
 */
public class Wheel extends JPanel {
	private static int angle=0, delay=32, revolution = 0, revolutionsDone;
	private FuelTank tank;
	private FuelMeter meter;
	private SystemController controller;

	/**
	 * Creates the wheel to be used in the program, with access to the other objects it is dependent of.
	 * @param tank the fuel tank to be used
	 * @param meter the fuel meter to be used
	 * @param controller the controller to be used
	 */
	public Wheel(FuelTank tank, FuelMeter meter, SystemController controller)
	{
		this.tank = tank;
		this.meter = meter;
		this.controller = controller;
	}

	/**
	 * Paints the graphics to the panel.
	 */
	public void paintComponent(Graphics g)
	{
		//Sets size and location.
		super.paintComponent(g);
		this.setLocation(420, 125);
		this.setSize(255,235);

		//Background for wheel.
		g.setColor(Color.black);
		g.fillArc(0, 0, 235, 235, 0, 360);

		//Foreground of the wheel
		g.setColor(Color.gray);
		g.fillArc(0, 0, 235, 235, angle-335, 40);
		g.fillArc(0, 0, 235, 235, angle-20, 40);
		g.fillArc(0, 0, 235, 235, angle-65, 40);
		g.fillArc(0, 0, 235, 235, angle-110, 40);
		g.fillArc(0, 0, 235, 235, angle-155, 40);
		g.fillArc(0, 0, 235, 235, angle-200, 40);
		g.fillArc(0, 0, 235, 235, angle-245, 40);

		//Wheel Label
		g.setColor(Color.black);
		g.drawString("W",240,90);
		g.drawString("H",240,110);
		g.drawString("E",240,130);
		g.drawString("E",240,150);
		g.drawString("L",240,170);

		//Reference marker.
		g.setColor(Color.red);
		g.fillArc(0, 0, 235, 235, angle-290, 40);

		update();
	}

	/**
	 * Controls the animation of the wheel.
	 */
	public void update()
	{		

		//Rotates wheel
		if(tank.getCurrentValue()>0)
			angle-=(controller.getCurrentValue()-14)/12.0;
		else
			controller.resetCurrentValue();


		//Checks if a revolution has been finished, and counts it.
		if(angle/-360 != revolution)
		{
			revolutionsDone++;
			revolution=angle/-360;
		}

		CarDashSimulator.frame.repaint();

		try{
			//Delay is in milliseconds
			Thread.sleep(delay);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Returns the number of revolutions done with the current gas.
	 * @return the number of revolutions done with the current gas.
	 */
	public static int getRevolution()
	{
		return revolutionsDone;
	}

	/**
	 * Returns the delay at which the graphics are updated.
	 * @return the time interval at which the graphics are updated (in seconds)
	 */
	public static double getDelay()
	{
		return delay/1000.0;
	}

	/**
	 * Used for the gas calculations. Resets the revolutions done with the current gas.
	 */
	public static void tankFilled()
	{
		revolutionsDone=0;
	}

	/**
	 * Used for the revolution counter. Returns the number of revolutions done in the current session.
	 * @return the number of revolutions in the current session
	 */
	public static int getCounterRevolution()
	{
		return revolution;
	}


}
