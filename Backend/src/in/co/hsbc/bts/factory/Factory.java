package in.co.hsbc.bts.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import in.co.hsbc.bts.service.BtsService;
import in.co.hsbc.bts.service.impl.BtsServiceImpl;
import in.co.hsbc.bts.view.BtsView;
import in.co.hsbc.bts.view.impl.BtsViewImpl;

public class Factory {
	
	public static BtsService getBtsService() {
		return new BtsServiceImpl();
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
