package in.co.hsbc.bts.model;

import java.util.Set;

public class Tester extends User{
	private Set<Team> teams;	//Tester can be assigned to 2 projects but the manager should be same
	private Set<Bug> bugsReported;
	
	public Set<Team> getTeams() {
		return teams;
	}
	public void setTeams(Set<Team> teams) {
		this.teams = teams;
	}
	public Set<Bug> getBugsReported() {
		return bugsReported;
	}
	public void setBugsReported(Set<Bug> bugsReported) {
		this.bugsReported = bugsReported;
	}
}
