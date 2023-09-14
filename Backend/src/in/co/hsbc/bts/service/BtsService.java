package in.co.hsbc.bts.service;

import java.util.Set;

import in.co.hsbc.bts.model.Bug;
import in.co.hsbc.bts.model.BugSeverityLevel;
import in.co.hsbc.bts.model.Developer;
import in.co.hsbc.bts.model.Project;
import in.co.hsbc.bts.model.ProjectManager;
import in.co.hsbc.bts.model.Tester;
import in.co.hsbc.bts.model.User;
import in.co.hsbc.bts.model.dto.LoginDTO;

public interface BtsService {
	boolean createManager(ProjectManager projectManager);
	ProjectManager getProjectManagerById(int id);
	boolean updateProjectManager(ProjectManager projectManager);
	boolean deleteProjectManagerById(int id);
	
	boolean createDeveloper(Developer developer);
	Developer getDeveloperById(int id);
	boolean updateDeveloper(Developer developer);
	boolean deleteDeveloperById(int id);
	
	
	boolean createTester(Tester tester);
	Tester getTesterById(int id);
	boolean updateTester(Tester tester);
	boolean deleteTesterById(int id);
	
	boolean createBug(String title, String description, Project project, BugSeverityLevel bugSeverityLevel);
	Bug getBugById(int id);
	boolean updateBug(Bug bug);
	boolean deleteBugById(int id);
	
	
	boolean createProject(Project project);
	Project getProjectById(int id);
	boolean updateProject(Project project);
	boolean deleteProjectById(int id);
	
	boolean createTeam(Tester tester, Set<Developer> developers, Project project);
	boolean assignBug(int bugId, Developer developer);
	boolean bugMarkedToClose(int bugId);
	boolean closeBug(int bugId);
	boolean reAssgnBug(int bugId,Developer developer);
	User getUserByLogin(LoginDTO login);
	Set<Project> getProjectsByProjectManager(ProjectManager pm);
	Set<Developer> getDevelopersByProjectManager(ProjectManager pm);
	Set<Tester> getTestersByProjectManager(ProjectManager pm);
	boolean closeProject(int projectIdToClose);
	Set<Bug> getBugsByProjectManager(ProjectManager pm);
	Set<Bug> getBugsMarkedForClosingByProjectManager(ProjectManager pm);
	
	
}
