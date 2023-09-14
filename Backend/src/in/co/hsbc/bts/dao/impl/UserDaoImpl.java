package in.co.hsbc.bts.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

import in.co.hsbc.bts.dao.UserDao;
import in.co.hsbc.bts.dao.exception.NoSuchRecordException;
import in.co.hsbc.bts.factory.Factory;
import in.co.hsbc.bts.model.Developer;
import in.co.hsbc.bts.model.ProjectManager;
import in.co.hsbc.bts.model.Tester;
import in.co.hsbc.bts.model.User;
import in.co.hsbc.bts.model.UserType;

public class UserDaoImpl implements UserDao {
	
	private Connection con = null;

	public UserDaoImpl() {
		try {
			con = Factory.getJdbcConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public boolean create(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getByEmail(String email) throws NoSuchRecordException {
		try {
			String query = "SELECT * FROM btsapp_db.user_tbl where email = ?";
			
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, email);
			
			ResultSet result = stmt.executeQuery();
			
			result.next();
			
			String userType = result.getString(5);
			
			User user = null;
			UserType ut = null;
			
			if(userType.equals("projectmanager")) {
				user = new ProjectManager();
				ut = UserType.ProjectManager;
			}
			else if(userType.equals("developer")) {
				user = new Developer();
				ut = UserType.Developer;
			}
			else if(userType.equals("tester")) {
				user = new Tester();
				ut = UserType.Tester;
			}else{
				throw new SQLException();
			}
			
			user.setUserId(result.getInt(1));
			user.setUserName(result.getString(2));
			user.setUserEmail(result.getString(3));
			user.setPassword(result.getString(4));
			user.setUserType(ut);
			
			return user;
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new NoSuchRecordException();
		}
	}

}
