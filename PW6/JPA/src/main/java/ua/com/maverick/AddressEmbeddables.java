package ua.com.maverick;

import javax.persistence.Embeddable;

@Embeddable
public class AddressEmbeddables {

	private String state;
	private String zipcode;
	private String country;

	// Constructors, getters, setters
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "AddressEmbeddables [state=" + state + ", zipcode=" + zipcode
				+ ", country=" + country + "]";
	}
}
