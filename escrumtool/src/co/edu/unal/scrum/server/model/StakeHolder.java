package co.edu.unal.scrum.server.model;

import com.google.code.twig.annotation.Root;

import co.edu.unal.scrum.shared.model.Rol;

public class StakeHolder {
	@Root
	private Project p;
	private String email;
	private Rol rol;
}
