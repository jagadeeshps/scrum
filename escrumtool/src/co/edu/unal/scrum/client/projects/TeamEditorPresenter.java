package co.edu.unal.scrum.client.projects;

import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.PopupView;
import com.google.inject.Inject;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HasHandlers;

public class TeamEditorPresenter  extends
		PresenterWidget<TeamEditorPresenter.MyView> implements HasHandlers,TeamEditorUiHandlers{

	public interface MyView extends PopupView,HasUiHandlers<TeamEditorUiHandlers> {
		// TODO Put your view methods here
	}

	@Inject
	public TeamEditorPresenter(final EventBus eventBus, final MyView view) {
		super(eventBus, view);
		
	}

	@Override
	protected void onBind() {
		super.onBind();
		getView().setUiHandlers(this);
	}

	@Override
	public void onSaveClicked() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onCancelClicked() {
		// TODO Auto-generated method stub
		getView().hide();
	}
}
