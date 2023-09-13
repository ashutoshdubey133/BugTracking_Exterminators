package in.co.hsbc.bts.view.impl;

import java.util.Scanner;
import java.util.Set;

import in.co.hsbc.bts.model.Bug;
import in.co.hsbc.bts.model.Developer;
import in.co.hsbc.bts.model.Project;
import in.co.hsbc.bts.model.ProjectManager;
import in.co.hsbc.bts.model.Team;
import in.co.hsbc.bts.model.Tester;
import in.co.hsbc.bts.view.BtsView;

public class BtsViewImpl implements BtsView,AutoCloseable{
	
	public int showRoles() 
	{	
		System.out.println("Choose the role ");
		System.out.println("1.Project Manager");
		System.out.println("2.Developer");
		System.out.println("3.Tester");
		Scanner sc= new Scanner(System.in);
		int option = sc.nextInt();
		return option;
	}

	public ProjectManager addProjectManager() {
     
		System.out.println("Enter your Name");
      
		return null;
	}
	
	public Bug addBug(){
		
		return null;
	}
	
	public Project addProject(){
		
		return null;
		
	}

	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void viewAllBug(Set<Bug> b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void viewAllTeams(Set<Team> t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void viewProject(Project p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Team addTeam() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void viewAllDevelopers(Set<Developer> d) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void viewAllTesters(Set<Tester> t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int markProjectForClosing() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void diplayBugs(Set<Bug> b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int closeBug() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Bug reassigningBug() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Bug assigningBug() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void displayBugsWhichAreMarkedForClosing(Set<Bug> s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void viewBugsAssigned(Set<Bug> b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void viewTeam(Team t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void viewBugsOpened(Set<Bug> s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int markBugToClose() {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
