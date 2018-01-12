package com.ecetech.titi3.itprojet.Ecole.model.beans;

public class AuthentificationRespo {
	
	private String loginRespo;
	private String passwordRespo;
	
	
	public AuthentificationRespo(String loginRespo, String passwordRespo) {
		this.loginRespo = loginRespo;
		this.passwordRespo = loginRespo;
	}
	
	public AuthentificationRespo(){
		this.loginRespo = "";
		this.passwordRespo = "";
	}

	public String getLoginRespo() {
		return loginRespo;
	}
	public void setLoginRespo(String loginRespo) {
		this.loginRespo = loginRespo;
	}
	public String getPasswordRespo() {
		return passwordRespo;
	}
	public void setPasswordRespo(String passwordRespo) {
		this.passwordRespo = passwordRespo;
	}
	
	
	
}