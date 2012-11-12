package co.edu.unal.scrum.server.model;

import co.edu.unal.scrum.shared.model.TaskStatus;

import com.google.code.twig.annotation.Entity;
import com.google.code.twig.annotation.Id;
import com.google.code.twig.annotation.Parent;

@Entity(kind = "Tasks", version = 1)
public class SprintItem {
	@Id
	private int id;
	@Parent
	private SprintBacklog sprintBacklog;
	private TaskStatus status;
	private StakeHolder owner;
	private String description;
	private String comments;
	private Integer estHrs;
	private Integer actHrs;
	private ProductBacklogItem userHistory;

	public SprintItem() {
	}

}
