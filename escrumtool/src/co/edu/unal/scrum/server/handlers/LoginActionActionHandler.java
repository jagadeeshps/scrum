package co.edu.unal.scrum.server.handlers;

import java.util.ArrayList;
import java.util.List;

import co.edu.unal.scrum.server.dao.UserDetailsDao;
import co.edu.unal.scrum.server.guice.ObjectDatastoreProvider;
import co.edu.unal.scrum.server.model.ProjectUser;
import co.edu.unal.scrum.server.model.UserDetail;
import co.edu.unal.scrum.shared.actions.LoginAction;
import co.edu.unal.scrum.shared.actions.LoginActionResult;
import co.edu.unal.scrum.shared.model.LoginInfo;
import co.edu.unal.scrum.shared.model.Project;
import co.edu.unal.scrum.shared.model.ProjectBuilder;

import com.google.appengine.api.datastore.Query.FilterOperator;
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
	@Inject
	ObjectDatastoreProvider provider;
	private List<ProjectUser> r;

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
			} else {
				ObjectDatastore ds = provider.get();
				r = ds.find()
						.type(ProjectUser.class)
						.addFilter("emailUser", FilterOperator.EQUAL,
								user.getEmail()).returnAll().now();
				ArrayList<Project> project = new ArrayList<Project>();
				for (ProjectUser pu : r) {
					co.edu.unal.scrum.server.model.Project p = pu.getP();
					Project pro = ProjectBuilder.project()
							.withDateEnd(p.getEndDate())
							.withDateStart(p.getStartDate())
							.withDescription(p.getDescription())
							.withIdProject(p.getId()).withName(p.getName())
							.withStatus(p.getState().toString()).build();
					project.add(pro);
				}
				userLoginInfo.setProjects(project);
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
