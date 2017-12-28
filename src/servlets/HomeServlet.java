package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Homework;
import models.HomeworkDAO;

public class HomeServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{    
		 response.setContentType("text/html; charset=UTF-8");
		 HomeworkDAO hd = new HomeworkDAO();
		 List<Homework> homeworks = hd.ListHomework();
		 request.getSession().setAttribute("homeworks", homeworks);
		 request.getSession().setAttribute("curHomework", homeworks.get(0));
		 try {
			request.getRequestDispatcher("home.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
