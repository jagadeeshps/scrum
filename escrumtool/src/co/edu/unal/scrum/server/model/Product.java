package co.edu.unal.scrum.server.model;

import com.extjs.gxt.charts.client.model.Text;
import com.google.code.twig.annotation.Child;
import com.google.code.twig.annotation.Entity;
import com.google.code.twig.annotation.Id;
import com.google.code.twig.annotation.Index;
import com.google.code.twig.annotation.Parent;
import com.google.code.twig.annotation.Type;

@Entity(kind = "Product", version = 1)
public class Product {
	@Id
	private int id;
	@Index
	private String name;
	@Type(Text.class)
	private String desc;
	@Parent
	private Project project;
	@Child
	private ProductBacklog productBacklog;

}
