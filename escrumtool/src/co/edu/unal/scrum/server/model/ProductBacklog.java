package co.edu.unal.scrum.server.model;

import java.util.ArrayList;

import com.google.code.twig.annotation.Child;
import com.google.code.twig.annotation.Entity;
import com.google.code.twig.annotation.Id;
import com.google.code.twig.annotation.Parent;

@Entity(kind = "Product BackLog", version = 1)
public class ProductBacklog {
	@Id
	private int id;
	@Parent
	private Product product;
	private String name;
	@Child
	private ArrayList<ProductBacklogItem> productBacklogItems;

	public ProductBacklog() {
	}
}
