package in.co.hsbc.bts.service.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import in.co.hsbc.bts.dao.BugDao;
import in.co.hsbc.bts.dao.DeveloperDao;
import in.co.hsbc.bts.dao.ProjectDao;
import in.co.hsbc.bts.dao.ProjectManagerDao;
import in.co.hsbc.bts.dao.TeamDao;
import in.co.hsbc.bts.dao.TesterDao;
import in.co.hsbc.bts.dao.UserDao;
import in.co.hsbc.bts.dao.exception.NoSuchRecordException;
import in.co.hsbc.bts.model.Bug;
import in.co.hsbc.bts.model.BugSeverityLevel;
import in.co.hsbc.bts.model.BugStatus;
import in.co.hsbc.bts.model.Developer;
import in.co.hsbc.bts.model.Project;
import in.co.hsbc.bts.model.ProjectManager;
import in.co.hsbc.bts.model.ProjectStatus;
import in.co.hsbc.bts.model.Team;
import in.co.hsbc.bts.model.Tester;
import in.co.hsbc.bts.model.User;
import in.co.hsbc.bts.model.dto.LoginDTO;
import in.co.hsbc.bts.service.BtsService;
import in.co.hsbc.bts.service.exception.InvalidCredentialsException;

public class BtsServiceImpl implements BtsService{

	private UserDao userDao;
	private ProjectManagerDao projectManagerDao;
	private DeveloperDao developerDao;
	private TesterDao testerDao;
	private ProjectDao projectDao;
	private BugDao bugDao;
	private TeamDao teamDao;
	
	public static int bugId = 0;
	public static int projectId = 0 ;
	
	private Set<Bug> bugSet;
	private Set<Project> projectSet;
	private Set<Developer> developerSet;
	private Set<Tester> testerSet;
	public BtsServiceImpl(UserDao userDao, ProjectManagerDao projectManagerDao, DeveloperDao developerDao, TesterDao testerDao, ProjectDao projectDao,BugDao bugDao, TeamDao teamDao)
	{
		this.userDao = userDao;
		this.projectManagerDao = projectManagerDao;
		this.developerDao = developerDao;
		this.testerDao = testerDao;
		this.projectDao = projectDao;
		this.bugDao = bugDao;
		this.teamDao = teamDao;
		
		bugSet = new HashSet<>();
		projectSet = new HashSet<>();
		developerSet = new HashSet<>();
		testerSet = new HashSet<>();
	}
	@Override
	public boolean createManager(ProjectManager projectManager) {
		return this.projectManagerDao.create(projectManager);
	}

	@Override
	public ProjectManager getProjectManagerById(int id) {
		
		return this.projectManagerDao.getById(id);
	}

	@Override
	public boolean updateProjectManager(ProjectManager projectManager) {
		// TODO Auto-generated method stub
		return this.projectManagerDao.update(projectManager);
	}

	@Override
	public boolean deleteProjectManagerById(int id) {
		// TODO Auto-generated method stub
		return this.projectManagerDao.deleteById(id);
	}

	@Override
	public boolean createDeveloper(Developer developer) {
		developerSet.add(developer);
		return this.developerDao.create(developer);
	}

	@Override
	public Developer getDeveloperById(int id) {
		return this.developerDao.getById(id);
	}

	@Override
	public boolean updateDeveloper(Developer developer) {
		// TODO Auto-generated method stub
		return this.developerDao.update(developer);
	}

	@Override
	public boolean deleteDeveloperById(int id) {
		// TODO Auto-generated method stub
		return this.developerDao.deleteById(id);
	}

	@Override
	public boolean createTester(Tester tester) {
		testerSet.add(tester);
		return this.testerDao.create(tester);
	}

	@Override
	public Tester getTesterById(int id) {
		// TODO Auto-generated method stub
		return this.testerDao.getById(id);
	}

	@Override
	public boolean updateTester(Tester tester) {
		// TODO Auto-generated method stub
		return this.testerDao.update(tester);
	}

	@Override
	public boolean deleteTesterById(int id) {
		// TODO Auto-generated method stub
		return this.testerDao.deleteById(id);
	}

	@Override
	public boolean createBug(String title, String description, Project project, BugSeverityLevel bugSeverityLevel) {
		// TODO Auto-generated method stub
		Bug bug = new Bug();
		bug.setId(bugId++);
		bug.setTitle(title);
		bug.setDescription(description);
		bug.setProject(project);
		bug.setSeverityLevel(bugSeverityLevel);
		bug.setCreatedBy(project.getProjectTeam().getTester());
		bug.setOpenDate(new Date());
		bug.setBugStatus(BugStatus.Open);
		bug.setSeverityLevel(BugSeverityLevel.Critical);
		project.setProjectStatus(ProjectStatus.InProgress);
		bugSet.add(bug);
		project.getProjectTeam().getTester().setBugsReported(bugSet);
		return this.bugDao.create(bug);
	}

	@Override
	public Bug getBugById(int id) {
		return this.bugDao.getById(id);
	}

	@Override
	public boolean updateBug(Bug bug) {
		return this.bugDao.update(bug);
	}

	@Override
	public boolean deleteBugById(int id) {
		// TODO Auto-generated method stub
		return this.bugDao.deleteById(id);
	}

	@Override
	public boolean createProject(Project project) {
		
		long projectForManagerCount = projectSet.stream().filter(project1 -> project1.getProjectTeam().getProjectManager()==project1.getProjectTeam().getProjectManager()).count();
		if(projectForManagerCount>4) {
			//TODO throw exception
		}
		//remaining to assign the team here
		project.setProjectId(projectId++);
		project.setProjectStatus(ProjectStatus.InProgress);
		projectSet.add(project);
		project.getProjectTeam().getProjectManager().setProjects(projectSet);
		
		return this.projectDao.create(project);
	}

	@Override
	public Project getProjectById(int id) {
		// TODO Auto-generated method stub
		return this.projectDao.getById(id);
	}

	@Override
	public boolean updateProject(Project project) {
		// TODO Auto-generated method stub
		return this.projectDao.update(project);
	}

	@Override
	public boolean deleteProjectById(int id) {
		// TODO Auto-generated method stub
		return this.projectDao.deleteById(id);
	}

	@Override
	public boolean createTeam(Tester tester, Set<Developer> developers, Project project) {
		Team team = new Team();
		long managercount = projectSet.stream().filter(project1 -> project1.getProjectTeam().getProjectManager().getUserId()==project.getProjectTeam().getProjectManager().getUserId()).count();
		if(managercount>4) {
			//TODO throw exception
		}
		team.setTester(tester);
		team.setDevelopers(developers);
		team.setProject(project);
		
		return this.teamDao.create(team);
	}

	@Override
	public boolean assignBug(int bugId, Developer developer) {
		Bug bug = bugDao.getById(bugId);
		
		boolean checkDeveloperTeam= bug.getProject().getProjectTeam().getDevelopers().contains(developer);
		if(checkDeveloperTeam) {
			bug.setAssignedTo(developer);
		}
		return checkDeveloperTeam;
	}

	@Override
	public boolean bugMarkedToClose(int bugId) {
		if(bugDao.getById(bugId).getBugStatus()==BugStatus.Open) {
			bugDao.getById(bugId).setBugStatus(BugStatus.MarkedForClose);
			return true;
		}
		return false;
	}

	@Override
	public boolean closeBug(int bugId) {
		if(bugDao.getById(bugId).getBugStatus()==BugStatus.MarkedForClose) {
			bugDao.getById(bugId).setBugStatus(BugStatus.Closed);
			return true;
		}
		return false;
	}

	@Override
	public boolean reAssgnBug(int bugId, Developer developer) {
		bugDao.getById(bugId).setBugStatus(BugStatus.Open);
		assignBug(bugId, developer);
		return true;
	}

	@Override
	public User getUserByLogin(LoginDTO login) throws InvalidCredentialsException{
		
		Optional<ProjectManager> manager = this.projectManagerDao.findAll().stream().filter(pm -> pm.getUserEmail()==login.getEmail()).findFirst();
		Optional<Tester> tester  = this.testerDao.findAll().stream().filter(pm -> pm.getUserEmail()==login.getEmail()).findFirst();
		Optional<Developer> developer = this.developerDao.findAll().stream().filter(pm -> pm.getUserEmail()==login.getEmail()).findFirst();
		if(manager.isPresent()) {
			return manager.get();
		}
		else if(tester.isPresent()){
			return tester.get();
		}
		else if(developer.isPresent()) {
			return developer.get();
		}
		throw new InvalidCredentialsException();
		
	}

	@Override
	public Set<Project> getProjectsByProjectManager(ProjectManager pm) {
		Set<Project> managerSpecificProjects = projectDao.findAll().stream().filter(project -> project.getProjectTeam().getProjectManager().getUserId()==pm.getUserId()).collect(Collectors.toSet());
		
		return managerSpecificProjects;
	}

	@Override
	public Set<Developer> getDevelopersByProjectManager(ProjectManager pm) {
		//Set<Developer> developersUnderManager = projectDao.findAll().stream().filter(project -> project.getProjectTeam().getProjectManager().getUserId()==pm.getUserId()).
		return null;
	}

	@Override
	public Set<Tester> getTestersByProjectManager(ProjectManager pm) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean closeProject(int projectIdToClose) {
		if(projectDao.getById(projectIdToClose).getProjectStatus()==ProjectStatus.InProgress) {
			projectDao.getById(projectIdToClose).setProjectStatus(ProjectStatus.Completed);
		}
		return false;
	}

	@Override
	public Set<Bug> getBugsByProjectManager(ProjectManager pm) {
		
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
