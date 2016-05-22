import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

/**
 * Contains operations related to the button used to fill the gas tank.
 * @author Jose Antonio Rodriguez Rivera
 *
 */
public class Button extends JPanel implements MouseInputListener {
	private FuelTank tank;
	private FuelMeter meter;

	/**
	 * Creates the button with the given references of the FuelTank and FuelMeter to be used.
	 * @param tank the FuelTank to be used
	 * @param meter the FuelMeter to be used
	 */
	public Button(FuelTank tank, FuelMeter meter)
	{
		this.tank = tank;
		this.meter = meter;
		addMouseListener(this);
	}

	/**
	 * Draws the graphics to the panel.
	 */
	public void paintComponent(Graphics g)
	{	
		//Sets the size and location.
		super.paintComponent(g);
		this.setLocation(470,510);
		this.setSize(150,30);

		//Draws the button.
		g.setColor(Color.black);
		g.fillRect(0, 0, 30, 30);
		
		g.drawString("Click to add gas", 35, 17);
	}

	/**
	 * Executed when the mouse is clicked.
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		//Checks if the click was within the button's boundaries.
		if(e.getX()>0 && e.getX()<30 && e.getY()>0 && e.getY()<30)
		{
			meter.fillTank();
			tank.fillTank();
			Wheel.tankFilled();
		}
	}

	/**
	 * Executed when the mouse is pressed.
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	/**
	 * Executed when the mouse is released.
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	/**
	 * Executed when the mouse enters the area.
	 */
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 * Executed when the mouse exits the area.
	 */
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 * Executed when the mouse is dragged.
	 */
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 * Executed when the mouse is moved.
	 */
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
