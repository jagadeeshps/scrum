package co.edu.unal.scrum.client;

import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.PopupView;
import com.gwtplatform.mvp.client.PresenterWidget;

public class UserHistoryPresenter extends
		PresenterWidget<UserHistoryPresenter.MyView> {

	public interface MyView extends PopupView {
		// TODO Put your view methods here
		void reset();
	}

	@Inject
	public UserHistoryPresenter(final EventBus eventBus, final MyView view) {
		super(eventBus, view);
	}

	@Override
	protected void onBind() {
		super.onBind();
	}

	public void reset() {
		// TODO Auto-generated method stub
		getView().reset();
	}
}
