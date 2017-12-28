package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Homework;
import models.HomeworkDAO;
import models.HomeworkItem;
import models.HomeworkItemDAO;
import models.User;

public class HwDetailServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{    
		response.setContentType("text/html; charset=UTF-8");
		User curUser = (User) request.getSession().getAttribute("user");
		
		int hwId = Integer.parseInt(request.getParameter("id"));
		HomeworkDAO hd = new HomeworkDAO();
		Homework currentHomework = hd.findOne(hwId);
		if(currentHomework != null) {
			request.getSession().setAttribute("curHomework", currentHomework);
		}
		HomeworkItemDAO hid = new HomeworkItemDAO();
		HomeworkItem homeworkItem = hid.findOne(hwId, curUser.getSid());
		if(homeworkItem != null) {
			request.getSession().setAttribute("curHomeworkItem", homeworkItem);
		}
		
		try {
			request.getRequestDispatcher("homework-detail.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
