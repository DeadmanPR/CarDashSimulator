import java.awt.Color;
import java.awt.Graphics;

/**
 * Contains operations related to the Fuel Meter used.
 * @author Jose Antonio Rodriguez Rivera
 *
 */
public class FuelMeter extends Meter{

	/**
	 * Creates the FuelMeter to be used.
	 */
	public FuelMeter()
	{
		setMinimumValue(0);
		setMaximumValue(200);
		setCurrentValue(0);
	}

	/**
	 * Fills the FuelMeter.
	 */
	public void fillTank()
	{
		setCurrentValue(200);
	}

	/**
	 * Paints the graphics to the panel.
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintTheComponent(g);

		this.setSize(205,46);
		this.setLocation(100,400);

		//Fuel Meter
		g.setColor(Color.black);
		g.drawRect(0, 0, 200, 30);
		g.drawLine(100, 0, 100, 15);
		g.drawLine(50, 0, 50, 10);
		g.drawLine(150, 0, 150, 10);

		g.setColor(Color.red);
		g.fillRect(1,15,(int)super.getCurrentValue(),5);


		//Fuel Meter Labels
		g.setColor(Color.black);
		g.drawString("E", 0,45);
		g.drawString("F", 198, 45);
		g.drawString("FUEL METER", 65, 45);

		update();
	}
	
	/**
	 * Controls the animation of the FuelMeter.
	 */
	@Override
	public void update() {
		if(getCurrentValue()>0)
			setCurrentValue((200.0-200.0*Car.getGasUsage()));
	}


}
