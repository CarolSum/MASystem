package widgets;

import models.Student;
import models.StudentDAO;
import models.Teacher;
import models.TeacherDAO;
import models.User;

public class CheckUser {
	/*
	 * check if sid && password correct from db.
	 * */
	public static User checkLogin(String sid, String password){
		StudentDAO sd = new StudentDAO();
		Student stu = sd.findOne(sid, password);
		if(stu != null) return stu;
		TeacherDAO td = new TeacherDAO();
		Teacher teacher = td.findOne(sid, password);
		if(teacher != null) return teacher;
		return null;
	}
	
	/**
	 * if the sid is already been register, return true; else return false;
	 * @param sid
	 * @return
	 */
	public static boolean CheckRepeat(String sid) {
		StudentDAO sd = new StudentDAO();
		if(sd.findStudentBySid(sid) != null) return true;
		TeacherDAO td = new TeacherDAO();
		if(td.findOneBySid(sid) != null) return true;
		return false;
	}
}
