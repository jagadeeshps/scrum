package co.edu.unal.scrum.client.projects.widgets;

import co.edu.unal.scrum.client.projects.ProjectEditorPresenter;
import co.edu.unal.scrum.client.projects.ProjectsUiHandles;
import co.edu.unal.scrum.shared.model.Project;

import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.View;

public class ProjectPresenter extends PresenterWidget<ProjectPresenter.MyView> implements ProjectViewUiHandlers {

	public interface MyView extends View,HasUiHandlers<ProjectViewUiHandlers> {

		void setProject(Project project);
	}

	private Project project;
	private ProjectEditorPresenter editor;

	@Inject
	public ProjectPresenter(final EventBus eventBus, final MyView view,ProjectEditorPresenter editor) {
		super(eventBus, view);
		this.editor=editor;
	}

	@Override
	protected void onBind() {
		super.onBind();
		getView().setUiHandlers(this);
	}

	
	public void setProject(Project project) {
		// TODO Auto-generated method stub
		this.project=project;
		getView().setProject(project);
	}

	@Override
	public void onDetailsClicked() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDeleteClicked() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onSelectClicked() {
		// TODO Auto-generated method stub
		
	}
}
