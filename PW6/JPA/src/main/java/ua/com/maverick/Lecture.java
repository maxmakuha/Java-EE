package ua.com.maverick;
import javax.persistence.*;

@Entity
@Table(name = "Lectures")
public class Lecture {
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private int id;
	private String name;
	@Basic(fetch = FetchType.EAGER)
	private double credits;
	
	@OneToOne (cascade = CascadeType.ALL)
	@JoinColumn(name = "address_fk")
	private Address address;
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	// Getters and settings
	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Lecture [id=" + id + ", name=" + name + ", credits=" + credits
				+ ", address=" + address + "]";
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getCredits() {
		return credits;
	}
	public void setCredits(double credits) {
		this.credits = credits;
	}
}
