package co.edu.unal.scrum.server.guice;

import co.edu.unal.scrum.server.dao.ProjectDao;
import co.edu.unal.scrum.server.dao.UserDetailsDao;
import co.edu.unal.scrum.server.handlers.LoginActionActionHandler;
import co.edu.unal.scrum.shared.actions.LoginAction;

import com.google.code.twig.ObjectDatastore;
import com.google.inject.Singleton;
import com.gwtplatform.dispatch.server.guice.HandlerModule;
import co.edu.unal.scrum.shared.actions.CreateProject;
import co.edu.unal.scrum.server.handlers.CreateProjectActionHandler;

public class ServerModule extends HandlerModule {

	@Override
	protected void configureHandlers() {
		bind(ObjectDatastore.class).toProvider(ObjectDatastoreProvider.class)
				.in(Singleton.class);
		bindHandler(LoginAction.class, LoginActionActionHandler.class);

		bindHandler(CreateProject.class, CreateProjectActionHandler.class);
		bind(ProjectDao.class);
		bind(UserDetailsDao.class);
	}
}
