package co.edu.unal.scrum.client.statics;

import co.edu.unal.scrum.client.LayoutPresenter;
import co.edu.unal.scrum.client.place.LoggedInGatekeeper;
import co.edu.unal.scrum.client.place.NameTokens;

import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.annotations.UseGatekeeper;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealContentEvent;

public class StaticsPresenter extends
		Presenter<StaticsPresenter.MyView, StaticsPresenter.MyProxy> {

	public interface MyView extends View {
	}

	@ProxyCodeSplit
	@NameToken(NameTokens.statics)
	@UseGatekeeper(LoggedInGatekeeper.class)
	public interface MyProxy extends ProxyPlace<StaticsPresenter> {
	}

	public static final Object PRODUCT_CHART_SLOT = new Object();

	@Inject
	public StaticsPresenter(final EventBus eventBus, final MyView view,
			final MyProxy proxy) {
		super(eventBus, view, proxy);
	}

	@Override
	protected void revealInParent() {
		RevealContentEvent.fire(this, LayoutPresenter.TYPE_CENTER, this);
	}

	@Override
	protected void onBind() {
		super.onBind();
	}
}
