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
import widgets.MsgTool;


public class PublishServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{    
		 response.setContentType("text/html; charset=UTF-8");
		 try {
			request.getRequestDispatcher("publish.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{  
		 request.setCharacterEncoding("UTF-8"); 
		 User curUser = (User) request.getSession().getAttribute("user");
		 /**
		  * 创建新作业
		  */
		 String title = request.getParameter("hw-title");
		 String startDate = request.getParameter("hw-start-time");
		 String endDate = request.getParameter("hw-end-time");
		 String content = request.getParameter("new-hw-content");
		 Homework hw = new Homework();
		 hw.setContent(content);
		 hw.setEndDate(endDate);
		 hw.setStartDate(startDate);
		 hw.setTitle(title);
		 HomeworkDAO hd = new HomeworkDAO();
		 
		 /**
		  * 创新对应homeworkItem
		  */
		 UserDAO ud = new UserDAO();
		 HomeworkItemDAO hid = new HomeworkItemDAO();
		 int newId = hd.insert(hw);
		 hw.setId(newId);
		 List<User> users = ud.studentList();
		 for(User user: users) {
			 HomeworkItem hi = new HomeworkItem(user.getSid(), hw.getId());
			 hid.insert(hi);
		 }
		 
		 /**
		  * 创建新消息
		  */
		 MsgTool.send(curUser.getName(), "新作业已发布~立个小目标吧，比如打他个100分~~");
		 
		 System.out.println("发布作业成功");
		 response.sendRedirect("/MASystem/home");
	 }
}
