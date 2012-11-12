package co.edu.unal.scrum.client.place;

import co.edu.unal.scrum.shared.model.LoginInfo;

import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.proxy.PlaceManagerImpl;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;
import com.gwtplatform.mvp.client.proxy.TokenFormatter;

public class ClientPlaceManager extends PlaceManagerImpl {

	private final PlaceRequest defaultPlaceRequest;
	private LoginInfo currentLogin;

	@Inject
	public ClientPlaceManager(final EventBus eventBus,
			final TokenFormatter tokenFormatter,
			@DefaultPlace final String defaultPlaceNameToken,
			final LoginInfo currentLogin) {
		super(eventBus, tokenFormatter);
		this.defaultPlaceRequest = new PlaceRequest(defaultPlaceNameToken);
		this.currentLogin = currentLogin;
	}

	@Override
	public void revealDefaultPlace() {
		if (currentLogin.isLoggedIn()) {
			revealPlace(new PlaceRequest(NameTokens.wall));
		} else {
			revealPlace(defaultPlaceRequest);
		}
	}
}
