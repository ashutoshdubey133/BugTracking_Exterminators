package in.co.hsbc.bts.view.impl;

import java.util.Scanner;
import java.util.Set;

import in.co.hsbc.bts.model.Bug;
import in.co.hsbc.bts.model.Developer;
import in.co.hsbc.bts.model.Project;
import in.co.hsbc.bts.model.Team;
import in.co.hsbc.bts.model.Tester;
import in.co.hsbc.bts.view.BtsView;

public class BtsViewImpl implements BtsView{
	Scanner sc;
	
	public BtsViewImpl(){
		sc = new Scanner(System.in);
	}
	
	public int showRoles() 
	{	
		System.out.println("Choose the role ");
		System.out.println("1.Project Manager");
		System.out.println("2.Developer");
		System.out.println("3.Tester");
		System.out.println("-1. Exit");
		
		int option = sc.nextInt();
		return option;
	}
	
	public Bug addBug(){
		Bug b = new Bug();
		System.out.println("Enter Bug Title:");
		b.setTitle(sc.nextLine());
		System.out.println("Enter Bug Description:");
		b.setDescription(sc.nextLine());
		System.out.println("Enter Project Id of Bug:");
		System.out.println("Enter Your Tester Id:");
		System.out.println("Enter Bug Severity Level:");
		return null;
	}
	
	public Project addProject(){
		// TODO: complete
		return null;
	}

	@Override
	public void close() throws Exception {
		sc.close();
	}

	@Override
	public void viewAllBug(Set<Bug> b) {
		b.forEach(System.out::println);
	}

	@Override
	public void viewAllTeams(Set<Team> t) {
		t.forEach(System.out::println);
	}

	@Override
	public void viewProject(Project p) {
		System.out.println(p);
	}

	@Override
	public Team addTeam() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void viewAllDevelopers(Set<Developer> d) {
		d.forEach(System.out::println);
	}

	@Override
	public void viewAllTesters(Set<Tester> t) {
		t.forEach(System.out::println);
	}

	@Override
	public int markProjectForClosing() {
		System.out.println("Enter Project Id For Closing");
		return sc.nextInt();
	}

	@Override
	public void diplayBugs(Set<Bug> s) {
		s.forEach(System.out::println);
	}

	@Override
	public int closeBug() {
		System.out.println("Enter Bug Id For Closing");
		return sc.nextInt();
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
	public void viewTeam(Team t) {
		System.out.println(t);
	}


	@Override
	public int markBugToClose() {
		System.out.println("Enter The Bug Id To Close");
		return sc.nextInt();
	}

	@Override
	public void showMessage(String str) {
		System.out.println(str);
	}

	@Override
	public void showError(String str) {
		System.err.println(str);
	}

	@Override
	public int displayProjectManagerOptions() {
		System.out.println("1. View Projects");
		System.out.println("2. Add Project");
		System.out.println("3. View All Developers");
		System.out.println("4. View All Testers");
		System.out.println("5. Close Project");
		System.out.println("6. View All Bugs");
		System.out.println("7. View All Bugs Marked For Closing");
		System.out.println("8. Close Bug");
		System.out.println("9. Assign Bug To Developer");
		System.out.println("10. ReAssign Bug To Developer");
		System.out.println("-1. Exit");
		return sc.nextInt();
	}

	@Override
	public int displayDeveloperOptions() {
		System.out.println("1. Add Bug");
		System.out.println("1. View All Bugs");
		System.out.println("3. View All Teams");
		return sc.nextInt();
	}

	@Override
	public int displayTesterOptions() {
		System.out.println("1. View Team");
		System.out.println("2. View All Bugs");
		return sc.nextInt();
	}
	

}
