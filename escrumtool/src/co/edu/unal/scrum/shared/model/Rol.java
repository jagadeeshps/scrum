package co.edu.unal.scrum.shared.model;

public enum Rol {
	PRODUCT_OWNER("Product owner"), SCRUM_MASTER("Scrum Master"), TEAM("Team");
	private final String displayName;

	Rol(final String displayName) {
		this.displayName = displayName;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return displayName;
	}
}
