package in.co.hsbc.bts.dao;

import java.util.Set;

import in.co.hsbc.bts.model.ProjectManager;

public interface ProjectManagerDao {
	boolean create(ProjectManager projectManager);
	ProjectManager getById(int id);
	ProjectManager getByEmail(String email);
	boolean update(ProjectManager projectManager);
	boolean deleteById(int id);
	Set<ProjectManager> findAll();
}
