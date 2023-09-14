package in.co.hsbc.bts.model;

public enum BugStatus {
	Open ("open"),
	Closed ("closed");

	public final String value;

	private BugStatus(String value) {
		this.value = value;
	}
}
