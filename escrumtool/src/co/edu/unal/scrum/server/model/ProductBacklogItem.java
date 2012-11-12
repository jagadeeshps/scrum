package co.edu.unal.scrum.server.model;

import co.edu.unal.scrum.shared.model.UserHistoryStatus;

import com.google.appengine.api.datastore.Text;
import com.google.code.twig.annotation.Entity;
import com.google.code.twig.annotation.Id;
import com.google.code.twig.annotation.Index;
import com.google.code.twig.annotation.Parent;
import com.google.code.twig.annotation.Type;

@Entity(kind = "User histories", version = 1)
public class ProductBacklogItem {
	@Id
	private int id;
	@Parent
	private ProductBacklog productBacklog;
	private UserHistoryStatus status;
	@Index
	private String name;
	@Type(Text.class)
	private String description;
	@Type(Text.class)
	private String aceptanceCriteria;
	private int priority;

	public ProductBacklogItem() {
	}

}
