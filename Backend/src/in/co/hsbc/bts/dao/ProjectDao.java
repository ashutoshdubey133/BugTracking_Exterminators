package in.co.hsbc.bts.dao;

import in.co.hsbc.bts.model.Project;

public interface ProjectDao {
	boolean create(Project project);
	Project getById(int id);
	boolean update(Project project);
	boolean deleteById(int id);
}
