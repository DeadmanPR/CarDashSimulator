import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

/**
 * Creates the border that is around the user interface.
 * @author Jose Antonio Rodriguez Rivera
 *
 */
public class Border extends JPanel {
	
	/**
	 * Draws the graphics to the panel.
	 */
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		setSize(900,600);
		setLocation(0,0);

		//Adds a border to the frame.
		Graphics2D g2 = (Graphics2D)g;
		final float separation[] = {5.0f};
		final BasicStroke borderFrame = new BasicStroke(5.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, separation, 0.0f);
		g2.setStroke(borderFrame);
		g2.setColor(Color.black);
		g2.drawRect(5, 5, 750, 550);
	}

}
