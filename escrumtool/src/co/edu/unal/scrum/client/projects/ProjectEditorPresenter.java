package co.edu.unal.scrum.client.projects;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HasHandlers;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.PopupView;
import com.gwtplatform.mvp.client.PresenterWidget;

public class ProjectEditorPresenter extends
		PresenterWidget<ProjectEditorPresenter.MyView> implements HasHandlers,
		ProjectEditorUiHandlers {

	public interface MyView extends PopupView,
			HasUiHandlers<ProjectEditorUiHandlers> {
		// TODO Put your view methods here
	}

	@Inject
	public ProjectEditorPresenter(final EventBus eventBus, final MyView view) {
		super(eventBus, view);
	}

	@Override
	protected void onBind() {
		super.onBind();
	}

	@Override
	public void onSaveButtonClicked() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onCancelButtonClicked() {
		// TODO Auto-generated method stub
		getView().hide();
	}

	public void reset() {
		// TODO Auto-generated method stub

	}

}
