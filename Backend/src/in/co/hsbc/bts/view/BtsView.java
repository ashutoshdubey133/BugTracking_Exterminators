package in.co.hsbc.bts.view;

import java.util.Set;

import in.co.hsbc.bts.model.Bug;
import in.co.hsbc.bts.model.Developer;
import in.co.hsbc.bts.model.Project;
import in.co.hsbc.bts.model.Team;
import in.co.hsbc.bts.model.Tester;
import in.co.hsbc.bts.model.dto.BugAssignDTO;
import in.co.hsbc.bts.model.dto.LoginDTO;

public interface BtsView  extends AutoCloseable{

	//Roles
	int showRoles();
	
	//Tester
	Bug addBug();
	void viewAllBug(Set<Bug>b); //loop print
	void viewAllTeams(Set<Team>t);
	
	//Project Manager
	Project addProject();
	void viewProject(Project p);
	Team addTeam();
	void viewAllDevelopers(Set<Developer> d);
	void viewAllTesters(Set<Tester>t);
	int markProjectForClosing(); //return project id from user (accept)
	void displayBugs(Set<Bug>b);
	int closeBug();//return project id from user (accept)
	BugAssignDTO reassigningBug();//Bug id,Developer id (User )-->array return krna
	BugAssignDTO assigningBug();//Bug id,Developer id (User )-->array return krna
	
	//Developer
	void viewTeam(Team t);//print team
	int markBugToClose();//accept bug id return id
	
	//GeneralMessagesAndErrors
	void showMessage(String str);
	void showError(String str);

	int displayProjectManagerOptions();

	int displayDeveloperOptions();

	int displayTesterOptions();

	LoginDTO getLogin();

	void displayProjects(Set<Project> projects);
}
