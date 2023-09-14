package in.co.hsbc.bts.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Set;

import in.co.hsbc.bts.dao.ProjectManagerDao;
import in.co.hsbc.bts.factory.Factory;
import in.co.hsbc.bts.model.ProjectManager;

public class ProjectManagerDaoImpl implements ProjectManagerDao {
	
	private Connection con = null;

	public ProjectManagerDaoImpl() {
		try {
			con = Factory.getJdbcConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public boolean create(ProjectManager projectManager) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ProjectManager getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(ProjectManager projectManager) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<ProjectManager> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
