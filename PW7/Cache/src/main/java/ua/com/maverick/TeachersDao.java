package ua.com.maverick;

public interface TeachersDao {
	void addTeacher(Teacher teacher);

	Teacher getTeacherById(int id);

	void saveTacher(Teacher teacher);
}
