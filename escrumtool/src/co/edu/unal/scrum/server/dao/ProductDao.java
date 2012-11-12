/**
 * 
 */
package co.edu.unal.scrum.server.dao;

import java.util.List;

import com.google.inject.Inject;

import co.edu.unal.scrum.server.guice.ObjectDatastoreProvider;
import co.edu.unal.scrum.server.model.Product;
import co.edu.unal.scrum.server.model.Project;

/**
 * @author ricardo
 * 
 */
public class ProductDao extends DAO<Product> {

	@Inject
	protected ProductDao(final ObjectDatastoreProvider dataStoreProvider) {
		super(Product.class, dataStoreProvider);
	}

	public Product readById(long id) {
		return datastoreProvider.get().load(Product.class, id);
	}

	public List<Product> readAll(Project parent) {
		return datastoreProvider.get().find().type(Product.class)
				.ancestor(parent).returnAll().now();
	}

}
