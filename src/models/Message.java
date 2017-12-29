package models;

public class Message {
	private int id;
	private String Owner;
	private String msg;
	private String date;
	private String receiver;
	
	
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOwner() {
		return Owner;
	}
	public void setOwner(String owner) {
		Owner = owner;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}	
}
