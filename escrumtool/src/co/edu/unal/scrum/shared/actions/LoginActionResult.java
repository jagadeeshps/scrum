package co.edu.unal.scrum.shared.actions;

import co.edu.unal.scrum.shared.model.LoginInfo;

import com.gwtplatform.dispatch.shared.Result;

public class LoginActionResult implements Result {

	private LoginInfo loginInfo;

	@SuppressWarnings("unused")
	private LoginActionResult() {
		// For serialization only
	}

	public LoginActionResult(LoginInfo loginInfo) {
		this.loginInfo = loginInfo;
	}

	public LoginInfo getLoginInfo() {
		return loginInfo;
	}
}
