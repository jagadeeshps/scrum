package co.edu.unal.scrum.shared.actions;

import com.gwtplatform.dispatch.shared.ActionImpl;

public class LoginAction extends ActionImpl<LoginActionResult> {

	private String RequestUrl;

	@SuppressWarnings("unused")
	private LoginAction() {
		// For serialization only
	}

	public LoginAction(String RequestUrl) {
		this.RequestUrl = RequestUrl;
	}

	public String getRequestUrl() {
		return RequestUrl;
	}
}
