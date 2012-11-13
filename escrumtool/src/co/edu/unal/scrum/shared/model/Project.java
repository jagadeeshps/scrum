package co.edu.unal.scrum.shared.model;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Project implements Serializable {
	private Date dateEnd;
	private Date dateStart;
	private String name;
	private String status;
	private String description;
	private long idProject;

	public Project() {

	}

	public Project(Date dateEnd, Date dateStart, String name, String status,
			String description, long idProject) {
		super();
		this.dateEnd = dateEnd;
		this.dateStart = dateStart;
		this.name = name;
		this.status = status;
		this.description = description;
		this.idProject = idProject;
	}

	public Date getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}

	public Date getDateStart() {
		return dateStart;
	}

	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public long getIdProject() {
		return idProject;
	}

	public void setIdProject(long idProject) {
		this.idProject = idProject;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
}
