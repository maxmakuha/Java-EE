package ua.com.maverick;

public class Blue implements iColour {

	private String carColour = "Blue";
	
	public void drawCar() {
		System.out.println("Taxi is " + carColour);
	}
}
