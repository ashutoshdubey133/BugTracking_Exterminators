package in.co.hsbc.bts.model;

import java.util.Set;

public class ProjectManager extends User{
	private Set<Project> projects; //maximum of 4 projects

	public Set<Project> getProjects() {
		return projects;
	}

	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}
	
}
