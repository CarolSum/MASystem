package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HomeworkDAO{

	private Connection c = null;
	
	public HomeworkDAO() {
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
	 * ������Homework
	 * @param homework
	 */
	public void insert(Homework homework) {
		String sql = "insert into homework values(null,?,?,?,?)";
		try {
			PreparedStatement ps = c.prepareStatement(sql);
			//����Ԥ�������
			ps.setString(1, homework.getTitle());
			ps.setString(2, homework.getContent());
			ps.setString(3, homework.getStartDate());
			ps.setString(4, homework.getEndDate());
			//ִ��
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * ɾ��ĳһ����ҵ
	 * @param hwID
	 */
	public void delete(int hwID) {
		String sql = "delete from homework where id = ?";
		try {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, hwID);
			ps.execute();
			
			//@Tode: delete relative homework items.
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * �޸���ҵ����
	 */
	public void update(Homework hw) {
		String sql = "update homework set title = ?, content = ?, startDate = ?, endDate = ? where id = ?";
		try {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, hw.getTitle());
			ps.setString(2, hw.getContent());
			ps.setString(3, hw.getStartDate());
			ps.setString(4, hw.getEndDate());
			ps.setInt(5, hw.getId());
			ps.execute();
			
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Homework findOne(int hwId) {
		Homework homework = null;
		String sql = "select * from homework where id = ?";
		PreparedStatement ps;
		try {
			ps = c.prepareStatement(sql);
			ps.setInt(1, hwId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				homework = new Homework();
				int id = rs.getInt(1);
				String title = rs.getString(2);
				String content = rs.getString(3);
				String startDate = rs.getString(4);
				String endDate = rs.getString(5);
				
				homework.setId(id);
				homework.setContent(content);
				homework.setTitle(title);
				homework.setEndDate(endDate);
				homework.setStartDate(startDate);
		
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return homework;
	}
	
	
	/**
	 * ��ѯ������ҵ
	 * @return
	 */
	public List<Homework> ListHomework(){
		List<Homework> homeworks = new ArrayList<Homework>();
		String sql = "select * from homework order by id desc";
		PreparedStatement ps;
		try {
			ps = c.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Homework homework = new Homework();
				int id = rs.getInt(1);
				String title = rs.getString(2);
				String content = rs.getString(3);
				String startDate = rs.getString(4);
				String endDate = rs.getString(5);
				
				homework.setId(id);
				homework.setContent(content);
				homework.setTitle(title);
				homework.setEndDate(endDate);
				homework.setStartDate(startDate);
				
				homeworks.add(homework);
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return homeworks;
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
