import java.awt.Color;
import java.awt.Graphics;

/**
 * Contains operations related to the Fuel Tank used.
 * @author Jose Antonio Rodriguez Rivera
 *
 */
public class FuelTank extends Meter {

	/**
	 * Creates the FuelTank to be used.
	 */
	public FuelTank()
	{
		setMinimumValue(0);
		setMaximumValue(499);
		setCurrentValue(0);
	}

	/**
	 * Fills the FuelTank.
	 */
	public void fillTank()
	{
		setCurrentValue(499);
	}

	/**
	 * Paints the graphics to the panel.
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintTheComponent(g);
		setLocation(800,55);
		setSize(80,550);

		//Fuel Tank
		g.setColor(Color.black);
		g.drawRect(0,0,60,500);

		g.setColor(new Color(238,162,173));
		g.fillRect(1, 500-(int)getCurrentValue(), 59, 0+(int)getCurrentValue());

		//Fuel Tank Title
		g.setColor(Color.black);
		g.drawString("F",70,150);
		g.drawString("U",70,170);
		g.drawString("E",70,190);
		g.drawString("L",70,210);
		g.drawString("T",70,250);
		g.drawString("A",70,270);
		g.drawString("N",70,290);
		g.drawString("K",70,310);

		update();

	}
	
	/**
	 * Controls the animation of the FuelTank.
	 */
	@Override
	public void update() {
		if(getCurrentValue()>0)
			setCurrentValue(499.0-499.0*Car.getGasUsage());

	}

}
