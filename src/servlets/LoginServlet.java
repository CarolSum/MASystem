package servlets;

import java.io.IOException;
import java.util.Date;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Student;
import models.StudentDAO;
import models.User;
import widgets.CheckUser;

public class LoginServlet extends HttpServlet {
	 public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{    
		 try {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 
	 public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{    
		 System.out.println("handling post");
//		 String test = null;
//		 if ("POST".equalsIgnoreCase(request.getMethod())) 
//		 {
//		    test = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
//		 }
//		 System.out.println(test);
		 String sid = request.getParameter("studentid");
		 String password = request.getParameter("password");
		 //Authority
		 System.out.println(sid + " " + password);
		 
//		 StudentDAO mstudentDao = new StudentDAO();
//		 Student stu = mstudentDao.findOne(sid, password);
//		 if (null != stu) {
//            request.getSession().setAttribute("user", stu);
//            response.sendRedirect("/MASystem/home");
//         } else
//            response.sendRedirect("/MASystem/login");
		 User user = CheckUser.checkLogin(sid, password);
		 if(user != null) {
			 request.getSession().setAttribute("user", user);
			 response.sendRedirect("/MASystem/home");
		 }else {
			 response.sendRedirect("/MASystem/login");
		 }
		 
	 }
}
