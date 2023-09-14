package in.co.hsbc.bts.model;

public enum UserType {
	ProjectManager("projectmanager"),
	Developer("developer"),
	Tester("tester");

	public final String value;

	private UserType(String value) {
		this.value = value;
	}
}
