package co.edu.unal.scrum.client.projects.widgets;

import co.edu.unal.scrum.client.projects.ProjectsUiHandles;

import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.View;

public class ProjectPresenter extends PresenterWidget<ProjectPresenter.MyView> implements ProjectsUiHandles {

	public interface MyView extends View,HasUiHandlers<ProjectsUiHandles> {
	}

	@Inject
	public ProjectPresenter(final EventBus eventBus, final MyView view) {
		super(eventBus, view);
	}

	@Override
	protected void onBind() {
		super.onBind();
		getView().setUiHandlers(this);
	}

	@Override
	public void onEditButtonClicked() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onAddButtonClicked() {
		// TODO Auto-generated method stub
		
	}
}
