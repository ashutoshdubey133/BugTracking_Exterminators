package in.co.hsbc.bts.dao;

import in.co.hsbc.bts.model.ProjectManager;

public interface ProjectManagerDao {
	boolean create(ProjectManager projectManager);
	ProjectManager getById(int id);
	boolean update(ProjectManager projectManager);
	boolean deleteById(int id);
}
