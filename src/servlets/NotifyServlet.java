package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Message;
import models.MessageDAO;
import models.User;

public class NotifyServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{    
		response.setContentType("text/html; charset=UTF-8");
		User user = (User) request.getSession().getAttribute("user");
		MessageDAO md = new MessageDAO();
		List<Message> messages = md.ListMessages(user.getName());
		request.getSession().setAttribute("messages", messages);
		try {
			request.getRequestDispatcher("notification.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
