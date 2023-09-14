package in.co.hsbc.bts.model;

public enum ProjectStatus {
	InProgress ("inprogress"),
	Completed ("completed");

	public final String value;

	private ProjectStatus(String value) {
		this.value = value;
	}
}
