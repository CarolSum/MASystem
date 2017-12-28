package models;

public class HomeworkItem {
	
	public static int HomeworkStatus_HasSubmit = 1;
	public static int HomeworkStatus_NoSubmit = 0;
	
	private int id;
	private String studentId; //学生id
	private int hwId; //作业id
	private int score;// 作业成绩
	private String feedback;
	private int status;
	private String uploadURL;
	
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

	public HomeworkItem() {}
	
	public HomeworkItem(String studentId, int hwId) {
		this.studentId = studentId;
		this.hwId = hwId;
		this.status = HomeworkStatus_NoSubmit;
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
