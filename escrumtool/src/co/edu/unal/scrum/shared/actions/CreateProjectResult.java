package co.edu.unal.scrum.shared.actions;

import com.gwtplatform.dispatch.shared.Result;
import co.edu.unal.scrum.shared.model.Project;
import java.lang.String;

public class CreateProjectResult implements Result {

	private Project project;
	private boolean error;
	private String errorMessage;

	@SuppressWarnings("unused")
	private CreateProjectResult() {
		// For serialization only
	}

	public CreateProjectResult(Project project, boolean error, String errorMessage) {
		this.project = project;
		this.error = error;
		this.errorMessage = errorMessage;
	}

	public Project getProject() {
		return project;
	}

	public boolean isError() {
		return error;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
}
