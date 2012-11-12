package co.edu.unal.scrum.server.guice;

import co.edu.unal.scrum.server.model.Product;
import co.edu.unal.scrum.server.model.ProductBacklog;
import co.edu.unal.scrum.server.model.ProductBacklogItem;
import co.edu.unal.scrum.server.model.Project;
import co.edu.unal.scrum.server.model.ProjectUser;
import co.edu.unal.scrum.server.model.SprintBacklog;
import co.edu.unal.scrum.server.model.SprintItem;
import co.edu.unal.scrum.server.model.UserDetail;

import com.google.code.twig.ObjectDatastore;
import com.google.code.twig.ObjectDatastoreFactory;
import com.google.code.twig.Settings;
import com.google.code.twig.annotation.AnnotationObjectDatastore;
import com.google.inject.Provider;

public class ObjectDatastoreProvider implements Provider<ObjectDatastore> {

	static {
		ObjectDatastoreFactory.register(UserDetail.class);
		ObjectDatastoreFactory.register(Product.class);
		ObjectDatastoreFactory.register(ProductBacklog.class);
		ObjectDatastoreFactory.register(ProductBacklogItem.class);
		ObjectDatastoreFactory.register(Project.class);
		ObjectDatastoreFactory.register(SprintBacklog.class);
		ObjectDatastoreFactory.register(SprintItem.class);
		ObjectDatastoreFactory.register(ProjectUser.class);

	}
	private Boolean indexed = false;
	private int activationDepth = 4;

	@Override
	public ObjectDatastore get() {
		// TODO Auto-generated method stub
		ObjectDatastore datastore = new AnnotationObjectDatastore(Settings
				.builder().build(), activationDepth, indexed);
		return datastore;
	}
}
