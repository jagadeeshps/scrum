package co.edu.unal.scrum.server.dao;

import java.util.List;

import co.edu.unal.scrum.server.guice.ObjectDatastoreProvider;
import co.edu.unal.scrum.server.model.Project;

import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.inject.Inject;

public class ProjectDao extends DAO<Project> {
	@Inject
	protected ProjectDao(final ObjectDatastoreProvider datastoreProvider) {
		super(Project.class, datastoreProvider);
	}

	public Project readProject(long id) {

		Project p = null;
		try {
			p = datastoreProvider.get().load(Project.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}

	public List<Project> readByName(String name) {

		return datastoreProvider.get().find().type(Project.class)
				.addFilter("name", FilterOperator.EQUAL, name).returnAll()
				.now();

	}

}
