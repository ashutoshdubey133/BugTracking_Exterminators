package in.co.hsbc.bts.service.impl;

import java.util.Set;

import in.co.hsbc.bts.dao.exception.NoSuchRecordException;
import in.co.hsbc.bts.dao.impl.BugDaoImpl;
import in.co.hsbc.bts.dao.impl.DeveloperDaoImpl;
import in.co.hsbc.bts.dao.impl.ProjectDaoImpl;
import in.co.hsbc.bts.dao.impl.ProjectManagerDaoImpl;
import in.co.hsbc.bts.dao.impl.TeamDaoImpl;
import in.co.hsbc.bts.dao.impl.TesterDaoImpl;
import in.co.hsbc.bts.dao.impl.UserDaoImpl;
import in.co.hsbc.bts.model.Bug;
import in.co.hsbc.bts.model.BugSeverityLevel;
import in.co.hsbc.bts.model.Developer;
import in.co.hsbc.bts.model.Project;
import in.co.hsbc.bts.model.ProjectManager;
import in.co.hsbc.bts.model.Team;
import in.co.hsbc.bts.model.Tester;
import in.co.hsbc.bts.model.User;
import in.co.hsbc.bts.model.dto.LoginDTO;
import in.co.hsbc.bts.service.BtsService;
import in.co.hsbc.bts.service.exception.InvalidCredentialsException;

public class BtsServiceImpl implements BtsService{
	
	BugDaoImpl bugDaoImpl;
	DeveloperDaoImpl developerDaoImpl;
	ProjectDaoImpl projectDaoImpl;
	ProjectManagerDaoImpl projectManagerDaoImpl;
	TeamDaoImpl teamDaoImpl;
	TesterDaoImpl testerDaoImpl;
	UserDaoImpl userDaoImpl;
	
	public BtsServiceImpl(BugDaoImpl bugDaoImpl, DeveloperDaoImpl developerDaoImpl, ProjectDaoImpl projectDaoImpl, ProjectManagerDaoImpl projectManagerDaoImpl, TeamDaoImpl teamDaoImpl, TesterDaoImpl testerDaoImpl, UserDaoImpl userDaoImpl) {
		this.bugDaoImpl = bugDaoImpl;
		this.developerDaoImpl = developerDaoImpl;
		this.projectDaoImpl = projectDaoImpl;
		this.projectManagerDaoImpl = projectManagerDaoImpl;
		this.teamDaoImpl = teamDaoImpl;
		this.testerDaoImpl = testerDaoImpl;
		this.userDaoImpl = userDaoImpl;
	}
	
	@Override
	public boolean createManager(ProjectManager projectManager) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ProjectManager getProjectManagerById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateProjectManager(ProjectManager projectManager) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteProjectManagerById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean createDeveloper(Developer developer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Developer getDeveloperById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateDeveloper(Developer developer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteDeveloperById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean createTester(Tester tester) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Tester getTesterById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateTester(Tester tester) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteTesterById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean createBug(String title, String description, Project project, BugSeverityLevel bugSeverityLevel) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Bug getBugById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateBug(Bug bug) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteBugById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean createProject(Project project) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Project getProjectById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateProject(Project project) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteProjectById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean createTeam(Tester tester, Set<Developer> developers, Project project) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean assignBug(int bugId, Developer developer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean bugMarkedToClose(int bugId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean closeBug(int bugId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean reAssgnBug(int bugId, Developer developer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User getUserByLogin(LoginDTO login) throws InvalidCredentialsException {
		try {
			User user = userDaoImpl.getByEmail(login.getEmail());
			return user;
		} catch (NoSuchRecordException e) {
			e.printStackTrace();
			throw new InvalidCredentialsException();
		}
	}

	@Override
	public Set<Project> getProjectsByProjectManager(ProjectManager pm) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Developer> getDevelopersByProjectManager(ProjectManager pm) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Tester> getTestersByProjectManager(ProjectManager pm) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean closeProject(int projectIdToClose) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<Bug> getBugsByProjectManager(ProjectManager pm) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Bug> getBugsMarkedForClosingByProjectManager(ProjectManager pm) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Team getTeamByDeveloper(Developer dev) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Bug> getBugsByDeveloper(Developer dev) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Bug> getBugsByTester(Tester tester) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Team> getTeamsByTester(Tester tester) {
		// TODO Auto-generated method stub
		return null;
	}

}
