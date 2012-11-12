package co.edu.unal.scrum.client.place;

import co.edu.unal.scrum.shared.model.LoginInfo;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.gwtplatform.mvp.client.proxy.Gatekeeper;

@Singleton
public class LoggedInGatekeeper implements Gatekeeper {

	private final LoginInfo loginInfo;

	@Inject
	public LoggedInGatekeeper(LoginInfo loginInfo) {
		this.loginInfo = loginInfo;
	}

	@Override
	public boolean canReveal() {
		return loginInfo.isLoggedIn();
	}
}