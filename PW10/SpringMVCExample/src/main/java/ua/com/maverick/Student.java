package ua.com.maverick;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "students")
@NamedQueries({
		@NamedQuery(name = Student.getAllStudents, query = "SELECT student FROM Student student"),
		@NamedQuery(name = Student.getStudentByPib, query = "SELECT student FROM Student student WHERE student.pib = :pib"),
		@NamedQuery(name = Student.getStudentsByCourse, query = "SELECT student FROM Student student WHERE student.course = :course") })
public class Student implements Serializable {
	public static final String getAllStudents = "Student.getAllStudents";
	public static final String getStudentByPib = "Student.getStudentByPib";
	public static final String getStudentsByCourse = "Student.getStudentsByCourse";
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int studentId;

	private String pib;
	private int course;
	// getters, setters, equals, hash
	public String getPib() {
		return pib;
	}
	public void setPib(String pib) {
		this.pib = pib;
	}
	public int getCourse() {
		return course;
	}
	public void setCourse(int course) {
		this.course = course;
	}
}