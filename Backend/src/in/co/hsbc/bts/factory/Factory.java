package in.co.hsbc.bts.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import in.co.hsbc.bts.dao.impl.BugDaoImpl;
import in.co.hsbc.bts.dao.impl.DeveloperDaoImpl;
import in.co.hsbc.bts.dao.impl.ProjectDaoImpl;
import in.co.hsbc.bts.dao.impl.ProjectManagerDaoImpl;
import in.co.hsbc.bts.dao.impl.TeamDaoImpl;
import in.co.hsbc.bts.dao.impl.TesterDaoImpl;
import in.co.hsbc.bts.dao.impl.UserDaoImpl;
import in.co.hsbc.bts.service.BtsService;
import in.co.hsbc.bts.service.impl.BtsServiceImpl;
import in.co.hsbc.bts.view.BtsView;
import in.co.hsbc.bts.view.impl.BtsViewImpl;

public class Factory {
	
	public static BtsService getBtsService() {
		return new BtsServiceImpl(new BugDaoImpl(), new DeveloperDaoImpl(), new ProjectDaoImpl(), new ProjectManagerDaoImpl(), new TeamDaoImpl(), new TesterDaoImpl(), new UserDaoImpl());
	}
	
	public static BtsView getBtsView() {
		return new BtsViewImpl();
	}
	
	public static Connection getJdbcConnection() throws SQLException, ClassNotFoundException {
			Connection con;
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/btsapp_db", "root", "root");
			return con;
	}
}
