package models;

public class Teacher extends User{
	private int id;
	private String sid; //��ʦ��ѧ�� 
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	
	
}
