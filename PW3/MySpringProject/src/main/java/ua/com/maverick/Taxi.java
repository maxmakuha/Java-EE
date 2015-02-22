package ua.com.maverick;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

public class Taxi implements iCar {
	private String driverName;
	private String carModel;
	@Autowired
	private iColour colour;
	public Collection <iColour> colours;
	 
	public Taxi (String driverName){
		this.driverName = driverName;
	}
	
	public Taxi (String driverName, String carModel){
		this.carModel = carModel;
		this.driverName = driverName;
	}
	
	public String getDriverName() {
		return driverName;
	}

	public String getCarModel() {
		return carModel;
	}

	
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	 
	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}
	
	public void driverInfo() {
		System.out.println("Driver " + driverName + " are ready to drive car " + carModel);
	    colour.drawCar();
	}

	public void drive() {
		System.out.println("âæó-âæó");
	}

	public iColour getColour() {
		return colour;
	}

	public void setColour(iColour colour) {
		this.colour = colour;
	}

	public Collection<iColour> getColours() {
		return colours;
	}

	public void setColours(Collection<iColour> colours) {
		this.colours = colours;
	}
}