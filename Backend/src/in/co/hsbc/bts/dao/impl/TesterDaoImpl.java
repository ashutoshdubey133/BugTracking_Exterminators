package in.co.hsbc.bts.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Set;

import in.co.hsbc.bts.dao.TesterDao;
import in.co.hsbc.bts.factory.Factory;
import in.co.hsbc.bts.model.Tester;

public class TesterDaoImpl implements TesterDao {
	
	private Connection con = null;

	public TesterDaoImpl() {
		try {
			con = Factory.getJdbcConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public boolean create(Tester tester) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Tester getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Tester tester) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<Tester> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
