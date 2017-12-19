package servlets;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SignupServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{    
		 response.setContentType("text/html; charset=UTF-8");
		 response.getWriter().println("注册界面");
	 }
	 
	 public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{  
		 response.setContentType("text/html; charset=UTF-8");
		 response.getWriter().println("提交注册");
	 }
}
