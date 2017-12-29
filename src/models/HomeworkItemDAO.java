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
		String sql = "insert into homeworkitem values(null,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = c.prepareStatement(sql);
			//设置预编译参数
			ps.setString(1, homeworkItem.getStudentId());
			ps.setInt(2, homeworkItem.getHwId());
			ps.setInt(3, homeworkItem.getScore());
			ps.setString(4, homeworkItem.getFeedback());
			ps.setInt(5, HomeworkItem.HomeworkStatus_NoSubmit);
			ps.setString(6, homeworkItem.getUploadURL());
			ps.setInt(7,homeworkItem.getRank());
			ps.setString(8, homeworkItem.getUsername());
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
		String sql = "update homeworkitem set status = ?, uploadURL = ?, feedback = ?, score = ?, rank = ? where id = ?";
		try {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, homeworkItem.getStatus());
			ps.setString(2, homeworkItem.getUploadURL());
			ps.setString(3, homeworkItem.getFeedback());
			ps.setInt(4, homeworkItem.getScore());
			ps.setInt(5, homeworkItem.getRank());
			ps.setInt(6, homeworkItem.getId());
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
				int rank = rs.getInt(8);
				String username = rs.getString(9);
				
				hi.setId(id);
				hi.setStudentId(studentId);
				hi.setHwId(_hwId);
				hi.setScore(score);
				hi.setFeedback(feedback);
				hi.setStatus(status);
				hi.setUploadURL(uploadURL);
				hi.setRank(rank);
				hi.setUsername(username);
			}
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hi;
	}
	
	public List<HomeworkItem> homeworkItemList(String sid) {
		List<HomeworkItem> homeworks = new ArrayList<HomeworkItem>();
		String sql = "select * from homeworkitem where studentId = ? and score != 0";
		PreparedStatement ps;
		try {
			ps = c.prepareStatement(sql);
			ps.setString(1, sid);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				HomeworkItem hi = new HomeworkItem();
				int id = rs.getInt(1);
				String studentid = rs.getString(2);
				int hwId = rs.getInt(3);
				int score = rs.getInt(4);
				String feedback = rs.getString(5);
				int status = rs.getInt(6);
				String url = rs.getString(7);
				int rank = rs.getInt(8);
				String username = rs.getString(9);
				
				hi.setFeedback(feedback);
				hi.setHwId(hwId);
				hi.setId(id);
				hi.setScore(score);
				hi.setStatus(status);
				hi.setStudentId(studentid);
				hi.setUploadURL(url);
				hi.setRank(rank);
				hi.setUsername(username);
				
				homeworks.add(hi);
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

	public List<HomeworkItem> getHomeworkItemByHwId(int hwId) {
		// TODO Auto-generated method stub
		List<HomeworkItem> homeworks = new ArrayList<HomeworkItem>();
		String sql = "select * from homeworkitem where hwId = ? order by rank asc";
		PreparedStatement ps;
		try {
			ps = c.prepareStatement(sql);
			ps.setInt(1, hwId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				HomeworkItem hi = new HomeworkItem();
				int id = rs.getInt(1);
				String studentid = rs.getString(2);
				int hwid = rs.getInt(3);
				int score = rs.getInt(4);
				String feedback = rs.getString(5);
				int status = rs.getInt(6);
				String url = rs.getString(7);
				int rank = rs.getInt(8);
				String username = rs.getString(9);
				
				hi.setFeedback(feedback);
				hi.setHwId(hwid);
				hi.setId(id);
				hi.setScore(score);
				hi.setStatus(status);
				hi.setStudentId(studentid);
				hi.setUploadURL(url);
				hi.setRank(rank);
				hi.setUsername(username);
				homeworks.add(hi);
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return homeworks;
	}

	public HomeworkItem getHomeworkItemByHiId(int hiid) {
		// TODO Auto-generated method stub
		HomeworkItem hi = null;
		String sql = "select * from homeworkitem where id = ?";
		PreparedStatement ps;
		try {
			ps = c.prepareStatement(sql);
			ps.setInt(1, hiid);
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
				int rank = rs.getInt(8);
				String username = rs.getString(9);
				
				hi.setId(id);
				hi.setStudentId(studentId);
				hi.setHwId(_hwId);
				hi.setScore(score);
				hi.setFeedback(feedback);
				hi.setStatus(status);
				hi.setUploadURL(uploadURL);
				hi.setRank(rank);
				hi.setUsername(username);
			}
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hi;
	}

	public List<HomeworkItem> getItemDesc(int hwId) {
		// TODO Auto-generated method stub
		List<HomeworkItem> homeworks = new ArrayList<HomeworkItem>();
		String sql = "select * from homeworkitem where hwId = ? order by score desc";
		PreparedStatement ps;
		try {
			ps = c.prepareStatement(sql);
			ps.setInt(1, hwId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				HomeworkItem hi = new HomeworkItem();
				int id = rs.getInt(1);
				String studentid = rs.getString(2);
				int hwid = rs.getInt(3);
				int score = rs.getInt(4);
				String feedback = rs.getString(5);
				int status = rs.getInt(6);
				String url = rs.getString(7);
				int rank = rs.getInt(8);
				String username = rs.getString(9);
				
				hi.setFeedback(feedback);
				hi.setHwId(hwid);
				hi.setId(id);
				hi.setScore(score);
				hi.setStatus(status);
				hi.setStudentId(studentid);
				hi.setUploadURL(url);
				hi.setRank(rank);
				hi.setUsername(username);
				homeworks.add(hi);
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return homeworks;
	}
}
