package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MessageDAO{

	private Connection c = null;
	
	public MessageDAO() {
		try {
            Class.forName("com.mysql.jdbc.Driver");
            this.c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/masystem?characterEncoding=UTF-8&serverTimezone=UTC",
                    "root", "admin");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	/**
	 * 插入新Homework
	 * @param homework
	 */
	public void insert(Message message) {
		String sql = "insert into messages values(null,?,?,?,?)";
		try {
			PreparedStatement ps = c.prepareStatement(sql);
			//设置预编译参数
			ps.setString(1, message.getOwner());
			ps.setString(2, message.getMsg());
			ps.setString(3, message.getDate());
			ps.setString(4, message.getReceiver());
			//执行
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void finalize() throws Throwable {
		if(c != null) {
			try {
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		super.finalize();
	}

	public List<Message> ListMessages(String username) {
		List<Message> messages = new ArrayList<Message>();
		String sql = "select * from messages where receiver = ? order by date desc ";
		PreparedStatement ps;
		try {
			ps = c.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Message message = new Message();
				int id = rs.getInt(1);
				String owner = rs.getString(2);
				String msg = rs.getString(3);
				String date = rs.getString(4);		
				String receiver = rs.getString(5);
				
				message.setId(id);
				message.setOwner(owner);
				message.setMsg(msg);
				message.setDate(date);
				message.setReceiver(receiver);

				messages.add(message);
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return messages;
	}
	
}
