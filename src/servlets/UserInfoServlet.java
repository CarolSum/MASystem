package servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Homework;
import models.HomeworkDAO;
import models.HomeworkItem;
import models.HomeworkItemDAO;
import models.Message;
import models.MessageDAO;
import models.User;
import models.UserDAO;

public class UserInfoServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{    
		 response.setContentType("text/html; charset=UTF-8");
		 try {
			request.getRequestDispatcher("user-info.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{  
		 request.setCharacterEncoding("UTF-8"); 
		 UserDAO ud = new UserDAO();
		 User curUser = (User) request.getSession().getAttribute("user");
		 curUser.setName(request.getParameter("name"));
		 curUser.setPassword(request.getParameter("password"));
		 ud.update(curUser);
		 request.getSession().setAttribute("user", curUser);
		 System.out.println("修改用户信息成功!");
		 response.sendRedirect("/MASystem/home");
	 }
}
