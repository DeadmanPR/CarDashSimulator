import java.awt.BorderLayout;
import java.awt.LayoutManager;

import javax.swing.JFrame;
import javax.swing.OverlayLayout;



public class CarDashSimulator {
	public static JFrame frame = new JFrame("System Simulator");

	public static void main(String[] args) {

		//Creates the frame's layout to be used.
		LayoutManager overlay = new OverlayLayout(frame.getContentPane());

		//Constructs the system's controller, fuel tank and fuel meter.
		SystemController controller = new SystemController();
		FuelTank tank = new FuelTank();
		FuelMeter fuelMeter = new FuelMeter();

		//Sets up a car (or system) with the given revolutions per liter.
		Car system = new Car(20,1, controller);

		//Creates the button and the wheel.
		Button button = new Button(tank, fuelMeter);
		Wheel wheel = new Wheel(tank, fuelMeter, controller);

		//Sets the frame's size and layout.
		frame.setSize(900, 600);
		frame.setLayout(overlay);


		//Adds everything to the frame.
		frame.add(fuelMeter);
		frame.add(wheel);
		frame.add(tank);
		frame.add(button);
		frame.add(new SystemController());
		frame.add(new SpeedMeter());
		frame.add(new RevolutionCounter());
		frame.add(new Border());

		//Sets additional properties for the frame.
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);



	}
}
