package co.edu.unal.scrum.shared.model;

public enum ProjectStatus {
	NEW("New"), STARTED("Started"), FINISHED("Finished");
	private final String displayName;

	ProjectStatus(final String displayName) {
		// TODO Auto-generated constructor stub
		this.displayName = displayName;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return displayName;
	}
}
