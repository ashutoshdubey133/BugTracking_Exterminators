package in.co.hsbc.bts.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Set;

import in.co.hsbc.bts.dao.TeamDao;
import in.co.hsbc.bts.factory.Factory;
import in.co.hsbc.bts.model.Team;

public class TeamDaoImpl implements TeamDao {
	
	private Connection con = null;

	public TeamDaoImpl() {
		try {
			con = Factory.getJdbcConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public boolean create(Team team) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Team getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Team team) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<Team> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
