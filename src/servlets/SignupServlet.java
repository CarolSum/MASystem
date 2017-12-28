package servlets;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Student;
import models.StudentDAO;
import models.Teacher;
import models.TeacherDAO;
import models.User;
import models.UserDAO;
import widgets.CheckUser;

public class SignupServlet extends HttpServlet {
	 public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{  
		 request.setCharacterEncoding("UTF-8");
		 String sid = request.getParameter("new-studentid");
		 String name = request.getParameter("name");
		 String password = request.getParameter("new-password");
		 //Authority
		 System.out.println(sid + " " + name + " " + password);
		 String type = request.getParameter("user-type");
		 System.out.println(type);
		 if(CheckUser.CheckRepeat(sid)) {
			 //error hints: Sid Repeat.
			 response.sendRedirect("/MASystem/login");
		 }else{
			 UserDAO ud = new UserDAO();
			 User user = new User();
			 user.setName(name);
			 user.setPassword(password);
			 user.setSid(sid);
			 if(type.equals("ѧ��") ) {
				 user.setType(User.USER_TYPE_STU);
				 System.out.println("ѧ��ע��ɹ�");
			 }else if(type.equals("��ʦ")){
				 user.setType(User.USER_TYPE_TEACHER);
				 System.out.println("�ɹ�ע��һ������ʦ");
			 }
			 ud.insert(user);
			 response.sendRedirect("/MASystem/login");
		 }
		 
	 }
}
