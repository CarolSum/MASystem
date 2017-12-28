package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HomeworkItemDAO {
	
	private Connection c = null;
	
	public HomeworkItemDAO() {
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
	
	public void insert(HomeworkItem homeworkItem) {
		String sql = "insert into homeworkitem values(null,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = c.prepareStatement(sql);
			//设置预编译参数
			ps.setString(1, homeworkItem.getStudentId());
			ps.setInt(2, homeworkItem.getHwId());
			ps.setInt(3, homeworkItem.getScore());
			ps.setString(4, homeworkItem.getFeedback());
			ps.setInt(5, HomeworkItem.HomeworkStatus_NoSubmit);
			ps.setString(6, "");
			//执行
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除某一次作业item
	 * @param hwID
	 */
	public void delete() {
		
	}
	
	/**
	 * 更新作业item
	 */
	public void update(HomeworkItem homeworkItem) {
		String sql = "update homeworkitem set status = ?, uploadURL = ? where id = ?";
		try {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, homeworkItem.getStatus());
			ps.setString(2, homeworkItem.getUploadURL());
			ps.setInt(3, homeworkItem.getId());
			ps.execute();
			
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public HomeworkItem findOne(int hwId, String sid) {
//		private String studentId; //学生id
//		private int hwId; //作业id
		HomeworkItem hi = null;
		String sql = "select * from homeworkitem where studentId = ? AND hwId = ?";
		PreparedStatement ps;
		try {
			ps = c.prepareStatement(sql);
			ps.setString(1, sid);
			ps.setInt(2, hwId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				hi = new HomeworkItem();
				int id = rs.getInt(1);				
				String studentId = rs.getString(2);
				int _hwId = rs.getInt(3);
				int score = rs.getInt(4);
				String feedback = rs.getString(5);
				int status = rs.getInt(6);
				String uploadURL = rs.getString(7);
				
				hi.setId(id);
				hi.setStudentId(studentId);
				hi.setHwId(_hwId);
				hi.setScore(score);
				hi.setFeedback(feedback);
				hi.setStatus(status);
				hi.setUploadURL(uploadURL);
			}
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hi;
	}
	
	public List<HomeworkItem> homeworkItemList() {
		return null;
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
