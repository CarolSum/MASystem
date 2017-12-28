package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
	private Connection c = null;
	
	public UserDAO() {
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
	
	
	public void insert(User user) {
		String sql = "insert into user values(null,?,?,?,?)";
		try {
			PreparedStatement ps = c.prepareStatement(sql);
			//设置预编译参数
			ps.setString(1, user.getName());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getSid());
			ps.setInt(4, user.getType());
			//执行
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void delete(int userId) {
		String sql = "delete from user where id = ?";
		try {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, userId);
			ps.execute();
			
			//@Tode: delete relative homework items.
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void update(User user) {
		String sql = "update user set name = ?, password = ? where id = ?";
		try {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setString(2, user.getPassword());
			ps.setInt(3, user.getId());
			ps.execute();
			
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public User findOne(String sid, String password) {
		User user = null;
		String sql = "select * from user where sid = ? AND password = ?";
		PreparedStatement ps;
		try {
			ps = c.prepareStatement(sql);
			ps.setString(1, sid);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				user = new User();
				int id = rs.getInt(1);				
				String name = rs.getString(2);
				String _password = rs.getString(3);
				String _sid = rs.getString(4);
				int _type = rs.getInt(5);
				
		
				user.setId(id);
				user.setName(name);
				user.setPassword(_password);
				user.setSid(_sid);
				user.setType(_type);
				System.out.println("find a User: " + user.getName());
			}
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
	}
	
	public List<User> studentList() {
		List<User> students = new ArrayList<User>();
		String sql = "select * from user where type = 0";
		PreparedStatement ps;
		try {
			ps = c.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				User student = new User();
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String password = rs.getString(3);
				String sid = rs.getString(4);
				int type = rs.getInt(5);
				
				student.setId(id);
				student.setSid(sid);
				student.setName(name);
				student.setPassword(password);
				student.setType(type);
							
				students.add(student);
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return students;
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


	public User findUserBySid(String sid) {
		// TODO Auto-generated method stub
		User user = null;
		String sql = "select * from user where sid = ?";
		PreparedStatement ps;
		try {
			ps = c.prepareStatement(sql);
			ps.setString(1, sid);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				user = new User();
				int id = rs.getInt(1);
				String _sid = rs.getString(2);
				String name = rs.getString(3);
				String _password = rs.getString(4);
				int _type = rs.getInt(5);
		
				user.setId(id);
				user.setName(name);
				user.setPassword(_password);
				user.setSid(_sid);
				user.setType(_type);
				System.out.println("find a user: " + user.getName());
			}
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
	}
}
