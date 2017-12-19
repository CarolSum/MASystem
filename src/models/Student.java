package models;

public class Student extends User{
	private int id; 
	private int sid; //Ñ§ºÅ
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	
}
