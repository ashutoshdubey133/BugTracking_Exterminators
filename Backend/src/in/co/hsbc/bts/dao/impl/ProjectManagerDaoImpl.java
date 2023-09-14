package in.co.hsbc.bts.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
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
		try {
			String query = "SELECT * FROM pm_tbl INNER JOIN user_tbl WHERE pmId = id AND id = ?";
			
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, id);
			
			ResultSet result = stmt.executeQuery();
			
			ProjectManager pm = new ProjectManager();
			
			pm.setUserId(result.getInt(2));
			pm.setUserName(result.getString(3));
			pm.setUserEmail(result.getString(4));
			pm.setPassword(result.getString(5));
			
			return pm;
			
		} catch (SQLException e) {
			e.printStackTrace();
//			TODO: throw exception
			return null;
		}
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
		try {
			String query = "SELECT * FROM pm_tbl INNER JOIN user_tbl WHERE pmId = id";
			
			PreparedStatement stmt = con.prepareStatement(query);
			
			ResultSet result = stmt.executeQuery();
			
			Set<ProjectManager> set = new HashSet<>();
			
			while(result.next()) {
				ProjectManager pm = new ProjectManager();
				
				pm.setUserId(result.getInt(2));
				pm.setUserName(result.getString(3));
				pm.setUserEmail(result.getString(4));
				pm.setPassword(result.getString(5));
				
				set.add(pm);
			}
			
			return set;
			
		} catch (SQLException e) {
			e.printStackTrace();
//			TODO: throw exception
			return null;
		}
	}

	@Override
	public ProjectManager getByEmail(String email) {
		try {
			String query = "SELECT * FROM pm_tbl INNER JOIN user_tbl WHERE pmId = id AND name = ?";
			
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, email);
			
			ResultSet result = stmt.executeQuery();
			
			ProjectManager pm = new ProjectManager();
			
			pm.setUserId(result.getInt(2));
			pm.setUserName(result.getString(3));
			pm.setUserEmail(result.getString(4));
			pm.setPassword(result.getString(5));
			
			return pm;
			
		} catch (SQLException e) {
			e.printStackTrace();
//			TODO: throw exception
			return null;
		}
	}

}
