package in.co.hsbc.bts.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import in.co.hsbc.bts.dao.BugDao;
import in.co.hsbc.bts.factory.Factory;
import in.co.hsbc.bts.model.Bug;
import in.co.hsbc.bts.model.Developer;
import in.co.hsbc.bts.model.Project;
import in.co.hsbc.bts.model.ProjectManager;
import in.co.hsbc.bts.model.Tester;
import in.co.hsbc.bts.model.BugStatus;

public class BugDaoImpl implements BugDao {
	
	private Connection con = null;
	private ProjectDaoImpl projectDaoImpl;
	private TesterDaoImpl testerDaoImpl;
	private DeveloperDaoImpl developerDaoImpl;
	private ProjectManagerDaoImpl projectManagerDaoImpl;
	
	public BugDaoImpl() {
		try 
		{
			con = Factory.getJdbcConnection();
			projectDaoImpl = new ProjectDaoImpl();
			testerDaoImpl = new TesterDaoImpl();
			developerDaoImpl = new DeveloperDaoImpl();
			projectDaoImpl = new ProjectDaoImpl();
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	@Override
	public boolean create(Bug bug) {
		String query  = "INSERT INTO bug_tbl VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
		try 
		{
			PreparedStatement stmt = con.prepareStatement(query);
			
			stmt.setInt(1, bug.getId());
			stmt.setString(2, bug.getTitle());
			stmt.setString(3, bug.getDescription());
			stmt.setInt(4, bug.getProject().getProjectId());
			stmt.setInt(5, bug.getCreatedBy().getUserId());
			stmt.setDate(6,convertUtilToSql( bug.getOpenDate()));
			stmt.setInt(7,  bug.getAssignedTo().getUserId());
			stmt.setInt(8, bug.getMarkedForClosingBy().getUserId());
			stmt.setInt(9, bug.getClosedBy().getUserId());
			stmt.setDate(10, convertUtilToSql(bug.getClosedOn()));
			//stmt.set	Enum
			//stmt.set	Enum
			int inserted = stmt.executeUpdate();
			if(inserted==1) {
				return true;
			}
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//TODO exception
		}
		
		return false;
	}

	public Date convertSqlToUtilDate(java.sql.Date sqlDate) {
		java.util.Date utilDate = new java.util.Date(sqlDate.getTime());
		return utilDate;
	}
	
	public java.sql.Date convertUtilToSql(java.util.Date utilDate){
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		return sqlDate;
	}
	@Override
	public Bug getById(int id) {
		String query = "SELECT * FROM bug_tbl WHERE bugId = ?";
		
		try {
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, id);
			ResultSet result = stmt.executeQuery();
			
			Bug bug = new Bug();
			bug.setTitle(result.getString("title"));
			bug.setDescription(result.getString("description"));
			
			Project p = projectDaoImpl.getById(result.getInt("projectId"));
			bug.setProject(p);
			
			Tester tester = testerDaoImpl.getById(result.getInt("createdBy"));
			bug.setCreatedBy(tester);
			
			bug.setOpenDate(convertSqlToUtilDate(result.getDate("openDate")));
			
			Developer developer = developerDaoImpl.getById(result.getInt("assignedTo"));
			bug.setAssignedTo(developer);
			
			Developer developerMarkedForClosing = developerDaoImpl.getById(result.getInt("markedForClosingBy"));
			bug.setMarkedForClosingBy(developerMarkedForClosing);
			
			ProjectManager projectManager = projectManagerDaoImpl.getById(result.getInt("closedBy"));
			bug.setClosedBy(projectManager);
			
			bug.setClosedOn(convertSqlToUtilDate(result.getDate("closedOn")));
			
			//bug.setBugStatus(null);
			
			//bug.setSeverityLevel(null);
			
			return bug;
			
		} catch (SQLException e) {
			e.printStackTrace();
			//TODO: throw Exception
		}
		
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
		
		String query = "SELECT * FROM bug_tbl";
		try 
		{
			PreparedStatement stmt = con.prepareStatement(query);
			ResultSet result = stmt.executeQuery();
			Set<Bug> bugSet = new HashSet<>();
			while(result.next()) {
				Bug bug = new Bug();
				
				bug.setTitle(result.getString("title"));
				bug.setDescription(result.getString("description"));
				
				Project p = projectDaoImpl.getById(result.getInt("projectId"));
				bug.setProject(p);
				
				Tester tester = testerDaoImpl.getById(result.getInt("createdBy"));
				bug.setCreatedBy(tester);
				
				bug.setOpenDate(convertSqlToUtilDate(result.getDate("openDate")));
				
				Developer developer = developerDaoImpl.getById(result.getInt("assignedTo"));
				bug.setAssignedTo(developer);
				
				Developer developerMarkedForClosing = developerDaoImpl.getById(result.getInt("markedForClosingBy"));
				bug.setMarkedForClosingBy(developerMarkedForClosing);
				
				ProjectManager projectManager = projectManagerDaoImpl.getById(result.getInt("closedBy"));
				bug.setClosedBy(projectManager);
				
				bug.setClosedOn(convertSqlToUtilDate(result.getDate("closedOn")));
				
				//bug.setBugStatus(null);
				
				//bug.setSeverityLevel(null);
				
				bugSet.add(bug);
			}
			return bugSet;
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
			//TODO throw exception
			
		}
		
		return null;
	}

}
