package servlets;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Student;
import models.StudentDAO;
import widgets.CheckUser;

public class SignupServlet extends HttpServlet {
	 public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{  
		 String sid = request.getParameter("new-studentid");
		 String name = request.getParameter("name");
		 String password = request.getParameter("new-password");
		 //Authority
		 System.out.println(sid + " " + name + " " + password);
		 if(CheckUser.CheckRepeat(sid)) {
			 //error hints: Sid Repeat.
			 response.sendRedirect("/MASystem/login");
		 }else{
			 StudentDAO sd = new StudentDAO();
			 Student student = new Student();
			 student.setName(name);
			 student.setPassword(password);
			 student.setSid(sid);
			 sd.insert(student);
			 System.out.println("×¢²á³É¹¦");
			 response.sendRedirect("/MASystem/login");
		 }
		 
	 }
}
