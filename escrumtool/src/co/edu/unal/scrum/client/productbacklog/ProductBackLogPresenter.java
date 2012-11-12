package co.edu.unal.scrum.client.productbacklog;

import co.edu.unal.scrum.client.LayoutPresenter;
import co.edu.unal.scrum.client.UserHistoryPresenter;
import co.edu.unal.scrum.client.place.LoggedInGatekeeper;
import co.edu.unal.scrum.client.place.NameTokens;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HasHandlers;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.annotations.UseGatekeeper;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealContentEvent;

public class ProductBackLogPresenter
		extends
		Presenter<ProductBackLogPresenter.MyView, ProductBackLogPresenter.MyProxy>
		implements HasHandlers, ProductBackLogUiHandlres {

	public interface MyView extends View,
			HasUiHandlers<ProductBackLogUiHandlres> {
	}

	@ProxyCodeSplit
	@NameToken(NameTokens.product)
	@UseGatekeeper(LoggedInGatekeeper.class)
	public interface MyProxy extends ProxyPlace<ProductBackLogPresenter> {
	}

	private UserHistoryPresenter userHistoryPresenter;

	@Inject
	public ProductBackLogPresenter(final EventBus eventBus, final MyView view,
			final MyProxy proxy, final UserHistoryPresenter userHistoryPresenter) {
		super(eventBus, view, proxy);
		this.userHistoryPresenter = userHistoryPresenter;
		getView().setUiHandlers(this);
	}

	@Override
	protected void revealInParent() {
		RevealContentEvent.fire(this, LayoutPresenter.TYPE_CENTER, this);
	}

	@Override
	protected void onBind() {
		super.onBind();
	}

	@Override
	public void addUserHistory() {
		// TODO Auto-generated method stub
		userHistoryPresenter.reset();
		addToPopupSlot(userHistoryPresenter);
	}
}
