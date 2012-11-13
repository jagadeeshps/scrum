package co.edu.unal.scrum.shared.actions;

import com.gwtplatform.dispatch.shared.ActionImpl;
import co.edu.unal.scrum.shared.actions.CreateProjectResult;
import java.lang.String;
import java.util.Date;

public class CreateProject extends ActionImpl<CreateProjectResult> {

	private String name;
	private Date startDate;
	private Date endDate;
	private int teamSize;
	private String description;
private String email;
	@SuppressWarnings("unused")
	private CreateProject() {
		// For serialization only
	}

	public CreateProject(String name, Date startDate, Date endDate, int teamSize,
			String description, String email) {
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.teamSize = teamSize;
		this.description = description;
		this.email=email;
	}

	public String getName() {
		return name;
	}

	public Date getStartDate() {
		return startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public int getTeamSize() {
		return teamSize;
	}

	public String getDescription() {
		return description;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmail() {
		return email;
	}
}
