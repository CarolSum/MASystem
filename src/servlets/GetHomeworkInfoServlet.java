package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import models.Homework;
import models.HomeworkItem;
import models.HomeworkItemDAO;
import models.User;

public class GetHomeworkInfoServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{    
		 Homework curHomework = (Homework) request.getSession().getAttribute("curHomework");
		 List<HomeworkItem> homeworkItems = (List<HomeworkItem>) request.getSession().getAttribute("homeworkItems");
		 
		 System.out.println(homeworkItems.toString());
		 String json = new Gson().toJson(homeworkItems);
		 System.out.println(json);
		 response.setContentType("application/json");
		 response.setCharacterEncoding("UTF-8");
		 response.getWriter().write(json);
	}
}
