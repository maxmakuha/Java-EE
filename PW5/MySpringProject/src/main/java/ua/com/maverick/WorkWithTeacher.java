package ua.com.maverick;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import ua.com.maverick.TeachersDao;
import ua.com.maverick.Teacher;

@Transactional
public class WorkWithTeacher {
	@Autowired
	private TeachersDao teachersDao;

	public Teacher addTeacher(Teacher teacher) {
		teachersDao.addTeacher(teacher);
		System.out.println("Teacher has been added " + teacher);
		return teacher;
	}

	public Teacher getTeacherById(int id) {
		return teachersDao.getTeacherById(id);
	}

	public void saveTacher(Teacher teacher) {
		teachersDao.saveTacher(teacher);
		System.out.println("Teacher has been saved " + teacher);
	}
}
