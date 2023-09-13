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
		Scanner sc= new Scanner(System.in);
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
	

}
