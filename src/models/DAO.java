package models;

import java.util.List;

public interface DAO {
	public void add(Homework homework);
	public void update(Homework homework);
	public void delete(int id);
	public void get(int id);
	public List<Homework> list(int id);
}
