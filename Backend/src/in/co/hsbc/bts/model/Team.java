package in.co.hsbc.bts.model;

import java.util.Set;

public class Team {
	private ProjectManager projectManager;
	private Tester tester;
	private Set<Developer> developers;
	private Project project; 	//Project on which the team is working on.
	public ProjectManager getProjectManager() {
		return projectManager;
	}
	public void setProjectManager(ProjectManager projectManager) {
		this.projectManager = projectManager;
	}
	public Tester getTester() {
		return tester;
	}
	public void setTester(Tester tester) {
		this.tester = tester;
	}
	public Set<Developer> getDevelopers() {
		return developers;
	}
	public void setDevelopers(Set<Developer> developers) {
		this.developers = developers;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
}
