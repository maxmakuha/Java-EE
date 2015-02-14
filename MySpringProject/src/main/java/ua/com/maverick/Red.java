package ua.com.maverick;

public class Red implements iColour {

	private String carColour = "Red";
	
	public void drawCar() {
		System.out.println("Taxi is " + carColour);
	}
}
