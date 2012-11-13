package co.edu.unal.scrum.server.handlers;

import java.util.ArrayList;

import com.gwtplatform.dispatch.server.actionhandler.ActionHandler;

import co.edu.unal.scrum.server.dao.ProjectDao;
import co.edu.unal.scrum.server.guice.ObjectDatastoreProvider;
import co.edu.unal.scrum.server.model.Project;
import co.edu.unal.scrum.server.model.ProjectUser;
import co.edu.unal.scrum.server.model.StakeHolder;
import co.edu.unal.scrum.shared.actions.CreateProject;
import co.edu.unal.scrum.shared.actions.CreateProjectResult;
import co.edu.unal.scrum.shared.model.LoginInfo;

import com.google.appengine.api.datastore.Key;
import com.google.inject.Inject;
import com.gwtplatform.dispatch.server.ExecutionContext;
import com.gwtplatform.dispatch.shared.ActionException;

public class CreateProjectActionHandler implements
		ActionHandler<CreateProject, CreateProjectResult> {


	@Inject
	public CreateProjectActionHandler() {
	
	}

	@Inject
	ProjectDao dao;
	@Inject
	ObjectDatastoreProvider provider;

	@Override
	public CreateProjectResult execute(CreateProject action,
			ExecutionContext context) throws ActionException {
		CreateProjectResult r;
		Project p = new Project(action.getName(), action.getDescription(),
				action.getStartDate(), action.getEndDate(),
				action.getEmail());
		
		co.edu.unal.scrum.shared.model.Project pr = new co.edu.unal.scrum.shared.model.Project(
				p.getEndDate(), p.getStartDate(), p.getName(), p.getState()
						.toString(), p.getDescription(), p.getId());
		boolean error = true;
		try {
			Key k = dao.store(p);
			ProjectUser pu=new ProjectUser(action.getEmail(), p);
			provider.get().store(pu);
			error = false;
			pr.setIdProject(p.getId());
			r = new CreateProjectResult(pr, error, "");
		} catch (Exception e) {
			r = new CreateProjectResult(null, error, "");
			e.printStackTrace();
		}

		return r;
	}

	@Override
	public void undo(CreateProject action, CreateProjectResult result,
			ExecutionContext context) throws ActionException {
	}

	@Override
	public Class<CreateProject> getActionType() {
		return CreateProject.class;
	}
}
