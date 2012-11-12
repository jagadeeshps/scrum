package co.edu.unal.scrum.server.model;

import com.google.code.twig.annotation.Denormalise;
import com.google.code.twig.annotation.Entity;
import com.google.code.twig.annotation.Id;

@Entity(kind = "Project_User", version = 1)
public class ProjectUser {

	@Id
	long id;
	String emailUser;
	@Denormalise({ "name", "startDate", "endDate", "state" })
	Project p;

}
