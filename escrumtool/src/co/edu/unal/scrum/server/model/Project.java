package co.edu.unal.scrum.server.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import co.edu.unal.scrum.shared.model.ProjectStatus;
import co.edu.unal.scrum.shared.model.Rol;

import com.google.appengine.api.datastore.Text;
import com.google.code.twig.annotation.Child;
import com.google.code.twig.annotation.Embed;
import com.google.code.twig.annotation.Embedded;
import com.google.code.twig.annotation.Entity;
import com.google.code.twig.annotation.Id;
import com.google.code.twig.annotation.Index;
import com.google.code.twig.annotation.Type;

@Entity(kind = "Project", version = 1)
public class Project {
	@Id
	private long id;
	@Index
	private String name;
	@Type(Text.class)
	private String description;
	private Date startDate;
	private Date endDate;
	private ProjectStatus state = ProjectStatus.NEW;
	@Child
	private ArrayList<Product> products;
	@Child
	private ArrayList<SprintBacklog> sprints;
	@Embedded
	ArrayList<StakeHolder> scrumTeam = new ArrayList<StakeHolder>();;

	public Project() {
	}

	public Project(String name, String description, Date startDate,
			Date endDate, String email) {
		super();
		this.name = name;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		scrumTeam.add(new StakeHolder(this, email, Rol.SCRUM_MASTER));
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate
	 *            the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate
	 *            the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the state
	 */
	public ProjectStatus getState() {
		return state;
	}

	/**
	 * @param state
	 *            the state to set
	 */
	public void setState(ProjectStatus state) {
		this.state = state;
	}

	/**
	 * @return the products
	 */
	public ArrayList<Product> getProducts() {
		return products;
	}

	/**
	 * @param products
	 *            the products to set
	 */
	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}

	/**
	 * @return the sprints
	 */
	public ArrayList<SprintBacklog> getSprints() {
		return sprints;
	}

	/**
	 * @param sprints
	 *            the sprints to set
	 */
	public void setSprints(ArrayList<SprintBacklog> sprints) {
		this.sprints = sprints;
	}

	public ArrayList<StakeHolder> getScrumTeam() {
		return scrumTeam;
	}

	public void setScrumTeam(ArrayList<StakeHolder> scrumTeam) {
		this.scrumTeam = scrumTeam;
	}

}
