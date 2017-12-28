package widgets;

import models.Student;
import models.StudentDAO;
import models.Teacher;
import models.TeacherDAO;
import models.User;
import models.UserDAO;

public class CheckUser {
	/*
	 * check if sid && password correct from db.
	 * */
	public static User checkLogin(String sid, String password){
		UserDAO ud = new UserDAO();
		User user = ud.findOne(sid, password);
		if(user != null) return user;
		return null;
	}
	
	/**
	 * if the sid is already been register, return true; else return false;
	 * @param sid
	 * @return
	 */
	public static boolean CheckRepeat(String sid) {
		UserDAO ud = new UserDAO();
		if(ud.findUserBySid(sid) != null) return true;
		return false;
	}
}
