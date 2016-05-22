import java.awt.Color;
import java.awt.Graphics;

/**
 * Contains operations related to the speedmeter (tachometer) used in this program.
 * @author Jose Antonio Rodriguez Rivera
 *
 */
public class SpeedMeter extends Meter {

	/**
	 * Creates the SpeedMeter to be used.
	 */
	public SpeedMeter()
	{
		setMinimumValue(-55);
		setMaximumValue(230);
		setCurrentValue(230);
	}

	/**
	 * Draws the graphics to the panel.
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintTheComponent(g);

		//Sets the size and location.
		setSize(350,250);
		setLocation(10,125);



		//Draws the SpeedMeter background.
		g.setColor(Color.black);
		g.fillOval(65, 0, 250, 250);

		//Draws the white markers for the SpeedMeter.
		g.setColor(Color.white);
		g.drawLine(65, 125, 190, 125);
		g.drawLine(190, 0, 190, 125);
		g.drawLine(110, 30, 190, 125);
		g.drawLine(110, 220, 271, 29);

		//Draws the red markers for the SpeedMeter.
		g.setColor(Color.red);
		g.drawLine(190, 125, 315, 125);
		g.drawLine(190, 125, 272, 217);

		//Draws the inner circle of the SpeedMeter.
		g.setColor(Color.black);
		g.fillOval(80, 15, 220, 220);

		//Draws the needle (marker) for the SpeedMeter.
		g.setColor(Color.cyan);
		g.fillArc(65, 0, 250, 250, (int)getCurrentValue(), 1);

		//Draws the SpeedMeter title.
		g.setColor(Color.black);
		g.drawString("S",40,25);
		g.drawString("P",40,45);
		g.drawString("E",40,65);
		g.drawString("E",40,85);
		g.drawString("D",40,105);
		g.drawString("O",40,125);
		g.drawString("M",40,145);
		g.drawString("E",40,165);
		g.drawString("T",40,185);
		g.drawString("E",40,205);
		g.drawString("R",40,225);

		//Draws the RPM label inside the SpeedMeter.
		g.setColor(Color.white);
		g.drawString("RPM",178,205);

		//Draws the SpeedMeter's numbers.
		g.drawString("0", 125, 203);
		g.drawString("10", 90, 133);
		g.drawString("20", 125, 63);
		g.drawString("30", 183, 43);
		g.drawString("40", 243, 63);
		g.drawString("50", 270, 133);
		g.drawString("60", 243, 200);

		update();
	}

	/**
	 * Controls the animation of the SpeedMeter.
	 */
	@Override
	public void update() {
		setCurrentValue(230-4.7*Car.getRPM());

	}

}
