import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Contains operations related to the Revolution Counter.
 * @author Jose Antonio Rodriguez Rivera
 *
 */
public class RevolutionCounter extends JPanel {
	private static JLabel[] numbers = new JLabel[7];

	/**
	 * Creates the revolution counter, and sets all numbers to 0.
	 */
	public RevolutionCounter()
	{
		//Sets layout to null in order to freely locate things.
		setLayout(null);

		//Font to be used for the numbers.
		Font font = new Font("Arial", Font.PLAIN, 18);
		int offset = 0;

		//Creates the labels with value 0.
		for (int i = 0;i<numbers.length; i++)
			numbers[i] = new JLabel("0");

		//Sets up the size and location, and adds them to the panel.
		for (int i = 0;i<numbers.length; i++)
		{
			numbers[i].setSize(15,30);
			numbers[i].setLocation(12+offset,2);
			numbers[i].setFont(font);
			numbers[i].setHorizontalAlignment(JLabel.CENTER);
			offset+=35;
			add(numbers[i]);
		}
	}

	/**
	 * Paints the graphics to the panel.
	 */
	public void paintComponent(Graphics g)
	{
		//Sets size and location.
		super.paintComponent(g);
		this.setSize(255,70);
		this.setLocation(255,20);

		//Draws the rectangles that are located around the numbers.
		g.setColor(Color.black);
		g.drawRect(0, 0, 35, 35);
		g.drawRect(35, 0, 35, 35);
		g.drawRect(70, 0, 35, 35);
		g.drawRect(105,0, 35, 35);
		g.drawRect(140, 0, 35, 35);
		g.drawRect(175, 0, 35, 35);
		g.drawRect(210, 0, 35, 35);

		//Draws the "Revolutions Counter" title.
		g.setColor(Color.black);
		g.drawString("Revolutions Counter",70,55);

		update();
	}

	/**
	 * Controls the animation of the revolution counter.
	 */
	public void update()
	{
		//Sets the number up for the revolution counter. Each label has one digit of the total number. Maximum count is 9999995.
		if(Wheel.getCounterRevolution()<=9999995)
		{
			numbers[0].setText(""+Wheel.getCounterRevolution()/1000000);

			if(Wheel.getCounterRevolution()<1000000) 
				numbers[1].setText(""+Wheel.getCounterRevolution()/100000);
			else			
				numbers[1].setText(""+(Wheel.getCounterRevolution()/100000 - (Wheel.getCounterRevolution()/1000000)*10));

			if(Wheel.getCounterRevolution()<100000)
				numbers[2].setText(""+Wheel.getCounterRevolution()/10000);
			else
				numbers[2].setText(""+(Wheel.getCounterRevolution()/10000 - (Wheel.getCounterRevolution()/100000)*10));

			if (Wheel.getCounterRevolution()<10000)
				numbers[3].setText(""+Wheel.getCounterRevolution()/1000);
			else
				numbers[3].setText(""+(Wheel.getCounterRevolution()/1000 - (Wheel.getCounterRevolution()/10000)*10));

			if (Wheel.getCounterRevolution()<1000)
				numbers[4].setText(""+Wheel.getCounterRevolution()/100);
			else
				numbers[4].setText(""+(Wheel.getCounterRevolution()/100 - (Wheel.getCounterRevolution()/1000)*10));

			if (Wheel.getCounterRevolution()<100)
				numbers[5].setText(""+Wheel.getCounterRevolution()/10);
			else	
				numbers[5].setText(""+(Wheel.getCounterRevolution()/10 - (Wheel.getCounterRevolution()/100)*10));

			numbers[6].setText("" + Wheel.getCounterRevolution()%10);	
		}

	}

}
