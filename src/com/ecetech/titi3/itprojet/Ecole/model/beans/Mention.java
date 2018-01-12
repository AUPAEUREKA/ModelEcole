package com.ecetech.titi3.itprojet.Ecole.model.beans;

public class Mention {
	
	private String type;

	
	public Mention(String type) {
		this.type = type;
	}
	
	public Mention() {
		this.type = "";
	}

	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}

}
