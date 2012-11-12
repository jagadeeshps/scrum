package co.edu.unal.scrum.server.dao;

import java.util.logging.Logger;

import co.edu.unal.scrum.server.guice.ObjectDatastoreProvider;

import com.google.appengine.api.datastore.Key;
import com.google.code.twig.ObjectDatastore;

public abstract class DAO<T> {

	protected Class<T> tClass;
	protected final ObjectDatastoreProvider datastoreProvider;

	protected static final Logger logger = Logger
			.getLogger(DAO.class.getName());

	protected DAO(Class<T> tClass,
			final ObjectDatastoreProvider datastoreProvider) {
		this.tClass = tClass;
		this.datastoreProvider = datastoreProvider;
	}

	public Key getKey(T entity) {
		return datastoreProvider.get().associatedKey(entity);
	}

	public Key store(T entity) {
		return datastoreProvider.get().store(entity);
	}

	public T read(Key key) {
		return datastoreProvider.get().load(key);
	}

	public void update(T entity) {
		ObjectDatastore ds = datastoreProvider.get();
		ds.associate(entity, true);
		ds.update(entity);
	}

	public void delete(T entity) {
		// workaround for
		// http://code.google.com/p/twig-persist/issues/detail?id=47
		ObjectDatastore ds = datastoreProvider.get();
		ds.associate(entity);
		ds.delete(entity);
		ds.disassociate(entity);
	}
}
