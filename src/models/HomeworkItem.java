package models;

public class HomeworkItem {
	
	public static int HomeworkStatus_HasFinished = 2;
	public static int HomeworkStatus_HasSubmit = 1;
	public static int HomeworkStatus_NoSubmit = 0;
	
	private int id;
	private String studentId; //学生id
	private int hwId; //作业id
	private int score;// 作业成绩
	private String feedback;
	private int status;
	private String uploadURL;
	private int rank;
	private String username;
	
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public String getUploadURL() {
		return uploadURL;
	}

	public void setUploadURL(String uploadURL) {
		this.uploadURL = uploadURL;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public HomeworkItem(){}
	
	
	public HomeworkItem(String studentId, int hwId, String username) {
		this.studentId = studentId;
		this.hwId = hwId;
		this.status = HomeworkStatus_NoSubmit;
		this.score = 0;
		this.username = username;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public int getHwId() {
		return hwId;
	}
	public void setHwId(int hwId) {
		this.hwId = hwId;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	
	
}
