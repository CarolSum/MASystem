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
		
	}
	
	public HomeworkItem findOne() {
		return null;
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
