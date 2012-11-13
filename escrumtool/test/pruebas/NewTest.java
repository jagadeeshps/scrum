package pruebas;

import java.util.Date;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

import co.edu.unal.scrum.server.dao.ProjectDao;
import co.edu.unal.scrum.server.guice.DispatchServletModule;
import co.edu.unal.scrum.server.guice.ObjectDatastoreProvider;
import co.edu.unal.scrum.server.guice.ServerModule;
import co.edu.unal.scrum.server.model.Project;
import co.edu.unal.scrum.server.model.ProjectUser;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;
import com.google.inject.Inject;

@Guice(modules = { ServerModule.class, DispatchServletModule.class })
public class NewTest {
	private final LocalServiceTestHelper helper = new LocalServiceTestHelper(
			new LocalDatastoreServiceTestConfig()); // .setDefaultHighRepJobPolicyUnappliedJobPercentage(1));
	@Inject
	ProjectDao dao;
	@Inject
	ObjectDatastoreProvider prov;

	@BeforeTest
	private void setu() {
		// TODO Auto-generated method stub
		helper.setUp();
	}

	@AfterTest
	private void teard() {
		// TODO Auto-generated method stub
		helper.tearDown();
	}

	@Test
	public void f() {
		Project p = new Project("prueba", "aaaa", new Date(), new Date(),
				"ricardo@gmail.com");
		Key k = dao.store(p);
		Assert.assertNotNull(k);

		ProjectUser pp = new ProjectUser("ricardo@gmail.com", p);
		Key kk = prov.get().store(pp);
		Assert.assertNotNull(kk);

		int i = prov.get().find().type(ProjectUser.class).returnCount().now();
		Assert.assertEquals(1, i);
		List<ProjectUser> data = prov
				.get()
				.find()
				.type(ProjectUser.class)
				.addFilter("emailUser", FilterOperator.EQUAL,
						"ricardo@gmail.com").returnAll().now();
		Assert.assertEquals(p.getId(), data.get(0).getP().getId());

	}
}
