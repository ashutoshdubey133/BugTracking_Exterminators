package in.co.hsbc.bts.model;

import java.util.Date;

public class Project {
	private int projectId;
	private String projectName;
	private String projectDescription;
	private Date startDate;
	private Team projectTeam;
	private ProjectStatus projectStatus;
	
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getProjectDescription() {
		return projectDescription;
	}
	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Team getProjectTeam() {
		return projectTeam;
	}
	public void setProjectTeam(Team projectTeam) {
		this.projectTeam = projectTeam;
	}
	public ProjectStatus getProjectStatus() {
		return projectStatus;
	}
	public void setProjectStatus(ProjectStatus projectStatus) {
		this.projectStatus = projectStatus;
	}

}
