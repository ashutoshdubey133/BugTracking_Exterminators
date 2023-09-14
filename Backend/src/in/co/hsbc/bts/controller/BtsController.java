package in.co.hsbc.bts.controller;

import java.util.Set;

import in.co.hsbc.bts.factory.Factory;
import in.co.hsbc.bts.model.Bug;
import in.co.hsbc.bts.model.BugSeverityLevel;
import in.co.hsbc.bts.model.Developer;
import in.co.hsbc.bts.model.Project;
import in.co.hsbc.bts.model.ProjectManager;
import in.co.hsbc.bts.model.Team;
import in.co.hsbc.bts.model.Tester;
import in.co.hsbc.bts.model.User;
import in.co.hsbc.bts.model.UserType;
import in.co.hsbc.bts.model.dto.BugAssignDTO;
import in.co.hsbc.bts.model.dto.BugDTO;
import in.co.hsbc.bts.model.dto.LoginDTO;
import in.co.hsbc.bts.service.BtsService;
import in.co.hsbc.bts.view.BtsView;

public class BtsController{

	private static final BtsService service = Factory.getBtsService();
	private static final BtsView view = Factory.getBtsView();
	
	public static void main(String[] args) {
		
		try{

			int option = 0;
			do {
				LoginDTO login =view.getLogin();
				
				if(login == null) {
					option = -1;
					break;
				}
				
				User user = service.getUserByLogin(login);
				
				if(user.getUserType().equals(UserType.ProjectManager))
					option = 1;
				else if(user.getUserType().equals(UserType.Developer))
					option = 2;
				else if(user.getUserType().equals(UserType.Tester))
					option = 3;
					
				switch(option) {

				//ProjectManager
				case 1:
					handleProjectManager(user);
					break;

					//Developer
				case 2:
					handleDeveloper(user);
					break;

					//Tester
				case 3:
					handleTester(user);
					break;

				case -1:
					break;
				}	
			}while(option!= -1);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void handleProjectManager(User user) {
		int pmOption = 0;
		do {
			pmOption = view.displayProjectManagerOptions();
			ProjectManager pm = (ProjectManager) user;
					
			switch(pmOption) {
			//View All Projects Of ProjectManager
			case 1:
				Set<Project> projects= service.getProjectsByProjectManager(pm);
				view.displayProjects(projects);
				break;
				
			case 2:
				Project project = view.addProject();
				boolean createProject = service.createProject(project);
				if(createProject)
					view.showMessage("Project Created Successfully");
				else
					view.showError("Some Error Occured");
				break;
				
			case 3:
				Set<Developer> devs = service.getDevelopersByProjectManager(pm);
				view.viewAllDevelopers(devs);
				break;
				
			case 4:
				Set<Tester> testers = service.getTestersByProjectManager(pm);
				view.viewAllTesters(testers);
				break;
				
			case 5:
				int projectIdToClose = view.markProjectForClosing();
				if(service.closeProject(projectIdToClose))
					view.showMessage("Project Closed Successfully");
				else
					view.showError("Some Error Occured");
				break;
				
			case 6:
				Set<Bug> bugs = service.getBugsByProjectManager(pm);
				view.displayBugs(bugs);
				break;
				
			case 7:
				bugs = service.getBugsMarkedForClosingByProjectManager(pm);
				view.displayBugs(bugs);
				break;
				
			case 8:
				int closeBug = view.closeBug();
				if(service.closeBug(closeBug))
					view.showMessage("Bug Closed Successfully");
				else
					view.showError("Some Error Occured");
				
			case 9:
				BugAssignDTO bugAssignDTO = view.assigningBug();
				if(service.assignBug(bugAssignDTO.getBugId(), service.getDeveloperById(bugAssignDTO.getDeveloperId())))
					view.showMessage("Bug Assigned Successfully");
				else
					view.showError("Some Error occured");

			case 10:
				bugAssignDTO = view.reassigningBug();
				if(service.reAssgnBug(bugAssignDTO.getBugId(), service.getDeveloperById(bugAssignDTO.getDeveloperId())))
					view.showMessage("Bug Reassigned Successfully");
				else
					view.showError("Some Error occured");
				
				
			case -1:
				break;
			
			}
		}while(pmOption != -1);
	}
	
	private static void handleDeveloper(User user) {
		int devOption = 0;
		
		Developer dev = (Developer) user;
		
		do {
			devOption = view.displayDeveloperOptions();
			
			switch(devOption) {
			case 1:
				Team team = service.getTeamByDeveloper(dev);
				view.viewTeam(team);
				break;
			
			case 2:
				Set<Bug> bugs = service.getBugsByDeveloper(dev);
				view.displayBugs(bugs);
				break;
				
			case -1:
				break;
			
			}
		}while(devOption != -1);
	}
	
	private static void handleTester(User user) {
		int testerOption = 0;
		
		Tester tester = (Tester) user;
		
		do {
			testerOption = view.displayTesterOptions();
			
			switch(testerOption) {
			
			case 1:
				BugDTO bugDTO = view.addBug();
				Bug bug = new Bug();
				BugSeverityLevel bsl;
				if(service.createBug(bugDTO.getTitle(), bug.getDescription(), service.getProjectById(bugDTO.getProjectId()), BugSeverityLevel.valueOf(bugDTO.getSeverityLevel().toLowerCase())))
					view.showMessage("Bug created Successfully");
				else
					view.showError("Some Error Occured");
				break;
				
			case 2:
				Set<Bug> bugs = service.getBugsByTester(tester);
				view.displayBugs(bugs);
				break;
				
			case 3:
				Set<Team> teams = service.getTeamsByTester(tester);
				view.viewAllTeams(teams);
				break;
				
			case -1:
				break;
			}
		}while(testerOption != -1);
	}
}
