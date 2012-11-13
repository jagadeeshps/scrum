package co.edu.unal.scrum.shared.model;

import java.io.Serializable;
import java.util.ArrayList;

public class LoginInfo implements Serializable {

	private static final long serialVersionUID = -4067860048346576139L;

	private boolean loggedIn = false;
	private boolean administrator = false;
	private String logoutUrl = "";
	private String loginUrl = "";
	private ArrayList<Project> projects;

	public void setLoginUrl(String loginUrl) {
		this.loginUrl = loginUrl;
	}

	public String getLoginUrl() {
		return loginUrl;
	}

	private String email = "";

	public LoginInfo() {
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public boolean isLoggedOut() {
		return !loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public boolean isAdministrator() {
		return administrator;
	}

	public void setAdministrator(boolean administrator) {
		this.administrator = administrator;
	}

	public void setLogoutUrl(String logoutUrl) {
		this.logoutUrl = logoutUrl;
	}

	public String getLogoutUrl() {
		return logoutUrl;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public ArrayList<Project> getProjects() {
		return projects;
	}

	public void setProjects(ArrayList<Project> projects) {
		this.projects = projects;
	}

	public void reset() {
		setLoggedIn(false);
		setAdministrator(false);
		setLogoutUrl(null);
		setEmail(null);
		setLoginUrl(null);
		setProjects(null);
	}

	public void initialize(LoginInfo loginInfo) {
		if (loginInfo != null && loginInfo.isLoggedIn()) {
			setLoggedIn(true);
			setAdministrator(loginInfo.isAdministrator());
			setLogoutUrl(loginInfo.getLogoutUrl());
			setEmail(loginInfo.getEmail());
			setProjects(loginInfo.projects);
		} else {
			reset();
			setLoginUrl(loginInfo.getLoginUrl());
		}
	}

	@Override
	public String toString() {
		return isLoggedIn() ? "User " + getEmail() + "Logged in: "
				: "User Not logged in yet.";
	}

}
