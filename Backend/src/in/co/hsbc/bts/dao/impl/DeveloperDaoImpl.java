package in.co.hsbc.bts.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Set;

import in.co.hsbc.bts.dao.DeveloperDao;
import in.co.hsbc.bts.factory.Factory;
import in.co.hsbc.bts.model.Developer;

public class DeveloperDaoImpl implements DeveloperDao {

	private Connection con = null;

	public DeveloperDaoImpl() {
		try {
			con = Factory.getJdbcConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean create(Developer developer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Developer getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Developer developer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<Developer> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
