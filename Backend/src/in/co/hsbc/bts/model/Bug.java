package in.co.hsbc.bts.model;

import java.util.Date;

public class Bug {
	private int id;
	private String title;
	private String description;
	private Project project;
	private Tester createdBy;
	private Date openDate;
	private Developer assignedTo;
	private Developer markedForClosingBy;
	private ProjectManager closedBy;
	private Date closedOn;
	private BugStatus bugStatus;
	private BugSeverityLevel severityLevel;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public Tester getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Tester createdBy) {
		this.createdBy = createdBy;
	}
	public Date getOpenDate() {
		return openDate;
	}
	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}
	public Developer getAssignedTo() {
		return assignedTo;
	}
	public void setAssignedTo(Developer assignedTo) {
		this.assignedTo = assignedTo;
	}
	public Developer getMarkedForClosingBy() {
		return markedForClosingBy;
	}
	public void setMarkedForClosingBy(Developer markedForClosingBy) {
		this.markedForClosingBy = markedForClosingBy;
	}
	public ProjectManager getClosedBy() {
		return closedBy;
	}
	public void setClosedBy(ProjectManager closedBy) {
		this.closedBy = closedBy;
	}
	public Date getClosedOn() {
		return closedOn;
	}
	public void setClosedOn(Date closedOn) {
		this.closedOn = closedOn;
	}
	public BugStatus getBugStatus() {
		return bugStatus;
	}
	public void setBugStatus(BugStatus bugStatus) {
		this.bugStatus = bugStatus;
	}
	public BugSeverityLevel getSeverityLevel() {
		return severityLevel;
	}
	public void setSeverityLevel(BugSeverityLevel severityLevel) {
		this.severityLevel = severityLevel;
	}
}
