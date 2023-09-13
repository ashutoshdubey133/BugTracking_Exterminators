package in.co.hsbc.bts.service.impl;

import java.util.Date;
import java.util.Set;

import in.co.hsbc.bts.model.Bug;
import in.co.hsbc.bts.model.BugSeverityLevel;
import in.co.hsbc.bts.model.Developer;
import in.co.hsbc.bts.model.Project;
import in.co.hsbc.bts.model.ProjectManager;
import in.co.hsbc.bts.model.Tester;
import in.co.hsbc.bts.service.BtsService;

public class BtsServiceImpl implements BtsService{

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
	public boolean createProject(String projectName, String description, Date startDate) {
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

}
