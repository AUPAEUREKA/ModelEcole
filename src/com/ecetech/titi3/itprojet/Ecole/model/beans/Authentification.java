package com.ecetech.titi3.itprojet.Ecole.model.beans;

public class Authentification {

	private String login;
	private String password;
	
	
	public Authentification(String login, String password) {
		this.login = login;
		this.password = password;
	}
	
	public Authentification(){
		this.login = "";
		this.password = "";
	}

	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
