package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Homework;
import models.HomeworkDAO;
import models.HomeworkItem;
import models.HomeworkItemDAO;
import models.User;
import models.UserDAO;
import widgets.MsgTool;

public class CheckHomeworkServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{    
		 response.setContentType("text/html; charset=UTF-8");
		 
		 String rawHwId = request.getParameter("hwId");
		 String rawSid = request.getParameter("stId");
		 HomeworkDAO hd = new HomeworkDAO();
		 HomeworkItemDAO hid = new HomeworkItemDAO();
		 
		 if(rawHwId != null) {
			 int hwid = Integer.parseInt(request.getParameter("hwId"));
			 Homework curHomework = hd.findOne(hwid);
			 List<HomeworkItem> homeworks =  hid.getHomeworkItemByHwId(hwid);
			 request.getSession().setAttribute("homeworkItems", homeworks);
			 request.getSession().setAttribute("curHomework", curHomework);
		 }else if(rawSid != null) {
			 List<HomeworkItem> homeworks = hid.homeworkItemList(rawSid);
			 if(!homeworks.isEmpty()) {
				 HomeworkItem firstItem = homeworks.get(0);
				 int hwId = firstItem.getHwId();
				 Homework curHomework = hd.findOne(hwId);
				 request.getSession().setAttribute("homeworkItems", homeworks);
				 request.getSession().setAttribute("curHomework", curHomework);
			 }
		 }
		 
		 
		 /**
		  * 获取所有学号
		  */
		 if(request.getSession().getAttribute("allStudentId") == null) {
			 UserDAO ud = new UserDAO();
			 List<User> students = ud.studentList();
			 ArrayList<String> sids = new ArrayList<String>();
			 for(User stu: students) {
				 sids.add(stu.getSid());
			 }
			
			 request.getSession().setAttribute("allStudentId", sids);
		 }

		 try {
			request.getRequestDispatcher("checkHomework.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
		request.setCharacterEncoding("UTF-8"); 
		 User curUser = (User) request.getSession().getAttribute("user");
		 HomeworkItemDAO hid = new HomeworkItemDAO();
		 
		 int hiid = Integer.parseInt(request.getParameter("hiid"));
		 HomeworkItem curHomeworkItem = hid.getHomeworkItemByHiId(hiid);
		 
		 String feedback = request.getParameter("feedback-content");
		 String rawScore = request.getParameter("score");
		 int score = Integer.parseInt(rawScore);
		 System.out.println(feedback);
		 System.out.println(score);
		 
		 curHomeworkItem.setFeedback(feedback);
		 curHomeworkItem.setScore(score);
		 curHomeworkItem.setStatus(HomeworkItem.HomeworkStatus_HasFinished);
		 
		 hid.update(curHomeworkItem);
		
		 List<HomeworkItem> allItems = hid.getItemDesc(curHomeworkItem.getHwId());
		 
		 int rank = 0;
		 int lastItemScore = -1;
		 int temp = 0;
		 for(HomeworkItem item: allItems) {
			 if(item.getScore() != lastItemScore) {
				 item.setRank(++rank + temp);
				 lastItemScore = item.getScore();
				 temp = 0;
			 }else {
				 item.setRank(rank);
				 temp++;
			 }
		 }
		 for(HomeworkItem item: allItems) {
			 hid.update(item);
		 }
		 
		 UserDAO ud = new UserDAO();
		 User receiver =  ud.findUserBySid(curHomeworkItem.getStudentId());
		 
		 /**
		  * 创建新消息
		  */
		 MsgTool.send(curUser.getName(), "批改了作业"+curHomeworkItem.getHwId(), receiver.getName());
		 
		 System.out.println("批改作业成功");
		 response.sendRedirect("/MASystem/home");
	}
	
}
