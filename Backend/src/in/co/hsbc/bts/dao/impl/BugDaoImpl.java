package in.co.hsbc.bts.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Set;

import in.co.hsbc.bts.dao.BugDao;
import in.co.hsbc.bts.factory.Factory;
import in.co.hsbc.bts.model.Bug;

public class BugDaoImpl implements BugDao {
	
	private Connection con = null;
	
	public BugDaoImpl() {
		try {
			con = Factory.getJdbcConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public boolean create(Bug bug) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Bug getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Bug bug) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<Bug> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
