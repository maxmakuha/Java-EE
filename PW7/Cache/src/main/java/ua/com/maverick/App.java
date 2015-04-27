package ua.com.maverick;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"SpringBeans.xml");
		WorkWithStudents worker = (WorkWithStudents) context.getBean("worker");
		// new WorkWithStudents();
		Student testStudent = new Student("Vlad Valt", 5);
		worker.saveStudentToDb(testStudent);
		WorkWithTeacher workWithTeacher = (WorkWithTeacher) context
				.getBean("teachersWorker");
		Teacher teacher = new Teacher();
		teacher.setFirstname("Andrii");
		teacher.setLastname("Glybovets");
		teacher.setCellphone("+380675097865");
		teacher = workWithTeacher.addTeacher(teacher);
		teacher.setBirthDate(new Date());
		workWithTeacher.saveTacher(teacher);
	}
}
