package in.co.hsbc.bts.model;

import java.util.Set;

public class Developer {
	private Set<Bug> bugs; //Bugs assigned to the Developer
	private Team team;
	
	public Set<Bug> getBugs() {
		return bugs;
	}
	public void setBugs(Set<Bug> bugs) {
		this.bugs = bugs;
	}
	public Team getTeam() {
		return team;
	}
	public void setTeam(Team team) {
		this.team = team;
	}
	
}
