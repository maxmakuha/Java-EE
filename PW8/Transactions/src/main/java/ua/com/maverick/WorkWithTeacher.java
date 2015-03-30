package ua.com.maverick;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import ua.com.maverick.TeachersDao;
import ua.com.maverick.Teacher;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class WorkWithTeacher {
	@Autowired
	private TransactionTemplate transactionTemplate;
	@Autowired
	private TeachersDao teachersDao;

	public Teacher addTeacher(final Teacher teacher) {
		transactionTemplate.execute(new TransactionCallback<Void>() {
			public Void doInTransaction(TransactionStatus txStatus) {
				try {
					teachersDao.addTeacher(teacher);
					System.out.println("Teacher has been added " + teacher);
				} catch (RuntimeException e) {
					txStatus.setRollbackOnly();
					throw e;
				}
				return null;
			}
		});
		return teacher;
	}

	public Teacher getTeacherById(int id) {
		return teachersDao.getTeacherById(id);
	}

	// Транзакції управляємі контейнером
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public void saveTacher(Teacher teacher) {
		teachersDao.saveTacher(teacher);
		System.out.println("Teacher has been saved " + teacher);
	}
}