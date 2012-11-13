package co.edu.unal.scrum.server.model;

import com.google.code.twig.annotation.Root;

import co.edu.unal.scrum.shared.model.Rol;

public class StakeHolder {
	@Root
	private Project p;
	private String email;
	public StakeHolder(){
		
	}
	public StakeHolder(Project p, String email, Rol rol) {
		super();
		this.p = p;
		this.email = email;
		this.rol = rol;
	}
	private Rol rol;
}
