package co.edu.unal.scrum.server.model;

import com.google.code.twig.annotation.Entity;
import com.google.code.twig.annotation.Id;
import com.google.code.twig.annotation.Index;

@Entity(kind = "ProjectUserRel")
public class ProjectUser {

	@Id
	long id;
	@Index
	String emailUser;
	Project p;

	public long getId() {
		return id;
	}

	public ProjectUser() {

	}

	public ProjectUser(String emailUser, Project p) {
		super();
		this.emailUser = emailUser;
		this.p = p;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmailUser() {
		return emailUser;
	}

	public void setEmailUser(String emailUser) {
		this.emailUser = emailUser;
	}

	public Project getP() {
		return p;
	}

	public void setP(Project p) {
		this.p = p;
	}

}
