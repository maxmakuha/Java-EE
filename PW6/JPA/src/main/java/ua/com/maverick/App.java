package ua.com.maverick;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"SpringBeans.xml");
		Lecture lecture = new Lecture();
		lecture.setName("Introduction to Spring");
		lecture.setCredits(2.5);
		Address address = new Address();
		address.setCity("Kyiv");
		address.setStreet("Skovoroda street");
		AddressEmbeddables add = new AddressEmbeddables();
		add.setState("state");
		add.setCountry("country");
		add.setZipcode("zipcode");
		// test embeddable object
		address.setAdd(add);
		// test one to one bidirectional
		lecture.setAddress(address);
		address.setLecture(lecture);
		LecturesWorker worker = (LecturesWorker) context.getBean("worker");
		worker.addLecture(lecture);
	}
}
