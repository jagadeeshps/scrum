package co.edu.unal.scrum.client.menu;

import co.edu.unal.scrum.client.place.NameTokens;
import co.edu.unal.scrum.shared.model.LoginInfo;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HasHandlers;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;

public class MenuPresenter extends PresenterWidget<MenuPresenter.MyView>
		implements HasHandlers, MenuUiHandlres {

	public interface MyView extends View, HasUiHandlers<MenuUiHandlres> {
		void renderUserMenus();

		void enabledActions();

	}

	final LoginInfo currentLogininfo;
	@Inject
	PlaceManager placeManager;

	@Inject
	public MenuPresenter(final EventBus eventBus, final MyView view,
			final LoginInfo currentLoginInfo) {
		super(eventBus, view);
		this.currentLogininfo = currentLoginInfo;
		getView().setUiHandlers(this);
		getView().renderUserMenus();
		if (currentLogininfo.isLoggedIn()) {
			getView().enabledActions();
		}
	}

	@Override
	protected void onBind() {
		super.onBind();

	}

	@Override
	public void onProductClicked() {
		// TODO Auto-generated method stub
		placeManager.revealPlace(new PlaceRequest(NameTokens.wall));
	}

	@Override
	public void onProductBacklogClicked() {
		// TODO Auto-generated method stub
		placeManager.revealPlace(new PlaceRequest(NameTokens.product));
	}

	@Override
	public void onChartclicked() {
		// TODO Auto-generated method stub
		placeManager.revealPlace(new PlaceRequest(NameTokens.statics));
	}
}
