package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO{

	private Connection c = null;
	
	public StudentDAO() {
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
	
	public void insert(Student student) {
		String sql = "insert into student values(null,?,?,?)";
		try {
			PreparedStatement ps = c.prepareStatement(sql);
			//设置预编译参数
			ps.setInt(1, student.getSid());
			ps.setString(2, student.getName());
			ps.setString(3, student.getPassword());
			//执行
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除某个学生
	 * @param hwID
	 */
	public void delete(int studentID) {
		String sql = "delete from student where id = ?";
		try {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, studentID);
			ps.execute();
			
			//@Tode: delete relative homework items.
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 更新学生信息
	 */
	public void update(Student student) {
		String sql = "update student set sid = ?, name = ?, password = ? where id = ?";
		try {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, student.getSid());
			ps.setString(2, student.getName());
			ps.setString(3, student.getPassword());
			ps.setInt(4, student.getId());
			ps.execute();
			
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Student findOne(int studentId) {
		Student student = null;
		String sql = "select * from student where id = ?";
		PreparedStatement ps;
		try {
			ps = c.prepareStatement(sql);
			ps.setInt(1, studentId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				student = new Student();
				int id = rs.getInt(1);
				int sid = rs.getInt(2);
				String name = rs.getString(3);
				String password = rs.getString(4);
		
				student.setId(id);
				student.setName(name);
				student.setPassword(password);
				student.setSid(sid);
		
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return student;
	}
	
	public List<Student> studentList() {
		List<Student> students = new ArrayList<Student>();
		String sql = "select * from student";
		PreparedStatement ps;
		try {
			ps = c.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Student student = new Student();
				int id = rs.getInt(1);
				int sid = rs.getInt(2);
				String name = rs.getString(3);
				String password = rs.getString(4);
				
				student.setId(id);
				student.setSid(sid);
				student.setName(name);
				student.setPassword(password);
							
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
}
