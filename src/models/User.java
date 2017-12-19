package models;

public abstract class User {
	public final static int USER_TYPE_STU = 0;
	public final static int USER_TYPE_TEACHER = 1;
	
	protected String name;
	protected String password;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
