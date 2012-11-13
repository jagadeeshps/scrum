package co.edu.unal.scrum.client.events;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.EventHandler;
import co.edu.unal.scrum.shared.model.Project;
import com.google.gwt.event.shared.HasHandlers;
import com.google.gwt.event.shared.HandlerRegistration;

public class ProjectAddedEvent extends
		GwtEvent<ProjectAddedEvent.ProjectAddedHandler> {

	public static Type<ProjectAddedHandler> TYPE = new Type<ProjectAddedHandler>();
	private Project project;

	public interface ProjectAddedHandler extends EventHandler {
		void onProjectAdded(ProjectAddedEvent event);
	}

	public interface ProjectAddedHasHandlers extends HasHandlers {
		HandlerRegistration addProjectAddedHandler(ProjectAddedHandler handler);
	}

	public ProjectAddedEvent(Project project) {
		this.project = project;
	}

	public Project getProject() {
		return project;
	}

	@Override
	protected void dispatch(ProjectAddedHandler handler) {
		handler.onProjectAdded(this);
	}

	@Override
	public Type<ProjectAddedHandler> getAssociatedType() {
		return TYPE;
	}

	public static Type<ProjectAddedHandler> getType() {
		return TYPE;
	}

	public static void fire(HasHandlers source, Project project) {
		source.fireEvent(new ProjectAddedEvent(project));
	}
}
