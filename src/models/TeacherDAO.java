package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TeacherDAO {
	private Connection c = null;
	
	public TeacherDAO() {
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
	
	public void insert(Teacher teacher) {
		String sql = "insert into teacher values(null,?,?)";
		try {
			PreparedStatement ps = c.prepareStatement(sql);
			//设置预编译参数
			ps.setString(1, teacher.getName());
			ps.setString(2, teacher.getPassword());
			//执行
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void delete(int teacherId) {
		String sql = "delete from teacher where id = ?";
		try {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, teacherId);
			ps.execute();
			
			//@Tode: delete relative homework items.
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void update(Teacher teacher) {
		String sql = "update teacher set name = ?, password = ? where id = ?";
		try {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, teacher.getName());
			ps.setString(2, teacher.getPassword());
			ps.setInt(3, teacher.getId());
			ps.execute();
			
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Teacher findOne(int teacherId) {
		Teacher teaceher = null;
		String sql = "select * from teacher where id = ?";
		PreparedStatement ps;
		try {
			ps = c.prepareStatement(sql);
			ps.setInt(1, teacherId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				teaceher = new Teacher();
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String password = rs.getString(3);
		
				teaceher.setId(id);
				teaceher.setName(name);
				teaceher.setPassword(password);
		
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return teaceher;
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

}
