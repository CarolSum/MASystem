package models;

public class HomeworkItem {
	private int id;
	private int studentId; //学生id
	private int hwId; //作业id
	private int score;// 作业成绩
	private String feedback;
	
	public HomeworkItem() {}
	
	public HomeworkItem(int studentId, int hwId, int score, String feedback) {
		this.studentId = studentId;
		this.hwId = hwId;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
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
