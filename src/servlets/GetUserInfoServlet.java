package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import models.Homework;
import models.HomeworkDAO;
import models.HomeworkItem;
import models.HomeworkItemDAO;
import models.User;

public class GetUserInfoServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{    

//		 HomeworkDAO hd = new HomeworkDAO();
//		 List<Homework> homeworks = hd.ListHomework();
//		 request.getSession().setAttribute("homeworks", homeworks);
//		 try {
//			request.getRequestDispatcher("home.jsp").forward(request, response);
//			 
//		} catch (ServletException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		 
		 
		 
//		 String data = "Hello World!";
//		 response.setContentType("text/plain");
//		 response.setCharacterEncoding("UTF-8");
//		 response.getWriter().write(data);
		 
		 User user = (User) request.getSession().getAttribute("user");
		 
		 HomeworkItemDAO hid = new HomeworkItemDAO();
		 List<HomeworkItem> myHomeworkItems = hid.homeworkItemList(user.getSid());
		 
		 System.out.println(myHomeworkItems.toString());
		 String json = new Gson().toJson(myHomeworkItems);
		 System.out.println(json);
		 response.setContentType("application/json");
		 response.setCharacterEncoding("UTF-8");
		 response.getWriter().write(json);
	}
}
