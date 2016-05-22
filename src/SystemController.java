import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

/**
 * Contains operations related to the system's controller that is used in the program.
 * @author Jose Antonio Rodriguez Rivera
 *
 */
public class SystemController extends JPanel implements MouseMotionListener{
	private static int border=2;
	private static double currentValue;

	/**
	 * Creates the SystemController.
	 */
	public SystemController()
	{
		addMouseMotionListener(this);
	}

	/**
	 * Returns the current value of the "slider"
	 * @return the current value
	 */
	public double getCurrentValue()
	{
		currentValue=(2*border+24)/2;
		return currentValue;
	}

	/**
	 * Resets the current value (and position) to the starting point.
	 */
	public void resetCurrentValue()
	{
		border=2;
	}

	/**
	 * Draws the graphics to the panel.
	 */
	public void paintComponent(Graphics g)
	{
		//Sets the size and locations.
		super.paintComponent(g);
		setSize(205,95);
		setLocation(445,380);

		//Draws the outer rectangle of the slider.
		g.setColor(Color.black);
		g.drawRect(0, 20, 200, 30);

		//Draws the button that is moved when controlling the system.
		g.fillRect(border, 22, 25, 25);
		g.setColor(Color.red);

		//Sets the middle line, indicating the current value.
		g.drawLine((int)getCurrentValue(), 22, (int)getCurrentValue(), 46);

		//Markers for the inside of the Controller
		g.setColor(Color.GRAY);
		g.drawLine(100, 25, 100, 50); //Med

		for (int i = 0; i<20; i++)
			g.drawLine(14+i*9, 28, 14+i*9, 42);

		//Draws the OFF, MED and MAX markers for the controller.
		g.setColor(Color.black);
		g.drawString("O", 10, 65);
		g.drawString("F", 10, 78);
		g.drawString("F", 10, 91);
		g.drawString("M", 96, 65);
		g.drawString("E", 96, 78);
		g.drawString("D", 96, 91);
		g.drawString("M", 181, 65);
		g.drawString("A", 181, 78);
		g.drawString("X", 181, 91);

		g.drawString("System Controller", 50, 15);

	}

	/**
	 * Executed when the mouse is dragged.
	 */
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getX()<0)
			border=2;
		else
			if(e.getX()>174)
				border=173;
			else
			{
				border = e.getX();
				repaint();
			}
	}

	/**
	 * Executed when the mouse is moved.
	 */
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}



}
