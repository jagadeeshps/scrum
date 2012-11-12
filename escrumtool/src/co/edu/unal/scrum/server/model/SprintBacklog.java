package co.edu.unal.scrum.server.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.google.code.twig.annotation.Child;
import com.google.code.twig.annotation.Entity;
import com.google.code.twig.annotation.Id;
import com.google.code.twig.annotation.Parent;

@Entity(kind = "Sprint", version = 1)
public class SprintBacklog {
	@Id
	private int id;
	@Parent
	private Project project;
	private String name;
	private Date startDate;
	private Date estEndDate;
	private String objective;
	@Child
	private Set<SprintItem> sprintItems = new HashSet<SprintItem>(0);

	public SprintBacklog() {
	}

}
