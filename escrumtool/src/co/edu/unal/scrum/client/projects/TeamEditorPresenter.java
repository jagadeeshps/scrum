package co.edu.unal.scrum.client.projects;

import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.PopupView;
import com.google.inject.Inject;
import com.google.gwt.event.shared.EventBus;

public class TeamEditorPresenter extends
		PresenterWidget<TeamEditorPresenter.MyView> {

	public interface MyView extends PopupView {
		// TODO Put your view methods here
	}

	@Inject
	public TeamEditorPresenter(final EventBus eventBus, final MyView view) {
		super(eventBus, view);
	}

	@Override
	protected void onBind() {
		super.onBind();
	}
}
