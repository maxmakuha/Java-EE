package ua.com.maverick;

import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) throws Exception {
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

		Teacher teacher2 = new Teacher();
		teacher2.setFirstname("Dmytro");
		teacher2.setLastname("Glomozda");
		teacher2.setCellphone("+380644497865");
		teacher2.setBirthDate(new Date());

		// Управління транзакціями з застосування
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.merge(teacher2);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				try {
					tx.rollback();
				} catch (HibernateException he) {
					// log he and rethrow e
				}
			}
			throw e;
		} finally {
			try {
				session.close();
			} catch (HibernateException he) {
				throw he;
			}
		}
	}
}
