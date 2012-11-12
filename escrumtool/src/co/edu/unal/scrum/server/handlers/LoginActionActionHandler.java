package co.edu.unal.scrum.server.handlers;

import co.edu.unal.scrum.server.dao.UserDetailsDao;
import co.edu.unal.scrum.server.model.UserDetail;
import co.edu.unal.scrum.shared.actions.LoginAction;
import co.edu.unal.scrum.shared.actions.LoginActionResult;
import co.edu.unal.scrum.shared.model.LoginInfo;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.google.code.twig.ObjectDatastore;
import com.google.inject.Inject;
import com.gwtplatform.dispatch.server.ExecutionContext;
import com.gwtplatform.dispatch.server.actionhandler.ActionHandler;
import com.gwtplatform.dispatch.shared.ActionException;

public class LoginActionActionHandler implements
		ActionHandler<LoginAction, LoginActionResult> {

	@Inject
	public LoginActionActionHandler() {
	}

	@Inject
	UserDetailsDao dao;

	@Override
	public LoginActionResult execute(LoginAction action,
			ExecutionContext context) throws ActionException {
		return execute(action);

	}

	public LoginActionResult execute(LoginAction action) {
		UserService userService = UserServiceFactory.getUserService();
		LoginInfo userLoginInfo = new LoginInfo();

		if (userService.isUserLoggedIn()) {
			User user = userService.getCurrentUser();

			UserDetail u = dao.findByEmail(user.getEmail());

			userLoginInfo.setLoggedIn(true);
			String logoutUrl = "";

			logoutUrl = userService.createLogoutURL(action.getRequestUrl());

			userLoginInfo.setLogoutUrl(logoutUrl);

			userLoginInfo.setEmail(user.getEmail());
			if (u == null) {
				UserDetail userP = new UserDetail("", "", user.getEmail());
				dao.store(userP);
			}

		} else {
			userLoginInfo.setLoginUrl(userService.createLoginURL(action
					.getRequestUrl()));
		}
		return new LoginActionResult(userLoginInfo);
	}

	@Override
	public void undo(LoginAction action, LoginActionResult result,
			ExecutionContext context) throws ActionException {
	}

	@Override
	public Class<LoginAction> getActionType() {
		return LoginAction.class;
	}
}
