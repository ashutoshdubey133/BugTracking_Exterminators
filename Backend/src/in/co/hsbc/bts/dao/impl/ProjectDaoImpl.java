package in.co.hsbc.bts.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Set;

import in.co.hsbc.bts.dao.ProjectDao;
import in.co.hsbc.bts.factory.Factory;
import in.co.hsbc.bts.model.Project;

public class ProjectDaoImpl implements ProjectDao {

	private Connection con = null;

	public ProjectDaoImpl() {
		try {
			con = Factory.getJdbcConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean create(Project project) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Project getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Project project) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<Project> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
