package servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	 public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{    
		 try {
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 
	 public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{    
		 String sid = request.getParameter("sid");
		 String password = request.getParameter("password");
		 //Authority
		 System.out.println(sid + " " + password);
	 }
}
