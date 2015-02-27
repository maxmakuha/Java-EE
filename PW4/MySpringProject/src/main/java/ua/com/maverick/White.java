package ua.com.maverick;

public class White implements iColour {

	private String carColour = "White";
	
	public void drawCar() {
		System.out.println("Taxi is " + carColour);
	}
}