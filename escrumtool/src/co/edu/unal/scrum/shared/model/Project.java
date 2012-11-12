package co.edu.unal.scrum.shared.model;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Project implements Serializable {
	private Date dateEnd;
	private Date dateStart;
	private String name;
	private String status;
	private long idProject;

	public Project() {

	}

	
}
