package models;

public class Homework {
	int id;
	private String title;
	private String content;
	private String startDate; // 开始日期
	private String endDate; // 结束日期

	public Homework() {}
	
	public Homework(String title, String content, String startDate, String endDate) {
		this.title = title;
		this.content = content;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	
}
