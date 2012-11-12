package co.edu.unal.scrum.server.dao;

import co.edu.unal.scrum.server.guice.ObjectDatastoreProvider;
import co.edu.unal.scrum.server.model.UserDetail;

import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.inject.Inject;

public class UserDetailsDao extends DAO<UserDetail> {

	@Inject
	protected UserDetailsDao(final ObjectDatastoreProvider dataStoreProvider) {
		super(UserDetail.class, dataStoreProvider);
	}

	public UserDetail findByEmail(String email) {
		UserDetail user = null;
		try {
			user = datastoreProvider.get().find().type(UserDetail.class)
					.addFilter("email", FilterOperator.EQUAL, email)
					.returnUnique().now();
		} catch (Exception e) {
			e.fillInStackTrace();
		}
		return user;
	}

}
