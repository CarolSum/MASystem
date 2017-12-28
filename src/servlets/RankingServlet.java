package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Homework;
import models.HomeworkDAO;
import models.HomeworkItem;
import models.HomeworkItemDAO;

public class RankingServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{    
		response.setContentType("text/html; charset=UTF-8");
		HomeworkDAO hd = new HomeworkDAO();
		HomeworkItemDAO hid = new HomeworkItemDAO();
		int hwId = Integer.parseInt(request.getParameter("hwId")) ; 
		Homework curHomework =  hd.findOne(hwId);
		System.out.println(curHomework.getId());
		List<HomeworkItem> homeworkItems = hid.getHomeworkItemByHwId(hwId);
		request.getSession().setAttribute("curHomework", curHomework);
		request.getSession().setAttribute("homeworkItems", homeworkItems);
		 try {
			request.getRequestDispatcher("ranking.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
}
