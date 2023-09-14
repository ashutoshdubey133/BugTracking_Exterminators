package in.co.hsbc.bts.model;

public enum BugSeverityLevel {
	Critical("critical"),
	Major("major"),
	Minor("minor"),
	Trivial("trivial");
	
	public final String value;
	
	private BugSeverityLevel(String value) {
		this.value = value;
	}
}
