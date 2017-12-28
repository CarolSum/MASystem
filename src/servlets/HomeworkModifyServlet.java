package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Homework;
import models.HomeworkDAO;
import models.User;
import widgets.MsgTool;

public class HomeworkModifyServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{    
		 response.setContentType("text/html; charset=UTF-8");
		 try {
			request.getRequestDispatcher("homework-modification.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{  
		 request.setCharacterEncoding("UTF-8"); 
		 User user = (User) request.getSession().getAttribute("user");
		 HomeworkDAO hd = new HomeworkDAO();
		 Homework homework = (Homework) request.getSession().getAttribute("curHomework");
		 homework.setTitle(request.getParameter("hw-title"));
		 homework.setContent(request.getParameter("new-hw-content"));
		 homework.setStartDate(request.getParameter("hw-start-time"));
		 homework.setEndDate(request.getParameter("hw-end-time"));
		 hd.update(homework);
		 request.getSession().setAttribute("curHomework", homework);
		 System.out.println("更新作业成功!");
		 
		 MsgTool.send(user.getName(), "修改了作业"+homework.getId());
		 
		 response.sendRedirect("/MASystem/homework-detail?id=" + homework.getId());
	 }
}
