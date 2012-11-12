package co.edu.unal.scrum.client;

import co.edu.unal.scrum.client.place.NameTokens;

import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealContentEvent;

public class InicioPresenter extends
		Presenter<InicioPresenter.MyView, InicioPresenter.MyProxy> {

	public interface MyView extends View {
	}

	@ProxyCodeSplit
	@NameToken(NameTokens.inicio)
	public interface MyProxy extends ProxyPlace<InicioPresenter> {
	}

	@Inject
	public InicioPresenter(final EventBus eventBus, final MyView view,
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
